package com.nhom12.controller.admin;

import com.nhom12.dao.AdminDAOImpl;
import com.nhom12.dao.CouncilDAOImpl;
import com.nhom12.dao.LecturerDAOImpl;
import com.nhom12.dao.PeriodDAOImpl;
import com.nhom12.dao.SubjectDAOImpl;
import com.nhom12.dao.TopicDAOImpl;
import com.nhom12.dao.TopicTypeDAOImpl;
import com.nhom12.entity.Admin;
import com.nhom12.entity.Council;
import com.nhom12.entity.Lecturer;
import com.nhom12.entity.Period;
import com.nhom12.entity.Subject;
import com.nhom12.entity.Topic;
import com.nhom12.entity.TypeOfTopic;
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

@WebServlet(name = "createCouncil", urlPatterns = {"/createCouncil"})
public class CreateCouncil extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

    AdminDAOImpl admindao = new AdminDAOImpl();
    TopicDAOImpl topicdao = new TopicDAOImpl();
    TopicTypeDAOImpl topictypedao = new TopicTypeDAOImpl();
    PeriodDAOImpl perioddao = new PeriodDAOImpl();
    SubjectDAOImpl subjectdao = new SubjectDAOImpl();
    LecturerDAOImpl lecturerdao = new LecturerDAOImpl();
    CouncilDAOImpl councildao = new CouncilDAOImpl();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        if (session != null && session.getAttribute("admin") != null) {
            // L??u ?????i t?????ng Admin 
            Admin admin = (Admin) session.getAttribute("admin");
            request.setAttribute("admin", admin);
            // T???o ?????i t?????ng topic l???y id t??? url 
            int topicID = Integer.parseInt(request.getParameter("topicID"));
            Topic topic = topicdao.findTopicByID(topicID);
            // Th???c hi???n t???o h???i ?????ng cho Topic v???a ch???n
            // V?? ??? ????y l?? danh s??ch Topic ch??a c?? h???i ?????ng cho n??n kh??ng c???n ki???m ??i???u ki???n 
            Council Council = new Council();
            councildao.addCouncil(topicID, 0);
            Council = councildao.findCouncilByTopicID(topic.getTopicID());
            request.setAttribute("message", "???? t???o h???i ?????ng cho ????? t??i s??? "+ topic.getTopicID()+"!");
            
            // Chuy???n ?????n trang t???o h???i ?????ng 
            request.getRequestDispatcher("/topicToCouncil").forward(request, response);

        } else {
            request.setAttribute("message", "Error");
            request.getRequestDispatcher("/home").forward(request, response);
        }
    }
}
