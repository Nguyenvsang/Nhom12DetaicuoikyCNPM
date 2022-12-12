package com.nhom12.dao;

import com.nhom12.context.DBContext;
import com.nhom12.entity.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    // Kết nối
    Connection conn = null;
    // Ném câu lệnh query qua dbms
    PreparedStatement ps = null;
    // Nhận kết quả trả về
    ResultSet rs = null;

    @Override
    public boolean StudentLogin(String username, String password) {
        String query = "SELECT * FROM Student WHERE username = ? and password = ?";
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
    public Student findStudentByUsername(String username) {
        String query = "SELECT * FROM Student WHERE username = ?";
        try {
            conn = new DBContext().getConnection();// Mở kết nối
            ps = conn.prepareStatement(query.trim());
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                //Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(rs.getDate(5));

                //java.sql.Date sql_StartDate = new java.sql.Date(startDate.getTime());
                return new Student(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDate(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8));
            }
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public Student findStudentByID(int studentID) {
        String query = "SELECT * FROM Student WHERE studentID = ?";
        try {
            conn = new DBContext().getConnection();// Mở kết nối
            ps = conn.prepareStatement(query.trim());
            ps.setInt(1, studentID);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Student(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDate(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8));
            }
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public void updateStudent(int studentID, String studentName, String citizenID, String gender, Date dateOfBirth, String email, String phoneNumber, String department) {
        String query = "UPDATE Student SET studentName = ?,  citizenID = ?, gender = ?, dateOfBirth = ?, email = ?, phoneNumber = ?, department = ? WHERE studentID = ?";
        try {
            conn = new DBContext().getConnection();// Mở kết nối
            ps = conn.prepareStatement(query.trim());
            ps.setString(1, studentName);
            ps.setString(2, citizenID);
            ps.setString(3, gender);
            ps.setDate(4, (java.sql.Date) dateOfBirth);
            ps.setString(5, email);
            ps.setString(6, phoneNumber);
            ps.setString(7, department);
            ps.setInt(8, studentID);

            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    @Override
    public List<Student> getListStudentByLecturer(int lecturerID) {
        List<Student> council = new ArrayList<>();
        String query = "SELECT Student.studentID, studentName, citizenID, gender, dateOfBirth, email, phoneNumber, department FROM Lecturer, Topic, TopicRegistration, Team, Student WHERE Lecturer.lecturerID = ? AND Lecturer.lecturerID = Topic.lecturerID AND TopicRegistration.teamID = Team.teamID AND Team.topicID =  Topic.topicID AND TopicRegistration.studentID = Student.studentID";
        try {
            conn = new DBContext().getConnection();// Mở kết nối
            ps = conn.prepareStatement(query.trim());
            ps.setInt(1, lecturerID);
            rs = ps.executeQuery();
            while (rs.next()) {
                council.add(new Student(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDate(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)));
            }
        } catch (Exception e) {
        }
        return council;
    }

    public static void main(String[] args) throws ParseException {
        StudentDAOImpl dao = new StudentDAOImpl();
        String dOB = "1999-10-19";
        java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dOB);
        java.sql.Date dateOfBirth = new java.sql.Date(date.getTime());
        dao.updateStudent(1, "Nguyễn Gia Cát", "021215254125", "Nam", dateOfBirth, "a@gmail.com", "0231456845", "CNTT");
        //System.out.println(s);
    }

}
