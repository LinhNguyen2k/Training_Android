package com.example.paypallayout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import kotlinx.android.synthetic.main.activity_pays.*

class Pays : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pays)
        img_back.setOnClickListener {
            finish()
        }
        btn_enviar.setOnClickListener {
            val intent: Intent = Intent(applicationContext,Cards::class.java)
            startActivity(intent)
        }
    }
}