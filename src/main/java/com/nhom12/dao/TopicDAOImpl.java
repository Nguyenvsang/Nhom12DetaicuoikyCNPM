package com.nhom12.dao;

import com.nhom12.context.DBContext;
import com.nhom12.entity.Topic;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TopicDAOImpl implements TopicDAO {

    // Kết nối
    Connection conn = null;
    // Ném câu lệnh query qua dbms
    PreparedStatement ps = null;
    // Nhận kết quả trả về
    ResultSet rs = null;

    @Override
    public List<Topic> getAllTopics() {
        List<Topic> topic = new ArrayList<>();
        String query = "SELECT * FROM Topic;";
        try {
            conn = new DBContext().getConnection();// Mở kết nối
            ps = conn.prepareStatement(query.trim());
            rs = ps.executeQuery();
            while (rs.next()) {
                topic.add(new Topic(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getDouble(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getInt(10)));
            }
        } catch (Exception e) {
        }
        return topic;
    }

    @Override
    public List<Topic> getTopicsToRegister(int periodID) {
        List<Topic> topic = new ArrayList<>();
        String query = "SELECT * FROM Topic t \n"
                + "INNER JOIN Period p ON t.periodID = p.periodID \n"
                + "WHERE p.periodID = ?;";
        try {
            conn = new DBContext().getConnection();// Mở kết nối
            ps = conn.prepareStatement(query.trim());
            ps.setInt(1, periodID);
            rs = ps.executeQuery();
            while (rs.next()) {
                topic.add(new Topic(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getDouble(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getInt(10)));
            }
        } catch (Exception e) {
        }
        return topic;
    }

    @Override
    public Topic findTopicByID(int topicID) {
        String query = "SELECT * FROM Topic WHERE topicID = ?";
        try {
            conn = new DBContext().getConnection();// Mở kết nối
            ps = conn.prepareStatement(query.trim());
            ps.setInt(1, topicID);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Topic(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getDouble(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getInt(10));
            }
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public List<Topic> findTopicByLecturer(int lecturerID) {
        String query = "SELECT * FROM Topic WHERE lecturerID = ?";
        List<Topic> topic = new ArrayList<>();
        try {
            conn = new DBContext().getConnection();// Mở kết nối
            ps = conn.prepareStatement(query.trim());
            ps.setInt(1, lecturerID);
            rs = ps.executeQuery();
            while (rs.next()) {
                topic.add(new Topic(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getDouble(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getInt(10)));
            }
            if (topic.isEmpty() || topic == null) {
                topic = null;
            }
        } catch (Exception e) {
        }
        return topic;
    }

    @Override
    public void addTopic(String topicName, String topicRequire, String topicGoal, int schoolYear, int periodID, int lecturerID, int quantity) {
        String query = "INSERT INTO Topic (topicName, topicRequire, topicGoal, schoolYear, periodID, lecturerID, quantity) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            conn = new DBContext().getConnection();// Mở kết nối
            ps = conn.prepareStatement(query.trim());
            ps.setString(1, topicName);
            ps.setString(2, topicRequire);
            ps.setString(3, topicGoal);
            ps.setInt(4, schoolYear);
            ps.setInt(5, periodID);
            ps.setInt(6, lecturerID);
            ps.setInt(7, quantity);
            ps.executeUpdate();
        } catch (Exception e) {
            {
            }
        }
    }

    @Override
    public void editTopic(int topicID, String topicName, String topicRequire, String topicGoal, int schoolYear, int periodID, int lecturerID, int quantity) {
        String query = "UPDATE Topic SET topicName = ?, topicRequire = ?, topicGoal = ?, schoolYear = ?, periodID = ?, lecturerID = ?, quantity = ? WHERE topicID = ?";
        try {
            conn = new DBContext().getConnection();// Mở kết nối
            ps = conn.prepareStatement(query.trim());
            ps.setString(1, topicName);
            ps.setString(2, topicRequire);
            ps.setString(3, topicGoal);
            ps.setInt(4, schoolYear);
            ps.setInt(5, periodID);
            ps.setInt(6, lecturerID);
            ps.setInt(7, quantity);
            ps.setInt(8, topicID);
            ps.executeUpdate();
        } catch (Exception e) {
            {
            }
        }
    }

    @Override
    public List<Topic> AllTopicsHaveCouncil() {
        List<Topic> topic = new ArrayList<>();
        String query = "SELECT * FROM Topic, Council Where Topic.topicID = Council.topicID";
        try {
            conn = new DBContext().getConnection();// Mở kết nối
            ps = conn.prepareStatement(query.trim());
            rs = ps.executeQuery();
            while (rs.next()) {
                topic.add(new Topic(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getDouble(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getInt(10)));
            }
        } catch (Exception e) {
        }
        return topic;
    }

    @Override
    public List<Topic> AllTopicsNoCouncil() {
        List<Topic> topic = new ArrayList<>();
        String query = "SELECT * FROM Topic Where TopicID NOT IN (SELECT Topic.topicID FROM Topic, Council Where Topic.topicID = Council.topicID)";
        try {
            conn = new DBContext().getConnection();// Mở kết nối
            ps = conn.prepareStatement(query.trim());
            rs = ps.executeQuery();
            while (rs.next()) {
                topic.add(new Topic(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getDouble(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getInt(10)));
            }
        } catch (Exception e) {
        }
        return topic;
    }

    public static void main(String[] args) {
        TopicDAOImpl dao = new TopicDAOImpl();
        List<Topic> listtopic = dao.AllTopicsNoCouncil();
        for (Topic t : listtopic) {
            System.out.println(t.getTopicName());
        }
    }
}
