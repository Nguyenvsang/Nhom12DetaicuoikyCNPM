/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.nhom12.controller;

import com.nhom12.dao.AdminDAOImpl;
import com.nhom12.dao.DeanDAOImpl;
import com.nhom12.dao.LecturerDAOImpl;
import com.nhom12.dao.StudentDAOImpl;
import com.nhom12.entity.Admin;
import com.nhom12.entity.Lecturer;
import com.nhom12.entity.Student;
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
@WebServlet(name = "loginServlet", urlPatterns = {"/loginServlet"})
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    AdminDAOImpl adminDAOImpl = new AdminDAOImpl();
    LecturerDAOImpl lecturerDAOImpl = new LecturerDAOImpl();
    StudentDAOImpl studentDAOImpl = new StudentDAOImpl();
    DeanDAOImpl deanDAOImpl = new DeanDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String typechecked = request.getParameter("typelogin");

            // Khởi tạo biến xác thực
            boolean verification = false;
            // Khởi tạo biến lưu đường dẫn chuyển đến trang phù hợp 
            String pathrequestDispatcher = "";

            // Gọi DAO để xác thực đăng nhập và đặt đường dẫn chuyển đến trang danh sách đề tài
            if ("lecturer".equals(typechecked)) {
                verification = lecturerDAOImpl.LecturerLogin(username, password);
                pathrequestDispatcher = "/list-of-topic";
            } else if ("student".equals(typechecked)) {
                verification = studentDAOImpl.StudentLogin(username, password);
                pathrequestDispatcher = "/topic-to-register";
            } else if ("admin".equals(typechecked)) {
                verification = adminDAOImpl.AdminLogin(username, password);
                pathrequestDispatcher = "/all-topic";
            } else if ("dean".equals(typechecked)) {
                verification = deanDAOImpl.DeanLogin(username, password);
                pathrequestDispatcher = "/all-topic";
            }

            // Nếu login hợp lệ sẽ chuyển đến trang phù hợp
            if (verification == true) {
                // Khởi tạo session
                HttpSession session = request.getSession();

                // Thiết lập giá trị trong sesion
                session.setAttribute("username", username);
                if ("lecturer".equals(typechecked)) {
                    Lecturer lecturer = lecturerDAOImpl.findLecturerByUsername(username);
                    session.setAttribute("lecturer", lecturer);
                    session.setAttribute("account", lecturer);
                } else if ("student".equals(typechecked)) {
                    Student student = studentDAOImpl.findStudentByUsername(username);
                    session.setAttribute("student", student);
                    session.setAttribute("account", student);
                } else if ("dean".equals(typechecked)) {
                    Lecturer dean = deanDAOImpl.findDeanByUsername(username);
                    session.setAttribute("dean", dean);
                    session.setAttribute("account", dean);
                } else if ("admin".equals(typechecked)) {
                    Admin admin = new Admin();
                    session.setAttribute("admin", admin);
                    session.setAttribute("account", admin);
                }

                // Chuyển đến trang danh sách đề tài
                response.sendRedirect(request.getContextPath() + pathrequestDispatcher);
            } else {
                // Đăng nhập không hợp lệ sẽ quay lại trang login
                request.setAttribute("message", "Tên đăng nhập hoặc mật khẩu sai!\nVui lòng thử lại!");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } finally {
            out.close();
        }
    }
}
