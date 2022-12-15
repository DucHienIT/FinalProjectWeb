<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<!-- /. NAV SIDE  -->
<div id="page-wrapper">
	<div id="page-inner">
		<div class="row">
			<div class="col-md-12">
				<h2>Edit Category</h2>
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
								<c:url value="/admin/category/edit" var="edit"></c:url>
								<form role="form" action="${list}" method="post"
									enctype="multipart/form-data">
									<input name="id" value="${category.id }" hidden="">
									<div class="form-group">
										<label>Name</label> <input class="form-control"
											value="${category.name }" name="name" />
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
<!-- /. PAGE WRAPPER  -->

