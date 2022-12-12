package com.nhom12.controller;

import com.nhom12.dao.StudentDAOImpl;
import com.nhom12.entity.Student;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
@WebServlet(name = "StudentAccountUpdateServlet", urlPatterns = {"/student/update"})
public class StudentAccountUpdateServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    StudentDAOImpl dao = new StudentDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        if (session != null && session.getAttribute("student") != null) {
            Student student = (Student) session.getAttribute("student");

            request.setAttribute("student", student);

            request.getRequestDispatcher("/edit_account_student.jsp").forward(request, response);

        } else {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();

        if (session != null && session.getAttribute("student") != null) {
            try {
                Student student = (Student) session.getAttribute("student");
                
                int studentID = student.getStudentID();
                String studentName = request.getParameter("studentName");
                String citizenID = request.getParameter("citizenID");
                String gender = request.getParameter("gender");

                String dOB = request.getParameter("dateOfBirth");
                java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dOB);
                java.sql.Date dateOfBirth = new java.sql.Date(date.getTime());
                
                String email = request.getParameter("email");
                String phoneNumber = request.getParameter("phoneNumber");
                String department = request.getParameter("department");
                
                System.out.println("\n" + dOB + "\n" + studentID);
                System.out.println(studentName);
                System.out.println(citizenID);
                System.out.println(gender);
                System.out.println(email);
                System.out.println(phoneNumber);
                System.out.println(department);
                
                dao.updateStudent(studentID, studentName, citizenID, gender, dateOfBirth, email, phoneNumber, department);

                session.setAttribute("student", dao.findStudentByID(studentID));
                
                response.sendRedirect(request.getContextPath() + "/student/manage");
            } catch (ParseException ex) {
                Logger.getLogger(StudentAccountUpdateServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
    }

}
