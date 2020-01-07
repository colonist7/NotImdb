package com.example.notimdb.DetaildInfo

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PagarAdapter(fm: FragmentManager,info : InfoFragment,cast : CastFragment) : FragmentPagerAdapter(fm) {
    val info = info
    val cast = cast

    override fun getCount(): Int {
        return 2
    }

    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> {
                info
            }
            else -> {
                cast
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            0 -> "Info"
            else -> "Cast"
        }
    }

}