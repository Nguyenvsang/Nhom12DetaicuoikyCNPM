package com.nhom12.dao;

import com.nhom12.entity.Topic;
import java.util.List;

public interface TopicDAO {

    List<Topic> getAllTopics();

    void addTopic(String topicName, String topicRequire, String topicGoal, int schoolYear, int typeID, int periodID, int lecturerID, int quantity);

    void editTopic(int topicID, String topicName, String topicRequire, String topicGoal, int schoolYear, int quantity);

    Topic findTopicByID(int topicID);

    List<Topic> findTopicByLecturer(int lecturerID); 
    
    List<Topic> AllTopicsHaveCouncil();
    
    List<Topic> AllTopicsNoCouncil();

    List<Topic> getTopicsToRegister(int periodID);
    
    List<Topic> getTopicsByStudent(int studentID);
}
