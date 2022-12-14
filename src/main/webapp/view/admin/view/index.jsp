<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:url value="/view/admin/static" var="url"></c:url>

<div id="page-wrapper">
	<div id="page-inner">
		<div class="row">
			<div class="col-md-12">
				<h2>Admin Dashboard</h2>
				<h5>Welcome : ${username}</h5>
			</div>
		</div>
		<div class="row" style="text_align: left">
			<div style="">
				<h3>Total User: ${ total_user }</h3>
			</div>
			<div style="">
				<h3>Total Product: ${ total_pro }</h3>
			</div>
			<div style="">
				<h3>Total Category: ${ total_cat }</h3>
			</div>
			<div style="">
				<h3>Total Cart: ${ total_cart }</h3>
			</div>

		</div>

	</div>

</div>

