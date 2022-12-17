package com.nhom12.controller.lecturer;

import com.nhom12.dao.CouncilDAOImpl;
import com.nhom12.dao.LecturerDAOImpl;
import com.nhom12.dao.TopicEvaluationDAOImpl;
import com.nhom12.entity.Council;
import com.nhom12.entity.Lecturer;
import com.nhom12.entity.Topic;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "TopicToEvaluate", urlPatterns = {"/topic-to-evaluate"})
public class TopicToEvaluate extends HttpServlet {

    TopicEvaluationDAOImpl dao = new TopicEvaluationDAOImpl();
    LecturerDAOImpl dao2 = new LecturerDAOImpl();
    CouncilDAOImpl dao3 = new CouncilDAOImpl();

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
        Lecturer lecturer = (Lecturer) session.getAttribute("lecturer");
        if (session != null && lecturer != null) {
            List<Topic> topicToEvaluate = dao.getListToEvaluate(lecturer.getLecturerID());
            List<Lecturer> lecturerlist = dao2.getAlllecturer();
            List<Council> councillist = dao3.getAllCouncils();
            
            request.setAttribute("topicToEvaluate", topicToEvaluate);
            request.setAttribute("lecturerlist", lecturerlist);
            request.setAttribute("councillist", councillist);
            request.getRequestDispatcher("/list_topic_to_evaluate.jsp").forward(request, response);
        } else {
            request.setAttribute("message", "Error");
            request.getRequestDispatcher("/home").forward(request, response);
        }
    }
}
