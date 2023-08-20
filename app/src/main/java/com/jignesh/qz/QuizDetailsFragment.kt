package com.jignesh.qz

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class QuizDetailsFragment : Fragment() {

    lateinit var tvCancelQz: TextView
    lateinit var tvSaveQz: TextView

    lateinit var btnAddQuestionOnQuizDetails: Button

    lateinit var rvQzQuestions: RecyclerView
    lateinit var alQuestions: ArrayList<QuestionModel>
    lateinit var rvQuestionsAdapter: RvQuestionsAdapter

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
        var view: View = inflater.inflate(R.layout.fragment_quiz_details, container, false)

        rvQzQuestions = view.findViewById(R.id.rv_qz_questions)
        btnAddQuestionOnQuizDetails = view.findViewById(R.id.btn_add_question)
        tvCancelQz = view.findViewById(R.id.tv_cancel_qz)
        tvSaveQz = view.findViewById(R.id.tv_save_qz)

        rvQzQuestions.layoutManager = LinearLayoutManager(context)
        alQuestions = ArrayList()
        rvQuestionsAdapter = RvQuestionsAdapter(requireContext(), alQuestions)
        rvQzQuestions.adapter = rvQuestionsAdapter

        alQuestions.add(QuestionModel("What is the capital of Gujarat?", "Gandhinagar"))
        alQuestions.add(QuestionModel("What is the capital of Goa?", "Panji"))
        alQuestions.add(QuestionModel("What is the capital of MP?", "Bhopal"))
        alQuestions.add(QuestionModel("What is the capital of UP?", "Lakhnau"))
        alQuestions.add(QuestionModel("What is the capital of Bihar?", "Patna"))
        alQuestions.add(QuestionModel("What is the capital of Maharashtra?", "Mumbai"))
        alQuestions.add(QuestionModel("What is the capital of Rajasthan?", "Jaipur"))
        rvQuestionsAdapter.notifyDataSetChanged()

        tvCancelQz.setOnClickListener(View.OnClickListener { view ->
            activity?.supportFragmentManager?.popBackStack()
        })

        tvSaveQz.setOnClickListener(View.OnClickListener { view ->

        })

        btnAddQuestionOnQuizDetails.setOnClickListener(View.OnClickListener { view ->
            Utils.replaceFragment(R.id.frame_layout_container, AddQuestionsFragment(), requireFragmentManager())
        })

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            QuizDetailsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}