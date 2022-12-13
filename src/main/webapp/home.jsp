<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- Main content -->
<!-- Content Wrapper. Contains page content -->

<div class="content-wrapper">
    <!-- Main content -->
    <section class="content">

        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <div class="card">
                        <div class="card-header" style="display: block; position: relative">
                            <h3 class="card-title" style="font-size: 30px; color: green">Thông báo</h3>
                            <h3 id="time" class="card-title" style="position: absolute; right: 20px;  padding-top: 6px"></h3>
                        </div>
                    </div>
                </div>
            </div>
            <c:set var="error" value="Error"></c:set>
            <c:if test="${message == error}">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-header">
                                <i class="fa fa-warning card-title" style="color: #fa9f1e; padding-top: 1px"></i> 
                                <h3 class="card-title" style="color: #fa9f1e; font-weight: bold;">&nbsp; Cảnh báo</h3>
                                <br>
                                <h3 class="card-title" style="left: 0; margin-top: 15px">Vui lòng đăng nhập!</h3> 
                            </div>
                        </div>
                    </div>
                </div>
            </c:if>
            
            <div class="row">
                <div class="col-md-12">
                    <div class="card">
                        <div class="card-header">
                            <h3 class="card-title" style="color: #00cd5a; font-weight: bold">Đang diễn ra</h3>
                        </div>
                        <c:forEach items="${happening}" var="h">
                            <div class="card-header">
                                <input class="card-title" type="button" value="<fmt:formatDate pattern = "dd/MM/yyyy" value = "${h.beginning}"/> - <fmt:formatDate pattern = "dd/MM/yyyy" value = "${h.end}"/>"> &ensp;
                                <h3 class="card-title" style="padding-top: 6px">&ensp;&ensp;<em>Dành cho ${h.createFor == 0 ? "giảng viên" : "sinh viên"}</em> - Đăng ký ${h.periodName}</h3>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-12">
                    <div class="card">
                        <div class="card-header">
                            <h3 class="card-title" style="color: #5897fb; font-weight: bold">Sắp diễn ra</h3>
                        </div>
                        <c:forEach items="${upcoming}" var="u">
                            <div class="card-header">
                                <input class="card-title" type="button" value="<fmt:formatDate pattern = "dd/MM/yyyy" value = "${u.beginning}"/> - <fmt:formatDate pattern = "dd/MM/yyyy" value = "${u.end}"/>" readonly>
                                <h3 class="card-title" style="padding-top: 6px"> &ensp;&ensp;<em>Dành cho ${u.createFor == 0 ? "giảng viên" : "sinh viên"}</em> - Đăng ký ${u.periodName}</h3>
                            </div>
                        </c:forEach>
                    </div>
                </div>
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
    <script>
        var timeDisplay = document.getElementById("time");
        function refreshTime() {
            var dateString = new Date().toLocaleString("vi-VI", {timeZone: "Asia/Ho_Chi_Minh"});
            var formattedString = dateString.replace(", ", " - ");
            timeDisplay.innerHTML = formattedString;
        }

        setInterval(refreshTime, 1000);
    </script>
</div>