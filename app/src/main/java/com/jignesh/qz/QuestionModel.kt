package com.jignesh.qz

class QuestionModel {
    lateinit var question: String
    lateinit var correctAns: String

    constructor(question: String, correctAns: String){
        this.question = question
        this.correctAns = correctAns
    }
}