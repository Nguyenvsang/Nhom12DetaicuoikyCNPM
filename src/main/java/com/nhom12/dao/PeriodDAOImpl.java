package com.nhom12.dao;

import com.nhom12.context.DBContext;
import com.nhom12.entity.Period;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PeriodDAOImpl implements PeriodDAO {

    // Kết nối
    Connection conn = null;
    // Ném câu lệnh query qua dbms
    PreparedStatement ps = null;
    // Nhận kết quả trả về
    ResultSet rs = null;

    @Override
    public List<Period> getAllPeriods() {
        List<Period> period = new ArrayList<>();
        String query = "SELECT * FROM Period;";
        try {
            conn = new DBContext().getConnection();// Mở kết nối
            ps = conn.prepareStatement(query.trim());
            rs = ps.executeQuery();
            while (rs.next()) {
                period.add(new Period(
                        rs.getInt(1),
                        rs.getDate(2),
                        rs.getDate(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7)));
            }
        } catch (Exception e) {
        }
        return period;
    }

    @Override
    public List<Period> getMainPeriods() { // Các đợt cho giảng viên
        List<Period> period = new ArrayList<>();
        String query = "SELECT * FROM Period WHERE createFor = 0;";
        try {
            conn = new DBContext().getConnection();// Mở kết nối
            ps = conn.prepareStatement(query.trim());
            rs = ps.executeQuery();
            while (rs.next()) {
                period.add(new Period(
                        rs.getInt(1),
                        rs.getDate(2),
                        rs.getDate(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7)));
            }
        } catch (Exception e) {
        }
        return period;
    }

    @Override
    public void addPeriod(java.sql.Date beginning, java.sql.Date end, String periodName, int createFor, int typeID, int mainPeriod) {
        String query = "INSERT INTO Period (beginning, `end`, periodName, createFor, typeID, mainPeriod) VALUES (?, ?, ?, ?, ?, ?);";
        try {
            conn = new DBContext().getConnection();// Mở kết nối
            ps = conn.prepareStatement(query.trim());
            ps.setDate(1, beginning);
            ps.setDate(2, end);
            ps.setString(3, periodName);
            ps.setInt(4, createFor);
            ps.setInt(5, typeID);
            ps.setInt(6, mainPeriod);
            ps.executeUpdate();
        } catch (Exception e) {
            {
            }
        }
    }

    @Override
    public void updatePeriodFor(int periodID, int mainPeriod) { // cập nhật lại mainPeriod
        String query = "UPDATE Period SET mainPeriod =  ?;";
        try {
            conn = new DBContext().getConnection();// Mở kết nối
            ps = conn.prepareStatement(query.trim());
            ps.setInt(1, periodID);
            ps.setInt(2, mainPeriod);
            ps.executeUpdate();
        } catch (Exception e) {
            {
            }
        }
    }

    public static void main(String[] args) throws ParseException {
        PeriodDAOImpl dao = new PeriodDAOImpl();

        java.util.Date b = new SimpleDateFormat("yyyy-MM-dd").parse("2022-08-10");
        java.sql.Date beginning = new java.sql.Date(b.getTime());
        java.util.Date e = new SimpleDateFormat("yyyy-MM-dd").parse("2022-12-08");
        java.sql.Date end = new java.sql.Date(e.getTime());

        dao.addPeriod(beginning, end, "Tiểu luận chuyên ngành K20", 0, 1, 0);
        List<Period> period = dao.getAllPeriods();
        for (Period p : period) {
            System.out.println(p.getPeriodName());
        }

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        //Date f = dateFormat.format(date);
        //System.out.println(date.after(e)); 
    }
}
