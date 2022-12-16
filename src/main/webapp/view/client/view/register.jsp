<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="wrapper">


	<!--=== Breadcrumbs v4 ===-->
	<div class="breadcrumbs-v4">
		<div class="container">
			<h1>
				SD<span class="shop-green">COMPUTER</span>
			</h1>
			<ul class="breadcrumb-v4-in">
				<li><a href="${pageContext.request.contextPath }/welcome">Trang
						chủ</a></li>
				<li class="active">Đăng ký tài khoản</li>
			</ul>
		</div>
		<!--/end container-->
	</div>
	<!--=== End Breadcrumbs v4 ===-->

	<!--=== Registre ===-->
	<div class="log-reg-v3 content-md margin-bottom-30">
		<div class="container">
			<div class="row">
				<div class="col-md-7 md-margin-bottom-50">
					<h2 class="welcome-title">Chào mừng đến với SDCOMPUTER</h2>
					<div class="row margin-bottom-50">
						<div class="col-sm-4 md-margin-bottom-20">
							<div class="site-statistics">
								<span>20,039</span> <small>Sản phẩm</small>
							</div>
						</div>
						<div class="col-sm-4 md-margin-bottom-20">
							<div class="site-statistics">
								<span>54,283</span> <small>Đánh giá</small>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="site-statistics">
								<span>376k</span> <small>Đơn hàng</small>
							</div>
						</div>
					</div>
					<div class="members-number">
						<h3>
							Tổng số <span class="shop-green">13,000</span> khách hàng hàng
							tháng
						</h3>
						<img class="img-responsive" src="${url}/img/map.png" alt="">
					</div>
				</div>

				<div class="col-md-5">
					<form id="sky-form4" class="log-reg-block sky-form"
						action="register" method="post">
						<h2>Đăng ký thành viên</h2>

						<div class="login-input reg-input">
							<section>
								<label class="input"> <input type="text" name="username"
									placeholder="Username" class="form-control">
								</label>
							</section>
							<section>
								<label class="input"> <input type="tel" name="email"
									placeholder="Number phone" class="form-control">
								</label>
							</section>
							<section>
								<label class="input"> <input type="password"
									name="password" placeholder="Password" id="password"
									class="form-control">
								</label>
							</section>
							<section>
								<label class="input"> <input type="password"
									name="passwordConfirm" placeholder="Confirm password"
									class="form-control">
								</label>
							</section>
						</div>

						</label> <label class="checkbox margin-bottom-20"> <input
							type="checkbox" name="checkbox" /> <i></i> Tôi đồng ý với <a
							href="#">điều khoản &amp; và yêu cầu</a>
						</label>
						<button class="btn-u btn-u-sea-shop btn-block margin-bottom-20"
							type="submit">Đăng ký</button>
					</form>

					<div class="margin-bottom-20"></div>
					<p class="text-center">
						Bạn đã có tài khoản? <a
							href="${pageContext.request.contextPath}/login">Đăng nhập
							ngay</a>
					</p>
				</div>
			</div>
			<!--/end row-->
		</div>
		<!--/end container-->
	</div>
	<!--=== End Registre ===-->


</div>
