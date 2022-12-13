package com.nhom12.controller;

import com.nhom12.dao.PeriodDAOImpl;
import com.nhom12.entity.Period;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Type of topic means the name of period at which the topic was registered

@WebServlet(name = "TypeOfTopicWithPeriod", urlPatterns = {"/type"})
public class TypeOfTopicWithPeriod extends HttpServlet {

    private static final long serialVersionUID = 1L;

    PeriodDAOImpl dao = new PeriodDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        List<Period> period = dao.getAllPeriods();
        
        request.setAttribute("period", period);

        request.getRequestDispatcher("/list_type_of_topic.jsp").forward(request, response); // Lưu ý không cần request.getContextPath() + 
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
