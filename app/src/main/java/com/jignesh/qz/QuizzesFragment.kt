package com.jignesh.qz

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

var rvQuizzes: RecyclerView? = null
var ivCreateNewQz: ImageView? = null
var rvQuizAdapter: RvQuizAdapter? = null

class QuizzesFragment : Fragment() {
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
        var view: View = inflater.inflate(R.layout.fragment_quizzes, container, false)

        rvQuizzes = view.findViewById(R.id.rv_quizzes)
        ivCreateNewQz = view.findViewById(R.id.iv_create_new_qz)

        try {
            rvQuizzes!!.layoutManager = LinearLayoutManager(context)
            var alQuiz = ArrayList<QuizModel>()
            rvQuizAdapter = RvQuizAdapter(alQuiz)
            rvQuizzes!!.adapter = rvQuizAdapter

            rvQuizzes!!.addItemDecoration(DividerItemDecoration(context, LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false).orientation))

            alQuiz!!.add(QuizModel("KnowledgeQuiz", "123456", 8, "31/07/2023", 24))
            alQuiz!!.add(QuizModel("KnowledgeQuiz", "123456", 8, "31/07/2023", 24))
            alQuiz!!.add(QuizModel("KnowledgeQuiz", "123456", 8, "31/07/2023", 24))
            alQuiz!!.add(QuizModel("KnowledgeQuiz", "123456", 8, "31/07/2023", 24))
            alQuiz!!.add(QuizModel("KnowledgeQuiz", "123456", 8, "31/07/2023", 24))
            alQuiz!!.add(QuizModel("KnowledgeQuiz", "123456", 8, "31/07/2023", 24))
            alQuiz!!.add(QuizModel("KnowledgeQuiz", "123456", 8, "31/07/2023", 24))
            alQuiz!!.add(QuizModel("KnowledgeQuiz", "123456", 8, "31/07/2023", 24))
            alQuiz!!.add(QuizModel("KnowledgeQuiz", "123456", 8, "31/07/2023", 24))
            alQuiz!!.add(QuizModel("KnowledgeQuiz", "123456", 8, "31/07/2023", 24))
            alQuiz!!.add(QuizModel("KnowledgeQuiz", "123456", 8, "31/07/2023", 24))
            alQuiz!!.add(QuizModel("KnowledgeQuiz", "123456", 8, "31/07/2023", 24))
            alQuiz!!.add(QuizModel("KnowledgeQuiz", "123456", 8, "31/07/2023", 24))

            rvQuizAdapter!!.notifyDataSetChanged()
        }catch (e: Exception){
            Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show()
        }

        ivCreateNewQz!!.setOnClickListener(View.OnClickListener{ view ->
            var fragmentManager: FragmentManager? = getFragmentManager()
            var fragmentTransaction: FragmentTransaction = fragmentManager!!.beginTransaction()
            fragmentTransaction.replace(R.id.frame_layout_container, QuizDetailsFragment())
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        })

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            QuizzesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}