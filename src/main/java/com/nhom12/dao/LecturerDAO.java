/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nhom12.dao;

import com.nhom12.entity.Lecturer;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface LecturerDAO {
    boolean LecturerLogin(String username, String password);
    List<Lecturer> getAlllecturer();

    void addLecturer(String lecturerName, String citizenID, String gender, Date dateOfBirth, String email, String phoneNumber, String professionalQualification, int deanID, String username, String password);

    void editLecturer(int lecturerID, String lecturerName, String citizenID, String gender, Date dateOfBirth, String email, String phoneNumber, String professionalQualification, int deanID);

    Lecturer findLecturerByID(int lecturerID);
    
    Lecturer findLecturerByUsername(String username);
}
