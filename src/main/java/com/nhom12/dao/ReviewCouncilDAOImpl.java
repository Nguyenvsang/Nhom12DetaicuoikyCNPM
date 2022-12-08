/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom12.dao;

import com.nhom12.context.DBContext;
import com.nhom12.entity.ReviewCouncil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nguye
 */
public class ReviewCouncilDAOImpl implements ReviewCouncilDAO {

    // Kết nối
    Connection conn = null;
    // Ném câu lệnh query qua dbms
    PreparedStatement ps = null;
    // Nhận kết quả trả về
    ResultSet rs = null;
    
    @Override
    public void addCouncil(int leaderID, int topicID, int quantity) {
        String query = "INSERT INTO ReviewCouncil (leaderID, topicID, quantity) VALUES (?, ?, ?)";
        try {
            conn = new DBContext().getConnection();// Mở kết nối
            ps = conn.prepareStatement(query.trim());
            ps.setInt(1, leaderID);
            ps.setInt(2, topicID);
            ps.setInt(3, quantity);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    @Override
    public ReviewCouncil findCouncilByID(int councilID) {
        String query = "SELECT * FROM ReviewCouncil WHERE councilID = ?";
        try {
            conn = new DBContext().getConnection();// Mở kết nối
            ps = conn.prepareStatement(query.trim());
            ps.setInt(1, councilID);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new ReviewCouncil(
                        rs.getInt("councilID"),
                        rs.getInt("leaderID"),
                        rs.getInt("topicID"),
                        rs.getInt("quantity"));
            }
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public ReviewCouncil findCouncilByTopicID(int topicID) {
        String query = "SELECT * FROM ReviewCouncil INNER JOIN Topic WHERE ReviewCouncil.topicID = ?";
        try {
            conn = new DBContext().getConnection();// Mở kết nối
            ps = conn.prepareStatement(query.trim());
            ps.setInt(1, topicID);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new ReviewCouncil(
                        rs.getInt("councilID"),
                        rs.getInt("leaderID"),
                        rs.getInt("topicID"),
                        rs.getInt("quantity"));
            }
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public void updateCouncil(int councilID, int leaderID, int topicID, int quantity) {
        String query = "UPDATE ReviewCouncil SET leaderID = ?,  topicID = ?, quantity = ? WHERE councilID = ?";
        try {
            conn = new DBContext().getConnection();// Mở kết nối
            ps = conn.prepareStatement(query.trim());
            ps.setInt(1, leaderID);
            ps.setInt(2, topicID);
            ps.setInt(3, quantity);
            ps.setInt(4, councilID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    @Override
    public List<ReviewCouncil> getAllReviewCouncils(){
        List<ReviewCouncil> council = new ArrayList<>();
        String query = "SELECT * FROM ReviewCouncil;";
        try {
            conn = new DBContext().getConnection();// Mở kết nối
            ps = conn.prepareStatement(query.trim());
            rs = ps.executeQuery();
            while (rs.next()) {
                council.add(new ReviewCouncil(
                        rs.getInt("councilID"),
                        rs.getInt("leaderID"),
                        rs.getInt("topicID"),
                        rs.getInt("quantity")));
            }
        } catch (Exception e) {
        }
        return council;
    }
    
    public static void main(String[] args) {
        ReviewCouncilDAOImpl dao = new ReviewCouncilDAOImpl();
        TopicEvaluationCommitteeDAOImpl dao2 = new TopicEvaluationCommitteeDAOImpl();
        dao.addCouncil(1, 1, 1);
        dao2.addTopicEvaluationCommittee(1,1);
        ReviewCouncil council = dao.findCouncilByID(1);
        System.out.println(dao2.findTECommitteeByLecturerandCouncil(1, council.getCouncilID()));
        System.out.print("1");
    }
    
}
