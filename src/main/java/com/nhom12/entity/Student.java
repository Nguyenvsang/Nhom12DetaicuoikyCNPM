package com.nhom12.entity;

import java.util.Date;

public class Student extends User {
    private int studentID;
    private String studentName;
    private String citizenID;
    private String gender;
    private Date dateOfBirth;
    private String email;
    private String phoneNumber;
    private String department;

    public Student() {
    }

    public Student(int studentID, String studentname, String citizenID, String gender, Date dateOfbirth, String email, String phonenumber, String department) {
        this.studentID = studentID;
        this.studentName = studentname;
        this.citizenID = citizenID;
        this.gender = gender;
        this.dateOfBirth = dateOfbirth;
        this.email = email;
        this.phoneNumber = phonenumber;
        this.department = department;
    }

    public Student(int studentID, String studentname, String citizenID, String gender, Date dateOfbirth, String email, String phonenumber, String department, String username, String password) {
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

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
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

    @Override
    public String toString() {
        return "Student{" + "studentID=" + studentID + ", studentName=" + studentName + ", citizenID=" + citizenID + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth + ", email=" + email + ", phoneNumber=" + phoneNumber + ", department=" + department + '}';
    }

    
    
    
}
