package com.nhom12.dao;

import com.nhom12.context.DBContext;
import com.nhom12.entity.Topic;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TopicDAOImpl implements TopicDAO{

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
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7)));
            }
        } catch (Exception e) {
        }
        return topic;
    }

    @Override
    public void addTopic(String topicID, String topicName, String topicRequire, String topicGoal, int schoolYear, String typeID, String subjectID) {
        String query = "INSERT INTO Topic VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            conn = new DBContext().getConnection();// Mở kết nối
            ps = conn.prepareStatement(query.trim());
            ps.setString(1, topicID);
            ps.setString(2, topicName);
            ps.setString(3, topicRequire);
            ps.setString(4, topicGoal);
            ps.setInt(5, schoolYear);
            ps.setString(6, typeID);
            ps.setString(7, subjectID);
            ps.executeUpdate();
        } catch (Exception e) {
            {
            }
        }
    }
    

    public static void main(String[] args) {
        TopicDAOImpl dao = new TopicDAOImpl();
        dao.addTopic("04", "Điện thông minh", "2 sinh viên", "Công tắc", 2019, "TO001", "SU001");
    }
}
