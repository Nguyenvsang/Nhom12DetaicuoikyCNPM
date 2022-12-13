package com.nhom12.controller;

import com.nhom12.dao.PeriodDAOImpl;
import com.nhom12.entity.Period;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "HomeServlet", urlPatterns = {"/home"})
public class HomeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    PeriodDAOImpl dao = new PeriodDAOImpl();

    List<Period> period = dao.getAllPeriods();

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

        List<Period> happening = new ArrayList<>(); // Đợt đăng ký đang diễn ra
        List<Period> upcoming = new ArrayList<>(); // Đợt đăng ký sắp diễn ra

        Date currentDate = new Date(); // Ngày hiện tại

        for (Period p : period) {
            if (currentDate.after(p.getBeginning()) && currentDate.before(p.getEnd())) {
                happening.add(p);
            }
            if (currentDate.before(p.getBeginning())) {
                upcoming.add(p);
            }
        }
        request.setAttribute("happening", happening);
        request.setAttribute("upcoming", upcoming);
        request.getRequestDispatcher("/home.jsp").forward(request, response);
    }
}
