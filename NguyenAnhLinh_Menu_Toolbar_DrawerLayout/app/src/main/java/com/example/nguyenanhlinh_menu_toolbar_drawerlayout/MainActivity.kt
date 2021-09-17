package com.example.nguyenanhlinh_menu_toolbar_drawerlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    lateinit var homeFragment: HomeFragment
    lateinit var workFragment: WorkFragment
    lateinit var logOutFragment: LogOutFragment
    lateinit var schoolFragment: SchoolFragment
    lateinit var timeLineFragment: TimeLineFragment
    lateinit var settingFragment: SettingFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolBar)
        val actionBar = supportActionBar
        actionBar?.title = "Drawer Layout"

        more.setOnClickListener {
            var popupMenu = PopupMenu(applicationContext, it)
            popupMenu.menuInflater.inflate(R.menu.menu_main, popupMenu.menu)
            popupMenu.show()
            popupMenu.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.item1 -> {
                    Toast.makeText(applicationContext,"Selected item 1",Toast.LENGTH_SHORT).show()

                    }
                    R.id.item2 -> {
                        Toast.makeText(applicationContext,"Selected item 2",Toast.LENGTH_SHORT).show()
                    }
                    R.id.item3 -> {
                        Toast.makeText(applicationContext,"Selected item 3",Toast.LENGTH_SHORT).show()
                    }
                    R.id.item4 -> {
                        Toast.makeText(applicationContext,"Selected item 4",Toast.LENGTH_SHORT).show()
                    }

                }

                false
            }
        }


        val drawerToggle: ActionBarDrawerToggle = object : ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolBar,
            (R.string.open),
            (R.string.close)
        ) {

        }

        drawerToggle.isDrawerIndicatorEnabled = true
        drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
        homeFragment = HomeFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frameLayout, homeFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()

    }

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.menu_main, menu)
//        return true
//    }

//    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
//        menu?.getItem(3)?.isEnabled = false
//        return super.onPrepareOptionsMenu(menu)
//    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when (item.itemId) {
//            R.id.item1 -> Toast.makeText(applicationContext, "selected item 1", Toast.LENGTH_SHORT)
//                .show()
//            R.id.item2 -> Toast.makeText(applicationContext, "selected item 2", Toast.LENGTH_SHORT)
//                .show()
//            R.id.item3 -> Toast.makeText(applicationContext, "selected item 3", Toast.LENGTH_SHORT)
//                .show()
//            R.id.item4 -> Toast.makeText(applicationContext, "selected item 4", Toast.LENGTH_SHORT)
//                .show()
//        }
//
//
//        return super.onOptionsItemSelected(item)
//    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

            R.id.home -> {
                homeFragment = HomeFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frameLayout, homeFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()

            }
            R.id.work -> {
                workFragment = WorkFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frameLayout, workFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()

            }
            R.id.school -> {
                schoolFragment = SchoolFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frameLayout, schoolFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()

            }

            R.id.timeline -> {
                timeLineFragment = TimeLineFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frameLayout, timeLineFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()

            }
            R.id.setting -> {
                settingFragment = SettingFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frameLayout, settingFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()

            }
            R.id.logout -> {
                logOutFragment = LogOutFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frameLayout, logOutFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()

            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}