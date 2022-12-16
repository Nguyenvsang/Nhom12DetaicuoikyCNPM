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
                                <h3 class="card-title">Danh sách sinh viên chưa đăng kí đề tài</h3>

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
<!--                        <label style="margin-left: 20px"></label>
                        <select name="catid" style="margin-bottom: 20px;margin-left: 20px;width: 20%">
                            <c:forEach items="${categorylist}" var="c">
                                <option value="${c.id}">${c.name}</option>
                            </c:forEach>
                        </select>-->
                        <p class="text-warning text-center">${message}</p>
                        <!-- /.card-header -->
                        <div class="card-body" >
                            <table class="table table-bordered table-hover" id="example2">
                                <thead>
                                    <tr>
                                        <th style="width: 10px">STT</th>
                                        <th style="width: 55%;">Họ và tên</th>                                                                                                                         
                                        <th style="width: 20%;">CCCD</th>                                       
                                        <th style="width: 10%;">Xem</th>
                                        <th style="width: 10%;">Chỉnh sửa</th>
<!--                                        <th style="width: 5%;">Xóa</th>-->
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${liststudent}" var="i" >
                                        <tr>
                                            <td>${i.studentID}</td>
                                            <td>${i.studentName}</td>
                                            <td>${i.citizenID}</td>

                                            <td><a
                                                    href="<c:url value="/lecturerManageStudentAccount?studentID=${i.studentID}"/>"
                                                    class="btn btn-sm btn-primary">Chi tiết</a></td>
                                            <td><a
                                                    href="${pageContext.request.contextPath}/lecturerTopicsForStudent?studentID=${i.studentID}"
                                                    class="btn btn-sm btn-info">Chọn</a></td>
<!--                                            <td>
                                                <button type="button" class="btn btn-primary btn-danger"
                                                        data-toggle="modal"
                                                        data-target="#staticBackdrop-${Integer.toString(book.getId())}"
                                                        style="padding-bottom: 5px; padding-top: 3px; font-size: 14px">Xóa</button>
                                            </td>-->
                                        </tr>

                                    </c:forEach>
                                </tbody>
                            </table>
                        <div class="card-footer">                                                                     
                                    <input type="button" value="Trở lại" class="btn btn-primary"
                                           onclick="location.href = '${pageContext.request.contextPath}/list-of-topic'">
                                </div>
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