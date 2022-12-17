/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.nhom12.controller.dean;

import com.nhom12.dao.LecturerDAOImpl;
import com.nhom12.entity.Lecturer;
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
@WebServlet(name = "deanViewDetailLecturer", urlPatterns = {"/deanViewDetailLecturer"})
public class DeanViewDetailLecturer extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

    LecturerDAOImpl lecturerDAOImpl = new LecturerDAOImpl();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        if (session != null && session.getAttribute("dean") != null) {
            // Nhận lecturerID từ thanh địa chỉ và setAttribute tên "lecturer"
            int lecturerID = Integer.parseInt(request.getParameter("lecturerID"));
            Lecturer lecturer = lecturerDAOImpl.findLecturerByID(lecturerID);
            session.setAttribute("lecturer", lecturer);
            
            
            request.getRequestDispatcher("/lecturer/manage").forward(request, response);
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
