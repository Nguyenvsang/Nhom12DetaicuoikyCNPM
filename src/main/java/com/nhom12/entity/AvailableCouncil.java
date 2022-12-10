/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom12.entity;

/**
 *
 * @author nguye
 */
// Nếu topicID có trong bảng AvailableCouncil nghĩa là 
public class AvailableCouncil {
    private int avaiID;
    private int topicID;

    public AvailableCouncil() {
    }

    public AvailableCouncil(int avaiID, int topicID) {
        this.avaiID = avaiID;
        this.topicID = topicID;
    }

    public int getAvaiID() {
        return avaiID;
    }

    public void setAvaiID(int avaiID) {
        this.avaiID = avaiID;
    }

    public int getTopicID() {
        return topicID;
    }

    public void setTopicID(int topicID) {
        this.topicID = topicID;
    }
    
    
}
