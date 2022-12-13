package com.nhom12.controller;

import com.nhom12.dao.AdminDAOImpl;
import com.nhom12.entity.Admin;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "AdminAccountUpdateServlet", urlPatterns = {"/admin/update"})
public class AdminAccountUpdateServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    AdminDAOImpl dao = new AdminDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        if (session != null && session.getAttribute("admin") != null) {
            Admin admin = (Admin) session.getAttribute("admin");

            request.setAttribute("admin", admin);

            request.getRequestDispatcher("/edit_account_admin.jsp").forward(request, response);

        } else {
            request.setAttribute("message", "Error");
            request.getRequestDispatcher("/home").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();

        if (session != null && session.getAttribute("admin") != null) {
            Admin admin = (Admin) session.getAttribute("admin");

            String username = request.getParameter("username");
            String password = request.getParameter("password");

            dao.updateAdmin(username, password);

            session.setAttribute("admin", dao.findAdminByUsername(username));
            response.sendRedirect(request.getContextPath() + "/admin/update");
        } else {
            request.setAttribute("message", "Error");
            request.getRequestDispatcher("/home").forward(request, response);
        }
    }

}
