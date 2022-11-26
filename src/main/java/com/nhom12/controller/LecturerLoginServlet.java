/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.nhom12.controller;

import com.nhom12.dao.LecturerDAO;
import com.nhom12.dao.LecturerDAOImpl;
import com.nhom12.entity.Lecturer;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "lecturerLoginServlet", urlPatterns = {"/lecturerLoginServlet"})
public class LecturerLoginServlet extends HttpServlet {
    
    LecturerDAOImpl dao = new LecturerDAOImpl();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            
            // Gọi DAO để xác thực đăng nhập
            Lecturer lecturer = dao.LecturerLogin(username, password);
            
            // Nếu login hợp lệ sẽ chuyển đến trang phù hợp
            if(lecturer != null) {
                // Khởi tạo session
                HttpSession session = request.getSession();
                
                // Thiết lập giá trị trong sesion
                session.setAttribute("username", username);
                
                // Chuyển đến trang danh sách đề tài
                RequestDispatcher dispatch = getServletContext().
                        getRequestDispatcher("/list_topic.jsp");
                dispatch.forward(request, response);
            } else {
                // Đăng nhập không hợp lệ sẽ quay lại trang login
                RequestDispatcher dispatch = getServletContext().
                        getRequestDispatcher("/login.jsp");
                dispatch.forward(request, response);
            }
        } finally {
            out.close();
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
