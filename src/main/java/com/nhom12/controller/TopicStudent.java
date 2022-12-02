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
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "TopicStudent", urlPatterns = {"/topic-to-register"})
public class TopicStudent extends HttpServlet {

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
        List<Topic> listtopic = dao3.getAllTopics();
        List<Subject> subject = dao5.getAllSubjects();
        List<TypeOfTopic> topictype = dao4.getAllTypeOfTopics();
        List<Lecturer> lecturer = dao6.getAlllecturer();

        request.setAttribute("listtopic", listtopic);
        request.setAttribute("subject", subject);
        request.setAttribute("topictype", topictype);
        request.setAttribute("lecturer", lecturer);

        request.getRequestDispatcher("/register_topic_student.jsp").forward(request, response); // Lưu ý không cần request.getContextPath() + 
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}