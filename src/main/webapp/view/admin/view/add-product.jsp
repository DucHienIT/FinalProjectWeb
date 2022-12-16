<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- /. NAV SIDE  -->
<div id="page-wrapper">
	<div id="page-inner">
		<div class="row">
			<div class="col-md-12">
				<h2>Create New Product</h2>
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
										<label>Name</label> <input class="form-control"
											placeholder="Enter Product Name" name="name" />
									</div>
									<div class="form-group">
										<label>Price</label> <input class="form-control"
											placeholder="Enter Price" type="number" name="price" />
									</div>
									<div class="form-group">
										<label>Description</label> <input class="form-control"
											placeholder="Enter Product Description" name="des" />
									</div>
									<div class="form-group">
										<label>Category</label>
										<div class="checkbox">
											<select name="category">
												<c:forEach items="${categories}" var="c">
													<option value="${c.id}">${c.name}</option>
												</c:forEach>
											</select>
											
											<select name="type">
												<c:forEach items="${types}" var="t">
													<option value="${t.id}">${t.name}</option>
												</c:forEach>
											</select>
										</div>

									</div>
									<div class="form-group">
										<label>Link image</label> <input class="form-control"
											placeholder="Enter Product Image link:" name="image" />
									</div>
									<button type="submit" class="btn btn-primary">Add</button>
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

