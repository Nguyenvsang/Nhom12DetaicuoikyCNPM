/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom12.dao;

import com.nhom12.context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author nguye
 */
public class TopicEvaluationCommitteeDAOImpl implements TopicEvaluationCommitteeDAO {

    // Kết nối
    Connection conn = null;
    // Ném câu lệnh query qua dbms
    PreparedStatement ps = null;
    // Nhận kết quả trả về
    ResultSet rs = null;
    
    @Override
    public void addTopicEvaluationCommittee(int topicID, int lecturerID) {
        String query = "INSERT INTO TopicEvaluationCommittee (topicID, lecturerID) VALUES (?, ?)";
        try {
            conn = new DBContext().getConnection();// Mở kết nối
            ps = conn.prepareStatement(query.trim());
            ps.setInt(1, topicID);
            ps.setInt(2, lecturerID);
            ps.executeUpdate();
        } catch (Exception e) {
            {
            }
        }
    }
    
    public static void main(String[] args) {
        TopicEvaluationCommitteeDAOImpl dao = new TopicEvaluationCommitteeDAOImpl();
        dao.addTopicEvaluationCommittee(1,7);
        //System.out.println(ll.getDateOfBirth());
    }  
}
