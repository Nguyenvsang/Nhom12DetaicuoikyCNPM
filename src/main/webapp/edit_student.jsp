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
                            <h3 class="card-title">Chỉnh sửa thông tin</h3>
                        </div>
                        <!-- /.card-header -->
                        <!-- form start -->
                        <form role="form" method="post" action="<c:url value="/student/update?studentID=${sessionScope.student.studentID}"/>">
                            <div class="card-body">
                                <div class="form-group">
                                    <input type="hidden"
                                           class="form-control" id="studentID" name="studentID"
                                           value=${sessionScope.student.studentID} readonly>
                                </div>
                                <div class="form-group">
                                    <label>Họ và tên</label> <input type="text"
                                                                    class="form-control" id="studentName" name="studentName"
                                                                    value="${sessionScope.student.studentName}">
                                </div>
                                <div class="form-group">
                                    <label>CCCD/CMND</label> <input type="text"
                                                                    class="form-control" id="citizenID" name="citizenID"
                                                                    value="${sessionScope.student.citizenID}">
                                </div>
                                <div class="form-group">
                                    <label>Giới tính</label> <input type="text"
                                                                    class="form-control" id="gender" name="gender"
                                                                    value="${sessionScope.student.gender}">
                                </div>
                                <div class="form-group">
                                    <label>Ngày sinh</label> <input type="date"
                                                                    class="form-control" id="dateOfBirth" name="dateOfBirth"
                                                                    value="${sessionScope.student.dateOfBirth}">
                                </div>
                                <div class="form-group">
                                    <label>Email</label> <input type="email"
                                                                class="form-control" id="email" name="email"
                                                                value="${sessionScope.student.email}">
                                </div>
                                <div class="form-group">
                                    <label>Số điện thoại</label> <input type="text"
                                                                        class="form-control" id="phoneNumber" name="phoneNumber"
                                                                        value="${sessionScope.student.phoneNumber}">
                                </div>
                                <div class="form-group">
                                    <label>Ngành</label> <input type="text"
                                                                class="form-control" id="department" name="department"
                                                                value="${sessionScope.student.department}">
                                </div>
                                <div class="card-footer">
                                    <button type="submit" class="btn btn-primary ">Lưu</button>
                                    <input type="button" value="Trở lại" class="btn btn-primary"
                                           onclick="location.href = '${pageContext.request.contextPath}/student/manage'">
                                </div>
                            </div>
                        </form>
                    </div>
                    <!-- /.row -->
                </div>
            </div>
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
</div>
<!-- /.card -->
