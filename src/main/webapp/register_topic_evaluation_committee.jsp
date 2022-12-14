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
                                <h3 class="card-title">Danh sách đề tài khả dụng</h3>

                                <div class="card-tools" style="margin-right: 1px;">
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
                                </div>

                            </div>
                        </form>
                        <div class="row justify-content-center">
                            <div style="margin-top: 20px; color: red;">${errorString}</div>
                        </div>
                        <label style="margin-left: 20px">Vui lòng chọn 1 đề tài muốn phân giảng viên phản biện</label>
                        <%--  <select name="subjectID" style="margin-bottom: 20px;margin-left: 20px;width: 20%">
                            <c:forEach items="${subject}" var="s">
                                <option value="${s.id}">${s.name}</option>
                            </c:forEach>
                        </select>
                        --%>
                        <p class="text-warning text-center">${message}</p>
                        <!-- /.card-header -->
                        <div class="card-body" >
                            <table class="table table-bordered table-hover" id="example2">
                                <thead>
                                    <tr>
                                        <th style="width: 5%">STT</th>
                                        <th style="width: 25%;">Tên đề tài</th>                                                                                                                         
                                        <th style="width: 15%;">Giảng viên hướng dẫn</th>
                                        <th style="width: 10%;">Bộ môn</th>
                                        <th style="width: 10%;">Số lượng sinh viên</th>
                                        <th style="width: 10%;">Xem</th>
                                        <th style="width: 15%;">Chọn</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${listtopichavecouncil}" var="i" >
                                        <tr>
                                            <td>${i.topicID}</td>
                                            <td>${i.topicName}</td>
                                            <c:forEach items="${listlecturer}" var="l">
                                                <c:if test="${l.lecturerID == i.lecturerID}">
                                                    <td>${l.lecturerName}</td>  
                                                </c:if>
                                            </c:forEach>
                                            <c:forEach items="${subject}" var="s">
                                                <c:if test="${s.subjectID == i.subjectID}">
                                                    <td>${s.subjectName}</td>  
                                                </c:if>
                                            </c:forEach>  
                                            <td>${i.quantity}</td>
                                            
                                            <td>
                                                <a href="${pageContext.request.contextPath}/topicdetail?topicID=${i.topicID}" class="btn btn-sm btn-info">Chi tiết</a>
                                            </td>
                                            <td>
                                                <a href="${pageContext.request.contextPath}/lecturerDean?topicID=${i.topicID}" class="btn btn-sm btn-info">Chọn</a>
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
