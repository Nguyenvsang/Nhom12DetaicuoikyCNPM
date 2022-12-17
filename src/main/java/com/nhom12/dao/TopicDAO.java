package com.nhom12.dao;

import com.nhom12.entity.Topic;
import java.sql.SQLException;
import java.util.List;

public interface TopicDAO {

    List<Topic> getAllTopics();
    
    List<Topic> getTopicsByType(int periodID);

    void addTopic(String topicName, String topicRequire, String topicGoal, int schoolYear, int typeID, int periodID, int lecturerID, int quantity);

    void editTopic(int topicID, String topicName, String topicRequire, String topicGoal, int schoolYear, int quantity);

    Topic findTopicByID(int topicID);

    List<Topic> findTopicByLecturer(int lecturerID); 
    
    List<Topic> AllTopicsHaveCouncil();
    //List<Topic> AllTopicsHaveCouncilByDean(int lecturerID);
    
    List<Topic> AllTopicsNoCouncil();

    List<Topic> getTopicsToRegister(int periodID);

    List<Topic> getTopicsByStudent(int studentID);

    List<Topic> getTopicsByTypeAndSubject(int typeID, int periodID);

    List<Topic> getTopicsByLeadLecturer(int lecturerID);

    // if topic has no point, return true
    boolean checkPoint(int topicID) throws SQLException;

    void markTopic(int topicID, double point);
}
