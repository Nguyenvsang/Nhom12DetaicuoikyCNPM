package com.nhom12.controller;

import com.nhom12.dao.SubjectDAOImpl;
import com.nhom12.dao.TeamDAOImpl;
import com.nhom12.dao.TopicDAOImpl;
import com.nhom12.dao.TopicRegistrationDAOImpl;
import com.nhom12.dao.PeriodDAOImpl;
import com.nhom12.dao.CouncilDAOImpl;
import com.nhom12.dao.LecturerDAOImpl;
import com.nhom12.entity.Subject;
import com.nhom12.entity.Topic;
import com.nhom12.entity.Period;
import com.nhom12.entity.Council;
import com.nhom12.entity.Lecturer;
import java.io.IOException;
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
    PeriodDAOImpl dao4 = new PeriodDAOImpl();
    SubjectDAOImpl dao5 = new SubjectDAOImpl();
    CouncilDAOImpl dao6 = new CouncilDAOImpl();
    LecturerDAOImpl dao7 = new LecturerDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session != null && session.getAttribute("dean") != null) {
            Lecturer dean = (Lecturer) session.getAttribute("dean");
            // Lấy danh sách các topic đã có hội đồng
            List<Topic> listtopichavecouncil = dao3.AllTopicsHaveCouncilByDean(dean.getDeanID());
            List<Subject> subject = dao5.getAllSubjects();
            List<Period> period = dao4.getAllPeriods();
            List<Council> listcouncil = dao6.getAllCouncils();
            List<Lecturer> listlecturer = dao7.getAlllecturer();

            request.setAttribute("listtopichavecouncil", listtopichavecouncil);
            request.setAttribute("subject", subject);
            request.setAttribute("period", period);
            request.setAttribute("listcouncil", listcouncil);
            request.setAttribute("listlecturer", listlecturer);

            request.getRequestDispatcher("/register_topic_evaluation_committee.jsp").forward(request, response); // Lưu ý không cần request.getContextPath() +
        }
        else{
            request.setAttribute("message", "Error");
            request.getRequestDispatcher("/home").forward(request, response);
        }
         
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
