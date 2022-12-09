package com.nhom12.entity;

import java.sql.Timestamp;

public class TopicEvaluation {
    /*
    A council includes:
    - ID
    - topicID
    - quantity
    - leaderID
    So a teacher is assigned to a council to evaluate a topic.
    Then the council will check all evaluation to give the final point for the topic
    */
    int id;
    int councilID;
    int lecturerID;
    String evaluation;
    double point;
    Timestamp dateEvaluate;

    public TopicEvaluation() {
    }
    // This is for the dean to fill.
    public TopicEvaluation(int id, int councilID, int lecturerID, String evaluation, double point, Timestamp dateEvaluate) {
        this.id = id;
        this.councilID = councilID; 
        this.lecturerID = lecturerID; 
        this.evaluation = evaluation; // When first created, it is null.
        this.point = point; // When first created, it is null.
        this.dateEvaluate = dateEvaluate; // When first created, it is null.
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

    public int getCouncilID() {
        return councilID;
    }

    public void setCouncilID(int councilID) {
        this.councilID = councilID;
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

    public Timestamp getTimestampEvaluate() {
        return dateEvaluate;
    }

    public void setTimestampEvaluate(Timestamp dateEvaluate) {
        this.dateEvaluate = dateEvaluate;
    }
    
    
}
