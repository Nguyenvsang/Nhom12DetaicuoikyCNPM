/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nhom12.dao;

import com.nhom12.entity.Lecturer;

/**
 *
 * @author nguye
 */
public interface DeanDAO {
    boolean DeanLogin(String username, String password);
    
    Lecturer findDeanByUsername(String username);
}
