package com.jignesh.qz

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class DynamicQuestionFragmentAdapter(var fragmentManager: FragmentManager, var alFragments: ArrayList<DynamicQuestionFragment>): FragmentStatePagerAdapter(fragmentManager) {
    override fun getCount(): Int {
        return alFragments.size
    }

    override fun getItem(position: Int): Fragment {
        return alFragments.get(position)
    }
}