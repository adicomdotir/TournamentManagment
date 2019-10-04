package com.example.tournomentmanagement

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction

public class Utils {
    companion object {
        fun addFragmentToActivity(manager: FragmentManager?, fragment: Fragment) {
            val transaction: FragmentTransaction? = manager?.beginTransaction()
            transaction?.replace(R.id.container, fragment)
            transaction?.commit()
        }
    }
}