package com.nhom12.controller;

import com.nhom12.dao.StudentDAOImpl;
import com.nhom12.entity.Student;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "StudentAccountManageServlet", urlPatterns = {"/student/manage"})
public class StudentAccountManageServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    StudentDAOImpl dao = new StudentDAOImpl();
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        if (session != null && session.getAttribute("student") != null) {
            Student student = (Student) session.getAttribute("student");
            
            request.setAttribute("student", student);
            
            request.getRequestDispatcher("/manage_account_student.jsp").forward(request, response);
            
        }
        else{
            response.sendRedirect(request.getContextPath()+ "/login.jsp");
        }
            
    }

}
