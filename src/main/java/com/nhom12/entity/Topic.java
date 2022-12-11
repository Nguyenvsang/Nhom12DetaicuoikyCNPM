package com.nhom12.entity;

public class Topic {

    private int topicID;
    private String topicName;
    private String topicRequire;
    private String topicGoal;
    private int schoolYear;
    private int quantity;
    private double point;
    private int periodID;
    private int subjectID;
    private int lecturerID;

    public Topic() {
    }

    public Topic(int topicID, String topicName, String topicRequire, String topicGoal, int schoolYear, int quantity, double point, int periodID, int subjectID, int lecturerID) {
        this.topicID = topicID;
        this.topicName = topicName;
        this.topicRequire = topicRequire;
        this.topicGoal = topicGoal;
        this.schoolYear = schoolYear;
        this.quantity = quantity;
        this.point = point;
        this.periodID = periodID;
        this.subjectID = subjectID;
        this.lecturerID = lecturerID;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public int getPeriodID() {
        return periodID;
    }

    public void setPeriodID(int periodID) {
        this.periodID = periodID;
    }

    public int getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(int subjectID) {
        this.subjectID = subjectID;
    }

    public int getLecturerID() {
        return lecturerID;
    }

    public void setLecturerID(int lecturerID) {
        this.lecturerID = lecturerID;
    }

    
}
