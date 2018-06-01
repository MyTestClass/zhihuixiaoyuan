package com.example.witgather.bean;

public class Question_Bean {
    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public String getQuestionImageUrl() {
        return questionImageUrl;
    }

    public void setQuestionImageUrl(String questionImageUrl) {
        this.questionImageUrl = questionImageUrl;
    }

    public String getQuestionState() {
        return questionState;
    }

    public void setQuestionState(String questionState) {
        this.questionState = questionState;
    }

    public String getQuestionUserId() {
        return questionUserId;
    }

    public void setQuestionUserId(String questionUserId) {
        this.questionUserId = questionUserId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getQuestionPrice() {
        return questionPrice;
    }

    public void setQuestionPrice(String questionPrice) {
        this.questionPrice = questionPrice;
    }

    public String getIsSolve() {
        return isSolve;
    }

    public void setIsSolve(String isSolve) {
        this.isSolve = isSolve;
    }

    public String getAnswerCount() {
        return answerCount;
    }

    public void setAnswerCount(String answerCount) {
        this.answerCount = answerCount;
    }

    private String answerCount;
    private String isSolve;
    private String questionPrice;
    private String subject;
    private String questionId;
    private String questionTitle;
    private String questionContent;
    private String questionImageUrl;
    private String questionState;
    private String questionUserId;
}
