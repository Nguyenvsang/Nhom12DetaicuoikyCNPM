/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom12.entity;

/**
 *
 * @author nguye
 */
public class TopicEvaluationCommittee {
    private int id;
    private int topicID;
    private int lecturerID;

    public TopicEvaluationCommittee() {
    }

    public TopicEvaluationCommittee(int id, int topicID, int lecturerID) {
        this.id = id;
        this.topicID = topicID;
        this.lecturerID = lecturerID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTopicID() {
        return topicID;
    }

    public void setTopicID(int topicID) {
        this.topicID = topicID;
    }

    public int getLecturerID() {
        return lecturerID;
    }

    public void setLecturerID(int lecturerID) {
        this.lecturerID = lecturerID;
    }
    
}
