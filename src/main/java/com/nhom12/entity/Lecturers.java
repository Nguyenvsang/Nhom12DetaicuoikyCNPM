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
public class Lecturers extends User {
    private int lecturerID;
    private String lecturerName;
    private String citizenID;
    private String gender;
    private Date dateOfBirth;
    private String email;
    private String phoneNumber;
    private String professionalQualification;

    public Lecturers() {
    }

    public Lecturers(int lecturerID, String lecturername, String citizenID, String gender, Date dateOfbirth, String email, String phonenumber, String professionalQualification) {
        this.lecturerID = lecturerID;
        this.lecturerName = lecturername;
        this.citizenID = citizenID;
        this.gender = gender;
        this.dateOfBirth = dateOfbirth;
        this.email = email;
        this.phoneNumber = phonenumber;
        this.professionalQualification = professionalQualification;
    }

    public Lecturers(int lecturerID, String lecturername, String citizenID, String gender, Date dateOfbirth, String email, String phonenumber, String professionalQualification, String username, String password) {
        super(username, password);
        this.lecturerID = lecturerID;
        this.lecturerName = lecturername;
        this.citizenID = citizenID;
        this.gender = gender;
        this.dateOfBirth = dateOfbirth;
        this.email = email;
        this.phoneNumber = phonenumber;
        this.professionalQualification = professionalQualification;
    }

    public int getLecturerID() {
        return lecturerID;
    }

    public void setLecturerID(int lecturerID) {
        this.lecturerID = lecturerID;
    }

    public String getLecturerName() {
        return lecturerName;
    }

    public void setLecturerName(String lecturerName) {
        this.lecturerName = lecturerName;
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

    public String getProfessionalQualification() {
        return professionalQualification;
    }

    public void setProfessionalQualification(String professionalQualification) {
        this.professionalQualification = professionalQualification;
    }

    @Override
    public String toString() {
        return "Lecturers{" + "lecturerID=" + lecturerID + ", lecturername=" + lecturerName + ", citizenID=" + citizenID + ", gender=" + gender + ", dateOfbirth=" + dateOfBirth + ", email=" + email + ", phonenumber=" + phoneNumber + ", professionalQualification=" + professionalQualification + '}';
    }
    
    
}
