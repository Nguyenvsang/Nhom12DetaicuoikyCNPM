/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom12.dao;

import com.nhom12.context.DBContext;
import com.nhom12.entity.TypeOfTopic;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class TopicTypeDAOImpl implements TopicTypeDAO{
        // Kết nối
    Connection conn = null;
    // Ném câu lệnh query qua dbms
    PreparedStatement ps = null;
    // Nhận kết quả trả về
    ResultSet rs = null;

    @Override
    public List<TypeOfTopic> getAllTypeOfTopics() {
        List<TypeOfTopic> topictype = new ArrayList<>();
        String query = "SELECT * FROM TypeOfTopic;";
        try {
            conn = new DBContext().getConnection();// Mở kết nối
            ps = conn.prepareStatement(query.trim());
            rs = ps.executeQuery();
            while (rs.next()) {
                topictype.add(new TypeOfTopic(
                        rs.getString(1),
                        rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return topictype;
    }
        public static void main(String[] args) {
        TopicTypeDAOImpl dao = new TopicTypeDAOImpl();
        List<TypeOfTopic> topictype = dao.getAllTypeOfTopics();
        for(TypeOfTopic t:topictype){
            System.out.println(t.getTypeName());
        }
    }
}
