package com.nhom12.controller;

import com.nhom12.dao.SubjectDAOImpl;
import com.nhom12.dao.TopicDAOImpl;
import com.nhom12.dao.PeriodDAOImpl;
import com.nhom12.dao.TopicTypeDAOImpl;
import com.nhom12.entity.Lecturer;
import com.nhom12.entity.Subject;
import com.nhom12.entity.Period;
import com.nhom12.entity.TypeOfTopic;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "TopicRegisterServlet", urlPatterns = {"/topicregister"})
public class TopicRegisterServlet extends HttpServlet {

    TopicDAOImpl dao = new TopicDAOImpl();
    SubjectDAOImpl dao2 = new SubjectDAOImpl();
    PeriodDAOImpl dao3 = new PeriodDAOImpl();
    TopicTypeDAOImpl dao4 = new TopicTypeDAOImpl();
    
    List<Period> period = dao3.getAllPeriods();
    List<TypeOfTopic> topicType = dao4.getAllTypeOfTopics();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session != null && session.getAttribute("lecturer") != null) {
            boolean check = false; // Kiểm tra đợt đăng ký
            // Kiểm tra có nằm trong thời gian đăng ký cho giảng viên không
            for (Period p : period) {
                Date currentDate = new Date();
                if (currentDate.after(p.getBeginning()) && currentDate.before(p.getEnd()) && p.getCreateFor() == 0) {
                    check = true;
                    session.setAttribute("periodOfLecturer", p); // lưu lại thời gian đăng ký
                    break;
                }
            }
            if (check == false) {
                request.setAttribute("message", "Hiện tại không nằm trong thời gian đăng ký đề tài!");
                request.getRequestDispatcher("/list-of-topic").forward(request, response);
            } else {
                request.setAttribute("topicType", topicType);
                request.getRequestDispatcher("/register_topic.jsp").forward(request, response);
            }
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
        if (session != null && session.getAttribute("lecturer") != null) {

            Lecturer lecturer = (Lecturer) session.getAttribute("lecturer");

            String topicName = request.getParameter("topicName");
            String topicRequire = request.getParameter("topicRequire");
            String topicGoal = request.getParameter("topicGoal");
            int schoolYear = Integer.parseInt(request.getParameter("schoolYear"));
            int quantity = 0;
            // Lấy periodID
            Period pd = (Period) session.getAttribute("periodOfLecturer");
            int periodID = pd.getPeriodID();
            // subjectID = null;
            int lecturerID = lecturer.getLecturerID();

            dao.addTopic(topicName, topicRequire, topicGoal, schoolYear, periodID, lecturerID, quantity);

            request.setAttribute("message", "Đăng ký đề tài thành công!");
            request.getRequestDispatcher("/list-of-topic").forward(request, response);

        } else {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
    }
}
