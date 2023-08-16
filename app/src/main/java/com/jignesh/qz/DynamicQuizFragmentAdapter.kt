package com.jignesh.qz

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class DynamicQuizFragmentAdapter(var fm: FragmentManager,var alQuizFragments: ArrayList<DynamicQuizFragment>) : FragmentStatePagerAdapter(fm) {
    override fun getCount(): Int {
        return alQuizFragments.size
    }

    override fun getItem(position: Int): Fragment {
        return alQuizFragments.get(position)
    }
}