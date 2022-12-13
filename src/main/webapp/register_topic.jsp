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
                            <h3 class="card-title">Đăng ký đề tài cho giảng viên</h3>
                        </div>
                        <div class="row justify-content-center"
                             style="margin-top: 15px; margin-bottom: -15px;">
                            <!--<div style="color: red;">${errorString}</div>-->
                        </div>
                        <!-- /.card-header -->
                        <!-- form start -->
                        <form role="form" method="post" action="${pageContext.request.contextPath}/topicregister">
                            <div class="card-body">
                                <div class="form-group">
                                    <label>Tên đề tài</label> <input type="text"
                                                                     class="form-control" id="topicName" name="topicName"
                                                                     placeholder="Nhập tên đề tài">
                                </div>
                                <div class="form-group">
                                    <label>Mục tiêu</label> <input type="text"
                                                                   class="form-control" id="topicRequire" name="topicRequire"
                                                                   placeholder="Nhập mục tiêu">
                                </div>
                                <div class="form-group">
                                    <label>Yêu cầu</label> <input type="text"
                                                                  class="form-control" id="topicGoal" name="topicGoal"
                                                                  placeholder="Nhập yêu cầu">
                                </div>
                                <div class="form-group">
                                    <label>Năm học</label> <input type="text"
                                                                  class="form-control" id="schoolYear" name="schoolYear"
                                                                  placeholder="Nhập năm học">
                                </div>
                                <div class="form-group">
                                    <label>Loại đề tài</label> 
                                    <c:forEach items="${topicType}" var="tt">
                                        <c:if test="${tt.typeID == sessionScope.periodOfLecturer.typeID}">
                                            <input type="text"
                                                   class="form-control" id="typeID" name="typeID"
                                                   value="${tt.typeName}" readonly>
                                        </c:if>
                                    </c:forEach>
                                </div>
                                <div class="card-footer">
                                    <button type="submit" class="btn btn-primary ">Lưu</button>
                                    <input type="button" value="Trở lại" class="btn btn-primary"
                                           onclick="location.href = 'topicregister'">
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