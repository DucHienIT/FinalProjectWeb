<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

	<div class="wrapper">
		
		<!--=== Breadcrumbs v4 ===-->
		<div class="breadcrumbs-v4">
			<div class="container">
				<h1>
					SD<span class="shop-green">COMPUTER</span>
				</h1>
				<ul class="breadcrumb-v4-in">
					<li><a href="${pageContext.request.contextPath }">Trang chủ</a></li>
					<li><a href="${pageContext.request.contextPath }/product/list">Danh sách sản phẩm</a></li>
					<li class="active"><a href="${pageContext.request.contextPath }/product/category?cate_id=${category_id}">Tìm kiếm trong ${category_name}</li>
				</ul>
			</div>
			<!--/end container-->
		</div>
		<!--=== End Breadcrumbs v4 ===-->

		<!--=== Content Part ===-->
		<div class="content container">
			<div class="row">
				<jsp:include page="/view/client/view/seach.jsp"></jsp:include>

				<div class="col-md-9">
					<div class="row margin-bottom-5">
						<div class="col-sm-4 result-category">

						</div>
						<div class="col-sm-8">
							<ul class="list-inline clear-both">
								<li class="grid-list-icons"><a
									href="shop-ui-filter-list.html"><i class="fa fa-th-list"></i></a>
									<a href="shop-ui-filter-grid.html"><i class="fa fa-th"></i></a>
								</li>
								<li class="sort-list-btn">
									<h3>Sort By :</h3>
									<div class="btn-group">
										<button type="button" class="btn btn-default dropdown-toggle"
											data-toggle="dropdown">
											Popularity <span class="caret"></span>
										</button>
										<ul class="dropdown-menu" role="menu">
											<li><a href="#">All</a></li>
											<li><a href="#">Best Sales</a></li>
											<li><a href="#">Top Last Week Sales</a></li>
											<li><a href="#">New Arrived</a></li>
										</ul>
									</div>
								</li>
								<li class="sort-list-btn">
									<h3>Show :</h3>
									<div class="btn-group">
										<button type="button" class="btn btn-default dropdown-toggle"
											data-toggle="dropdown">
											20 <span class="caret"></span>
										</button>
										<ul class="dropdown-menu" role="menu">
											<li><a href="#">All</a></li>
											<li><a href="#">10</a></li>
											<li><a href="#">5</a></li>
											<li><a href="#">3</a></li>
										</ul>
									</div>
								</li>
							</ul>
						</div>
					</div>
					
					<!--/end result category-->
					<c:forEach items="${productSeachByCategory }" var="p" >
					<div class="filter-results">
						<div
							class="list-product-description product-description-brd">
							<div class="row">
							
								<div class="col-sm-4">
								<c:url value="/Images/${p.image }" var="imgUrl"></c:url>
									<a href="${pageContext.request.contextPath }/product/detail?id=${p.id}"><img
										class="img-responsive sm-margin-bottom-20"
										src="${imgUrl}" alt=""></a>
								</div>
								<div class="col-sm-8 product-description">
									<div class="overflow-h margin-bottom-5">
										<ul class="list-inline overflow-h">
											<li><h4 class="title-price">
													<a style="font-weight: bold;" href=""${pageContext.request.contextPath }/product/detail?id=${p.id}"">${p.name }</a>
													
												</h4></li>
											<li><span class="gender text-uppercase">${p.category.name }</span></li>
											<li class="pull-right">
												<ul class="list-inline product-ratings">
													<li><i class="rating-selected fa fa-star"></i></li>
													<li><i class="rating-selected fa fa-star"></i></li>
													<li><i class="rating-selected fa fa-star"></i></li>
													<li><i class="rating fa fa-star"></i></li>
													<li><i class="rating fa fa-star"></i></li>
												</ul>
											</li>
										</ul>
										<div class="margin-bottom-10">
											<span style="color: coral;" class="title-price margin-right-10">${p.price } đ</span>
										</div>
										<p class="margin-bottom-20">${p.des }</p>
										<a href="${pageContext.request.contextPath }/product/detail?id=${p.id}" ><button type="button" class="btn-u btn-u-sea-shop">Thêm vào giỏ hàng</button></a>
									</div>
								</div>								
							</div>
						</div>
					</div>
					</c:forEach>
					<!--/end filter resilts-->

					<div class="text-center">
						<ul class="pagination pagination-v2">
							<li><a href="#"><i class="fa fa-angle-left"></i></a></li>
							<li><a href="#">1</a></li>
							<li class="active"><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#"><i class="fa fa-angle-right"></i></a></li>
						</ul>
					</div>
					<!--/end pagination-->
				</div>
			</div>
			<!--/end row-->
		</div>
		<!--/end container-->
		<!--=== End Content Part ===-->
	</div>
