package com.nhom12.dao;

import com.nhom12.context.DBContext;
import com.nhom12.entity.Admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminDAOImpl implements AdminDAO {

    // Kết nối
    Connection conn = null;
    // Ném câu lệnh query qua dbms
    PreparedStatement ps = null;
    // Nhận kết quả trả về
    ResultSet rs = null;

    @Override
    public boolean AdminLogin(String username, String password) {
        String query = "SELECT * FROM Admin WHERE username = ? and password = ?";
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
    public void updateAdmin(String username, String password) {
        String query = "UPDATE Admin SET password = ? WHERE username = ?";
        try {
            conn = new DBContext().getConnection();// Mở kết nối
            ps = conn.prepareStatement(query.trim());
            ps.setString(1, password);
            ps.setString(2, username);

            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

//    @Override
//    public Admin checkPasswordAdmin(String username, String password) {
//        String query = "SELECT * FROM Admin WHERE username = ? AND password = ?";
//        try {
//            conn = new DBContext().getConnection();// Mở kết nối
//            ps = conn.prepareStatement(query.trim());
//            ps.setString(1, username);
//            ps.setString(2, password);
//
//            ps.executeQuery();
//            while (rs.next()) {
//                //Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(rs.getDate(5));
//
//                //java.sql.Date sql_StartDate = new java.sql.Date(startDate.getTime());
//                return new User(
//                        rs.getString(1),
//                        rs.getString(2));
//            }
//        } catch (Exception e) {
//        }
//    }
    @Override
    public Admin findAdminByUsername(String username) {
        String query = "SELECT * FROM Admin WHERE username = ?";
        try {
            conn = new DBContext().getConnection();// Mở kết nối
            ps = conn.prepareStatement(query.trim());
            ps.setString(1, username);
            ps.executeQuery();
            while (rs.next()) {
                Admin a = new Admin();
                a.setUsername(username);
                return a;
            }
        } catch (Exception e) {
        }
        return null;
    }
    
     public static void main(String[] args) {
        AdminDAOImpl dao = new AdminDAOImpl();
        System.out.print(dao.AdminLogin("trannhatphong", "123456"));
        System.out.print(dao.findAdminByUsername("trannhatphong"));
    }
}
