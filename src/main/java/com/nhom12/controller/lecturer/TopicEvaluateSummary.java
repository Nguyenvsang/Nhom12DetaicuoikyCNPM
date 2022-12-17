package com.nhom12.controller.lecturer;

import com.nhom12.dao.LecturerDAOImpl;
import com.nhom12.dao.TopicDAOImpl;
import com.nhom12.dao.TopicEvaluationDAOImpl;
import com.nhom12.entity.Lecturer;
import com.nhom12.entity.Topic;
import com.nhom12.entity.TopicEvaluation;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "TopicEvaluatenSummary", urlPatterns = {"/topic/evaluate/summary"})
public class TopicEvaluateSummary extends HttpServlet {

    private static final long serialVersionUID = 1L;

    TopicDAOImpl dao = new TopicDAOImpl();
    TopicEvaluationDAOImpl dao2 = new TopicEvaluationDAOImpl();
    LecturerDAOImpl dao3 = new LecturerDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Lecturer lecturer = (Lecturer) session.getAttribute("lecturer");
        if (session != null && lecturer != null) {
            int topicID = Integer.parseInt(request.getParameter("topicID"));// lấy topicID

            List<TopicEvaluation> topicEvaluation = dao2.getEvaluationOfTopic(topicID);
            List<Lecturer> lecturerList = dao3.getAlllecturer();
            Topic topic = dao.findTopicByID(topicID);
            
            // Kiểm tra đề tài đã được cho điểm cuối cùng chưa
            boolean check = false;
            try {
                check = dao.checkPoint(topicID);
            } catch (SQLException ex) {
                Logger.getLogger(TopicEvaluateSummary.class.getName()).log(Level.SEVERE, null, ex);
            }

            request.setAttribute("topic", topic);
            request.setAttribute("topicEvaluation", topicEvaluation);
            request.setAttribute("lecturerList", lecturerList);
            request.setAttribute("check", check);
            request.getRequestDispatcher("/list-topic-evaluation-summary.jsp").forward(request, response);
        } else {
            request.setAttribute("message", "Error");
            request.getRequestDispatcher("/home").forward(request, response);
        }
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
            double point = Double.parseDouble(request.getParameter("point"));

            dao.markTopic(topicID, point);

            request.setAttribute("message", "Đã cho điểm đề tài " + topicID + " chính thức!");
            request.getRequestDispatcher("/topic/summary").forward(request, response);

        } else {
            request.setAttribute("message", "Error");
            request.getRequestDispatcher("/home").forward(request, response);
        }
    }
}
