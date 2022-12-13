package com.nhom12.controller;

import com.nhom12.dao.TopicEvaluationDAOImpl;
import com.nhom12.entity.Lecturer;
import com.nhom12.entity.Topic;
import com.nhom12.entity.TopicEvaluation;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "TopicEvaluate", urlPatterns = {"/topic/evaluate"})
public class TopicEvaluate extends HttpServlet {

    TopicEvaluationDAOImpl dao = new TopicEvaluationDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Lecturer lecturer = (Lecturer) session.getAttribute("lecturer");
        if (session != null && lecturer != null) {
            int topicID = Integer.parseInt(request.getParameter("topicID"));// lấy topicID
            
            TopicEvaluation topicEvaluation = dao.findTopicEvaluation(topicID, lecturer.getLecturerID());
            // Kiểm tra đề tài đã được đánh giá chưa
            boolean check = dao.checkEvaluation(topicEvaluation);
            
            request.setAttribute("topicEvaluation", topicEvaluation);
            request.setAttribute("check", check);
            request.getRequestDispatcher("/evaluate_topic.jsp").forward(request, response);
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
            
            int evaluationID = Integer.parseInt(request.getParameter("id"));
            String evaluation = request.getParameter("evaluation");
            double point = Double.parseDouble(request.getParameter("point"));
            java.sql.Timestamp dateEvaluate = new java.sql.Timestamp(new java.util.Date().getTime());

            dao.evaluateTopic(evaluationID, evaluation, point, dateEvaluate);

            request.setAttribute("message", "Đã đánh giá đề tài! Đang đợi hội đồng thống nhất!");
            request.getRequestDispatcher("/list-of-topic").forward(request, response);

        } else {
            request.setAttribute("message", "Error");
            request.getRequestDispatcher("/home").forward(request, response);
        }
    }
}
