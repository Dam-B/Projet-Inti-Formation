<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>

<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/style.css">


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

							<spring:bind path="firstName">
								<div class="form-group ${status.error ? 'has-error' : ''}">
									<form:input type="text" path="firstName" class="form-control"
										placeholder="firstName" autofocus="true"></form:input>
									<form:errors path="firstName"></form:errors>
								</div>
							</spring:bind>
							
							<spring:bind path="lastName">
								<div class="form-group ${status.error ? 'has-error' : ''}">
									<form:input type="text" path="lastName" class="form-control"
										placeholder="lastName" autofocus="true"></form:input>
									<form:errors path="lastName"></form:errors>
								</div>
							</spring:bind>

							<spring:bind path="email">
								<div class="form-group ${status.error ? 'has-error' : ''}">
									<form:input type="text" path="email" class="form-control"
										placeholder="email" autofocus="true"></form:input>
									<form:errors path="email"></form:errors>
								</div>
							</spring:bind>
							
							<spring:bind path="salaire">
								<div class="form-group ${status.error ? 'has-error' : ''}">
									<form:input type="number" path="salaire" class="form-control"
										placeholder="salaire" autofocus="true"></form:input>
									<form:errors path="salaire"></form:errors>
								</div>
							</spring:bind>

							<spring:bind path="title">
								<div class="form-group ${status.error ? 'has-error' : ''}">
								<label for="manager" class="col-md-6 control-label">Title</label>
									<form:input type="text" path="title" class="form-control"
										placeholder="title" autofocus="true"></form:input>
									<form:errors path="title"></form:errors>
								</div>
							</spring:bind>
							
							<spring:bind path="startDate">
								<div class="form-group ${status.error ? 'has-error' : ''}">
									<label for="startDate" class="col-md-6 control-label">Start Date</label>
									<form:input type="Date" path="startDate" class="datepick"></form:input>
									<form:errors path="startDate"></form:errors>
								</div>
							</spring:bind>
							
							<spring:bind path="manager">
								<div class="form-group ${status.error ? 'has-error' : ''}">
									<label for="manager" class="col-md-6 control-label">Manager</label>
									<div class="col-md-9">
										<form:select path="manager" cssClass="form-control" >
										<form:option value="" label="--- Select a manager ---"/>
										<form:options items="${employees}" itemValue="empId" itemLabel="firstName" />
										<form:errors path="manager"></form:errors>
										</form:select>
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
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
	<script type="text/javascript">
    $(document).ready(function() {
        $('.datepick').datepicker({ dateFormat: "yyyy-mm-dd"});
    });
</script>
</body>
</html>