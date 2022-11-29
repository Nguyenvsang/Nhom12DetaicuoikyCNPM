/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nhom12.dao;

import com.nhom12.entity.Student;
import java.sql.Date;

/**
 *
 * @author nguye
 */
public interface StudentDAO {
    boolean StudentLogin(String username, String password);

    Student findStudentByUsername(String username);

    void updateStudent(int studentID, String studentName, String citizenID, String gender, java.util.Date dateOfBirth, String email, String phoneNumber, String department);

}
