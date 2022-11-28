package com.nhom12.dao;

import com.nhom12.context.DBContext;
import com.nhom12.entity.Team;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TeamDAOImpl implements TeamDAO {

    // Kết nối
    Connection conn = null;
    // Ném câu lệnh query qua dbms
    PreparedStatement ps = null;
    // Nhận kết quả trả về
    ResultSet rs = null;

    @Override
    public Team findTeamByID(int teamID) {
        String query = "SELECT * FROM Team WHERE teamID = ?";
        try {
            conn = new DBContext().getConnection();// Mở kết nối
            ps = conn.prepareStatement(query.trim());
            ps.setInt(1, teamID);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Team(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4));
            }
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public void addTeam(int leaderID, int topicID, int quantity) {
        String query = "INSERT INTO Team (leaderID, topicID, quantity) VALUES (?, ?, ?)";
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
    public void updateTeam(int teamID, int leaderID, int topicID, int quantity) {
        String query = "UPDATE Team SET leaderID = ?,  topicID = ?, quantity = ? WHERE teamID = ?";
        try {
            conn = new DBContext().getConnection();// Mở kết nối
            ps = conn.prepareStatement(query.trim());
            ps.setInt(1, leaderID);
            ps.setInt(2, topicID);
            ps.setInt(3, quantity);
            ps.setInt(4, teamID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    @Override
    public Team findTeamByTopicID(int topicID) {
        String query = "SELECT * FROM Team INNER JOIN Topic WHERE Team.topicID = ?";
        try {
            conn = new DBContext().getConnection();// Mở kết nối
            ps = conn.prepareStatement(query.trim());
            ps.setInt(1, topicID);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Team(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public static void main(String[] args) {
        TeamDAOImpl dao = new TeamDAOImpl();
        Team team = dao.findTeamByTopicID(1);
        team.setQuantity(2);
        System.out.println(team.getLeaderID());
    }
}
