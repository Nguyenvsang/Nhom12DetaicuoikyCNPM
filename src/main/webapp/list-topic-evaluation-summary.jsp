<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<!-- Main content -->
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Main content -->
    <section class="content">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <div class="card">
                        <form role="form" method="post"
                              action="${pageContext.request.contextPath}/SearchBook">
                            <div class="card-header">
                                <h3 class="card-title">Các đánh giá đã nhận được từ đề tài</h3>
                            </div>
                        </form>
                        <p class="text-success text-center">${message}</p>
                        <!-- /.card-header -->
                        <div class="card-body" >
                            <table class="table table-bordered table-hover text-center vertical" id="example2" style="text-align: center">
                                <thead>
                                    <tr>
                                        <th style="width: 10%">Hội đồng số</th>
                                        <th style="width: 20%;">Giảng viên</th>
                                        <th style="width: 40%;">Đánh giá</th>
                                        <th style="width: 10%;">Điểm số</th>
                                        <th style="width: 20%;">Ngày đánh giá</th>  
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${topicEvaluation}" var="te" >
                                        <tr>
                                            <td>${te.councilID}</td>
                                            <c:forEach items="${lecturerList}" var="lecturer">
                                                <c:if test="${lecturer.lecturerID == te.lecturerID}">
                                                    <td>${lecturer.lecturerName}</td>  
                                                </c:if>
                                            </c:forEach>   
                                            <td style=" text-align: justify">${te.evaluation}</td>
                                            <td>${te.point}</td>
                                            <td><fmt:formatDate pattern = "dd/MM/yyyy HH:mm:ss" value = "${te.dateEvaluate}"/></td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                            <p class="text-success text-center">${check == true ? "": "Đã cho điểm chính thức!"}</p>
                            <form role="form" method="post" action="${pageContext.request.contextPath}/topic/evaluate/summary?topicID=${topic.topicID}">
                                <div class="form-group">
                                    <label>Điểm số chính thức</label>
                                    <input type="text"class="form-control" id="point" name="point" value= "${check == true ? "" : topic.point}"
                                           ${check == true ? "" : "readonly" } required style="width: 20%">
                                </div>
                                <div class="card-footer" style="width: 20%">
                                    <button type="submit" class="btn btn-success" ${check == true ? "" : "disabled"}>Lưu điểm</button>
                                    <input type="button" value="Trở lại" class="btn btn-primary"
                                           onclick="location.href = '${pageContext.request.contextPath}/topic/summary'">
                                </div>
                            </form>
                        </div>

                    </div>
                    <!-- /.card -->
                </div>
            </div>
            <!-- /.container-fluid -->
    </section>

    <!-- DataTables -->
    <script src="Resources/plugins/datatables/jquery.dataTables.min.js"></script>
    <script
    src="Resources/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
    <script
    src="Resources/plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
    <script
    src="Resources/plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>
    <!-- AdminLTE App -->
    <script src="Resources/js/adminlte.min.js"></script>
    <!-- AdminLTE for demo purposes -->
    <script src="Resources/dist/js/demo.js"></script>
    <!-- page script -->
    <script>
                                               $(function () {
                                                   $("#example1").DataTable({
                                                       "responsive": true,
                                                       "autoWidth": false
                                                   });
                                                   $('#example2').DataTable({
                                                       "paging": true,
                                                       "lengthChange": false,
                                                       "searching": false,
                                                       "ordering": true,
                                                       "info": true,
                                                       "autoWidth": false,
                                                       "responsive": true
                                                   });
                                               });
    </script>