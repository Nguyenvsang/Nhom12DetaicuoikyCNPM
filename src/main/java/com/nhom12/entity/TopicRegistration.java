package com.nhom12.entity;

public class TopicRegistration {
    private int id;
    private int studentID;
    private int teamID;

    public TopicRegistration() {
    }

    public TopicRegistration(int id, int studentID, int teamID) {
        this.id = id;
        this.studentID = studentID;
        this.teamID = teamID;
    }

    public int getTeamID() {
        return teamID;
    }

    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }
}
