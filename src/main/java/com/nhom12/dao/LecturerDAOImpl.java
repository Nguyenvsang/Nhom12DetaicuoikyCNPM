/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom12.dao;

import com.nhom12.context.DBContext;
import com.nhom12.entity.Lecturer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class LecturerDAOImpl implements LecturerDAO {
    // Kết nối

    Connection conn = null;
    // Ném câu lệnh query qua dbms
    PreparedStatement ps = null;
    // Nhận kết quả trả về
    ResultSet rs = null;
    
    @Override
    public boolean LecturerLogin(String username, String password) {
        String query = "SELECT * FROM Lecturer WHERE username = ? and password = ?";
        try {
            conn = new DBContext().getConnection();// Mở kết nối
            ps = conn.prepareStatement(query.trim());
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }
    public static void main(String[] args) {
        LecturerDAOImpl dao = new LecturerDAOImpl();
        boolean l = dao.LecturerLogin("nguyenthihong", "hong@111");
        System.out.println(l);
    }   
    
    @Override
    public void addLecturer(String lecturerName, String citizenID, String gender, Date dateOfBirth, String mail, String phoneNumber, String professionalQualification) {
        String query = "INSERT INTO Lecturer (lecturerName, citizenID, gender, dateOfBirth, email, phoneNumber, professionalQualification) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            conn = new DBContext().getConnection();// Mở kết nối
            ps = conn.prepareStatement(query.trim());
            ps.setString(1, lecturerName);
            ps.setString(2, citizenID);
            ps.setString(3, gender);
            ps.setDate(4, (java.sql.Date) dateOfBirth);
            ps.setString(5, mail);
            ps.setString(6, phoneNumber);
            ps.setString(7, professionalQualification);
            ps.executeUpdate();
        } catch (Exception e) {
            {
            }
        }
    }
    
    @Override
    public void editLecturer(int lecturerID, String lecturerName, String citizenID, String gender, Date dateOfBirth, String mail, String phoneNumber, String professionalQualification) {
        String query = "UPDATE Lecturer "
                + "SET lecturerName = ?, citizenID = ?, gender = ?, dateOfBirth = ?, email = ?, phoneNumber = ?, professionalQualification = ?"
                + "WHERE lecturerID = ?";
        try {
            conn = new DBContext().getConnection();// Mở kết nối
            ps = conn.prepareStatement(query.trim());
            ps.setInt(1,lecturerID);
            ps.setString(2, lecturerName);
            ps.setString(3, citizenID);
            ps.setString(4, gender);
            ps.setDate(5, (java.sql.Date) dateOfBirth);
            ps.setString(6, mail);
            ps.setString(7, phoneNumber);
            ps.setString(8, professionalQualification);
            ps.executeUpdate();
        } catch (Exception e) {
            {
            }
        }
    }
    
    @Override
    public Lecturer findLecturerByID(int lecturerID) {
        String query = "SELECT * FROM Topic WHERE topicID = ?";
        try {
            conn = new DBContext().getConnection();// Mở kết nối
            ps = conn.prepareStatement(query.trim());
            ps.setInt(1, lecturerID);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Lecturer(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDate(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8));
            }
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public List<Lecturer> getAlllecturer() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
