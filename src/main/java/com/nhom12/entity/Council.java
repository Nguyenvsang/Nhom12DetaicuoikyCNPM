package com.nhom12.entity;

public class Council {
    private int councilID;
    private int leaderID;
    private int topicID;
    private int quantity;

    public Council() {
    }

    public Council(int councilID, int leaderID, int topicID, int quantity) {
        this.councilID = councilID;
        this.leaderID = leaderID;
        this.topicID = topicID;
        this.quantity = quantity;
    }

    public int getCouncilID() {
        return councilID;
    }

    public void setCouncilID(int councilID) {
        this.councilID = councilID;
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

