<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Trang đăng ký đề tài</title>
        <!-- Tell the browser to be responsive to screen width -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Font Awesome -->
        <link rel="stylesheet"
              href="<c:url value="/Resources/plugins/fontawesome-free/css/all.min.css"/>">
        <!-- Ionicons -->
        <link rel="stylesheet"
              href="<c:url value="/Resources/css/ionicons.min.css"/>">
        <!-- Tempusdominus Bbootstrap 4 -->
        <link rel="stylesheet"
              href="<c:url value="/Resources/plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css"/>">
        <!-- iCheck -->
        <link rel="stylesheet"
              href="<c:url value="/Resources/plugins/icheck-bootstrap/icheck-bootstrap.min.css"/>">
        <!-- JQVMap -->
        <link rel="stylesheet" href="<c:url value="/Resources/plugins/jqvmap/jqvmap.min.css"/>">

        <!-- overlayScrollbars -->
        <link rel="stylesheet"
              href="<c:url value="/Resources/plugins/overlayScrollbars/css/OverlayScrollbars.min.css"/>">
        <!-- Daterange picker -->
        <link rel="stylesheet"
              href="<c:url value="/Resources/plugins/daterangepicker/daterangepicker.css"/>">
        <!-- summernote -->
        <link rel="stylesheet"
              href="<c:url value="/Resources/plugins/summernote/summernote-bs4.css"/>">
        <!-- Google Font: Source Sans Pro -->
        <!-- daterange picker -->
        <link rel="stylesheet"
              href="<c:url value="/Resources/plugins/daterangepicker/daterangepicker.css"/>">
        <!-- Bootstrap Color Picker -->
        <link rel="stylesheet"
              href="<c:url value="/Resources/plugins/bootstrap-colorpicker/css/bootstrap-colorpicker.min.css"/>">
        <!-- Select2 -->
        <link rel="stylesheet"
              href="<c:url value="/Resources/plugins/select2/css/select2.min.css"/>">
        <link rel="stylesheet"
              href="<c:url value="/Resources/plugins/select2-bootstrap4-theme/select2-bootstrap4.min.css"/>">
        <!-- Bootstrap4 Duallistbox -->
        <link rel="stylesheet"
              href="<c:url value="/Resources/plugins/bootstrap4-duallistbox/bootstrap-duallistbox.min.css"/>">
        <!-- Theme style -->
        <link rel="stylesheet" href="<c:url value="/Resources/css/adminlte.min.css"/>">
        <!-- Google Font: Source Sans Pro -->

        <link
            href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700"
            rel="stylesheet">
    </head>
    <body class="hold-transition sidebar-mini layout-fixed"">
        <div class="wrapper">

            <!-- Navbar -->
            <nav class="main-header navbar navbar-expand navbar-white navbar-light" style="height: 100px">
                <!-- Left navbar links -->
                <ul class="navbar-nav">
                    <li class="nav-item"><a class="nav-link" data-widget="pushmenu"
                                            href="#" role="button"><i class="fas fa-bars"></i></a></li>
                    <li class="nav-item d-none d-sm-inline-block">
                        <a href="${pageContext.request.contextPath}/home"
                           class="nav-link" style="font-weight: bold">WEBSITE ĐĂNG KÝ ĐỀ TÀI KHOA CÔNG NGHỆ THÔNG TIN</a>
                </ul>

            </nav>
            <!-- /.navbar -->

            <!-- Main Sidebar Container -->
            <aside class="main-sidebar sidebar-dark-primary elevation-4">
                <a href="${pageContext.request.contextPath}/home" class="brand-link"> 
                    <img src="<c:url value="/Resources/img/fit.jpg"/>" alt="AdminLTE Logo"
                         class="brand-image img-circle elevation-3" style="opacity: 1">
                    <span class="brand-text font-weight-light">DANH MỤC</span>
                </a>
                <a href="#" class="brand-link" style="text-align: center">
                    <c:if test="${sessionScope.account != null}">
                        <c:if test="${sessionScope.admin != null}">
                            <div class="image">
                                <p style="color: white">ADMIN</p>
                            </div>  
                        </c:if>
                        <c:if test="${sessionScope.dean != null && sessionScope.lecturer == null}">
                            <div>
                                <p style="color: white">${sessionScope.dean.lecturerName}</p>
                                <p style="color: white; font-size: 15px">Trưởng bộ môn</p>
                            </div>  
                        </c:if>
                        <c:if test="${sessionScope.lecturer != null && sessionScope.dean == null}">
                            <div class="image">
                                <p style="color: white">${sessionScope.lecturer.lecturerName}</p>
                                <p style="color: white; font-size: 15px">Giảng viên</p>
                            </div>  
                        </c:if>
                        <c:if test="${sessionScope.lecturer != null && sessionScope.dean != null}">
                            <div class="image">
                                <p style="color: white">${sessionScope.lecturer.lecturerName}</p>
                                <p style="color: white; font-size: 15px">Trưởng bộ môn</p>
                            </div>  
                        </c:if>
                    </c:if>
                </a>
                <!-- Sidebar -->
                <div class="sidebar">
                    <!-- Sidebar user panel (optional) -->
                    <div class="user-panel mt-3 pb-3 mb-3 d-flex">
                        <div class="image">
                            <img src="<c:url value="/Resources/img/user.png"/>" class="img-circle elevation-2"
                                 alt="User Image">
                        </div>
                        <div class="info">
                            <a href="#" class="d-block"><%//=user.getUsername()%></a>
                        </div>
                        <c:choose>
                            <c:when test="${sessionScope.account == null}">
                                <div class="info" style="margin-left: 60px;">
                                    <a href="${pageContext.request.contextPath}/login.jsp" class="d-block">Đăng
                                        nhập</a>
                                </div>
                            </c:when>
                            <c:otherwise>
                                <div class="info" style="margin-left: 60px;">
                                    <a href="${pageContext.request.contextPath}/logout" class="d-block">Đăng
                                        xuất</a>
                                </div>
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <!-- Sidebar Menu -->
                    <nav class="mt-2"">
                        <ul class="nav nav-pills nav-sidebar flex-column"
                            data-widget="treeview" role="menu" data-accordion="false">
                            <li class="nav-item "><a
                                    href="${pageContext.request.contextPath}/home.jsp"
                                    class="nav-link">
                                    <i class="nav-icon fas fa-list""></i>
                                    <p>Hướng dẫn</p>
                                </a>
                            </li>

                            <!-- Thông tin cá nhân -->
                            <li class="nav-item ">
                                <c:if test="${sessionScope.student != null}">
                                    <a href="${pageContext.request.contextPath}/student/manage" class="nav-link">
                                        <i class="nav-icon fas fa-list"></i>
                                        <p>Thông tin sinh viên</p>
                                    </a>
                                </c:if>
                                <c:if test="${sessionScope.lecturer != null}">
                                    <a href="${pageContext.request.contextPath}/lecturer/manage" class="nav-link"> 
                                        <i class="nav-icon fas fa-list"></i>
                                        <p>Thông tin giảng viên</p>
                                    </a>
                                </c:if>
                            </li>

                            <li
                                class="nav-item has-treeview <c:if test="${sessionScope.Check.toString().equals('ManageBook') || sessionScope.Check.toString().equals('AddBook')||sessionScope.Check.toString().equals('ManageCategory')}">menu-open</c:if>">
                                    <a
                                        href="#"
                                        class="nav-link <c:if test="${sessionScope.Check.toString().equals('ManageBook') || sessionScope.Check.toString().equals('AddBook')||sessionScope.Check.toString().equals('ManageCategory')}">active</c:if> ">
                                        <i class="nav-icon fas fa-list""></i>
                                        <p>
                                            Danh sách đề tài<i class="right fas fa-angle-left"></i>
                                        </p>
                                    </a>
                                    <ul class="nav nav-treeview">
                                        <li class="nav-item">
                                            <a
                                                href="${pageContext.request.contextPath}/all-topic"
                                            class="nav-link">
                                            <i class="far fa-circle nav-icon"></i>
                                            <p>Tất cả đề tài</p>
                                        </a>
                                    </li>
                                    <li class="nav-item">
                                        <a
                                            href="${pageContext.request.contextPath}/type"
                                            class="nav-link">
                                            <i class="far fa-circle nav-icon"></i>
                                            <p>Đề tài theo loại</p>
                                        </a>
                                    </li>

                                    <c:if test="${sessionScope.dean != null || sessionScope.lecturer != null}" >
                                        <li class="nav-item">
                                            <a
                                                href="${pageContext.request.contextPath}/list-of-topic"
                                                class="nav-link">
                                                <i class="far fa-circle nav-icon"></i>
                                                <p>Đề tài đã đăng ký</p>
                                            </a>
                                        </li>
                                    </c:if>
                                    <c:if test="${sessionScope.student != null}" >
                                        <li class="nav-item">
                                            <a
                                                href="${pageContext.request.contextPath}/topicRegisteredOfStudent"
                                                class="nav-link">
                                                <i class="far fa-circle nav-icon"></i>
                                                <p>Đề tài đã đăng ký</p>
                                            </a>
                                        </li>
                                    </c:if>
                                        
                                    <li class="nav-item">
                                        <a
                                            href="${pageContext.request.contextPath}/topic-to-register"
                                            class="nav-link">
                                            <i class="far fa-circle nav-icon"></i>
                                            <p>Đề tài cho sinh viên</p>
                                        </a>
                                    </li>
                                </ul>
                            </li>
                            <li class="nav-item ">
                                <a href="<c:url value="/studentToLecturer"/>" class="nav-link">
                                    <i class="nav-icon fas fa-list"></i>
                                    <p>Quản lý sinh viên</p>
                                </a>
                            </li>

                            <!-- Đăng ký đề tài -->
                            <c:if test="${sessionScope.dean != null || sessionScope.lecturer != null}" >
                                <li class="nav-item ">
                                    <a href="<c:url value="/topicregister"/>" class="nav-link">
                                        <i class="nav-icon fas fa-list"></i>
                                        <p>Đăng ký đề tài</p>
                                    </a>
                                </li>
                            </c:if>

                            <!-- Đánh giá đề tài -->
                            <c:if test="${sessionScope.dean != null || sessionScope.lecturer != null}" >
                                <li class="nav-item ">
                                    <a href="<c:url value="/topic-to-evaluate"/>" class="nav-link">
                                        <i class="nav-icon fas fa-list"></i>
                                        <p>Đánh giá đề tài</p>
                                    </a>
                                </li>
                            </c:if>   

                            <!-- Đánh giá đề tài -->
                            <c:if test="${sessionScope.dean != null || sessionScope.lecturer != null}" >
                                <li class="nav-item ">
                                    <a href="<c:url value="/topic/summary"/>" class="nav-link">
                                        <i class="nav-icon fas fa-list"></i>
                                        <p>Tổng hợp đánh giá</p>
                                    </a>
                                </li>
                            </c:if>   

                            <!-- Admin -->
                            <c:if test="${sessionScope.admin != null}" >
                                <li class="nav-item ">
                                    <a href="<c:url value="/topicSubject"/>" class="nav-link">
                                        <i class="nav-icon fas fa-list"></i>
                                        <p>Phân theo bộ môn</p>
                                    </a>
                                </li>
                                <li class="nav-item ">
                                    <a href="<c:url value="/topicToCouncil"/>" class="nav-link">
                                        <i class="nav-icon fas fa-list"></i>
                                        <p>Tạo hội đồng phản biện</p>
                                    </a>
                                </li>
                                <li class="nav-item ">
                                    <a href="<c:url value="/createperiod"/>" class="nav-link">
                                        <i class="nav-icon fas fa-list"></i>
                                        <p>Tạo đợt đăng ký</p>
                                    </a>
                                </li>
                            </c:if>

                            <!-- Trưởng bộ môn -->
                            <c:if test="${sessionScope.dean != null}" >
                                <li class="nav-item ">
                                    <a href="<c:url value="/topicDean"/>" class="nav-link">
                                        <i class="nav-icon fas fa-list"></i>
                                        <p>Phân giảng viên phản biện</p>
                                    </a>
                                </li>
                            </c:if>
                        </ul>
                    </nav>
                    <!-- /.sidebar-menu -->
                </div>
                <!-- /.sidebar -->
            </aside>
        </div>
    </body>
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
