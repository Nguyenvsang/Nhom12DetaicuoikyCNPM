package com.nhom12.controller;

import com.nhom12.dao.SubjectDAOImpl;
import com.nhom12.dao.TeamDAOImpl;
import com.nhom12.dao.TopicDAOImpl;
import com.nhom12.dao.TopicRegistrationDAOImpl;
import com.nhom12.dao.TopicTypeDAOImpl;
import com.nhom12.entity.Student;
import com.nhom12.entity.Subject;
import com.nhom12.entity.Team;
import com.nhom12.entity.Topic;
import com.nhom12.entity.TopicRegistration;
import com.nhom12.entity.TypeOfTopic;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "TopicRegistrationStudent", urlPatterns = {"/student-register"})
public class TopicRegisterStudent extends HttpServlet {

    private static final long serialVersionUID = 1L;

    TeamDAOImpl dao = new TeamDAOImpl();
    TopicRegistrationDAOImpl dao2 = new TopicRegistrationDAOImpl();
    TopicDAOImpl dao3 = new TopicDAOImpl();
    TopicTypeDAOImpl dao4 = new TopicTypeDAOImpl();
    SubjectDAOImpl dao5 = new SubjectDAOImpl();

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

        Student student = (Student) session.getAttribute("student");
        if (session != null && student != null) {

            int topicID = Integer.parseInt(request.getParameter("topicID"));

            Team team = dao.findTeamByTopicID(topicID);
            Topic topic = dao3.findTopicByID(topicID);

            // Chưa ai đăng ký
            if (team == null) {
                dao.addTeam(student.getStudentID(), topicID, 0);
                team = dao.findTeamByTopicID(topicID);
            }

            // Kiểm tra đã đăng ký topic chưa
            TopicRegistration tr = dao2.findTopicRegistrationBySandT(student.getStudentID(), team.getTeamID());
            if (tr != null) {
                response.sendRedirect(request.getContextPath() + "/topic-to-register");
            }
            
            // Đầy
            if (team.getQuantity() == 2 || topic.getQuantity() == 2) {
                response.sendRedirect(request.getContextPath() + "/topic-to-register");
            } else {
                dao2.addTopicRegistration(student.getStudentID(), team.getTeamID());
                dao.updateTeam(team.getTeamID(), team.getLeaderID(), team.getTopicID(), team.getQuantity() + 1);
                topic.setQuantity(topic.getQuantity() + 1);
                response.sendRedirect(request.getContextPath() + "/topic-to-register");
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
    }

}
