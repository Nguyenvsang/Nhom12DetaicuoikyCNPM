<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<!-- Main content -->
<!-- Content Wrapper. Contains page content -->
<jsp:useBean id="t" class="com.nhom12.dao.TopicTypeDAOImpl" scope="request"/>
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
                                <h3 class="card-title">Danh sách loại đề tài</h3>

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
                        <!-- /.card-header -->
                        <div class="card-body" >
                            <div class="card-header" style="margin-left: -20px; margin-top: -40px;">
                                <input type="button" value="Thêm loại đề tài"
                                       class="btn btn-primary"
                                       onclick="location.href = '${pageContext.request.contextPath}/AddBook'">
                            </div>
                            <table class="table table-bordered table-hover" id="example2">
                                <thead>
                                    <tr>
                                        <th style="width: 10%">STT</th>
                                        <th style="width: 70%;">Loại đề tài</th>
                                        <th style="width: 20%;">Xem</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${t.allTypeOfTopics}" var="i" varStatus="loop">
                                        <tr>
                                            <td style="text-align: center;">${i.typeID}</td>
                                            <td>${i.typeName}</td>
                                            <td>${book.getCategory().getName()}</td>
                                            <td>                                                            
                                                <a href="<c:url value='/product/detail?id=${cat.id}'/>"
                                                   class="center">Danh sách</a>
                                            </td>

                                    <figcaption>
                                        <a href="Resources/img/products/${book.getImage()}"
                                           style="font-size: 14px;" target="_blank">Xem chi tiết</a>
                                    </figcaption>
                                    <td><a
                                            href="${pageContext.request.contextPath}/EditBook?id=${book.getId()}"
                                            class="btn btn-sm btn-info">Chỉnh sửa</a></td>
                                    <td>
                                        <button type="button" class="btn btn-primary btn-danger"
                                                data-toggle="modal"
                                                data-target="#staticBackdrop-${Integer.toString(book.getId())}"
                                                style="padding-bottom: 5px; padding-top: 3px; font-size: 14px">Xóa</button>
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