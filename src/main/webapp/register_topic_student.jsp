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
                                <h3 class="card-title">Danh sách đề tài</h3>

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
                        <label style="margin-left: 20px">Bộ môn</label>
                        <%--  <select name="subjectID" style="margin-bottom: 20px;margin-left: 20px;width: 20%">
                            <c:forEach items="${subject}" var="s">
                                <option value="${s.id}">${s.name}</option>
                            </c:forEach>
                        </select>
                        --%>
                        <!-- /.card-header -->
                        <p class="text-warning text-center">${message}</p>
                        <div class="card-body" >
                            <table class="table table-bordered table-hover" id="example2" style="text-align: center">
                                <thead>
                                    <tr>
                                        <th style="width: 5%">STT</th>
                                        <th style="width: 25%;">Tên đề tài</th>                                                                                                                         
                                        <th style="width: 15%;">Giảng viên hướng dẫn</th>
                                        <th style="width: 15%;">Loại đề tài</th>
                                        <th style="width: 10%;">Môn học</th>
                                        <th style="width: 10%;">Số lượng</th>
                                        <th style="width: 10%;">Xem</th>
                                        <th style="width: 10%;">Đăng ký</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${listtopic}" var="i" >
                                        <tr>
                                            <td>${i.topicID}</td>
                                            <td>${i.topicName}</td>

                                            <c:forEach items="${lecturer}" var="l">
                                                <c:if test="${l.lecturerID == i.lecturerID}">
                                                    <td>${l.lecturerName}</td>  
                                                </c:if>
                                            </c:forEach>                                           

                                            <c:forEach items="${topictype}" var="t">
                                                <c:if test="${t.typeID == sessionScope.periodOfStudent.typeID}">
                                                    <td>${t.typeName}</td>  
                                                </c:if>
                                            </c:forEach>

                                            <c:forEach items="${subject}" var="s">
                                                <c:if test="${s.subjectID == i.subjectID}">
                                                    <td>${s.subjectName}</td>  
                                                </c:if>
                                            </c:forEach>

                                            <td style="color: ${i.quantity != 2 ? "red":"green"}">${i.quantity}/2</td>   
                                            <td>
                                                <a href="<c:url value="/topicdetail?topicID=${i.topicID}"/>" class="btn btn-sm btn-info">Chi tiết</a>
                                            </td>
                                            <td>
                                                <button type="button" class="btn btn-primary btn-success ${i.quantity == 2 ? "disabled" : ""}"  style="font-size: 14px"
                                                        data-toggle="modal"
                                                        data-target="#staticBackdrop-${i.topicID}">Đăng ký</button>
                                            </td>
                                        </tr>

                                    <div class="modal fade"
                                         id="staticBackdrop-${i.topicID}"
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
                                                    <span class="text-warning"> Bạn có chắc muốn đăng ký đề tài ${i.topicName} không?</span>
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="button"
                                                            class="btn btn-warning  btn-secondary"
                                                            data-dismiss="modal">Hủy</button>
                                                    <form action="${pageContext.request.contextPath}/student-register?topicID=${i.topicID}"
                                                          method="post">
                                                        <button type="submit" class="btn btn-success">Đăng ký</button>
                                                    </form>

                                                </div>
                                            </div>
                                        </div>
                                    </div>

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