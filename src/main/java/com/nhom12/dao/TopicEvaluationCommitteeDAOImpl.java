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
    public void addTopicEvaluationCommittee(int id, int topicID, int lecturerID, int quantity) {
        String query = "INSERT INTO TopicEvaluationCommittee (topicID, lecturerID, quantity) VALUES (?, ?, ?)";
        try {
            conn = new DBContext().getConnection();// Mở kết nối
            ps = conn.prepareStatement(query.trim());
            ps.setInt(1, topicID);
            ps.setInt(2, lecturerID);
            ps.setInt(3, quantity);
            ps.executeUpdate();
        } catch (Exception e) {
            {
            }
        }
    }
    
}
