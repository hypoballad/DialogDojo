package com.hypoballad.dialogdojo.data

import com.hypoballad.dialogdojo.data.remote.ChatGPTAPIService
import com.hypoballad.dialogdojo.data.remote.GeneratedAnswer
import okhttp3.RequestBody
import javax.inject.Inject

class DialogDojoRepository @Inject constructor(
    private val chatGPTAPIService: ChatGPTAPIService
) {
    suspend fun getPrompt(message: RequestBody): GeneratedAnswer {
        return chatGPTAPIService.getPrompt(message)
    }
}

