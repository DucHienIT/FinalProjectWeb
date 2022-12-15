<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<div class="wrapper">

	<!--=== Shop Product ===-->
	<div class="shop-product">
		<!-- Breadcrumbs v5 -->
		<div class="container">
			<ul class="breadcrumb-v5">
				<li><a href="${pageContext.request.contextPath}">Trang chủ</a></li>
				<li><a href="${pageContext.request.contextPath }/product/list">Danh
						sách sản phẩm</a></li>
				<li class="active">Chi tiết sản phẩm</li>
			</ul>
		</div>
		<!-- End Breadcrumbs v5 -->

		<div class="container">
			<div class="row">
				<div class="col-md-6 md-margin-bottom-50">
					<div class="ms-showcase2-template">
						<!-- Master Slider -->
						<div class="master-slider ms-skin-default" id="masterslider">
							<div class="ms-slide">
								<c:url value="${product.image }" var="imgUrl"></c:url>
								<img class="ms-brd" src="${imgUrl}"
									data-src="${imgUrl}" alt="${product.name }" height="350" width="350">

							</div>


						</div>
						<!-- End Master Slider -->
					</div>
				</div>

				<div class="col-md-6">
					<div class="shop-product-heading">
						<h2>${product.name }</h2>
					</div>
					<!--/end shop product social-->

					<ul class="list-inline product-ratings margin-bottom-30">
						<li><i class="rating-selected fa fa-star"></i></li>
						<li><i class="rating-selected fa fa-star"></i></li>
						<li><i class="rating-selected fa fa-star"></i></li>
						<li><i class="rating fa fa-star"></i></li>
						<li><i class="rating fa fa-star"></i></li>
						<li class="product-review-list"><span>(1) <a href="#">Review</a>
								| <a href="#"> Add Review</a></span></li>
					</ul>
					<!--/end shop product ratings-->
					${product.des } <br>
					<ul class="list-inline shop-product-prices margin-bottom-30">
						<li class="shop-red">$ ${product.price }.0</li>
						<li class="line-through">${product.price * 1.25 }</li>
						<li><small class="shop-bg-red time-day-left"> Best
								Sale </small></li>
					</ul>
					<!--/end shop product prices-->

					<h3 class="shop-product-title">Quantity</h3>
					<div class="margin-bottom-40">

						<form name="f1" class="product-quantity sm-margin-bottom-20"
							method="get" action="<c:url value="/member/cart/add"></c:url>">
							<input type="text" value="${product.id }" name="pId" hidden="">
							<button type='button' class="quantity-button" name='subtract'
								onclick='javascript: subtractQty();' value='-'>-</button>
							<input type='text' class="quantity-field" name='quantity'
								value="1" id='qty' />
							<button type='button' class="quantity-button" name='add'
								onclick='javascript: document.getElementById("qty").value++;'
								value='+'>+</button>
							<button type="submit" class="btn-u btn-u-sea-shop btn-u-lg">Add
								to Cart</button>
						</form>


					</div>
					<!--/end product quantity-->

					<p class="wishlist-category">
						<strong>Categories:</strong> <a href="#">${product.category.name},</a>
					</p>
				</div>
			</div>
			<!--/end row-->
		</div>
	</div>
	<!--=== End Shop Product ===-->

	<!--=== Content Medium ===-->
	<div class="content-md container">
		<!--=== Product Service ===-->
		<div class="row margin-bottom-60">
			<div class="col-md-4 product-service md-margin-bottom-30">
				<div class="product-service-heading">
					<i class="fa fa-truck"></i>
				</div>
				<div class="product-service-in">
					<h3>Free Delivery</h3>
					<p>Integer mattis lacinia felis vel molestie. Ut eu euismod
						erat, tincidunt pulvinar semper veliUt porta, leo...</p>
					<a href="#">+Read More</a>
				</div>
			</div>
			<div class="col-md-4 product-service md-margin-bottom-30">
				<div class="product-service-heading">
					<i class="icon-earphones-alt"></i>
				</div>
				<div class="product-service-in">
					<h3>Customer Service</h3>
					<p>Integer mattis lacinia felis vel molestie. Ut eu euismod
						erat, tincidunt pulvinar semper veliUt porta, leo...</p>
					<a href="#">+Read More</a>
				</div>
			</div>
			<div class="col-md-4 product-service">
				<div class="product-service-heading">
					<i class="icon-refresh"></i>
				</div>
				<div class="product-service-in">
					<h3>Free Returns</h3>
					<p>Integer mattis lacinia felis vel molestie. Ut eu euismod
						erat, tincidunt pulvinar semper veliUt porta, leo...</p>
					<a href="#">+Read More</a>
				</div>
			</div>
		</div>
		<!--/end row-->
		<!--=== End Product Service ===-->

		<div class="tab-v5">
			<ul class="nav nav-tabs" role="tablist">
				<li class="active"><a href="#description" role="tab"
					data-toggle="tab">Description</a></li>
				<li><a href="#reviews" role="tab" data-toggle="tab">Reviews
						(1)</a></li>
			</ul>


		</div>
	</div>
	<!--/end container-->
	<!--=== End Content Medium ===-->
</div>
