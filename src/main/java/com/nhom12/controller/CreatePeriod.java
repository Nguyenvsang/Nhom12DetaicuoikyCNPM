package com.nhom12.controller;

import com.nhom12.dao.PeriodDAOImpl;
import com.nhom12.entity.Admin;
import com.nhom12.entity.Period;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "CreatePeriod", urlPatterns = {"/createperiod"})
public class CreatePeriod extends HttpServlet {

    private static final long serialVersionUID = 1L;

    PeriodDAOImpl dao = new PeriodDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();

        if (session != null && session.getAttribute("admin") != null) {
            List<Period> period = dao.getMainPeriods();
            request.setAttribute("period", period);
            request.getRequestDispatcher("/create_period.jsp").forward(request, response);
        } else {
            request.setAttribute("message", "Error");
            request.getRequestDispatcher("/home").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute("admin");
        
        if (session != null && admin != null) {

            try {
                String beginningDate = request.getParameter("beginning");
                String endDate = request.getParameter("end");
                String periodName = request.getParameter("periodName");
                int createFor = Integer.parseInt(request.getParameter("createFor"));
                int typeID = Integer.parseInt(request.getParameter("typeID"));
                int mainPeriod = Integer.parseInt(request.getParameter("mainPeriod"));

                java.util.Date b = new SimpleDateFormat("yyyy-MM-dd").parse(beginningDate);
                java.sql.Date beginning = new java.sql.Date(b.getTime());

                java.util.Date e = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
                java.sql.Date end = new java.sql.Date(e.getTime());

                dao.addPeriod(beginning, end, periodName, createFor, typeID, mainPeriod);

                request.setAttribute("message", "Tạo thành công đợt đăng ký cho " + (createFor == 0 ? "giảng viên!" : "sinh viên!"));
                request.getRequestDispatcher("/create_period.jsp").forward(request, response);

            } catch (ParseException ex) {
                Logger.getLogger(CreatePeriod.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            request.setAttribute("message", "Error");
            request.getRequestDispatcher("/home").forward(request, response);
        }
    }
}
