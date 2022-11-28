package com.nhom12.dao;

import com.nhom12.context.DBContext;
import com.nhom12.entity.Topic;
import com.nhom12.entity.TopicRegistration;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TopicRegistrationDAOImpl implements TopicRegistrationDAO{
    // Kết nối
    Connection conn = null;
    // Ném câu lệnh query qua dbms
    PreparedStatement ps = null;
    // Nhận kết quả trả về
    ResultSet rs = null;

    @Override
    public TopicRegistration findTopicRegistrationByID(int id) {
        String query = "SELECT * FROM TopicRegistration WHERE id = ?";
        try {
            conn = new DBContext().getConnection();// Mở kết nối
            ps = conn.prepareStatement(query.trim());
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new TopicRegistration(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3));
            }
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public TopicRegistration findTopicRegistrationBySandT(int studentID, int teamID) {
        String query = "SELECT * FROM TopicRegistration WHERE studentID = ? AND teamID = ?";
        try {
            conn = new DBContext().getConnection();// Mở kết nối
            ps = conn.prepareStatement(query.trim());
            ps.setInt(1, studentID);            
            ps.setInt(1, teamID);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new TopicRegistration(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3));
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    @Override
    public void addTopicRegistration(int studentID, int teamID) {
        String query = "INSERT INTO TopicRegistration (studentID, teamID) VALUES (?, ?)";
        try {
            conn = new DBContext().getConnection();// Mở kết nối
            ps = conn.prepareStatement(query.trim());
            ps.setInt(1, studentID);
            ps.setInt(2, teamID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
