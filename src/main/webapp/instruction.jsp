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
				<div class=""></div>
				<div class="col-md-12">
					<div class="card card-primary" style="margin-top: 12px;">
						<div class="card-header">
							<h3 class="card-title">Hướng dẫn sử dụng trang web</h3>
						</div>
						<div style="margin-top: 12px; margin-left: 12px;">
							<%
								if (request.getSession().getAttribute("User") == null) {
							%>
							<p>
								&nbsp;- Muốn sử dụng trang web này thì đầu tiên bạn cần <b>
									<a href="${pageContext.request.contextPath}/Login">đăng
										nhập.</a>
								</b>. Tên tài khoản: <b>tentaikhoan</b>, Mật khẩu: <b>matkhau</b>.
							</p>
							<%
								} else {
							%>
							<p>&nbsp;Cám ơn bạn đã đăng nhập, bây giờ bạn có thể sử dụng
								trang web.</p>
							<%
								}
							%>
							<p>- Các chức năng của trang web là quản lý đề tài, quản lý
								đăng kí đề tài và quản lý thông tin cá nhân</p>
							<p>
								<b>I. Quản lý đề tài</b>
							</p>
							<p>
								- Muốn xem danh sách đề tài hiện có chọn <b>Quản lý đề tài
									-&gt; Danh sách đề tài.</b>
							</p>
							<p>
								<b>-&nbsp; </b>Trong mục danh sách:&nbsp;
							</p>
							<p></p>
							<ol style="text-align: left;">
								<li>Muốn tìm kiếm đề tài trong danh sách thì gõ vào ô Tìm
									kiếm và nhấn enter.</li>
								<li>Muốn chỉnh sửa thông tin đề tài nào thì nút <b>Chỉnh
										sửa</b>-&gt; Chỉnh sửa những thông tin cần thiết-&gt; Nhấn <b>Lưu-</b>&gt;
									nhấn <b>Hủy</b> để trở lại danh sách.
								</li>
								<li>Muốn xóa đề tài nào thì bạn chọn nút <b>Xóa</b> tương ứng
									của đề tài đó . Có thông báo xác nhận hiện ra. Chọn <b>Xóa</b> để
									xóa vĩnh viễn hoặc chọn <b>Hủy</b> để hủy thao tác xóa.
								</li>
								<li>Muốn xóa tất cả thì chọn nút <b>Xóa tất cả</b>.
								</li>
							</ol>
							<p>
								- Muốn thêm đề tài thì chọn&nbsp;<b>Quản lý đề tài -&gt; Thêm
									đề tài -&gt; </b>Điền những thông tin cần thiết , chọn thể loại sách
								và hình ảnh tương ứng-&gt; Nhấn <b>Lưu</b> để lưu lại và nhấn <b>Hủy</b>
								để trở lại danh sách.
							</p>
							<p>
								-Muốn xem loại đề tài thì chọn&nbsp;<b>Quản lý đề tài -&gt;
									Loại đề tài.</b>
							</p>
							<p>-Trong mục loại đề tài, muốn thêm loại mới thì chọn thêm
								loại đề tài, muốn chỉnh sửa chọn chỉnh sửa, muốn xóa thì chọn nút Xóa.</p>
							<p>
								<b>II. Quản lý đăng ký đề tài</b>
							</p>
							<p>
								- Muốn đăng kí đề tài thì chọn <b>Quản lý đề
									tài-&gt;Danh sách đề tài-&gt;Chọn đề tài-&gt;Đăng ký.</b>
							</p>
							<p>
								-Muốn xem danh sách đã đăng ký thì chọn <b>Quản lý mượn
									sách-&gt;Danh sách đang mượn.</b> Ở mục này bạn có thể tìm kiếm,
								quản lý xác nhận đã đã sách hay chưa. Nếu người đó đến trả thì
								bạn chọn <b>Đã trả.</b>
							</p>
<!--							<p>
								- Muốn xem danh sách đang mượn sách thì chọn<b> Quản lý mượn
									sách-&gt;Danh sách đang mượn.&nbsp;</b>
							</p>-->
                                                        <p>
								<b>III. Quản lý thông tin cá nhân</b>
							</p>
							<p>
								- Muốn đăng kí đề tài thì chọn <b>Quản lý đề
									tài-&gt;Danh sách đề tài-&gt;Chọn đề tài-&gt;Đăng ký.</b>
							</p>
<!--							<p>
								-Muốn xem danh sách đã đăng ký thì chọn <b>Quản lý mượn
									sách-&gt;Danh sách đang mượn.</b> Ở mục này bạn có thể tìm kiếm,
								quản lý xác nhận đã đã sách hay chưa. Nếu người đó đến trả thì
								bạn chọn <b>Đã trả.</b>
							</p>-->
<!--							<p>
								- Muốn xem danh sách đang mượn sách thì chọn<b> Quản lý mượn
									sách-&gt;Danh sách đang mượn.&nbsp;</b>
							</p>-->
						</div>
					</div>

				</div>
			</div>
		</div>
	</section>
	<%@ include file="footer.jsp"%>