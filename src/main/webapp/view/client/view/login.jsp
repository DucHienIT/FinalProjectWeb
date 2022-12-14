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
				<li class="active">Đăng nhập</li>
			</ul>
		</div>
		<!--/end container-->
	</div>
	<!--=== End Breadcrumbs v4 ===-->

	<!--=== Login ===-->
	<div class="log-reg-v3 content-md">
		<div class="container">
			<div class="row">
				<div class="col-md-7 md-margin-bottom-50">
					<h2 class="welcome-title">Chào mừng đến với SDCOMPUTER</h2>
					<p>Cửa hàng linh kiện thiết bị máy tính cao cấp Hà Nội.</p>
				</div>

				<div class="col-md-5">
					<form id="sky-form1" class="log-reg-block sky-form" action="login"
						method="post">
						<h2>Đăng nhập</h2>
						<h3>${alertMsg }</h3>


						<section>
							<label class="input login-input">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user"></i></span>
									<input type="text" placeholder="Username" name="username"
										class="form-control">
								</div>
							</label>
						</section>
						<section>
							<label class="input login-input no-border-top">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-lock"></i></span>
									<input type="password" placeholder="Password" name="password"
										class="form-control">
								</div>
							</label>
						</section>
						<div class="row margin-bottom-5"></div>
						<button class="btn-u btn-u-sea-shop btn-block margin-bottom-20"
							type="submit">Đăng nhập</button>

						<div class="border-wings">
							<span>or</span>
						</div>

						<div class="row columns-space-removes">
							<div class="col-lg-6 margin-bottom-10">
								<button type="button" class="btn-u btn-u-md btn-u-fb btn-block">
									<i class="fa fa-facebook"></i> Facebook Log In
								</button>
							</div>
							<div class="col-lg-6">
								<button type="button" class="btn-u btn-u-md btn-u-tw btn-block">
									<i class="fa fa-twitter"></i> Twitter Log In
								</button>
							</div>
						</div>
					</form>

					<div class="margin-bottom-20"></div>
					<p class="text-center">
						Bạn chưa có tài khoản? <a
							href="${pageContext.request.contextPath }/register">Đăng ký
							ngay</a>
					</p>
				</div>
			</div>
			<!--/end row-->
		</div>
		<!--/end container-->
	</div>
	<!--=== End Login ===-->
</div>
