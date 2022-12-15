<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- /. NAV SIDE  -->
<div id="page-wrapper">
	<div id="page-inner">
		<div class="row">
			<div class="col-md-12">
				<h2>All Users</h2>
				<h5>You can management user in here</h5>

			</div>
		</div>
		<!-- /. ROW  -->
		<hr />

		<div class="row">
			<div>
				<button class="btn-primary"
					style="width: 260px; border: none; border-radius: 3px; height: 30px; margin-bottom: 20px;"
					onclick="window.location.href='<c:url value='/admin/user/add'/>';">New
					User</button>
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
										<th>Username</th>
										<th>Password</th>
										<th>Email</th>
										<th>Action</th>
										<th>User-Type</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${ userList }" var="user">
										<tr class="odd gradeX">
											<td>${user.id }</td>
											<td>${user.username }</td>
											<td>${user.password }</td>

											<td class="center"><c:choose>
													<c:when test="${user.roleId == 1 }">Admin
													</c:when>
													<c:otherwise>Client
													</c:otherwise>
												</c:choose></td>

											<td>${user.email }</td>

											<td><a
												href="<c:url value='/admin/user/edit?id=${user.id }'/>"
												class="center">Edit</a> | <a
												href="<c:url value='/admin/user/delete?id=${user.id }'/>"
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
