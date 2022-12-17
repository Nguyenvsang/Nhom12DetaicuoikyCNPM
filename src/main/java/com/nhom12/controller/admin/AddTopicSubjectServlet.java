package com.nhom12.controller.admin;

import com.nhom12.dao.AdminDAOImpl;
import com.nhom12.dao.LecturerDAOImpl;
import com.nhom12.dao.PeriodDAOImpl;
import com.nhom12.dao.SubjectDAOImpl;
import com.nhom12.dao.TopicDAOImpl;
import com.nhom12.entity.Admin;
import com.nhom12.entity.Lecturer;
import com.nhom12.entity.Period;
import com.nhom12.entity.Subject;
import com.nhom12.entity.Topic;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "addTopicSubject", urlPatterns = {"/addTopicSubject"})
public class AddTopicSubjectServlet extends HttpServlet {

    TopicDAOImpl dao = new TopicDAOImpl();
    SubjectDAOImpl dao2 = new SubjectDAOImpl();
    PeriodDAOImpl dao3 = new PeriodDAOImpl();
    LecturerDAOImpl dao4 = new LecturerDAOImpl();
    AdminDAOImpl dao5 = new AdminDAOImpl();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Tạo đối tượng topic được ghi trên url 
        int topicid = Integer.parseInt(request.getParameter("topicID"));
        Topic topic = dao.findTopicByID(topicid);
        // Lấy danh sách toàn bộ các môn học 
        List<Subject> listsubject = dao2.getAllSubjects();
        // Lưu các đối tượng như topic và listsubject để thao tác sau 
        request.setAttribute("topic", topic);
        request.setAttribute("listsubject", listsubject);
        request.getRequestDispatcher("/add_topic_subject.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();

        if (session != null && session.getAttribute("admin") != null) {
            // Tạo admin từ session đã lưu 
            Admin admin = (Admin) session.getAttribute("admin");
            // Lấy topicID từ ô input 
            int topicID = Integer.parseInt(request.getParameter("topicID"));
            // Lấy subjectID từ ô input 
            int subjectID = Integer.parseInt(request.getParameter("subjectID"));

            dao5.AdminTopicDivisionBySubject(topicID, subjectID);
            
            request.setAttribute("message", "Phân đề tài theo bộ môn thành công!");
            request.getRequestDispatcher("/topicSubject").forward(request, response);
        } else {
            request.setAttribute("message", "Error");
            request.getRequestDispatcher("/home").forward(request, response);
        }
    }
}
