package com.example.resultactcal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.resultactcal.R

class LoginSignupActivity : AppCompatActivity() {
    companion object{
        const val RESET = "RESET"
        const val SIGN_OUT = "SIGN_OUT"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_signup)

    }
}