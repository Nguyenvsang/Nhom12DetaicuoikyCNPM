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

/**
 *
 * @author nguye
 */
public class DeanDAOImpl implements DeanDAO {
    // Kết nối
    Connection conn = null;
    // Ném câu lệnh query qua dbms
    PreparedStatement ps = null;
    // Nhận kết quả trả về
    ResultSet rs = null;
    
    @Override
    public boolean DeanLogin(String username, String password) {
        String query = "SELECT * FROM Lecturer WHERE username = ? and password = ? and lecturerID = deanID";
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
    public Lecturer findDeanByUsername(String username) {
        String query = "SELECT * FROM Lecturer WHERE username = ? and lecturerID = deanID";
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
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public static void main(String[] args) {
        DeanDAOImpl dao = new DeanDAOImpl();
        boolean l = dao.DeanLogin("tranvanxuan", "xuan@111");
        Lecturer ll = dao.findDeanByUsername("nguyenvansong");
        System.out.println(l);
        System.out.println(ll.getDateOfBirth());
    }  
}
