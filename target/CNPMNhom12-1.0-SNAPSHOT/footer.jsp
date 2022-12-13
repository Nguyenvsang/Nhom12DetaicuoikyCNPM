<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <div>
        <footer class="main-footer"> </footer>
        <aside class="control-sidebar control-sidebar-dark">
            <!-- Control sidebar content goes here -->
        </aside>
        <!-- /.control-sidebar -->
    </div>
    <!-- ./wrapper -->

    <!-- jQuery -->
    <script src="<c:url value="/Resources/plugins/jquery/jquery.min.js"/>"></script>
    <!-- jQuery UI 1.11.4 -->
    <script src="<c:url value="/Resources/plugins/jquery-ui/jquery-ui.min.js"/>"></script>
    <!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
    <script>
        $.widget.bridge('uibutton', $.ui.button);
    </script>
    <!-- Bootstrap 4 -->
    <script src="<c:url value="/Resources/plugins/bootstrap/js/bootstrap.bundle.min.js"/>"></script>
    <!-- ChartJS -->
    <script src="<c:url value="/Resources/plugins/chart.js/Chart.min.js"/>"></script>
    <!-- Sparkline -->
    <script src="<c:url value="/Resources/plugins/sparklines/sparkline.js"/>"></script>
    <!-- JQVMap -->
    <script src="<c:url value="/Resources/plugins/jqvmap/jquery.vmap.min.js"/>"></script>
    <script src="<c:url value="/Resources/plugins/jqvmap/maps/jquery.vmap.usa.js"/>"></script>
    <!-- jQuery Knob Chart -->
    <script src="<c:url value="./Resources/plugins/jquery-knob/jquery.knob.min.js"/>"></script>
    <!-- daterangepicker -->
    <script src="<c:url value="/Resources/plugins/moment/moment.min.js"/>"></script>
    <script src="<c:url value="/Resources/plugins/daterangepicker/daterangepicker.js"/>"></script>
    <!-- Tempusdominus Bootstrap 4 -->
    <script
    src="<c:url value="/Resources/plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js"/>"></script>
    <!-- Summernote -->
    <script src="<c:url value="/Resources/plugins/summernote/summernote-bs4.min.js"/>"></script>
    <!-- overlayScrollbars -->
    <script
    src="<c:url value="/Resources/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"/>"></script>
    <!-- AdminLTE App -->
    <script src="<c:url value="/Resources/js/adminlte.js"/>"></script>
    <!-- AdminLTE dashboard demo (This is only for demo purposes) -->
    <script src="<c:url value="/Resources/js/pages/dashboard.js"/>"></script>
    <!-- AdminLTE for demo purposes -->
    <script src="<c:url value="/Resources/js/demo.js"/>"></script>

</html>
