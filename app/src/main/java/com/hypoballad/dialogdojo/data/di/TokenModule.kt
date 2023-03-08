package com.hypoballad.dialogdojo.data.di

import android.content.Context
import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import dagger.Module
import dagger.Provides
import java.security.KeyStore
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.inject.Singleton

@Module
object TokenModule {

    private const val ANDROID_KEYSTORE_PROVIDER = "AndroidKeyStore"
    private const val ENCRYPTION_TRANSFORMATION = "AES/CBC/PKCS7Padding"
    private const val KEY_ALIAS = "ChatGPT Token"

    @Provides
    @Singleton
    fun provideToken(context: Context): String {
        val tokenFromEnv = System.getenv("chatgpi_token")
        return if (tokenFromEnv != null) {
            val encryptedToken = encrypt(context, tokenFromEnv)
            saveTokenToKeystore(context, encryptedToken)
            encryptedToken
        } else {
            val encryptedToken = getTokenFromKeystore(context)
            decrypt(context, encryptedToken)
        }
    }

    private fun encrypt(context: Context, token: String): String {
        val cipher = getCipher()
        cipher.init(Cipher.ENCRYPT_MODE, getSecretKey(context))
        val encryptedBytes = cipher.doFinal(token.toByteArray())
        return encryptedBytes.joinToString(":") { "%02x".format(it) }
    }

    private fun decrypt(context: Context, encryptedToken: String): String {
        val cipher = getCipher()
        cipher.init(Cipher.DECRYPT_MODE, getSecretKey(context))
        val encryptedBytes = encryptedToken.split(":").map { it.toInt(16).toByte() }.toByteArray()
        return cipher.doFinal(encryptedBytes).toString(Charsets.UTF_8)
    }

    private fun getCipher(): Cipher {
        return Cipher.getInstance(ENCRYPTION_TRANSFORMATION)
    }

    private fun getSecretKey(context: Context): javax.crypto.SecretKey {
        val keyStore = KeyStore.getInstance(ANDROID_KEYSTORE_PROVIDER)
        keyStore.load(null)
        if (!keyStore.containsAlias(KEY_ALIAS)) {
            val keyGenerator = KeyGenerator.getInstance(KeyProperties.KEY_ALGORITHM_AES, ANDROID_KEYSTORE_PROVIDER)
            val keyGenParameterSpec = KeyGenParameterSpec.Builder(KEY_ALIAS, KeyProperties.PURPOSE_ENCRYPT or KeyProperties.PURPOSE_DECRYPT)
                .setBlockModes(KeyProperties.BLOCK_MODE_CBC)
                .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_PKCS7)
                .build()
            keyGenerator.init(keyGenParameterSpec)
            keyGenerator.generateKey()
        }
        val secretKeyEntry = keyStore.getEntry(KEY_ALIAS, null) as KeyStore.SecretKeyEntry
        return secretKeyEntry.secretKey
    }

    private fun saveTokenToKeystore(context: Context, encryptedToken: String) {
        val sharedPreferences = context.getSharedPreferences("Token", Context.MODE_PRIVATE)
        sharedPreferences.edit().putString("Encrypted Token", encryptedToken).apply()
    }

    private fun getTokenFromKeystore(context: Context): String {
        val sharedPreferences = context.getSharedPreferences("Token", Context.MODE_PRIVATE)
        return sharedPreferences.getString("Encrypted Token", "") ?: ""
    }
}
