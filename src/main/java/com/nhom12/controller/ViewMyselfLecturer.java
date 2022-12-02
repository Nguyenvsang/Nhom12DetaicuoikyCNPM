package com.nhom12.controller;

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


@WebServlet(name = "ViewMyselfLecturer", urlPatterns = {"/viewMyselfLecturer"})
public class ViewMyselfLecturer extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

    LecturerDAOImpl lecturerDAOImpl = new LecturerDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        Lecturer lecturer = (Lecturer) session.getAttribute("lecturer");
        if (session != null && lecturer != null) {

            request.setAttribute("lecturer", lecturer);

            request.getRequestDispatcher(request.getContextPath() + "/view_myself_lecturer.jsp").forward(request, response); // Lưu ý không cần request.getContextPath() +
        } else {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
