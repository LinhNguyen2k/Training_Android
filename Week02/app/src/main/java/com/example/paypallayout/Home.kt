package com.example.paypallayout

import android.content.Intent
import android.content.pm.ActivityInfo.*
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_home.*

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val actionBar = supportActionBar
        actionBar!!.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        //this.setRequestedOrientation(SCREEN_ORIENTATION_REVERSE_LANDSCAPE);
        bottom_NVT.background = null
        layout_info.setOnClickListener {
            val intent: Intent = Intent(applicationContext,Pays::class.java)
            startActivity(intent)
        }

    }
}