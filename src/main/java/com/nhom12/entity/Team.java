package com.nhom12.entity;

public class Team {
    private int teamID;
    private int leaderID;
    private int topicID;
    private int quantity;

    public Team() {
    }

    public Team(int teamID, int leaderID, int topicID, int quantity) {
        this.teamID = teamID;
        this.leaderID = leaderID;
        this.topicID = topicID;
        this.quantity = quantity;
    }

    public int getTeamID() {
        return teamID;
    }

    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }

    public int getLeaderID() {
        return leaderID;
    }

    public void setLeaderID(int leaderID) {
        this.leaderID = leaderID;
    }

    public int getTopicID() {
        return topicID;
    }

    public void setTopicID(int topicID) {
        this.topicID = topicID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    
}
