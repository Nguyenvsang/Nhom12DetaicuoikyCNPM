package com.nhom12.dao;

import com.nhom12.context.DBContext;
import com.nhom12.entity.Subject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SubjectDAOImpl implements SubjectDAO {
    // Kết nối

    Connection conn = null;
    // Ném câu lệnh query qua dbms
    PreparedStatement ps = null;
    // Nhận kết quả trả về
    ResultSet rs = null;

    @Override
    public List<Subject> getAllSubjects() {
        List<Subject> subject = new ArrayList<>();
        String query = "SELECT * FROM Subject;";
        try {
            conn = new DBContext().getConnection();// Mở kết nối
            ps = conn.prepareStatement(query.trim());
            rs = ps.executeQuery();
            while (rs.next()) {
                subject.add(new Subject(
                        rs.getInt(1),
                        rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return subject;
    }

    
    public static void main(String[] args) {
        SubjectDAOImpl dao = new SubjectDAOImpl();
        List<Subject> subject = dao.getAllSubjects();
        for(Subject s:subject){
            System.out.println(s.getSubjectName());
        }
    }
}
