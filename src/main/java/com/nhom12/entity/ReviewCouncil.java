/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom12.entity;

/**
 *
 * @author nguye
 */
public class ReviewCouncil {
    private int councilID;
    private int leaderID;
    private int topicID;
    private int quantity;

    public ReviewCouncil() {
    }

    public ReviewCouncil(int councilID, int leaderID, int topicID, int quantity) {
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

