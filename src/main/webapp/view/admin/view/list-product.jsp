<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!-- /. NAV SIDE  -->
<div id="page-wrapper">
	<div id="page-inner">
		<div class="row">
			<div class="col-md-12">
				<h2>All Products</h2>
				<h5>You can management product in here</h5>

			</div>
		</div>
		<!-- /. ROW  -->
		<hr />

		<div class="row">

			<div>
				<button class="btn-primary"
					style="width: 260px; border: none; border-radius: 3px; height: 30px; margin-bottom: 20px;"
					onclick="window.location.href='<c:url value='/admin/product/add'/>';">New
					Product</button>
			</div>

			<div class="col-md-12">
				<!-- Advanced Tables -->
				<div class="panel panel-default">
					<div class="panel-heading">Data Tables</div>
					<div class="panel-body">
						<div class="table-responsive">
							<table class="table table-striped table-bordered table-hover"
								id="dataTables-example">
								<thead>
									<tr>
										<th>ID</th>
										<th>Image</th>
										<th>Name</th>
										<th>Price</th>
										<th>Category</th>
										<th>Description</th>
										<th>Action</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${proList}" var="pro">
										<tr class="odd gradeX">
											<td>${pro.id }</td>
											<c:url value="${pro.image}" var="imgUrl"></c:url>
											<td><img height="150" width="150" src="${imgUrl}" /></td>

											<td>${pro.name }</td>
											<td>${pro.price }</td>
											<td>${pro.category.name }</td>
											<td>${pro.des }</td>
											<td><a
												href="<c:url value='/product/detail?id=${pro.id }'/>"
												class="center">Detail</a> | <a
												href="<c:url value='/admin/product/edit?id=${pro.id }'/>"
												class="center">Edit</a> | <a
												href="<c:url value='/admin/product/delete?id=${pro.id }'/>"
												class="center">Delete</a></td>

										</tr>
									</c:forEach>


								</tbody>
							</table>
						</div>

					</div>
				</div>
				<!--End Advanced Tables -->
			</div>
		</div>

	</div>

</div>
<!-- /. PAGE INNER  -->
