package com.nhom12.controller;

import com.nhom12.dao.TopicEvaluationDAOImpl;
import com.nhom12.entity.Lecturer;
import com.nhom12.entity.Topic;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "TopicEvaluation", urlPatterns = {"/topic/evaluate"})
public class TopicEvaluation extends HttpServlet {

    TopicEvaluationDAOImpl dao = new TopicEvaluationDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Lecturer lecturer = (Lecturer) session.getAttribute("lecturer");
        if (session != null && lecturer != null) {
            List<Topic> topicToEvaluate = dao.getListToEvaluate(lecturer.getLecturerID());

            request.setAttribute("topicToEvaluate", topicToEvaluate);//
            request.getRequestDispatcher("/list-of-topic").forward(request, response);//
        } else {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
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
            double point = Double.parseDouble(request.getParameter("topicRequire"));
            java.sql.Timestamp dateEvaluate = new java.sql.Timestamp(new java.util.Date().getTime());

            dao.evaluateTopic(evaluationID, evaluation, point, dateEvaluate);

            request.setAttribute("message", "Đã đánh giá đề tài! Đang đợi hội đồng thống nhất!");
            request.getRequestDispatcher("/list-of-topic").forward(request, response);

        } else {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
    }
}
