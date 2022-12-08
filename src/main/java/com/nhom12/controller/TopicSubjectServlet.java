/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.nhom12.controller;

import com.nhom12.dao.LecturerDAOImpl;
import com.nhom12.dao.PeriodDAOImpl;
import com.nhom12.dao.SubjectDAOImpl;
import com.nhom12.dao.TopicDAOImpl;
import com.nhom12.entity.Admin;
import com.nhom12.entity.Lecturer;
import com.nhom12.entity.Period;
import com.nhom12.entity.Subject;
import com.nhom12.entity.Topic;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "topicSubject", urlPatterns = {"/topicSubject"})
public class TopicSubjectServlet extends HttpServlet {

    TopicDAOImpl dao3 = new TopicDAOImpl();
    PeriodDAOImpl dao4 = new PeriodDAOImpl();
    SubjectDAOImpl dao5 = new SubjectDAOImpl();
    LecturerDAOImpl dao6 = new LecturerDAOImpl();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();

        if (session != null && session.getAttribute("admin") != null) {
            // Tạo admin từ session đã lưu 
            Admin admin = (Admin) session.getAttribute("admin");
            
            List<Subject> subject = dao5.getAllSubjects();
            List<Period> period = dao4.getAllPeriods();
            List<Lecturer> lecturer = dao6.getAlllecturer();
            List<Topic> listtopic = new ArrayList<>();
            // lưu dữ liệu để truyền sang trang sau 
            listtopic = dao3.getAllTopics();
            request.setAttribute("listtopic", listtopic);
            request.setAttribute("subject", subject);
            request.setAttribute("period", period);
            request.setAttribute("lecturer", lecturer);
            // truyền đến trang đề tài cần phân theo bộ môn 
            request.getRequestDispatcher("/list_topic_need_subject.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
