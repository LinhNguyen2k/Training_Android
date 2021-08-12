package com.example.paypallayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_cards.*

class Cards : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val actionBar = supportActionBar
        actionBar!!.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cards)
        img_back.setOnClickListener {
            finish()
        }
    }
}