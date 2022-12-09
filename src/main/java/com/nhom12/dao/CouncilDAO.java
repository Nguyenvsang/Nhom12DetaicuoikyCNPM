/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nhom12.dao;

import com.nhom12.entity.Council;
import java.util.List;

/**
 *
 * @author nguye
 */
public interface CouncilDAO {
    void addCouncil(int leaderID, int topicID, int quantity);

    Council findCouncilByID(int councilID);

    Council findCouncilByTopicID(int topicID);

    void updateCouncil(int councilID, int leaderID, int topicID, int quantity);
    
    List<Council> getAllReviewCouncils();
}
