package com.nhom12.entity;

import java.util.Date;

public class TopicEvaluation {
    /*
    A committee includes:
    - ID
    - topicID
    - quantity
    So a teacher is assigned to a committee to evaluate a topic.
    Then the committee will check all evaluation to give the final point for the topic
    */
    int id;
    int committeeID;
    int lecturerID;
    String evaluation;
    double point;
    Date dateEvaluate;

    public TopicEvaluation() {
    }
    // This is for the dean to fill.
    public TopicEvaluation(int id, int committeeID, int lecturerID, String evaluation, double point, Date dateEvaluate) {
        this.id = id;
        this.committeeID = committeeID; //
        this.lecturerID = lecturerID; 
        this.evaluation = evaluation; // When first created, it is null.
        this.point = point; // When first created, it is null.
        this.dateEvaluate = dateEvaluate;
    }
    
    public int getLecturerID() {
        return lecturerID;
    }

    public void setLecturerID(int lecturerID) {
        this.lecturerID = lecturerID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCommitteeID() {
        return committeeID;
    }

    public void setCommitteeID(int committeeID) {
        this.committeeID = committeeID;
    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public Date getDateEvaluate() {
        return dateEvaluate;
    }

    public void setDateEvaluate(Date dateEvaluate) {
        this.dateEvaluate = dateEvaluate;
    }
    
    
}
