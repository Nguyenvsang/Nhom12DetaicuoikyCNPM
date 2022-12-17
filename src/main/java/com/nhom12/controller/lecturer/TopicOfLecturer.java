package com.nhom12.controller.lecturer;

import com.nhom12.dao.LecturerDAOImpl;
import com.nhom12.dao.SubjectDAOImpl;
import com.nhom12.dao.TeamDAOImpl;
import com.nhom12.dao.TopicDAOImpl;
import com.nhom12.dao.TopicRegistrationDAOImpl;
import com.nhom12.dao.PeriodDAOImpl;
import com.nhom12.entity.Lecturer;
import com.nhom12.entity.Subject;
import com.nhom12.entity.Topic;
import com.nhom12.entity.Period;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "TopicOfLecturer", urlPatterns = {"/list-of-topic"})
public class TopicOfLecturer extends HttpServlet {

    private static final long serialVersionUID = 1L;

    TeamDAOImpl dao = new TeamDAOImpl();
    TopicRegistrationDAOImpl dao2 = new TopicRegistrationDAOImpl();
    TopicDAOImpl dao3 = new TopicDAOImpl();
    PeriodDAOImpl dao4 = new PeriodDAOImpl();
    SubjectDAOImpl dao5 = new SubjectDAOImpl();
    LecturerDAOImpl dao6 = new LecturerDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        List<Subject> subject = dao5.getAllSubjects();
        List<Period> period = dao4.getAllPeriods();
        List<Lecturer> lecturer = dao6.getAlllecturer();
        List<Topic> listtopic = new ArrayList<>();
        HttpSession session = request.getSession();

        Lecturer l = (Lecturer) session.getAttribute("lecturer");
        if (session != null && l != null) {
            listtopic = dao3.findTopicByLecturer(l.getLecturerID());
            request.setAttribute("listtopic", listtopic);
            request.setAttribute("subject", subject);
            request.setAttribute("period", period);
            request.setAttribute("lecturer", lecturer);

            request.getRequestDispatcher("/list_topic.jsp").forward(request, response); // Lưu ý không cần request.getContextPath() + 
        } else {
            request.setAttribute("message", "Error");
            request.getRequestDispatcher("/home").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
