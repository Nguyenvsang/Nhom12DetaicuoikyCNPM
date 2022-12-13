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
                            <h3 class="card-title">Tạo đợt đăng ký mới</h3>
                        </div>
                        <p class="text-success text-center">${message}</p>
                        <div class="row justify-content-center"
                             style="margin-top: 15px; margin-bottom: -15px;">
                        </div>
                        <!-- /.card-header -->
                        <!-- form start -->
                        <form role="form" method="post" action="${pageContext.request.contextPath}/createperiod" id="create">
                            <div class="card-body">
                                <div class="form-group">
                                    <label>Ngày bắt đầu</label> <input type="date"
                                                                       class="form-control" id="begining" name="beginning"
                                                                       placeholder="Nhập ngày kết thúc" required="">
                                </div>
                                <div class="form-group">
                                    <label>Ngày kết thúc</label> <input type="date"
                                                                        class="form-control" id="end" name="end"
                                                                        placeholder="Nhập ngày bắt đầu" required="">
                                </div>
                                <div class="form-group">
                                    <label>Tên đợt đăng ký</label> <input type="text"
                                                                          class="form-control" id="periodName" name="periodName"
                                                                          placeholder="Nhập tên đợt đăng ký" required="">
                                </div>
                                <div class="form-group">
                                    <label>Tạo đợt đăng ký cho</label> 
                                    <select name="createFor" id="createFor"
                                            class="form-control" required>
                                        <option value="">Chọn đối tượng cho đợt đăng ký</option> 
                                        <option value="0">Giảng viên</option>
                                        <option value="1">Sinh viên</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label>Loại đề tài</label> 
                                    <select name="typeID" id="typeID"
                                            class="form-control" required>
                                        <option value="">Chọn loại đề tài</option> 
                                        <option value="0">Đề tài tốt nghiệp</option>
                                        <option value="1">Tiểu luận chuyên ngành</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label>Đợt đăng ký chính</label> 
                                    <select name="mainPeriod" id="mainPeriod"
                                            class="form-control" required>
                                        <option value="">Chọn đợt đăng ký chính</option> 
                                        <option value="0">Không có</option>
                                        <c:forEach items="${period}" var="p">
                                            <option value="${p.periodID}">${p.periodName}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="card-footer">
                                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#staticBackdrop">Lưu</button>
                                    <input type="button" value="Trở lại" class="btn btn-primary"
                                           onclick="location.href = 'topicregister'">
                                </div>
                                <div class="modal fade"
                                     id="staticBackdrop"
                                     data-backdrop="static" data-keyboard="false" tabindex="-1"
                                     aria-labelledby="staticBackdropLabel" aria-hidden="true">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title" id="staticBackdropLabel1">Chú
                                                    ý</h5>
                                                <button type="button" class="close" data-dismiss="modal"
                                                        aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>
                                            </div>
                                            <div class="modal-body">
                                                <span class="text-warning">Bạn có chắc muốn đăng ký đề tài này không?</span>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button"
                                                        class="btn btn-warning  btn-secondary"
                                                        data-dismiss="modal">Hủy</button>
                                                <a href="#" type="button" class="btn btn-success" id="submit">Đăng ký</a>
                                            </div>
                                        </div>
                                    </div>
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
    <script>
        $('#submit').click(function () {
            $('#create').submit();
        });
    </script>
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
</div>