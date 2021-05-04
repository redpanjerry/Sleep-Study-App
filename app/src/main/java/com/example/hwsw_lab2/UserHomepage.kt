package com.example.hwsw_lab2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.hwsw_lab2.fragment.HomepageFragment
import com.example.hwsw_lab2.fragment.ProfileFragment
import com.example.hwsw_lab2.fragment.SurveyFragment
import kotlinx.android.synthetic.main.activity_user_homepage.*

class UserHomepage : AppCompatActivity() {

    private val homepageFragment = HomepageFragment()
    private val profileFragment = ProfileFragment()
    private val surveyFragment = SurveyFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_homepage)
        replaceFragment(homepageFragment)

        bottom_navigation.setOnNavigationItemReselectedListener {
            when(it.itemId){
                R.id.ic_home -> replaceFragment(homepageFragment)
                R.id.ic_profile -> replaceFragment(profileFragment)
                R.id.ic_survey -> replaceFragment(surveyFragment)
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){
        if (fragment != null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.commit()
        }
    }

}