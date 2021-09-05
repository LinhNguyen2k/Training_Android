package com.example.week03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Account_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)
        supportActionBar?.hide()

    }
}