package com.jignesh.qz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.RadioGroup
import androidx.fragment.app.Fragment

class DynamicQuestionFragment: Fragment() {

    companion object{
        fun newInstance(): DynamicQuestionFragment{
            return DynamicQuestionFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View = inflater.inflate(R.layout.fragment_dynamic_question_layout, container, false)

        return view
    }

    fun initViews(view: View){
        var etQuestion: EditText = view.findViewById(R.id.et_question)
        var etOptionOne: EditText = view.findViewById(R.id.et_option_one)
        var etOptionTwo: EditText = view.findViewById(R.id.et_option_two)
        var etOptionThree: EditText = view.findViewById(R.id.et_option_three)
        var etOptionFour: EditText = view.findViewById(R.id.et_option_four)
        var radioGroupCorrectAns: RadioGroup = view.findViewById(R.id.rg_correct_ans)
    }
}