package com.nhom12.controller;

import com.nhom12.dao.SubjectDAOImpl;
import com.nhom12.dao.TopicDAOImpl;
import com.nhom12.dao.TopicTypeDAOImpl;
import com.nhom12.entity.Subject;
import com.nhom12.entity.TypeOfTopic;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "TopicRegisterServlet", urlPatterns = {"/topicregister"})
public class TopicRegisterServlet extends HttpServlet {
    
    TopicDAOImpl dao = new TopicDAOImpl();
    SubjectDAOImpl dao2 = new SubjectDAOImpl();
    TopicTypeDAOImpl dao3 = new TopicTypeDAOImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Subject> subject = dao2.getAllSubjects();
        List<TypeOfTopic> topictype = dao3.getAllTypeOfTopics();
        
        request.setAttribute("subject", subject);
        request.setAttribute("topictype", topictype);
        
        request.getRequestDispatcher("/register_topic.jsp").forward(request, response); // Lưu ý không cần request.getContextPath() + 
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        String topicName = request.getParameter("topicName");
        String topicRequire = request.getParameter("topicRequire");
        String topicGoal = request.getParameter("topicGoal");
        int schoolYear = Integer.parseInt(request.getParameter("schoolYear"));
        String typeID = request.getParameter("typeID");
        String subjectID = request.getParameter("subjectID");
        
        dao.addTopic(topicName, topicRequire, topicGoal, schoolYear, typeID, subjectID);
        
        response.sendRedirect(request.getContextPath() + "/topicregister");
    }
    
}
