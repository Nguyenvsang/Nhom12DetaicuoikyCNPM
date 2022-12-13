package com.nhom12.controller;

import com.nhom12.dao.LecturerDAOImpl;
import com.nhom12.dao.SubjectDAOImpl;
import com.nhom12.dao.TeamDAOImpl;
import com.nhom12.dao.TopicDAOImpl;
import com.nhom12.dao.TopicRegistrationDAOImpl;
import com.nhom12.dao.PeriodDAOImpl;
import com.nhom12.dao.TopicTypeDAOImpl;
import com.nhom12.entity.Lecturer;
import com.nhom12.entity.Subject;
import com.nhom12.entity.Topic;
import com.nhom12.entity.Period;
import com.nhom12.entity.TypeOfTopic;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "TopicToRegisterStudent", urlPatterns = {"/topic-to-register"})
public class TopicToRegisterStudent extends HttpServlet {

    private static final long serialVersionUID = 1L;

    TeamDAOImpl dao = new TeamDAOImpl();
    TopicTypeDAOImpl dao1 = new TopicTypeDAOImpl();
    TopicRegistrationDAOImpl dao2 = new TopicRegistrationDAOImpl();
    TopicDAOImpl dao3 = new TopicDAOImpl();
    PeriodDAOImpl dao4 = new PeriodDAOImpl();
    SubjectDAOImpl dao5 = new SubjectDAOImpl();
    LecturerDAOImpl dao6 = new LecturerDAOImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Period> period = dao4.getAllPeriods();
            
        HttpSession session = request.getSession();
        if (session != null && session.getAttribute("student") != null) {          
            boolean check = false; // Kiểm tra đợt đăng ký
            // Kiểm tra có nằm trong thời gian đăng ký cho sinh viên không
            // Mỗi khoản thời gian chỉ có 1 đợt đăng ký cho giảng viên và cho sinh viên
            Period pd = new Period();
            for (Period p : period) {
                Date currentDate = new Date();
                if (currentDate.after(p.getBeginning()) && currentDate.before(p.getEnd()) && p.getCreateFor() == 1) {
                    check = true;
                    pd = p;
                    session.setAttribute("periodOfStudent", p); // lưu lại thời gian đăng ký
                    break;
                }
            }
            if (check == false) {
                request.setAttribute("message", "Hiện tại không nằm trong thời gian đăng ký đề tài!");
                request.getRequestDispatcher("/register_topic_student.jsp").forward(request, response);
            } else {
                List<Topic> listtopic = dao3.getTopicsToRegister(pd.getMainPeriod());
                List<TypeOfTopic> topictype = dao1.getAllTypeOfTopics();
                List<Subject> subject = dao5.getAllSubjects();
                List<Lecturer> lecturer = dao6.getAlllecturer();

                request.setAttribute("topictype", topictype);
                request.setAttribute("subject", subject);
                request.setAttribute("lecturer", lecturer);
                request.setAttribute("listtopic", listtopic);
                request.getRequestDispatcher("/register_topic_student.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("message", "Error");
            request.getRequestDispatcher("/home").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
