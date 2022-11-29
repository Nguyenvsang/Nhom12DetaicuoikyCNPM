/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom12.dao;

import com.nhom12.context.DBContext;
import com.nhom12.entity.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author nguye
 */
public class StudentDAOImpl implements StudentDAO {

    // Kết nối
    Connection conn = null;
    // Ném câu lệnh query qua dbms
    PreparedStatement ps = null;
    // Nhận kết quả trả về
    ResultSet rs = null;

    @Override
    public boolean StudentLogin(String username, String password) {
        String query = "SELECT * FROM Student WHERE username = ? and password = ?";
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
    private int studentID;
    private String studentName;
    private String citizenID;
    private String gender;
    private Date dateOfBirth;
    private String email;
    private String phoneNumber;
    private String department;

    @Override
    public Student findStudentByUsername(String username) {
        String query = "SELECT * FROM Student WHERE username = ?";
        try {
            conn = new DBContext().getConnection();// Mở kết nối
            ps = conn.prepareStatement(query.trim());
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                //Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(rs.getDate(5));

                //java.sql.Date sql_StartDate = new java.sql.Date(startDate.getTime());
                
                return new Student(
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

    public static void main(String[] args) {
        StudentDAOImpl dao = new StudentDAOImpl();
        boolean s = dao.StudentLogin("nguyengiacat", "cat@123");
        System.out.println(s);
    }

}
