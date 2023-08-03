package com.jignesh.qz

class QuizModel {
    var quizTitle: String? = null
    var quizCode: String? = null
    var noOfQuestions: Int? = null

    constructor(quizTitle: String?, quizCode: String?, noOfQuestions: Int?) {
        this.quizTitle = quizTitle
        this.quizCode = quizCode
        this.noOfQuestions = noOfQuestions
    }
}