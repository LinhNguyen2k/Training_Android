package com.example.week03

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.Navigator
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_home.*

class Home_Activity : AppCompatActivity() {

    lateinit var navHost : NavHostFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        supportActionBar!!.hide()
        navHost =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView2) as NavHostFragment
        var controller: NavController = navHost.navController
        bottom_NVT.setupWithNavController(controller)


    }

    override fun onBackPressed() {
        if(navHost.childFragmentManager.backStackEntryCount == 0){
//        val count = supportFragmentManager.backStackEntryCount
//        if (count == 0) {
            val eBundle = AlertDialog.Builder(this)
            eBundle.setTitle("Exit")
            eBundle.setIcon(R.drawable.ic_baseline_warning_24)
            eBundle.setMessage("Are you sure you wan exit app ?")
            eBundle.setPositiveButton("Yes") { Dialog, which ->
                super.onBackPressed()

            }
            eBundle.setNegativeButton("No") { Dialog, which ->
                Toast.makeText(this, "", Toast.LENGTH_SHORT)
            }
            val createBuild = eBundle.create()
            createBuild.show()
        } else {
            super.onBackPressed()
        }



    }
}