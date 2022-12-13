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
                            <h3 class="card-title">Đánh giá đề tài</h3>
                        </div>
                        <div class="row justify-content-center"
                             style="margin-top: 15px; margin-bottom: -15px;">
                        </div>            
                        <!-- /.card-header -->
                        <!-- form start -->
                        <form role="form" method="post" action="${pageContext.request.contextPath}/topic/evaluate">
                            <div class="card-body">
                                <p class="text-warning text-center">${check == true ? "": "Đã đánh giá!"}</p>
                                <input type="hidden"
                                       class="form-control" value="${topicEvaluation.id}" name="id">
                                <div class="form-group">
                                    <label>Nhận xét</label> 
                                    <textarea rows="5" cols="63" 
                                              placeholder="Nhập nhận xét" name="evaluation" 
                                              ${check == true ? "" : "readonly"} required 
                                              style="text-align: justify">${topicEvaluation.evaluation}</textarea>
                                </div>
                                <div class="form-group">
                                    <label>Nhập điểm</label> 
                                    <input type="text"
                                           class="form-control" name="point"
                                           placeholder="Nhập điểm" value="${topicEvaluation.point}"
                                           ${check == true ? "" : "readonly" } required>
                                </div>
                                <div class="card-footer">
                                    <button type="submit" class="btn btn-primary" ${check == true ? "" : "disabled"}>Lưu đánh giá</button>
                                    <input type="button" value="Quay lại" class="btn btn-primary"
                                           onclick="location.href = '<c:url value="/topic-to-evaluate"/>'">
                                </div>
                            </div>
                        </form>
                    </div>
                    <!-- /.row -->
                </div>
                <!-- /.container-fluid -->
            </div>
        </div>
    </section>
    <!-- /.content -->
    <%@ include file="footer.jsp"%>
    <!-- jQuery -->
    <script src="<c:url value="/Resources/plugins/jquery/jquery.min.js"/>"></script>

    <script
    src="<c:url value="/Resources/plugins/bs-custom-file-input/bs-custom-file-input.min.js"/>"></script>
    <!-- AdminLTE App -->
    <script src="<c:url value="/Resources/js/adminlte.min.js"/>"></script>
    <!-- AdminLTE for demo purposes -->
    <script src="<c:url value="/Resources/js/demo.js"/>"></script>
    <script type="text/javascript">
                                               $(document).ready(function () {
                                                   bsCustomFileInput.init();
                                               });
    </script>
    <!-- /.card -->
</div>