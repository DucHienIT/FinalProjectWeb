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
				<li class="active">Thông tin tài khoản</li>
			</ul>
		</div>
		<!--/end container-->
	</div>
	<!--=== End Breadcrumbs v4 ===-->

	<div class="tab-content">
		<div class="tab-pane active" id="home">
			<hr>

			<div class="form-group" style="">
				<div class="col-xs-6">
					<label for="first_name"><h4>Tên đăng nhập</h4></label> <input
						type="text" class="form-control" name="username" id="first_name"
						value="${sessionScope.account.username }"
						title="enter your first name if any.">
				</div>
			</div>

			<div class="form-group">

				<div class="col-xs-6">
					<label for="first_name"><h4>Email</h4></label> <input type="text"
						class="form-control" name="email" id="first_name"
						value="${sessionScope.account.email }"
						title="enter your first name if any.">
				</div>
			</div>
			<div class="form-group">

				<div class="col-xs-6">
					<label for="phone"><h4>Password</h4></label> <input type="password"
						class="form-control" name="password" id="phone"
						value="${sessionScope.account.password }"
						title="enter your phone number if any.">
				</div>
			</div>

			<div class="form-group">
				<div class="col-xs-12">
					<br>
					<button class="btn btn-primary" type="submit" style="">Lưu</button>
				</div>
			</div>
			</form>
			<hr>
		</div>

	</div>
	<!--/tab-pane-->
</div>
<!--/tab-content-->
</div>
