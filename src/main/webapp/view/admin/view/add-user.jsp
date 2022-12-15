<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div id="page-wrapper">
	<div id="page-inner">
		<div class="row">
			<div class="col-md-12">
				<h2>Create New User</h2>
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

								<form role="form" action="add" method="post"
									enctype="multipart/form-data">
									<div class="form-group">
										<label>Username</label> <input class="form-control"
											placeholder="Enter username" name="username" />
									</div>
									<div class="form-group">
										<label>Password</label> <input class="form-control"
											placeholder="Enter password" type="password" name="password" />
									</div>
									<div class="form-group">
										<label>Email</label> <input class="form-control"
											placeholder="Enter email" name="email" />
									</div>
									<div class="form-group">
										<label>User-Type</label>
										<div class="checkbox" style="">
											<label><input type="radio" value="1" name="role" />Admin
												User</label> <label><input type="radio" value="2"
												name="role" />Client User</label>
										</div>

									</div>

									<button type="submit" class="btn btn-primary">Create</button>
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
