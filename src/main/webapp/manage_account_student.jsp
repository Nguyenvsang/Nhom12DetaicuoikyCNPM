<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ include file="header.jsp"%>
<!-- Main content -->
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-6">
                    <h1 class="m-0 text-dark"></h1>
                </div>
            </div>
            <!-- /.row -->
        </div>
        <!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->
    <section class="content">

        <div class="container-fluid">

            <div class="row">
                <div class="col-md-3"></div>
                <div class="col-md-6">
                    <!-- general form elements -->
                    <div class="card card-primary">
                        <div class="card-header">
                            <h3 class="card-title">Chỉnh sửa tên thể loại</h3>
                        </div>
                        <div class="row justify-content-center"
                             style="margin-top: 15px; margin-bottom: -15px;">
                            <div style="color: red;">${errorString}</div>
                        </div>
                        <div class="card-body">

                            <input type="hidden" name="studentID" value="${student.studentID}" readonly />
                            <div class="form-group">
                                <label>Họ và tên</label> <input type="text" class="form-control"
                                                                name="studentName" value="${student.studentName}" readonly>
                            </div>
                            <div class="form-group">
                                <label>CCCD/CMND</label> <input type="text" class="form-control"
                                                                name="citizenID" value="${student.citizenID}" readonly>
                            </div>
                            <div class="form-group">
                                <label>Giới tính</label> <input type="text" class="form-control"
                                                                name="gender" value=" ${student.gender == "nam" ? "Nam" : "Nữ"}" readonly>
                            </div> 
                            <div class="form-group">
                                <label>Ngày sinh</label> <input type="date"
                                                                class="form-control"  name="dateOfBirth"
                                                                value="${student.dateOfBirth}" readonly>
                            </div>
                            <div class="form-group">
                                <label>Email</label> <input type="email"
                                                            class="form-control" name="email"
                                                            value="${student.email}" readonly>
                            </div> 
                            <div class="form-group">
                                <label>Số điện thoại</label> <input type="text"
                                                                    class="form-control" name="phoneNumber" 
                                                                    value="${student.phoneNumber}" readonly>
                            </div>
                            <div class="form-group">
                                <label>Khoa</label> <input type="text"
                                                           class="form-control" name="department" 
                                                           value="${student.department}" readonly>
                            </div>
                        </div>
                        <div class="card-footer">
                            <input type="button" value="Chỉnh sửa" class="btn btn-primary"
                                   onclick="location.href = '${pageContext.request.contextPath}/student/update'">
                        </div>
                        <div class="card-footer">
                            <input type="button" value="Trở lại" class="btn btn-primary"
                                   onclick="location.href = '${pageContext.request.contextPath}/student/manage'">
                        </div>
                    </div>
                    <!-- /.card -->

                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
    </section>
    <!-- /.content -->
    <%@ include file="footer.jsp"%>
    <script src="/Resources/plugins/jquery/jquery.min.js"></script>

    <script src="/Resources/plugins/bs-custom-file-input/bs-custom-file-input.min.js"></script>
    <!-- AdminLTE App -->
    <script src="/Resources/js/adminlte.min.js"></script>
            <!-- AdminLTE for demo purposes -->
    <script src="/Resources/js/demo.js"></script>
    <script type="/text/javascript">
    $(document).ready(function () {
                                               bsCustomFileInput.init();
                });
                </script>