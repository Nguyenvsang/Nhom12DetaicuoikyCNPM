/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.nhom12.controller;

import com.nhom12.dao.AdminDAOImpl;
import com.nhom12.dao.CouncilDAOImpl;
import com.nhom12.dao.LecturerDAOImpl;
import com.nhom12.dao.PeriodDAOImpl;
import com.nhom12.dao.SubjectDAOImpl;
import com.nhom12.dao.TopicDAOImpl;
import com.nhom12.dao.TopicTypeDAOImpl;
import com.nhom12.entity.Admin;
import com.nhom12.entity.Council;
import com.nhom12.entity.Lecturer;
import com.nhom12.entity.Period;
import com.nhom12.entity.Subject;
import com.nhom12.entity.Topic;
import com.nhom12.entity.TypeOfTopic;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "createCouncil", urlPatterns = {"/createCouncil"})
public class CreateCouncil extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

    AdminDAOImpl admindao = new AdminDAOImpl();
    TopicDAOImpl topicdao = new TopicDAOImpl();
    TopicTypeDAOImpl topictypedao = new TopicTypeDAOImpl();
    PeriodDAOImpl perioddao = new PeriodDAOImpl();
    SubjectDAOImpl subjectdao = new SubjectDAOImpl();
    LecturerDAOImpl lecturerdao = new LecturerDAOImpl();
    CouncilDAOImpl councildao = new CouncilDAOImpl();
    
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
        if (session != null && session.getAttribute("admin") != null) {
            // Lưu đối tượng Admin 
            Admin admin = (Admin) session.getAttribute("admin");
            request.setAttribute("admin", admin);
            // Tạo đối tượng topic lấy id từ url 
            int topicID = Integer.parseInt(request.getParameter("topicID"));
            Topic topic = topicdao.findTopicByID(topicID);
            // Thực hiện tạo hội đồng cho Topic vừa chọn
            // Vì ở đây là danh sách Topic chưa có hội đồng cho nên không cần kiểm điều kiện 
            Council Council = new Council();
            councildao.addCouncil(topicID);
            Council = councildao.findCouncilByTopicID(topic.getTopicID());
            request.setAttribute("message", "Đã tạo hội đồng cho đề tài số "+ topic.getTopicID()+"!");
            
            // Chuyển đến trang tạo hội đồng 
            request.getRequestDispatcher("/topicToCouncil").forward(request, response);

        } else {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
