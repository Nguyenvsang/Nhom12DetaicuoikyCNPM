/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.nhom12.controller;

import com.nhom12.dao.LecturerDAOImpl;
import com.nhom12.dao.TopicDAOImpl;
import com.nhom12.entity.Lecturer;
import com.nhom12.entity.Topic;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nguye
 */
@WebServlet(name = "lecturerDean", urlPatterns = {"/lecturerDean"})
public class LecturerDean extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

    LecturerDAOImpl lecturerDAOImpl = new LecturerDAOImpl();
    TopicDAOImpl topicDAOImpl = new TopicDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        if (session != null && session.getAttribute("dean") != null) {
            Lecturer dean = (Lecturer) session.getAttribute("dean");
            
            List<Lecturer> lecturerListByDean = lecturerDAOImpl.getListLecturerByDean(dean.getDeanID());

            request.setAttribute("lecturerListByDean", lecturerListByDean);
            
            // Nhận topicID từ thanh địa chỉ và setAttribute tên "topic"
            int topicID = Integer.parseInt(request.getParameter("topicID"));
            Topic topic = topicDAOImpl.findTopicByID(topicID);
            session.setAttribute("topic", topic);

            request.getRequestDispatcher("/register_lecturer_evaluation_committee.jsp").forward(request, response); // Lưu ý không cần request.getContextPath() +
        }
        else{
            response.sendRedirect(request.getContextPath()+ "/login.jsp");
        }
         
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
