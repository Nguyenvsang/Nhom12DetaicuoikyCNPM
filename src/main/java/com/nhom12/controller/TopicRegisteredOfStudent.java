/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.nhom12.controller;

import com.nhom12.dao.LecturerDAOImpl;
import com.nhom12.dao.PeriodDAOImpl;
import com.nhom12.dao.SubjectDAOImpl;
import com.nhom12.dao.TeamDAOImpl;
import com.nhom12.dao.TopicDAOImpl;
import com.nhom12.dao.TopicRegistrationDAOImpl;
import com.nhom12.entity.Lecturer;
import com.nhom12.entity.Period;
import com.nhom12.entity.Student;
import com.nhom12.entity.Subject;
import com.nhom12.entity.Topic;
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
@WebServlet(name = "topicRegisteredOfStudent", urlPatterns = {"/topicRegisteredOfStudent"})
public class TopicRegisteredOfStudent extends HttpServlet {

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
        
        HttpSession session = request.getSession();
        if (session != null && session.getAttribute("student") != null) {
            // Lưu đối tượng Student 
            Student student = (Student) session.getAttribute("student");
            request.setAttribute("student", student);
            
            List<Subject> subject = dao5.getAllSubjects();
            List<Period> period = dao4.getAllPeriods();
            List<Lecturer> lecturer = dao6.getAlllecturer();
            List<Topic> listtopic = new ArrayList<>();
            
            // Lấy danh sách đề tài đã đăng kí của sinh viên tương ứng 
            listtopic = dao3.getTopicsByStudent(student.getStudentID());
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
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
