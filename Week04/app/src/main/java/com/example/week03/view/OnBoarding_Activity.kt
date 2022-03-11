package com.example.week03.view


import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.week03.R


class OnBoarding_Activity : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)
        supportActionBar?.hide()
        setNavigationGraph()

    }

    private fun setNavigationGraph() {
        if (checkSkip()) {
            startActivity(Intent(applicationContext, Account_Activity::class.java))
            finish()
        } else {
        val finalHost = NavHostFragment.create(R.navigation.onboarding_nav)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_onBoarding, finalHost)
            .setPrimaryNavigationFragment(finalHost) // equivalent to app:defaultNavHost="true"
            .commit()
        }
    }

    private fun checkSkip(): Boolean {
        sharedPreferences = applicationContext.getSharedPreferences("SAVE_CHECK", MODE_PRIVATE)
        return sharedPreferences.getBoolean("check", false)
    }
}