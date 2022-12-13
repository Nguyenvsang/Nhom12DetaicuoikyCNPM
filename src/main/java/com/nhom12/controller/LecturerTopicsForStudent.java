/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.nhom12.controller;

import com.nhom12.dao.StudentDAOImpl;
import com.nhom12.entity.Student;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "lecturerTopicsForStudent", urlPatterns = {"/lecturerTopicsForStudent"})
public class LecturerTopicsForStudent extends HttpServlet {
    
    StudentDAOImpl studentDAOImpl = new StudentDAOImpl();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session != null && session.getAttribute("lecturer") != null) {
            // Nhận studentID từ thanh địa chỉ và setAttribute tên "student"
            int studentID = Integer.parseInt(request.getParameter("studentID"));
            Student student = studentDAOImpl.findStudentByID(studentID);
            session.setAttribute("student", student);
            
            request.getRequestDispatcher("/topic-to-register").forward(request, response);
            
        }
        else{
            response.sendRedirect(request.getContextPath()+ "/login.jsp");
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
