package com.nhom12.dao;

import com.nhom12.entity.Topic;
import com.nhom12.entity.TopicEvaluation;
import java.sql.Date;
import java.util.List;

public interface TopicEvaluationDAO {

    void distributeLecturer(int councilID, int lecturerID);

    List<TopicEvaluation> getAllEvaluation();

    List<TopicEvaluation> getEvaluationOfTopic(int topicID);

    void evaluateTopic(int id, String evaluation, Double point, java.sql.Timestamp dateEvaluate);

    List<Topic> getListToEvaluate(int lecturerID);

    TopicEvaluation findTopicEvaluation(int topicID, int lecturerID);

    boolean checkEvaluation(TopicEvaluation te);
    // Tìm TopicEvaluation theo cả giảng viên và hội đồng, trả về 
    TopicEvaluation findTopicEvaluationByLandC(int lecturerID, int councilID);
    
}
