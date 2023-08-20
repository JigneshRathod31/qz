package com.jignesh.qz

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RvQuestionsAdapter(val context: Context, val alQuestions: ArrayList<QuestionModel>): RecyclerView.Adapter<RvQuestionsAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvQuestion: TextView = itemView.findViewById(R.id.tv_question)
        var tvCorrectAns: TextView = itemView.findViewById(R.id.tv_correct_ans)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view: View = LayoutInflater.from(context).inflate(R.layout.rv_qz_question_item, parent, false)
        var viewHolder: ViewHolder = ViewHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvQuestion.text = "${position+1}. ${alQuestions.get(position).question}"
        holder.tvCorrectAns.text = "Ans. ${alQuestions.get(position).correctAns}"
    }

    override fun getItemCount(): Int {
        return alQuestions.size
    }
}