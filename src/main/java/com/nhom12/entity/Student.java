/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom12.entity;

import java.util.Date;

/**
 *
 * @author nguye
 */
public class Student extends User {
    private String studentID;
    private String studentName;
    private String citizenID;
    private String gender;
    private Date dateOfBirth;
    private String email;
    private String phoneNumber;
    private String department;

    public Student() {
    }

    public Student(String studentID, String studentname, String citizenID, String gender, Date dateOfbirth, String email, String phonenumber, String department) {
        this.studentID = studentID;
        this.studentName = studentname;
        this.citizenID = citizenID;
        this.gender = gender;
        this.dateOfBirth = dateOfbirth;
        this.email = email;
        this.phoneNumber = phonenumber;
        this.department = department;
    }

    public Student(String studentID, String studentname, String citizenID, String gender, Date dateOfbirth, String email, String phonenumber, String department, String username, String password) {
        super(username, password);
        this.studentID = studentID;
        this.studentName = studentname;
        this.citizenID = citizenID;
        this.gender = gender;
        this.dateOfBirth = dateOfbirth;
        this.email = email;
        this.phoneNumber = phonenumber;
        this.department = department;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCitizenID() {
        return citizenID;
    }

    public void setCitizenID(String citizenID) {
        this.citizenID = citizenID;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    
    
    
}
