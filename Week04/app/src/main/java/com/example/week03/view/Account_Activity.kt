package com.example.week03.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.week03.R

class Account_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)
        supportActionBar?.hide()

    }
}