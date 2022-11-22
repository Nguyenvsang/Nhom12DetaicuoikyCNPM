/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom12.entity;

/**
 *
 * @author nguye
 */
public class Topic {
    private String topicID;
    private String topicName;
    private String topicRequire;
    private String topicGoal;
    private int year;
    private TypeOfTopic type;
    private Subject subject;

    public Topic() {
    }

    public Topic(String topicID, String topicName, String topicRequire, String topicGoal, int year, TypeOfTopic type, Subject subject) {
        this.topicID = topicID;
        this.topicName = topicName;
        this.topicRequire = topicRequire;
        this.topicGoal = topicGoal;
        this.year = year;
        this.type = type;
        this.subject = subject;
    }

    public String getTopicID() {
        return topicID;
    }

    public void setTopicID(String topicID) {
        this.topicID = topicID;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getTopicRequire() {
        return topicRequire;
    }

    public void setTopicRequire(String topicRequire) {
        this.topicRequire = topicRequire;
    }

    public String getTopicGoal() {
        return topicGoal;
    }

    public void setTopicGoal(String topicGoal) {
        this.topicGoal = topicGoal;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public TypeOfTopic getType() {
        return type;
    }

    public void setType(TypeOfTopic type) {
        this.type = type;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    
    
    
}
