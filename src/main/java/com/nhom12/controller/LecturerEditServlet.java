/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.nhom12.controller;


import com.nhom12.dao.LecturerDAOImpl;
import com.nhom12.dao.TopicDAOImpl;
import com.nhom12.entity.Lecturer;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "LecturerEditServlet", urlPatterns = {"/LecturerEditServlet"})
public class LecturerEditServlet extends HttpServlet {
    
    LecturerDAOImpl dao = new LecturerDAOImpl();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int topicid = Integer.parseInt(request.getParameter("lecturerID"));
        
        Lecturer lecturer = dao.findLecturerByID(topicid);
        
        request.setAttribute("lecturer", lecturer);
        request.getRequestDispatcher("/edit_lecturer.jsp").forward(request, response); // Lưu ý không cần request.getContextPath() + 
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
                
        int lecturerID = Integer.parseInt(request.getParameter("lecturerID"));
        String lecturerName = request.getParameter("lecturerName");
        String citizenID = request.getParameter("citizenID");
        String gender = request.getParameter("gender");
        String dayOfBirth =request.getParameter("dayOfBirth"); //get the parameter convert it to a data type Date.out.println(startDate);
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        String professionalQualification = request.getParameter("professionalQualification");
        Date dateOfBirth = null;
        
        dao.editLecturer(lecturerID,  lecturerName,  citizenID,  gender,  dateOfBirth, email,  phoneNumber, professionalQualification);
        
        response.sendRedirect(request.getContextPath() + "/topicregister");
    }
}
    
