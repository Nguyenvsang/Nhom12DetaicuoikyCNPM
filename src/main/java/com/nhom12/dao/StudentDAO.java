package com.nhom12.dao;

import com.nhom12.entity.Student;
import java.sql.Date;
import java.util.List;

public interface StudentDAO {
    boolean StudentLogin(String username, String password);

    Student findStudentByUsername(String username);

    void updateStudent(int studentID, String studentName, String citizenID, String gender, java.util.Date dateOfBirth, String email, String phoneNumber, String department);

    Student findStudentByID(int studentID);
    
    List<Student> getListStudentByLecturer(int lecturerID);

}
