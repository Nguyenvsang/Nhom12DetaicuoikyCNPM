/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nhom12.dao;

import com.nhom12.entity.TopicEvaluationCommittee;

/**
 *
 * @author nguye
 */
public interface TopicEvaluationCommitteeDAO {
    void addTopicEvaluationCommittee(int lecturerID, int councilID);
    TopicEvaluationCommittee findTopicEvaluationCommitteeByID(int evaluationID);
    TopicEvaluationCommittee findTECommitteeByLecturerandCouncil(int lecturerID, int councilID);
}
