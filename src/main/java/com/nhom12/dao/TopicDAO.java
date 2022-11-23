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

    void addTopic(String topicName, String topicRequire, String topicGoal, int schoolYear, String typeID, String subjectID);

    void editTopic(int topicID, String topicName, String topicRequire, String topicGoal, int schoolYear, String typeID, String subjectID);

    Topic findTopicByID(int topicID);
    
}
