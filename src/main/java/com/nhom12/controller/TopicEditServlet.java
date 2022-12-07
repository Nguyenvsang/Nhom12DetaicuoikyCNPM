package com.nhom12.controller;

import com.nhom12.dao.LecturerDAOImpl;
import com.nhom12.dao.SubjectDAOImpl;
import com.nhom12.dao.TopicDAOImpl;
import com.nhom12.dao.PeriodDAOImpl;
import com.nhom12.entity.Lecturer;
import com.nhom12.entity.Subject;
import com.nhom12.entity.Topic;
import com.nhom12.entity.Period;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "TopicEditServlet", urlPatterns = {"/edittopic"})
public class TopicEditServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    TopicDAOImpl dao = new TopicDAOImpl();
    SubjectDAOImpl dao2 = new SubjectDAOImpl();
    PeriodDAOImpl dao3 = new PeriodDAOImpl();
    LecturerDAOImpl dao4 = new LecturerDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int topicid = Integer.parseInt(request.getParameter("topicID"));

        List<Subject> subject = dao2.getAllSubjects();
        List<Period> period = dao3.getAllPeriods();
        Topic topic = dao.findTopicByID(topicid);
        List<Lecturer> lecturer = dao4.getAlllecturer();

        request.setAttribute("subject", subject);
        request.setAttribute("period", period);
        request.setAttribute("topic", topic);
        request.setAttribute("lecturer", lecturer);
        request.getRequestDispatcher("/edit_topic.jsp").forward(request, response); // Lưu ý không cần request.getContextPath() + 
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        if (session != null && session.getAttribute("lecturer") != null) {
            Lecturer lecturer = (Lecturer) session.getAttribute("lecturer");
            int topicID = Integer.parseInt(request.getParameter("topicID"));
            String topicName = request.getParameter("topicName");
            String topicRequire = request.getParameter("topicRequire");
            String topicGoal = request.getParameter("topicGoal");
            int schoolYear = Integer.parseInt(request.getParameter("schoolYear"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            int periodID = Integer.parseInt(request.getParameter("periodID"));
            int lecturerID = lecturer.getLecturerID();

            dao.editTopic(topicID, topicName, topicRequire, topicGoal, schoolYear, periodID, lecturerID, quantity);
            
            request.setAttribute("message", "Chỉnh sửa đề tài thành công!");
            request.getRequestDispatcher("/list-of-topic").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
    }
}
