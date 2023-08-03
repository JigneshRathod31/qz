package com.jignesh.qz

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RvQuizAdapter(val alQuiz: ArrayList<QuizModel>):
    RecyclerView.Adapter<RvQuizAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view: View = LayoutInflater.from(parent.context).inflate(R.layout.rv_quiz_item, parent, false)
        var viewHolder: ViewHolder = ViewHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvQuizTitle!!.text = alQuiz!!.get(position).quizTitle
        holder.tvQuizCode!!.text = "Quiz Code: " + alQuiz!!.get(position).quizCode
        holder.tvNoOfQuestions!!.text = "Questions: " + alQuiz!!.get(position).noOfQuestions.toString()
    }

    override fun getItemCount(): Int {
        return alQuiz.size
    }

    class ViewHolder : RecyclerView.ViewHolder {

        var tvQuizTitle: TextView? = null
        var tvQuizCode: TextView? = null
        var tvNoOfQuestions: TextView? = null

        constructor(itemView: View) : super(itemView) {
            tvQuizTitle = itemView.findViewById(R.id.tv_quiz_title)
            tvQuizCode = itemView.findViewById(R.id.tv_qz_code)
            tvNoOfQuestions = itemView.findViewById(R.id.tv_no_of_questions)
        }
    }
}