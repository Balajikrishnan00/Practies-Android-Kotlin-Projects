package com.balaji_2_2_0_5.bottomnavwithfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.balaji_2_2_0_5.bottomnavwithfragment.fragments.DashBoardFragment
import com.balaji_2_2_0_5.bottomnavwithfragment.fragments.IconFragment
import com.balaji_2_2_0_5.bottomnavwithfragment.fragments.SettingsFragment
import com.google.android.material.navigation.NavigationBarView


class MainActivity : AppCompatActivity() {

    private val fragmentDashBoard=DashBoardFragment()
    private val fragmentIcon=IconFragment()
    private val fragmentSettings=SettingsFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        callFragment(DashBoardFragment())

        NavigationBarView.OnItemReselectedListener {
            when(it.itemId){
                R.id.info-> callFragment(fragmentIcon)
                R.id.settings-> callFragment(SettingsFragment())
                R.id.dash_board->callFragment(DashBoardFragment())
        }
        }



    }

     fun callFragment(fragment:Fragment?){
        if (fragment != null){
            val transection = supportFragmentManager.beginTransaction()
            transection.replace(R.id.fragment_container,fragment)
            transection.commit()
        }
    }

}