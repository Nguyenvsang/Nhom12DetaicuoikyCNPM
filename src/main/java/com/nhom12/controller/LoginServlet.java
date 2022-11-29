/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.nhom12.controller;

<<<<<<< Updated upstream
import com.nhom12.dao.AdminDAOImpl;
=======
import com.nhom12.dao.DeanDAOImpl;
>>>>>>> Stashed changes
import com.nhom12.dao.LecturerDAOImpl;
import com.nhom12.dao.StudentDAOImpl;
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
<<<<<<< Updated upstream
                pathrequestDispatcher = "/student/manage";
=======
                pathrequestDispatcher = "/topic-to-register";
                
>>>>>>> Stashed changes
            } else if ("student".equals(typechecked)) {
                verification = studentDAOImpl.StudentLogin(username, password);

                pathrequestDispatcher = "/student/manage";
            } else if ("admin".equals(typechecked)) {
                verification = adminDAOImpl.AdminLogin(username, password);
                pathrequestDispatcher = "/topic-to-register";
<<<<<<< Updated upstream
=======
            } else if ("dean".equals(typechecked)) {
                verification = deanDAOImpl.DeanLogin(username, password);
                pathrequestDispatcher = "/topicDean";
            }
>>>>>>> Stashed changes

            }
            // Nếu login hợp lệ sẽ chuyển đến trang phù hợp
            if (verification == true) {
                // Khởi tạo session
                HttpSession session = request.getSession();

                // Thiết lập giá trị trong sesion
                session.setAttribute("username", username);
                if ("lecturer".equals(typechecked)) {
                    session.setAttribute("lecturer", lecturerDAOImpl.findLecturerByUsername(username));
                } else if ("student".equals(typechecked)) {
                    session.setAttribute("student", studentDAOImpl.findStudentByUsername(username));
                } else if ("dean".equals(typechecked)) {
                    session.setAttribute("dean", deanDAOImpl.findDeanByUsername(username));
                }

                // Chuyển đến trang danh sách đề tài
                RequestDispatcher dispatch = getServletContext().
                        getRequestDispatcher(pathrequestDispatcher);
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
}
