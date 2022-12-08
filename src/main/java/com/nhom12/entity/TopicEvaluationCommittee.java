package com.nhom12.entity;

public class TopicEvaluationCommittee {
    private int evaluationID;
    private int councilID;
    private int lecturerID;

    public TopicEvaluationCommittee() {
    }

    public TopicEvaluationCommittee(int evaluationID, int councilID, int lecturerID) {
        this.evaluationID = evaluationID;
        this.councilID = councilID;
        this.lecturerID = lecturerID;
    }

    public int getEvaluationID() {
        return evaluationID;
    }

    public void setEvaluationID(int evaluationID) {
        this.evaluationID = evaluationID;
    }

    public int getCouncilID() {
        return councilID;
    }

    public void setCouncilID(int councilID) {
        this.councilID = councilID;
    }

    public int getLecturerID() {
        return lecturerID;
    }

    public void setLecturerID(int lecturerID) {
        this.lecturerID = lecturerID;
    }
    
}
