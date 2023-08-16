package com.jignesh.qz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class DynamicQuizFragment: Fragment() {

    companion object{
        fun newInstance(): DynamicQuizFragment{
            return DynamicQuizFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View = inflater.inflate(R.layout.fragment_dynamic_quiz_layout, container, false)



        return view
    }
}