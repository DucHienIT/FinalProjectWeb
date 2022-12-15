<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

 
	<div id="page-wrapper">
		<div id="page-inner">
			<div class="row">
				<div class="col-md-12">
					<h2>Edit User</h2>
					<h5>You can edit info user in here</h5>
				</div>
			</div>
			<!-- /. ROW  -->
			<hr />
			<div class="row">
				<div class="col-md-12">
					<!-- Form Elements -->
					<div class="panel panel-default">
						<div class="panel-body">
							<div class="row">
								<div class="" style="padding: 28px;">
									<c:url value="/admin/user/edit" var="edit"></c:url>
									<form role="form" action="${edit }" method="post"
										enctype="multipart/form-data">
										<input name="id" value="${user.id }" type="text" hidden="">
										<div class="form-group">
											<label>User Name</label> <input class="form-control"
												value="${user.username }" name="username" />
										</div>
										<div class="form-group">
											<label>Password</label> <input class="form-control"
												value="${user.password }" type="password" name="password" />
										</div>
										<div class="form-group">
											<label>Email:</label> <input class="form-control"
												value="${user.email }" name="email" />
										</div>
										<div class="form-group">
											<label>Role</label>
											<div class="checkbox">
												<label> <input type="radio" value="1" name="role" />Admin
												</label> <br> <label> <input type="radio" value="2"
													name="role" checked="checked" />Client
												</label>
											</div>

										</div>

										<button type="submit" class="btn btn-primary">Edit</button>
										<button type="reset" class="btn btn-warning">Reset</button>
									</form>



								</div>
							</div>
						</div>
					</div>
					<!-- End Form Elements -->
				</div>
			</div>
			<!-- /. ROW  -->
			<div class="row">
				<div class="col-md-12"></div>
			</div>
			<!-- /. ROW  -->
		</div>
		<!-- /. PAGE INNER  -->
	</div>
 