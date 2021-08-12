package com.example.paypallayout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        bottom_NVT.background = null
        layout_info.setOnClickListener {
            val intent: Intent = Intent(applicationContext,Pays::class.java)
            startActivity(intent)
        }

    }
}