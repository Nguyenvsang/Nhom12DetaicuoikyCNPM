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
                        <form name="formSearch" role="form" method="post"
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
                        <c:if test="${checkPeriodID == true}">
                            <label style="margin-left: 20px; text-align: center; margin-top: 20px">Bộ môn</label>
                            <form name="formSubject" role="form" method="post"
                                  action="${pageContext.request.contextPath}/topic/filter">
                                <select name="subjectID" id="subjectID"
                                        onchange="document.formSubject.submit();"
                                        style="margin-bottom: 20px;margin-left: 20px;width: 20%; display: block; margin: 0 auto">
                                    <option value="0">Chọn bộ môn</option>
                                    <option value="0">Tất cả</option>
                                    <c:forEach items="${subject}" var="s">
                                        <option value="${s.subjectID}">${s.subjectName}</option>
                                    </c:forEach>
                                </select>
                            </form>
                        </c:if>
                        <p class="text-warning text-center">${message}</p>
                        <!-- /.card-header -->
                        <div class="card-body" >
                            <c:if test="${sessionScope.admin == null && sessionScope.student == null}">
                                <div class="card-header" style="margin-left: -20px; margin-top: -40px;">
                                    <input type="button" value="Đăng ký đề tài"
                                           class="btn btn-primary"
                                           onclick="location.href = '${pageContext.request.contextPath}/topicregister'">
                                </div>
                            </c:if>
                            <table class="table table-bordered table-hover" id="example2">
                                <thead>
                                    <tr>
                                        <th style="width: 10px">STT</th>
                                        <th style="width: 55%;">Tên đề tài</th>                                                                                                                         
                                        <th style="width: 20%;">Giảng viên hướng dẫn</th>                                       
                                        <th style="width: 10%;">Xem</th>
                                        <th style="width: 10%;">Chỉnh sửa</th>
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

                                            <td><a
                                                    href="<c:url value="/topicdetail?topicID=${i.topicID}"/>"
                                                    class="btn btn-sm btn-primary">Chi tiết</a></td>
                                            <td><a
                                                    href="${pageContext.request.contextPath}/edittopic?topicID=${i.topicID}"
                                                    class="btn btn-sm btn-info">Chỉnh sửa</a></td>
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
    <script 
        src="Resources/plugins/datatables/jquery.dataTables.min.js">
    </script>
    <script
        src="Resources/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js">
    </script>
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