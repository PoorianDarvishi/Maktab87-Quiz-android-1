package com.example.resultactcal

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LogInViewModel : ViewModel() {
    companion object {
        const val LOG_IN_CHECK = "LOG_IN_CHECK"
        const val IS_LOGIN = "IS_LOGIN"
    }

    val userName = MutableLiveData("")
    val password = MutableLiveData("")
    private val mainUserName = MutableLiveData<String>()
    private val mainPassword = MutableLiveData<String>()
    private var status = false
    fun whatStatus(): Boolean {
        return status
    }


    fun setMainUsername(userName: String) {
        mainUserName.value = userName
        this.userName.value = mainUserName.value
    }

    fun setMainPassword(password: String) {
        mainPassword.value = password
        this.password.value = mainPassword.value
    }

    fun check(context: Context): String {
        return if (mainUserName.value != "" &&
            mainPassword.value != "" &&
            mainUserName.value == userName.value &&
            mainPassword.value == password.value
        ) {
            saveToSharedPref(context)
            status = true
            "Your Welcome :)"
        } else {

            "Your username or password is false :("
        }
    }

    private fun saveToSharedPref(context: Context) {
        val sharePref =
            context.getSharedPreferences(LOG_IN_CHECK, Context.MODE_PRIVATE)
        sharePref.edit().apply {
            putBoolean(IS_LOGIN, true)
        }.apply()
    }

    fun checkLogIn(context: Context): Boolean {
        val sharePref =
            context.getSharedPreferences(LOG_IN_CHECK, Context.MODE_PRIVATE)
        return sharePref.getBoolean(IS_LOGIN, false)
    }

    fun clearSharePref(context: Context) {
        val sharePref =
            context.getSharedPreferences(LOG_IN_CHECK, Context.MODE_PRIVATE)
        sharePref.edit().apply {
            clear()
        }.apply()
    }

}