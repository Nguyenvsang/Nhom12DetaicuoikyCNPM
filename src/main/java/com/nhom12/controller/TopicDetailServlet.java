package com.nhom12.controller;

import com.nhom12.dao.LecturerDAOImpl;
import com.nhom12.dao.SubjectDAOImpl;
import com.nhom12.dao.TopicDAOImpl;
import com.nhom12.dao.TopicTypeDAOImpl;
import com.nhom12.entity.Lecturer;
import com.nhom12.entity.Subject;
import com.nhom12.entity.Topic;
import com.nhom12.entity.TypeOfTopic;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "TopicDetailServlet", urlPatterns = {"/topicdetail"})
public class TopicDetailServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    TopicDAOImpl dao = new TopicDAOImpl();
    SubjectDAOImpl dao2 = new SubjectDAOImpl();
    TopicTypeDAOImpl dao3 = new TopicTypeDAOImpl();
    LecturerDAOImpl dao4 = new LecturerDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int topicid = Integer.parseInt(request.getParameter("topicID"));

        List<Subject> subject = dao2.getAllSubjects();
        List<TypeOfTopic> topictype = dao3.getAllTypeOfTopics();
        List<Lecturer> lecturer = dao4.getAlllecturer();
        Topic topic = dao.findTopicByID(topicid);

        request.setAttribute("subject", subject);
        request.setAttribute("topictype", topictype);
        request.setAttribute("topic", topic);
        request.setAttribute("lecturer", lecturer);
        request.getRequestDispatcher("/topic_detail.jsp").forward(request, response); // Lưu ý không cần request.getContextPath() + 
    }
}
