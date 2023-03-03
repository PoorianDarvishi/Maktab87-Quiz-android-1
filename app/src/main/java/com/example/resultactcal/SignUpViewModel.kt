package com.example.resultactcal

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignUpViewModel : ViewModel() {
    val userName = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    fun checkSend(): Boolean {
        return userName.value != "" && password.value != ""
    }
}