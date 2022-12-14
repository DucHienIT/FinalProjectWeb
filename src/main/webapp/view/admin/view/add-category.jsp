<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<div id="page-wrapper">
	<div id="page-inner">
		<div class="row">
			<div class="col-md-12">
				<h2>Create New Category</h2>
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
										<label>Category Name:</label><input name="cate_name"
											class="form-control" placeholder="Enter category name" />
									</div>
									<button type="submit" class="btn btn-primary">Create</button>
									<button type="reset" class="btn btn-warning"
										onclick="console.log(document.getElementById('aaaaa').value);">Reset</button>
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

