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
    private int schoolYear;
    private String typeID;
    private String subjectID;

    public Topic() {
    }

    public Topic(String topicID, String topicName, String topicRequire, String topicGoal, int year, String typeID, String subjectID) {
        this.topicID = topicID;
        this.topicName = topicName;
        this.topicRequire = topicRequire;
        this.topicGoal = topicGoal;
        this.schoolYear = year;
        this.typeID = typeID;
        this.subjectID = subjectID;
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

    public int getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(int schoolYear) {
        this.schoolYear = schoolYear;
    }

    public String getTypeID() {
        return typeID;
    }

    public void setTypeID(String typeID) {
        this.typeID = typeID;
    }

    public String getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(String subjectID) {
        this.subjectID = subjectID;
    }

    
}
