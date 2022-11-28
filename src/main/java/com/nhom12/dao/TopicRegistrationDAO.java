package com.nhom12.dao;

import com.nhom12.entity.TopicRegistration;

public interface TopicRegistrationDAO {

    void addTopicRegistration(int studentID, int teamID);

    TopicRegistration findTopicRegistrationByID(int id);

    TopicRegistration findTopicRegistrationBySandT(int studentID, int teamID);
    
}
