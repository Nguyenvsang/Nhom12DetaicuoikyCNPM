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

    Admin findAdminByUsername(String username);
}
