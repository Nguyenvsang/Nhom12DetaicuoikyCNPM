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
                        rs.getInt("topicID"),
                        rs.getString("topicName"),
                        rs.getString("topicRequire"),
                        rs.getString("topicGoal"),
                        rs.getInt("schoolYear"),
                        rs.getInt("quantity"),
                        rs.getInt("typeID"),
                        rs.getInt("subjectID"),
                        rs.getInt("lecturerID")));
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
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9));
            }
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public void addTopic(String topicName, String topicRequire, String topicGoal, int schoolYear, int quantity, int typeID, int subjectID, int lecturerID) {
        String query = "INSERT INTO Topic (topicName, topicRequire, topicGoal, schoolYear, quantity, typeID, subjectID, lecturerID) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            conn = new DBContext().getConnection();// Mở kết nối
            ps = conn.prepareStatement(query.trim());
            ps.setString(1, topicName);
            ps.setString(2, topicRequire);
            ps.setString(3, topicGoal);
            ps.setInt(4, schoolYear);
            ps.setInt(5, 2);
            ps.setInt(6, typeID);
            ps.setInt(7, subjectID);
            ps.setInt(8, lecturerID);
            ps.executeUpdate();
        } catch (Exception e) {
            {
            }
        }
    }

    @Override
    public void editTopic(int topicID, String topicName, String topicRequire, String topicGoal, int schoolYear, int quantity, int typeID, int subjectID, int lecturerID) {
        String query = "UPDATE Topic "
                + "SET topicName = ?, topicRequire = ?, topicGoal = ?, schoolYear = ?, quantity = ?, typeID = ?, subjectID = ?, lecturerID = ?"
                + "WHERE topicID = ?";
        try {
            conn = new DBContext().getConnection();// Mở kết nối
            ps = conn.prepareStatement(query.trim());
            ps.setString(1, topicName);
            ps.setString(2, topicRequire);
            ps.setString(3, topicGoal);
            ps.setInt(4, schoolYear);
            ps.setInt(5, quantity);
            ps.setInt(6, typeID);
            ps.setInt(7, subjectID);
            ps.setInt(8, lecturerID);
            ps.executeUpdate();
        } catch (Exception e) {
            {
            }
        }
    }

    public static void main(String[] args) {
        TopicDAOImpl dao = new TopicDAOImpl();
        //dao.addTopic("Điện thông minh", "2 sinh viên", "Công tắc", 2019, 1, 1, 0, 1);
        Topic topic = dao.findTopicByID(1);
        System.out.print(topic);
    }
}
