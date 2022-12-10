/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom12.dao;

import com.nhom12.context.DBContext;
import com.nhom12.entity.AvailableCouncil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author nguye
 */
public class AvailableCouncilDAOImpl implements AvailableCouncilDAO {
    // Kết nối
    Connection conn = null;
    // Ném câu lệnh query qua dbms
    PreparedStatement ps = null;
    // Nhận kết quả trả về
    ResultSet rs = null;
    
    @Override
    public void addAvaiCouncil(int topicID) {
        String query = "INSERT INTO AvailableCouncil (topicID) VALUES (?)";
        try {
            conn = new DBContext().getConnection();// Mở kết nối
            ps = conn.prepareStatement(query.trim());
            ps.setInt(1, topicID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    @Override
    public AvailableCouncil findAvaiCouncilByID(int avaiID) {
        String query = "SELECT * FROM AvailableCouncil WHERE avaiID = ?";
        try {
            conn = new DBContext().getConnection();// Mở kết nối
            ps = conn.prepareStatement(query.trim());
            ps.setInt(1, avaiID);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new AvailableCouncil(
                        rs.getInt("avaiID"),
                        rs.getInt("topicID"));
            }
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public AvailableCouncil findAvaiCouncilByTopicID(int topicID) {
        String query = "SELECT * FROM AvailableCouncil WHERE topicID = ?";
        try {
            conn = new DBContext().getConnection();// Mở kết nối
            ps = conn.prepareStatement(query.trim());
            ps.setInt(1, topicID);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new AvailableCouncil(
                        rs.getInt("avaiID"),
                        rs.getInt("topicID"));
            }
        } catch (Exception e) {
        }
        return null;
    }

}
