package com.example.login

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pandora.bottomnavigator.BottomNavigator

//import androidx.navigation.NavController
//import androidx.fragment.app.Fragment
//import androidx.fragment.app.FragmentController
//import com.google.android.material.bottomnavigation.BottomNavigationView
//import com.google.android.material.bottomnavigation.BottomNavigationItemView
//import com.google.android.material.bottomnavigation.BottomNavigationMenuView
//import androidx.navigation.findNavController
//import androidx.navigation.ui.AppBarConfiguration
//import androidx.navigation.ui.setupActionBarWithNavController
//import androidx.navigation.ui.setupWithNavController
//import androidx.navigation.fragment.NavHostFragment
//import androidx.navigation.ui.NavigationUI.setupWithNavController


class HomeActivity : AppCompatActivity() {

//    private lateinit var navController: NavController

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var navigator: BottomNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        navigator = BottomNavigator.onCreate(
            fragmentContainer = R.id.mainContainer,
            bottomNavigationView = findViewById(R.id.bottomNavigation),
            rootFragmentsFactory = mapOf(
                    R.id.navigation_home to {FragmentKos()},
                    R.id.navigation_chat to {ChatFragment()},
                    R.id.navigation_pemesanan to {PemesananFragment()},
                    R.id.navigation_profile to {ProfileFragment()}
            ),
            defaultTab = R.id.navigation_home,
            activity = this
        )
//        val navHostFragment = supportFragmentManager.findFragmentById(R.id.mainContainer) as NavHostFragment
//        navController = navHostFragment.navController
//        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigation)
//        setupWithNavController(bottomNavigationView, navController)

        sharedPreferences = getSharedPreferences("login", Context.MODE_PRIVATE)

    }

    override fun onBackPressed() {
        if(!navigator.pop()){
            super.onBackPressed()
        }
    }

    fun getSharedPreferences() : SharedPreferences{
        return sharedPreferences
    }
}