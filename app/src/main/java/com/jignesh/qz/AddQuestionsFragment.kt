package com.jignesh.qz

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import kotlinx.coroutines.flow.callbackFlow

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

lateinit var viewPagerQuestions: ViewPager
lateinit var tabLayoutQuestions: TabLayout
lateinit var alFragments: ArrayList<DynamicQuestionFragment>
lateinit var dynamicQuestionFragmentAdapter: DynamicQuestionFragmentAdapter

lateinit var ivBackIcon: ImageView
lateinit var iBtnAddQuestion: ImageButton

class AddQuestionsFragment : Fragment() {
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
        container?.removeAllViews()
        var view: View = inflater.inflate(R.layout.fragment_add_questions, container, false)

        viewPagerQuestions = view.findViewById(R.id.view_pager_questions)
        tabLayoutQuestions = view.findViewById(R.id.tab_layout_questions)
        iBtnAddQuestion = view.findViewById(R.id.btn_add_question)
        ivBackIcon = view.findViewById(R.id.iv_back_icon)

        alFragments = ArrayList()
        alFragments!!.add(DynamicQuestionFragment.newInstance())
        tabLayoutQuestions!!.addTab(tabLayoutQuestions!!.newTab().setText("Que. ${alFragments!!.size}"))
        dynamicQuestionFragmentAdapter = DynamicQuestionFragmentAdapter(requireFragmentManager(), alFragments!!)
        viewPagerQuestions!!.adapter = dynamicQuestionFragmentAdapter

        viewPagerQuestions!!.setOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayoutQuestions))

        tabLayoutQuestions!!.setOnTabSelectedListener(object:TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                viewPagerQuestions!!.currentItem = tab!!.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })

        iBtnAddQuestion!!.setOnClickListener(View.OnClickListener { view ->
            alFragments!!.add(DynamicQuestionFragment.newInstance())
            tabLayoutQuestions!!.addTab(tabLayoutQuestions!!.newTab().setText("Que. ${alFragments!!.size}"))

            dynamicQuestionFragmentAdapter!!.notifyDataSetChanged()
            viewPagerQuestions!!.currentItem = (alFragments!!.size - 1)
        })

        ivBackIcon.setOnClickListener(View.OnClickListener { view ->
            activity?.supportFragmentManager?.popBackStack()
        })

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AddQuestionsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}