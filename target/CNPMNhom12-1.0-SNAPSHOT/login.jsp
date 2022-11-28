<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
					<div class="card card-primary">
						<div class="card-header text-center">
							<h3 class="text-center">Đăng nhập</h3>
						</div>
						<!-- /.card-header -->
						<!-- form start -->
						<form role="form" action="loginServlet" method="post">
							<div class="row justify-content-center card-body"
								style="margin-bottom: -34px;">
								<div style="color: red;">${errorString}</div>
							</div>
							<div class="card-body">
                                                                <label><input type="radio" name="typelogin" value="lecturer">Giảng viên</label>
                                                                <label><input type="radio" name="typelogin" value="student" checked>Sinh viên</label>
								<div class="form-group text-center">
                                                                                <input
										type="text" class="form-control" name="username"
										placeholder="Tên người dùng" required="required">
								</div>
								<div class="form-group">
                                                                                <input
										type="password" class="form-control" name="password"
										id="exampleInputPassword1" placeholder="Mật khẩu"
										required="required">
								</div>
<!--								<div class="form-check">
									<input type="checkbox" class="form-check-input"
										id="exampleCheck1" name="rememberMe" value="Y"> <label
										class="form-check-label" for="exampleCheck1">Nhớ tài
										khoản</label>
								</div>-->
								
							</div>
							<!-- /.card-body -->

							<div class="card-footer">
								<button type="submit" class="btn btn-primary btn-block">Tiếp tục</button>
							</div>
						</form>
					</div>
				</div>
				<!-- /.row -->
			</div>
			<!-- /.container-fluid -->
	</section>
	<!-- /.content -->
	<%@ include file="footer.jsp"%>