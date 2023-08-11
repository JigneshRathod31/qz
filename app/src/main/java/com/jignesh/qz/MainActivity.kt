package com.jignesh.qz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.DocumentsContract.Root
import android.sax.RootElement
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    var bottomNavigationView: BottomNavigationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottom_navigation_view)

        loadFragment(PlayQzFragment(), true)

        bottomNavigationView!!.setOnNavigationItemSelectedListener { item ->
            when(item.itemId){
                R.id.nav_play_qz -> {
                    loadFragment(PlayQzFragment(), false)
                }

                R.id.nav_quizzes -> {
                    loadFragment(QuizzesFragment(), false)
                }

                else -> {
                    loadFragment(ProfileFragment(), false)
                }
            }
            true
        }
    }

    fun loadFragment(fragment: Fragment, firstFragment: Boolean){
        var fragmentManager: FragmentManager = supportFragmentManager
        var fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()

        if (firstFragment){
            fragmentTransaction.add(R.id.frame_layout_container, fragment)
        }
        else{
            fragmentTransaction.replace(R.id.frame_layout_container, fragment)
        }

        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}