<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
                            <h4 class="card-title">Thông tin giảng viên</h4>
                        </div>
                        <div class="row justify-content-center"
                             style="margin-top: 15px; margin-bottom: -15px;">
                            <!--<div style="color: red;">${errorString}</div>-->
                        </div>
                        <!-- /.card-header -->
                        <!-- form start -->
                        <form role="form" method="post" action="${pageContext.request.contextPath}/editlecturer">
                            <div class="card-body">
                                <div class="form-group">
                                    <label>ID</label> <input type="text"
                                                             class="form-control" id="lecturerID" name="lecturerID"
                                                             placeholder="ID" value=${lecturer.lecturerID} readonly>
                                </div>
                                <div class="form-group">
                                    <label>Họ và tên</label> <input type="text"
                                                                     class="form-control" id="lecturerName" name="lecturuerName"
                                                                     placeholder="Nhập họ và tên" value="${lecturer.lecturerName}" readonly>
                                </div>
                                <div class="form-group">
                                    <label>Số CCCD/CMND</label> <input type="text"
                                                                   class="form-control" id="citizenID" name="citizenID"
                                                                   placeholder="Nhập số CCCD/CMND" value="${lecturer.citizenID}" readonly>
                                </div>
                                <div class="form-group">
                                    <label>Giới tính</label> <input type="text"
                                                                  class="form-control" id="gender" name="gender"
                                                                  placeholder="Nhập giới tính" value="${lecturer.gender}" readonly>
                                </div>
                                <div class="form-group">
                                    <label>Ngày sinh</label> <input type="date"
                                                                  class="form-control" id="dateOfBirth" name="dateOfBirth"
                                                                  placeholder="Nhập giới tính" value=${lecturer.dateOfBirth} readonly>
                                </div>
                                <div class="form-group">
                                    <label>Email</label> <input type="email"
                                                                  class="form-control" id="email" name="email"
                                                                  placeholder="Nhập email" value="${lecturer.email}" readonly>
                                </div>
                                <div class="form-group">
                                    <label>Số điện thoại</label> <input type="text"
                                                                  class="form-control" id="phoneNumber" name="phoneNumber"
                                                                  placeholder="Nhập số điện thoại" value="${lecturer.phoneNumber}" readonly>
                                </div>
                                <div class="form-group">
                                    <label>Trình độ chuyên môn</label> <input type="text"
                                                                  class="form-control" id="professionalQualification" name="professionalQualification"
                                                                  placeholder="Nhập trình độ chuyên môn" value="${lecturer.professionalQualification}" readonly>
                                </div>
                                
                                <div class="card-footer">
                                           <input type="button" value="Chỉnh sửa" class="btn btn-primary"
                                           onclick="location.href = '${pageContext.request.contextPath}/editlecturer'">                                    
                                           <input type="button" value="Trở lại" class="btn btn-primary"
                                           onclick="location.href = 'edittopic'">
                                </div>
                            </div>
                        </form>
                    </div>
                    <!-- /.row -->
                </div>
                <!-- /.container-fluid -->
                </section>
                <!-- /.content -->
                <%@ include file="footer.jsp"%>
                <!-- jQuery -->
                <script src="./Resources/plugins/jquery/jquery.min.js"></script>

                <script
                src="./Resources/plugins/bs-custom-file-input/bs-custom-file-input.min.js"></script>
                <!-- AdminLTE App -->
                <script src="./Resources/js/adminlte.min.js"></script>
                <!-- AdminLTE for demo purposes -->
                <script src="./Resources/js/demo.js"></script>
                <script type="text/javascript">
                                               $(document).ready(function () {
                                                   bsCustomFileInput.init();
                                               });
                </script>
                <!-- /.card -->
