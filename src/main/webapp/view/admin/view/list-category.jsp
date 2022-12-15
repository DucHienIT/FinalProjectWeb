<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- /. NAV SIDE  -->
<div id="page-wrapper">
	<div id="page-inner">
		<div class="row">
			<div class="col-md-12">
				<h2>All Categories</h2>
				<h5>You can management category in here</h5>

			</div>
		</div>
		<!-- /. ROW  -->
		<hr />

		<div class="row">
			<div>
				<button class="btn-primary"
					style="width: 260px; border: none; border-radius: 3px; height: 30px; margin-bottom: 20px;"
					onclick="window.location.href='<c:url value='/admin/category/add'/>';">New
					Category</button>
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
										<th>Name</th>
										<th>Action</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${catList}" var="cat">
										<tr class="odd gradeX">
											<td>${cat.id }</td>
											<td>${cat.name }</td>
											<td><a
												href="<c:url value='/category/detail?id=${cat.id }'/>"
												class="center">Detail</a> | <a
												href="<c:url value='/admin/category/edit?id=${cat.id }'/>"
												class="center">Edit</a> | <a
												href="<c:url value='/admin/category/delete?id=${cat.id }'/>"
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