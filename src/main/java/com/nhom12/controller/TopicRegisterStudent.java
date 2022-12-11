package com.nhom12.controller;

import com.nhom12.dao.SubjectDAOImpl;
import com.nhom12.dao.TeamDAOImpl;
import com.nhom12.dao.TopicDAOImpl;
import com.nhom12.dao.TopicRegistrationDAOImpl;
import com.nhom12.dao.PeriodDAOImpl;
import com.nhom12.entity.Period;
import com.nhom12.entity.Student;
import com.nhom12.entity.Team;
import com.nhom12.entity.Topic;
import com.nhom12.entity.TopicRegistration;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "TopicRegistrationStudent", urlPatterns = {"/student-register"})
public class TopicRegisterStudent extends HttpServlet {

    private static final long serialVersionUID = 1L;

    TeamDAOImpl dao = new TeamDAOImpl();
    TopicRegistrationDAOImpl dao2 = new TopicRegistrationDAOImpl();
    TopicDAOImpl dao3 = new TopicDAOImpl();
    PeriodDAOImpl dao4 = new PeriodDAOImpl();
    SubjectDAOImpl dao5 = new SubjectDAOImpl();
    List<Period> period = dao4.getAllPeriods();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session != null && session.getAttribute("lecturer") != null) {
            boolean check = false; // Kiểm tra đợt đăng ký
            // Kiểm tra có nằm trong thời gian đăng ký cho sinh viên không
            for (Period p : period) {
                Date currentDate = new Date();
                if (currentDate.after(p.getBeginning()) && currentDate.before(p.getEnd()) && p.getCreateFor() == 1) {
                    check = true;
                    session.setAttribute("periodOfStudent", p); // lưu lại thời gian đăng ký
                    break;
                }
            }
            if (check == false) {
                request.setAttribute("message", "Hiện tại không nằm trong thời gian đăng ký đề tài!");
                request.getRequestDispatcher("/topic-to-register").forward(request, response);
            }
            else{
                doPost(request, response);
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

        Student student = (Student) session.getAttribute("student");
        if (session != null && student != null) {

            int topicID = Integer.parseInt(request.getParameter("topicID"));

            Team team = dao.findTeamByTopicID(topicID);
            Topic topic = dao3.findTopicByID(topicID);

            // Chưa ai đăng ký
            if (team == null) {
                dao.addTeam(student.getStudentID(), topicID, 0);
                team = dao.findTeamByTopicID(topicID);
            }

            // Kiểm tra đã đăng ký topic chưa
            TopicRegistration tr = dao2.findTopicRegistrationBySandT(student.getStudentID(), team.getTeamID());
            if (tr != null) {
                request.setAttribute("message", "Đề tài đã được đăng ký trước đó!");
                request.getRequestDispatcher("/topic-to-register").forward(request, response);
            } else { // Chưa đăng ký đề tài
                // Đầy
                if (team.getQuantity() == 2 || topic.getQuantity() == 2) {
                    request.setAttribute("message", "Đề tài " + topicID + " đã có đủ người đăng ký! Vui lòng đăng ký đề tài khác!");
                    request.getRequestDispatcher("/topic-to-register").forward(request, response);
                } else {
                    dao2.addTopicRegistration(student.getStudentID(), team.getTeamID());
                    dao.updateTeam(team.getTeamID(), team.getLeaderID(), team.getTopicID(), team.getQuantity() + 1);
                    dao3.editTopic(topicID, topic.getTopicName(), topic.getTopicRequire(), topic.getTopicGoal(), topic.getSchoolYear(), topic.getPeriodID(), topic.getLecturerID(), topic.getQuantity() + 1);
                    request.setAttribute("message", "Đăng ký thành công đề tài số " + topicID);
                    request.getRequestDispatcher("/topic-to-register").forward(request, response);
                }
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
    }

}
