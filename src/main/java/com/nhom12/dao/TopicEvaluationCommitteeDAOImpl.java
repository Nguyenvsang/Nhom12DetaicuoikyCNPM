/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom12.dao;

import com.nhom12.context.DBContext;
import com.nhom12.entity.TopicEvaluationCommittee;
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
    public void addTopicEvaluationCommittee(int lecturerID, int councilID) {
        String query = "INSERT INTO TopicEvaluationCommittee (lecturerID, councilID) VALUES (?, ?)";
        try {
            conn = new DBContext().getConnection();// Mở kết nối
            ps = conn.prepareStatement(query.trim());
            ps.setInt(1, lecturerID);
            ps.setInt(2, councilID);
            ps.executeUpdate();
        } catch (Exception e) {
            {
            }
        }
    }
    
    @Override
    public TopicEvaluationCommittee findTopicEvaluationCommitteeByID(int evaluationID){
        String query = "SELECT * FROM TopicEvaluationCommittee WHERE evaluationID = ?";
        try {
            conn = new DBContext().getConnection();// Mở kết nối
            ps = conn.prepareStatement(query.trim());
            ps.setInt(1, evaluationID);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new TopicEvaluationCommittee(
                        rs.getInt("evaluationID"),
                        rs.getInt("councilID"),
                        rs.getInt("lecturerID"));
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    @Override
    public TopicEvaluationCommittee findTECommitteeByLecturerandCouncil(int lecturerID, int councilID){
        String query = "SELECT * FROM TopicEvaluationCommittee WHERE lecturerID = ? AND councilID = ?";
        try {
            conn = new DBContext().getConnection();// Mở kết nối
            ps = conn.prepareStatement(query.trim());
            ps.setInt(1, lecturerID);            
            ps.setInt(2, councilID);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new TopicEvaluationCommittee(
                        rs.getInt("evaluationID"),
                        rs.getInt("councilID"),
                        rs.getInt("lecturerID"));
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public static void main(String[] args) {
        TopicEvaluationCommitteeDAOImpl dao = new TopicEvaluationCommitteeDAOImpl();
        dao.addTopicEvaluationCommittee(1,7);
        //System.out.println(ll.getDateOfBirth());
    }  
}
