<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                                <h3 class="card-title">Danh sách đề tài cần đánh giá</h3>
                                <!--                                <div class="card-tools" style="margin-right: 1px;">
                                                                    <div class="input-group input-group-sm" style="width: 200px;">
                                                                        <input type="text" name="data_search"
                                                                               class="form-control float-right"
                                                                               placeholder="Tìm kiếm theo tên">
                                
                                                                        <div class="input-group-append">
                                                                            <button type="submit" class="btn btn-primary">
                                                                                <i class="fas fa-search"></i>
                                                                            </button>
                                                                        </div>
                                                                    </div>
                                                                </div>-->
                            </div>
                        </form>
                        <div class="row justify-content-center">
                            <div style="margin-top: 20px; color: red;">${errorString}</div>
                        </div>
                        <p class="text-warning text-center">${message}</p>
                        <!-- /.card-header -->
                        <div class="card-body" >
                            <table class="table table-bordered table-hover" id="example2">
                                <thead>
                                    <tr>
                                        <th style="width: 10%">STT</th>
                                        <th style="width: 40%;">Tên đề tài</th>                                       
                                        <th style="width: 30%;">Giảng viên hướng dẫn</th>
                                        <%--<th style="width: 10%;">Hội đồng</th>--%>
                                        <th style="width: 20%;">Đánh giá</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${topicToEvaluate}" var="topic" >
                                        <tr>
                                            <td>${topic.topicID}</td>
                                            <td>${topic.topicName}</td>
                                            <c:forEach items="${lecturerlist}" var="lecturer">
                                                <c:if test="${lecturer.lecturerID == topic.lecturerID}">
                                                    <td>${lecturer.lecturerName}</td>  
                                                </c:if>
                                            </c:forEach>
                                                <%--<td>${topic.councilID}</td>--%>     
                                            <td>
                                                <a href="<c:url value="/topic/evaluate?topicID=${topic.topicID}"/>">
                                                    <input type="submit" value="Đánh giá">
                                                </a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>

                        </div>

                    </div>
                    <!-- /.card -->
                </div>
            </div>
            <!-- /.container-fluid -->
    </section>
    <%@ include file="footer.jsp"%>
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