package com.jignesh.qz

class QuizModel {
    var quizTitle: String? = null
    var quizCode: String? = null
    var noOfQuestions: Int? = null
    var quizCreateDate: String? = null
    var noOfPlays: Int? = null

    constructor(
        quizTitle: String?,
        quizCode: String?,
        noOfQuestions: Int?,
        quizCreateDate: String?,
        noOfPlays: Int?
    ) {
        this.quizTitle = quizTitle
        this.quizCode = quizCode
        this.noOfQuestions = noOfQuestions
        this.quizCreateDate = quizCreateDate
        this.noOfPlays = noOfPlays
    }
}