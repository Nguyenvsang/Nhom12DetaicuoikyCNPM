package com.nhom12.controller;

import com.nhom12.dao.SubjectDAOImpl;
import com.nhom12.dao.TeamDAOImpl;
import com.nhom12.dao.TopicDAOImpl;
import com.nhom12.dao.TopicRegistrationDAOImpl;
import com.nhom12.dao.TopicTypeDAOImpl;
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
import javax.servlet.http.HttpSession;

@WebServlet(name = "topicDean", urlPatterns = {"/topicDean"})
public class TopicDean extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

    TeamDAOImpl dao = new TeamDAOImpl();
    TopicRegistrationDAOImpl dao2 = new TopicRegistrationDAOImpl();
    TopicDAOImpl dao3 = new TopicDAOImpl();
    TopicTypeDAOImpl dao4 = new TopicTypeDAOImpl();
    SubjectDAOImpl dao5 = new SubjectDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session != null && session.getAttribute("dean") != null) {
            List<Topic> listtopic = dao3.getAllTopics();
            List<Subject> subject = dao5.getAllSubjects();
            List<TypeOfTopic> topictype = dao4.getAllTypeOfTopics();

            request.setAttribute("listtopic", listtopic);
            request.setAttribute("subject", subject);
            request.setAttribute("topictype", topictype);
            
            request.getRequestDispatcher("/register_topic_evaluation_committee.jsp").forward(request, response); // Lưu ý không cần request.getContextPath() + 
        } else {
            response.sendRedirect(request.getContextPath()+ "/login.jsp");
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
