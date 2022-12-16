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
                                <h3 class="card-title" style="font-weight: bold">Danh sách loại đề tài</h3>

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
                        <!-- /.card-header -->
                        <div class="card-body" >
                            <table class="table table-bordered table-hover" id="example2">
                                <thead>
                                    <tr>
                                        <th style="width: 15%; text-align: center">STT</th>
                                        <th style="width: 85%; text-align: center">Loại đề tài</th>                                                                                                                         
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${period}" var="p" >
                                        <tr>
                                            <td><a style="display: block; text-decoration: none; text-align: center; color: black" href="<c:url value="/topic/type?periodID=${p.periodID}"/>" >${p.periodID}</a></td>
                                            <td><a style="display: block; text-decoration: none; color: black" href="<c:url value="/topic/type?periodID=${p.periodID}"/>">${p.periodName}</a></td>
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
        </div>
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
</div>