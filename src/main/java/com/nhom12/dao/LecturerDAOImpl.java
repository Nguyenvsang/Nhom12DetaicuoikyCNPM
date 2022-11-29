/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom12.dao;

import com.nhom12.context.DBContext;
import com.nhom12.entity.Lecturer;
import com.nhom12.entity.Topic;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
    
    @Override
    public void addLecturer(String lecturerName, String citizenID, String gender, Date dateOfBirth, String email, String phoneNumber, String professionalQualification, int deanID, String username, String password) {
        String query = "INSERT INTO Lecturer (lecturerName, citizenID, gender, dateOfBirth, email, phoneNumber, professionalQualification, deanID, username, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            conn = new DBContext().getConnection();// Mở kết nối
            ps = conn.prepareStatement(query.trim());
            ps.setString(1, lecturerName);
            ps.setString(2, citizenID);
            ps.setString(3, gender);
            ps.setDate(4, (java.sql.Date) dateOfBirth);
            ps.setString(5, email);
            ps.setString(6, phoneNumber);
            ps.setString(7, professionalQualification);
            ps.setInt(8, deanID);
            ps.setString(9, username);
            ps.setString(10, password);
            ps.executeUpdate();
        } catch (Exception e) {
            {
            }
        }
    }
    
    @Override
    public void editLecturer(int lecturerID, String lecturerName, String citizenID, String gender, Date dateOfBirth, String mail, String phoneNumber, String professionalQualification, int deanID) {
        String query = "UPDATE Lecturer "
                + "SET lecturerName = ?, citizenID = ?, gender = ?, dateOfBirth = ?, email = ?, phoneNumber = ?, professionalQualification = ?, deanID = ?"
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
            ps.setInt(9, deanID);
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
<<<<<<< Updated upstream
                        rs.getString(8), rs.getString(9));
=======
                        rs.getString(8),
                        rs.getInt(9));
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    @Override
    public Lecturer findLecturerByUsername(String username) {
        String query = "SELECT * FROM Lecturer WHERE username = ?";
        try {
            conn = new DBContext().getConnection();// Mở kết nối
            ps = conn.prepareStatement(query.trim());
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                //Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(rs.getDate(5));

                //java.sql.Date sql_StartDate = new java.sql.Date(startDate.getTime());
                
                return new Lecturer(
                        rs.getInt("lecturerID"),
                        rs.getString("lecturerName"),
                        rs.getString("citizenID"),
                        rs.getString("gender"),
                        rs.getDate("dateOfBirth"),
                        rs.getString("email"),
                        rs.getString("phoneNumber"),
                        rs.getString("professionalQualification"),
                        rs.getInt("deanID"));
>>>>>>> Stashed changes
            }
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public List<Lecturer> getAlllecturer() {
        List<Lecturer> lecturer = new ArrayList<>();
        String query = "SELECT * FROM Lecturer;";
        try {
            conn = new DBContext().getConnection();// Mở kết nối
            ps = conn.prepareStatement(query.trim());
            rs = ps.executeQuery();
            while (rs.next()) {
                lecturer.add(new Lecturer(
                        rs.getInt("lecturerID"),
                        rs.getString("lecturerName"),
                        rs.getString("citizenID"),
                        rs.getString("gender"),
                        rs.getDate("dateOfBirth"),
                        rs.getString("email"),
                        rs.getString("phoneNumber"),
                        rs.getString("professionalQualification"),
<<<<<<< Updated upstream
                        rs.getString(9)));
=======
                        rs.getInt("deanID")));
>>>>>>> Stashed changes
            }
        } catch (Exception e) {
        }
        return lecturer;
    }
<<<<<<< Updated upstream
    public static void main(String[] args) {
        LecturerDAOImpl dao = new LecturerDAOImpl();
        dao.addLecturer("Nguyen Thi Nhung", "089456781256", "Nu",  new Date(622790105000L) , "nhung@111", "0397461236", "Thạc Sỹ");
    }     
=======
    
    

>>>>>>> Stashed changes
}
