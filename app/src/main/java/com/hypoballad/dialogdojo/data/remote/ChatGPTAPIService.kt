package com.hypoballad.dialogdojo.data.remote

import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.POST

interface ChatGPTAPIService {
    @POST("completions")
    suspend fun getPrompt(@Body body: RequestBody): GeneratedAnswer
}