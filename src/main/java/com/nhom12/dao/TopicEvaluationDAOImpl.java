package com.nhom12.dao;

import com.nhom12.context.DBContext;
import com.nhom12.entity.Topic;
import com.nhom12.entity.TopicEvaluation;
import com.nhom12.entity.TopicRegistration;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TopicEvaluationDAOImpl implements TopicEvaluationDAO {

    // Kết nối
    Connection conn = null;
    // Ném câu lệnh query qua dbms
    PreparedStatement ps = null;
    // Nhận kết quả trả về
    ResultSet rs = null;

    @Override
    public List<TopicEvaluation> getAllEvaluation() {
        List<TopicEvaluation> topicEvaluation = new ArrayList<>();
        String query = "SELECT * FROM TopicEvaluation;";
        try {
            conn = new DBContext().getConnection();// Mở kết nối
            ps = conn.prepareStatement(query.trim());
            rs = ps.executeQuery();
            while (rs.next()) {
                topicEvaluation.add(new TopicEvaluation(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getDouble(5),
                        rs.getDate(6)));
            }
        } catch (Exception e) {
        }
        return topicEvaluation;
    }

    @Override
    public TopicEvaluation findTopicEvaluationByLecturer(int topicID) {
        String query = "SELECT * FROM TopicEvaluation e "
                + "INNER JOIN Committee c WHERE c.id = e.committeeID"
                + "WHERE c.topicID = ?";
        try {
            conn = new DBContext().getConnection();// Mở kết nối
            ps = conn.prepareStatement(query.trim());
            ps.setInt(1, topicID);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new TopicEvaluation(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getDouble(5),
                        rs.getDate(6));
            }
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public List<TopicEvaluation> getEvaluationOfTopic(int topicID) {
        String query = "SELECT * FROM Topic t "
                + "INNER JOIN Committee c WHERE t.topicID = c.id"
                + "INNER JOIN TopicEvaluation e WHERE c.id = e.committeeID"
                + "WHERE t.topicID = ?";

        List<TopicEvaluation> topicEvaluation = new ArrayList<>();
        try {
            conn = new DBContext().getConnection();// Mở kết nối
            ps = conn.prepareStatement(query.trim());
            ps.setInt(1, topicID);
            rs = ps.executeQuery();
            while (rs.next()) {
                topicEvaluation.add(new TopicEvaluation(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getDouble(5),
                        rs.getDate(6)));
            }
        } catch (Exception e) {
        }
        return topicEvaluation;
    }

    @Override
    public List<Topic> getListToEvaluate(int lecturerID) {
        String query = "SELECT * FROM Topic t "
                + "INNER JOIN Committee c WHERE t.topicID = c.id"
                + "INNER JOIN TopicEvaluation e WHERE c.id = e.committeeID"
                + "WHERE e.lecturerID = ?";

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
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9)));
            }
        } catch (Exception e) {
        }
        return topic;
    }

    @Override
    public void distributeLecturer(int committeeID, int lecturerID) { // This is for Dean
        String query = "INSERT INTO TopicEvaluation (committeeID, lecturerID) VALUES (?, ?)";
        try {
            conn = new DBContext().getConnection();// Mở kết nối
            ps = conn.prepareStatement(query.trim());
            ps.setInt(1, committeeID);
            ps.setInt(2, lecturerID);
            ps.executeUpdate();
        } catch (Exception e) {
            {
            }
        }
    }

    @Override
    public void evaluateTopic(int id, String evaluation, Double point, java.sql.Timestamp dateEvaluate) { // This is for Lecturer
        String query = "UPDATE Topic SET evaluation = ?, point = ?, dateEvaluate = ? WHERE id = ?";
        try {
            conn = new DBContext().getConnection();// Mở kết nối
            ps = conn.prepareStatement(query.trim());
            ps.setString(1, evaluation);
            ps.setDouble(2, point);
            ps.setTimestamp(3, dateEvaluate);
            ps.setInt(4, id);
            ps.executeUpdate();
        } catch (Exception e) {
            {
            }
        }
    }
}
