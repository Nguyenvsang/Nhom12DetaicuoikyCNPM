package com.nhom12.dao;

import com.nhom12.entity.Team;

public interface TeamDAO {

    void addTeam(int leaderID, int topicID, int quantity);

    Team findTeamByID(int teamID);

    Team findTeamByTopicID(int topicID);

    void updateTeam(int teamID, int leaderID, int topicID, int quantity);
    
}
