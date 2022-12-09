/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.nhom12.controller;

import com.nhom12.dao.LecturerDAOImpl;
import com.nhom12.dao.ReviewCouncilDAOImpl;
import com.nhom12.dao.TopicDAOImpl;
import com.nhom12.dao.TopicEvaluationCommitteeDAOImpl;
import com.nhom12.entity.Lecturer;
import com.nhom12.entity.ReviewCouncil;
import com.nhom12.entity.Topic;
import com.nhom12.entity.TopicEvaluationCommittee;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nguye
 */
@WebServlet(name = "evaluationCommitteeTopicAdd", urlPatterns = {"/evaluationCommitteeTopicAdd"})
public class EvaluationCommitteeTopicAdd extends HttpServlet {

    private static final long serialVersionUID = 1L;

    LecturerDAOImpl lecturerDAOImpl = new LecturerDAOImpl();
    TopicDAOImpl topicDAOImpl = new TopicDAOImpl();
    TopicEvaluationCommitteeDAOImpl evalutiondaoImpl = new TopicEvaluationCommitteeDAOImpl();
    ReviewCouncilDAOImpl reviewCouncilDAOImpl = new ReviewCouncilDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        if (session != null && session.getAttribute("dean") != null && session.getAttribute("topic") != null) {
            // Tạo đối tượng giảng viên vừa được nhấn nút chọn, lấy id từ url 
            int lecturerID = Integer.parseInt(request.getParameter("lecturerID"));
            Lecturer lecturer = lecturerDAOImpl.findLecturerByID(lecturerID);
            // Tạo đối tượng topic được lưu trong session 
            Topic topic = (Topic) session.getAttribute("topic");
            // Tìm hội đồng tương ứng với đối tượng đã chọn
            ReviewCouncil council = reviewCouncilDAOImpl.findCouncilByTopicID(topic.getTopicID());
            // Nếu Topic chưa có hội đồng
            if(council == null){
                reviewCouncilDAOImpl.addCouncil(lecturerID, topic.getTopicID(), 0);
                council = reviewCouncilDAOImpl.findCouncilByTopicID(topic.getTopicID());
            }
            // Kiểm tra xem giảng viên này đã được phân cho đề tài này chưa 
            TopicEvaluationCommittee topicEC = evalutiondaoImpl.findTECommitteeByLecturerandCouncil(lecturerID, council.getCouncilID());
            // Nếu đã được phân cho đề tài (hội đồng này) trước đây
            if(topicEC != null){
                request.setAttribute("message", "Giảng viên này đã được phân cho đề tài "+ topic.getTopicID()+", vui lòng chọn người khác!");
                request.getRequestDispatcher("/topicDean").forward(request, response);
            } else {//Chưa đăng kí đề tài, hội đồng này 
                // Nếu hội đồng đã đầy thì 
                if(council.getQuantity() == 5){
                    request.setAttribute("message", "Đề tài " + topic.getTopicID() + " đã có đủ giảng viên phản biện! Vui lòng đăng ký đề tài khác!");
                    request.getRequestDispatcher("/topicDean").forward(request, response);
                } else {// Nếu hội đồng còn chỗ 
                    // Thêm giảng viên vào hội đồng
                    evalutiondaoImpl.addTopicEvaluationCommittee(lecturerID, council.getCouncilID());
                    // Cập nhật lại số lượng giảng viên của hội đồng
                    reviewCouncilDAOImpl.updateCouncil(council.getCouncilID(), council.getLeaderID(), council.getTopicID(), council.getQuantity() + 1);
                    // Thông báo đã phân thành công và chuyển trang 
                    // Sau khi đã hoàn thành sẽ chuyển về trang register_topic_evaluation_committee.jsp và hiện thông báo 
                    request.setAttribute("message", "Đã phân giảng viên phản biện thành công cho đề tài " + topic.getTopicID());
                    request.getRequestDispatcher("/topicDean").forward(request, response);
                }
            }
            
        }
        else{
            response.sendRedirect(request.getContextPath()+ "/login.jsp");
        }
    }

}
