package com.hypoballad.dialogdojo.presentation.practice.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hypoballad.dialogdojo.data.DialogDojoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import okhttp3.RequestBody
import javax.inject.Inject

@HiltViewModel
class PracticeDetailViewModel @Inject constructor(
    val dialogDojoRepository: DialogDojoRepository
) : ViewModel(){
    private val _response = MutableLiveData<String>()
    val response: LiveData<String>
        get() = _response

    fun sendMessages(requestBody: RequestBody) {
        viewModelScope.launch {
            val result = dialogDojoRepository.getPrompt(requestBody)
            _response.value = result.choices[0].text
        }
    }
}