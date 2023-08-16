package com.jignesh.qz

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

lateinit var viewPagerQuiz: ViewPager
lateinit var quizViewPagerAdapter: DynamicQuizFragmentAdapter
lateinit var alQuizFragments: ArrayList<DynamicQuizFragment>

class QuizFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        container!!.removeAllViews()
        var view: View = inflater.inflate(R.layout.fragment_quiz, container, false)

        viewPagerQuiz = view.findViewById(R.id.view_pager_quiz)
        alQuizFragments = ArrayList()
        quizViewPagerAdapter = DynamicQuizFragmentAdapter(requireFragmentManager(), alQuizFragments)
        viewPagerQuiz.adapter = quizViewPagerAdapter

        for (i in 1..4){
            alQuizFragments.add(DynamicQuizFragment.newInstance())
        }
        quizViewPagerAdapter.notifyDataSetChanged()

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            QuizFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}