/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.nhom12.controller;

import com.nhom12.dao.LecturerDAOImpl;
import com.nhom12.dao.SubjectDAOImpl;
import com.nhom12.dao.TeamDAOImpl;
import com.nhom12.dao.TopicDAOImpl;
import com.nhom12.dao.TopicRegistrationDAOImpl;
import com.nhom12.dao.TopicTypeDAOImpl;
import com.nhom12.entity.Lecturer;
import com.nhom12.entity.Subject;
import com.nhom12.entity.Topic;
import com.nhom12.entity.TypeOfTopic;
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
 * @author Admin
 */
@WebServlet(name = "TopicOfLecturer", urlPatterns = {"/list-of-topic"})
public class TopicOfLecturer extends HttpServlet {

    private static final long serialVersionUID = 1L;

    TeamDAOImpl dao = new TeamDAOImpl();
    TopicRegistrationDAOImpl dao2 = new TopicRegistrationDAOImpl();
    TopicDAOImpl dao3 = new TopicDAOImpl();
    TopicTypeDAOImpl dao4 = new TopicTypeDAOImpl();
    SubjectDAOImpl dao5 = new SubjectDAOImpl();
    LecturerDAOImpl dao6 = new LecturerDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        List<Subject> subject = dao5.getAllSubjects();
        List<TypeOfTopic> topictype = dao4.getAllTypeOfTopics();
        List<Lecturer> lecturer = dao6.getAlllecturer();
        List<Topic> listtopic = new ArrayList<>();
        HttpSession session = request.getSession();

        Lecturer l = (Lecturer) session.getAttribute("lecturer");
        if (session != null && l != null) {
            listtopic = dao3.findTopicByLecturer(l.getLecturerID());
            request.setAttribute("listtopic", listtopic);
            request.setAttribute("subject", subject);
            request.setAttribute("topictype", topictype);
            request.setAttribute("lecturer", lecturer);

            request.getRequestDispatcher("/list_topic.jsp").forward(request, response); // Lưu ý không cần request.getContextPath() + 
        } else {
            response.sendRedirect(request.getContextPath() + "/login.jsp"); // Lưu ý không cần request.getContextPath() + 
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
