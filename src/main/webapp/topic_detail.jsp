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
                    
                        <div class="card-header">
                            <h3 class="card-title">Chi tiết đề tài</h3>
                        </div>
                        <div class="row justify-content-center"
                             style="margin-top: 15px; margin-bottom: -15px;">
                        </div>
                        <!-- /.card-header -->
                        <!-- form start -->
                        <form role="form" method="post"
                                <c:if test="${sessionScope.admin != null}">
                                action="${pageContext.request.contextPath}/topicToCouncil"
                                </c:if>
                                <c:if test="${sessionScope.dean != null}">
                                action="${pageContext.request.contextPath}/topicDean"
                                </c:if>
                                <c:if test="${sessionScope.admin == null and sessionScope.dean == null}">
                                action="${pageContext.request.contextPath}/${sessionScope.lecturer == null ? "all-topic" : "list-of-topic"}"
                                </c:if>>
                            <div class="card-body">
                                <div class="form-group">
                                    <label>ID</label> <input type="text"
                                                             class="form-control" id="topicID" name="topicID"
                                                             value="${topic.topicID}" readonly>
                                </div>
                                <div class="form-group">
                                    <label>Tên đề tài</label> <input type="text"
                                                                     class="form-control" id="topicName" name="topicName"
                                                                     value="${topic.topicName}" readonly>
                                </div>
                                <div class="form-group">
                                    <label>Mục tiêu</label> <input type="text"
                                                                   class="form-control" id="topicRequire" name="topicRequire"
                                                                   value="${topic.topicGoal}" readonly>
                                </div>
                                <div class="form-group">
                                    <label>Yêu cầu</label> <input type="text"
                                                                  class="form-control" id="topicGoal" name="topicGoal"
                                                                  value="${topic.topicRequire}" readonly>
                                </div>
                                <div class="form-group">
                                    <label>Năm học</label> <input type="text"
                                                                  class="form-control" id="schoolYear" name="schoolYear"
                                                                  value=${topic.schoolYear} readonly>
                                </div>
                                <div class="form-group">
                                    <label>Số lượng sinh viên</label> <input type="text"
                                                                             class="form-control" id="quantity" name="quantity"
                                                                             value=${topic.quantity} readonly>
                                </div>
                                <div class="form-group">
                                    <label>Loại đề tài</label> 
                                    <c:forEach items="${topictype}" var="tt">
                                        <c:if test="${tt.typeID == topic.typeID}">
                                            <input type="text"
                                                   class="form-control" id="typeID" name="typeID"
                                                   value="${tt.typeName}" readonly>
                                        </c:if>
                                    </c:forEach>
                                    </select>
                                </div>
                                <!-- Tìm tên bộ môn -->
                                <c:set var="subjectInfo" scope="session" value="Chưa được phân"/>
                                <c:forEach items="${subject}" var="s">
                                    <c:if test="${s.subjectID == topic.subjectID}">
                                        <c:set var="subjectInfo" scope="session" value="${s.subjectName}"/>
                                    </c:if>
                                </c:forEach>
                                <div class="form-group">
                                    <label>Bộ môn</label> 
                                    <input type="text"
                                           class="form-control" id="subjectName" name="subjectName"
                                           value="${subjectInfo}" readonly>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label>Giảng viên hướng dẫn</label> 
                                    <c:forEach items="${lecturer}" var="l">
                                        <c:if test="${l.lecturerID == topic.lecturerID}">
                                            <input type="text"
                                                   class="form-control" id="lecturerName" name="lecturerName"
                                                   value="${l.lecturerName}" readonly>
                                        </c:if>
                                    </c:forEach>
                                    </select>
                                </div>
                                <div class="card-footer">
                                    <button type="submit" class="btn btn-primary ">Trở lại</button>
                                </div>
                            </div>
                        </form>
                    
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
