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
    private int topicID;
    private String topicName;
    private String topicRequire;
    private String topicGoal;
    private int schoolYear;
    private int typeID;
    private int subjectID;

    public Topic() {
    }

    public Topic(int topicID, String topicName, String topicRequire, String topicGoal, int year, int typeID, int subjectID) {
        this.topicID = topicID;
        this.topicName = topicName;
        this.topicRequire = topicRequire;
        this.topicGoal = topicGoal;
        this.schoolYear = year;
        this.typeID = typeID;
        this.subjectID = subjectID;
    }

    public int getTopicID() {
        return topicID;
    }

    public void setTopicID(int topicID) {
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

    public int getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(int schoolYear) {
        this.schoolYear = schoolYear;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public int getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(int subjectID) {
        this.subjectID = subjectID;
    }

    
}
