/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nhom12.dao;

import com.nhom12.entity.Topic;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface TopicDAO {

    List<Topic> getAllTopics();

    void addTopic(String topicName, String topicRequire, String topicGoal, int schoolYear, int periodID, int lecturerID, int quantity);

    void editTopic(int topicID, String topicName, String topicRequire, String topicGoal, int schoolYear, int periodID, int lecturerID, int quantity);

    Topic findTopicByID(int topicID);

    List<Topic> findTopicByLecturer(int lecturerID); 
    List<Topic> AllTopicsHaveAvaiCouncil();
    
    List<Topic> AllTopicsNoAvaiCouncil();
}
