package com.nhom12.dao;

import com.nhom12.context.DBContext;
import com.nhom12.entity.Council;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CouncilDAOImpl implements CouncilDAO {

    // Kết nối
    Connection conn = null;
    // Ném câu lệnh query qua dbms
    PreparedStatement ps = null;
    // Nhận kết quả trả về
    ResultSet rs = null;
    
    @Override
    public void addCouncil(int topicID, int quantity) {
        //String query = "INSERT INTO Council (leaderID, topicID, quantity) VALUES (?, ?, ?)";
        String query = "INSERT INTO Council (topicID, quantity) VALUES (?, ?)";
        try {
            conn = new DBContext().getConnection();// Mở kết nối
            ps = conn.prepareStatement(query.trim());
            //ps.setInt(1, leaderID);
            ps.setInt(1, topicID);
            ps.setInt(2, quantity);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    @Override
    public Council findCouncilByID(int councilID) {
        String query = "SELECT * FROM Council WHERE councilID = ?";
        try {
            conn = new DBContext().getConnection();// Mở kết nối
            ps = conn.prepareStatement(query.trim());
            ps.setInt(1, councilID);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Council(
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
    public Council findCouncilByTopicID(int topicID) {
        String query = "SELECT * FROM Council INNER JOIN Topic WHERE Council.topicID = ?";
        try {
            conn = new DBContext().getConnection();// Mở kết nối
            ps = conn.prepareStatement(query.trim());
            ps.setInt(1, topicID);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Council(
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
        String query = "UPDATE Council SET leaderID = ?,  topicID = ?, quantity = ? WHERE councilID = ?";
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
    public List<Council> getAllReviewCouncils(){
        List<Council> council = new ArrayList<>();
        String query = "SELECT * FROM Council;";
        try {
            conn = new DBContext().getConnection();// Mở kết nối
            ps = conn.prepareStatement(query.trim());
            rs = ps.executeQuery();
            while (rs.next()) {
                council.add(new Council(
                        rs.getInt("councilID"),
                        rs.getInt("leaderID"),
                        rs.getInt("topicID"),
                        rs.getInt("quantity")));
            }
        } catch (Exception e) {
        }
        return council;
    }
    
//    public static void main(String[] args) {
//        CouncilDAOImpl dao = new CouncilDAOImpl();
//        TopicEvaluationCommitteeDAOImpl dao2 = new TopicEvaluationCommitteeDAOImpl();
//        dao.addCouncil(1, 1, 1);
//        dao2.addTopicEvaluationCommittee(1,1);
//        Council council = dao.findCouncilByID(1);
//        System.out.println(dao2.findTECommitteeByLecturerandCouncil(1, council.getCouncilID()));
//        System.out.print("1");
//    }
    
        public static void main(String[] args) {
        CouncilDAOImpl dao = new CouncilDAOImpl();
        dao.addCouncil(4, 5);
        Council council = dao.findCouncilByID(1);
        //System.out.println(dao2.findTECommitteeByLecturerandCouncil(1, council.getCouncilID()));
        //System.out.print("1");
    }
    
}
