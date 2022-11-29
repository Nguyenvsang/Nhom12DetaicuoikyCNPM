/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nhom12.dao;

import com.nhom12.entity.Admin;

/**
 *
 * @author ASUS
 */
public interface AdminDAO {
    boolean AdminLogin(String username, String password);

    void updateAdmin(String username, String password);

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
    Admin findAdminByUsername(String username, String password);
}
