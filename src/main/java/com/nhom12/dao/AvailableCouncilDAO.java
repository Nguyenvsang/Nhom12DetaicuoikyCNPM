/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nhom12.dao;

import com.nhom12.entity.AvailableCouncil;

/**
 *
 * @author nguye
 */
public interface AvailableCouncilDAO {
    void addAvaiCouncil(int topicID);
    
    AvailableCouncil findAvaiCouncilByID(int avaiID);

    AvailableCouncil findAvaiCouncilByTopicID(int topicID);
}
