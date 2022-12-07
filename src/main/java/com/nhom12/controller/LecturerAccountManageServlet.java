package com.nhom12.controller;

import com.nhom12.dao.LecturerDAOImpl;
import com.nhom12.entity.Lecturer;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LecturerAccountManageServlet", urlPatterns = {"/lecturer/manage"})
public class LecturerAccountManageServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    LecturerDAOImpl lecturerDAOImpl = new LecturerDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        Lecturer lecturer = (Lecturer) session.getAttribute("lecturer");
        if (session != null && lecturer != null) {

            request.setAttribute("lecturer", lecturer);

            request.getRequestDispatcher("/manage_account_lecturer.jsp").forward(request, response); // Lưu ý không cần request.getContextPath() +
        } else {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
    }

}
