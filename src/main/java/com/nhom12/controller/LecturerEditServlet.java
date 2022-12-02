package com.nhom12.controller;


import com.nhom12.dao.LecturerDAOImpl;
import com.nhom12.entity.Lecturer;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "editlecturer", urlPatterns = {"/editlecturer"})
public class LecturerEditServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    LecturerDAOImpl dao = new LecturerDAOImpl();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        Lecturer lecturer = (Lecturer) session.getAttribute("lecturer");
        if (session != null && lecturer != null) {

            request.setAttribute("lecturer", lecturer);

            request.getRequestDispatcher("/edit_lecturer.jsp").forward(request, response); // Lưu ý không cần request.getContextPath() +
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
                
        int lecturerID = Integer.parseInt(request.getParameter("lecturerID"));
        String lecturerName = request.getParameter("lecturerName");
        String citizenID = request.getParameter("citizenID");
        String gender = request.getParameter("gender");
        Date dateOfBirth = null;
        try {
            dateOfBirth = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dateOfBirth"));
        } catch (ParseException ex) {
            Logger.getLogger(LecturerEditServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        String professionalQualification = request.getParameter("professionalQualification");
        int deanID = Integer.parseInt(request.getParameter("deanID"));
        
        dao.editLecturer(lecturerID,  lecturerName,  citizenID,  gender,  dateOfBirth, email,  phoneNumber, professionalQualification, deanID);
        
        response.sendRedirect(request.getContextPath() + "/topicregister");
    }
}
    
