<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<div class="wrapper">

	<!--=== Breadcrumbs v4 ===-->
	<div class="breadcrumbs-v4">
		<div class="container">
			<span class="page-name">Check Out</span>
			<h1>
				Maecenas <span class="shop-green">enim</span> sapien
			</h1>
			<ul class="breadcrumb-v4-in">
				<li><a href="index.html">Home</a></li>
				<li><a href="">Product</a></li>
				<li class="active">Shopping Cart</li>
			</ul>
		</div>
		<!--/end container-->
	</div>
	<!--=== End Breadcrumbs v4 ===-->

	<!--=== Content Medium Part ===-->
	<div class="content-md margin-bottom-30">
		<div class="container">
			<form class="shopping-cart" action="#">
				<div>
					<div class="header-tags">
						<div class="overflow-h">
							<h2>Shopping Cart</h2>
							<p>Review &amp; edit your product</p>
							<i class="rounded-x fa fa-check"></i>
						</div>
					</div>
					<section>
						<div class="table-responsive">
							<table class="table table-striped">
								<thead>
									<tr>
										<th>Product</th>
										<th>Price</th>
										<th>Qty</th>
										<th>Total</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${sessionScope.cart}" var="map">

										<tr>
											<c:url value="${map.value.product.image}" var="imgUrl"></c:url>
											<td class="product-in-table"><img class="img-responsive"
												src="${imgUrl}" alt="">
												<div class="product-it-in">
													<h3>${map.value.product.name }</h3>
													<span>${map.value.product.des }</span>
												</div></td>
											<td>$ ${map.value.product.price }</td>
											<td>${map.value.quantity }</td>
											<td class="shop-red">$ ${map.value.product.price * map.value.quantity }</td>
											<td><a
												href="${pageContext.request.contextPath}/member/cart/remove?pId=${map.value.product.id}"><button
														type="button" class="close">
														<span>&times;</span><span class="sr-only">Close</span>
													</button></a></td>
										</tr>
									</c:forEach>

								</tbody>
							</table>
						</div>
					</section>


					<div class="coupon-code">
						<div class="row">
							<div class="col-sm-4 sm-margin-bottom-30">
								<h3>Discount Code</h3>
								<p>Enter your coupon code</p>
								<input class="form-control margin-bottom-10" name="code"
									type="text">
								<button type="button" class="btn-u btn-u-sea-shop">Apply
									Coupon</button>
							</div>
							<div class="col-sm-3 col-sm-offset-5">
								<ul class="list-inline total-result">
									<li>
										<h4>Subtotal:</h4> <c:set var="total" value="${0}" /> <c:forEach
											items="${sessionScope.cart}" var="map">
											<c:set var="total"
												value="${total + map.value.quantity * map.value.product.price}" />
										</c:forEach>
										<div class="total-result-in">
											<span>$ ${total }</span>

										</div>
									</li>
									<li>
										<h4>Shipping:</h4>
										<div class="total-result-in">
											<span class="text-right">- - - -</span>
										</div>
									</li>
									<li class="divider"></li>
									<li class="total-price">
										<h4>Total:</h4>
										<div class="total-result-in">
											<span>$ ${total }</span>

										</div>
									</li>
									<li><br></li>
									
									<li>
										<a href="${pageContext.request.contextPath}/member/order" class="btn-u btn-u-sea-shop btn-block">Checkout</a>
									</li>
									
									
							</div>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
		<!--/end container-->
	</div>
	<!--=== End Content Medium Part ===-->

	<!--=== Shop Suvbscribe ===-->
	<div class="shop-subscribe">
		<div class="container">
			<div class="row">
				<div class="col-md-8 md-margin-bottom-20">
					<h2>
						subscribe to our weekly <strong>newsletter</strong>
					</h2>
				</div>
				<div class="col-md-4">
					<div class="input-group">
						<input type="text" class="form-control"
							placeholder="Email your email..."> <span
							class="input-group-btn">
							<button class="btn" type="button">
								<i class="fa fa-envelope-o"></i>
							</button>
						</span>
					</div>
				</div>
			</div>
		</div>
		<!--/end container-->
	</div>
	<!--=== End Shop Suvbscribe ===-->
</div>
