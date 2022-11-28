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
}
