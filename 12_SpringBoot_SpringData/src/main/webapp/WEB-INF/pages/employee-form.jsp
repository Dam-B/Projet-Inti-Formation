<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/styles/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/styles/style.css">

<title><spring:message code="label.title" /></title>

</head>
<body>
<div
		style="text-align: right; padding: 5px; margin: 0px 0px 10px; background: #ccc;">
		<a href="${pageContext.request.contextPath}/login?lang=en">En</a>
		&nbsp;&nbsp; <a
			href="${pageContext.request.contextPath}/login?lang=fr">Fr</a>
		&nbsp;&nbsp; <a
			href="${pageContext.request.contextPath}/login?lang=gr">Gr</a>
	</div>
	<div class="container">
		<div class="sidenav">
			<div class="login-main-text">
				<h2 class="text-center">CRUD EMPLOYEE</h2>
				<p>Login or register from here to access.</p>
			</div>
		</div>
		<div class="main">
		<div class="col-md-offset-2 col-md-7">
			
			<div class="panel panel-info">
				<div class="panel-body">
					<form:form action="saveEmployee" cssClass="form-horizontal"
						method="post" modelAttribute="employee">

						<!-- need to associate this data with employee id -->
						<form:hidden path="empId" />

						<div class="form-group">
							<label for="firstname" class="col-md-6 control-label">First	Name</label>
							<div class="col-md-9">
								<form:input path="firstName" cssClass="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-md-6 control-label">Last Name</label>
							<div class="col-md-9">
								<form:input path="lastName" cssClass="form-control" />
							</div>
						</div>

						<div class="form-group">
							<label for="email" class="col-md-6 control-label">Email</label>
							<div class="col-md-9">
								<form:input path="email" cssClass="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label for="salaire" class="col-md-6 control-label">Salaire</label>
							<div class="col-md-9">
								<form:input path="salaire" cssClass="form-control" />
							</div>
						</div>
						
						<div class="form-group">
							<label for="title" class="col-md-6 control-label">Title</label>
							<div class="col-md-9">
								<form:input path="title" cssClass="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label for="startDate" class="col-md-6 control-label">Start Date</label>
							<div class="col-md-9">
								<form:input path="startDate" cssClass="form-control" />
							</div>
						</div>
						<spring:bind path="manager">
						<div class="form-group">
							<label for="startDate" class="col-md-6 control-label">Manager</label>
							<div class="col-md-9">
								<form:select path="manager" items="${employees}" itemValue="empId" itemLabel="firstName" cssClass="form-control" />
							</div>
						</div>
						</spring:bind>
						<div class="form-group">
						
							<!-- Button -->
							<div class="col-md-offset-3 col-md-9">
								<form:button cssClass="btn btn-primary">Submit</form:button>
							</div>
						</div>

					</form:form>
				</div>
			</div>
		</div>
		</div>
	</div>
</body>
</html>