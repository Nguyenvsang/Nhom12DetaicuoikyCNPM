/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.nhom12.controller;

import com.nhom12.dao.LecturerDAOImpl;
import com.nhom12.dao.TopicDAOImpl;
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

/**
 *
 * @author nguye
 */
@WebServlet(name = "evaluationCommitteeTopicAdd", urlPatterns = {"/evaluationCommitteeTopicAdd"})
public class EvaluationCommitteeTopicAdd extends HttpServlet {

    private static final long serialVersionUID = 1L;

    LecturerDAOImpl lecturerDAOImpl = new LecturerDAOImpl();
    TopicDAOImpl topicDAOImpl = new TopicDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        if (session != null && session.getAttribute("dean") != null && session.getAttribute("topic") != null) {
            // Tạo đối tượng giảng viên vừa được nhấn nút chọn, lấy id từ url 
            int lecturerID = Integer.parseInt(request.getParameter("lecturerID"));
            Lecturer lecturer = lecturerDAOImpl.findLecturerByID(lecturerID);
            // Tạo đối tượng topic được lưu trong session 
            Topic topic = (Topic) session.getAttribute("topic");
            

            request.getRequestDispatcher("/register_lecturer_evaluation_committee.jsp").forward(request, response); // Lưu ý không cần request.getContextPath() +
        }
        else{
            response.sendRedirect(request.getContextPath()+ "/login.jsp");
        }
    }

}
