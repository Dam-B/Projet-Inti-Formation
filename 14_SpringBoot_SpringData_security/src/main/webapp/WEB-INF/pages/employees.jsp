<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head><%@ page isELIgnored="false"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CRUD EMPLOYEEs</title>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/style.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">

<style type="text/css">
.col-md-offset-1 {
	margin-left: 0%;
}
</style>
</head>
<body>
<form id="logoutForm" class="form-inline" action="/logout"
			 method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
 </form>
	<div
		style="text-align: right; padding: 10px; margin: 0px 0px 0px; background: black;">
		<a href="${pageContext.request.contextPath}/login?lang=en">En</a>
		&nbsp;&nbsp; <a
			href="${pageContext.request.contextPath}/login?lang=fr">Fr</a>
		&nbsp;&nbsp; <a
			href="${pageContext.request.contextPath}/login?lang=gr">Gr</a>		 
		<a style="padding:10px;"onclick="document.forms['logoutForm'].submit()">Logout</a>		
	</div>
	<div class="container">
		<jsp:useBean id="pagedListHolder" scope="request"
			type="org.springframework.beans.support.PagedListHolder" />
		<c:url value="/employee/list" var="pagedLink">
			<c:param name="p" value="~" />
		</c:url>
		<div class="sidenav">
			<div class="login-main-text">
				<h2 class="text-center">Base de données de la structure Blablabla</h2>
				<p style="text-align: center; padding: 20px;">Table des employées de la structure Blablabla</p>
			</div>
		</div>
		<div class="main">
			<div class="col-md-offset-1 col-md-16">


				<input type="button" value="Add Employee"
					onclick="window.location.href='showForm'; return false;"
					class="btn btn-primary" /> <br /> <br />
				<div class="panel panel-info">

					<div class="panel-body">
						<table class="table table-striped table-bordered">
							<tr>
								<th>ID</th>
								<th>First Name</th>
								<th>Last Name</th>
								<th>Email</th>
								<th>Salaire</th>
								<th>Manager ID</th>
								<th>Start Date</th>
								<th>Action</th>
							</tr>

							<!-- loop over and print our customers -->
							<c:forEach var="e" items="${pagedListHolder.pageList}">

								<!-- construct an "update" link with employee id -->
								<c:url var="updateLink" value="/employee/updateForm">
									<c:param name="empId" value="${e.empId}" />
								</c:url>

								<!-- construct an "delete" link with employee id -->
								<c:url var="deleteLink" value="/employee/delete">
									<c:param name="empId" value="${e.empId}" />
								</c:url>

								<tr>
									<td>${e.empId}</td>
									<td>${e.firstName}</td>
									<td>${e.lastName}</td>
									<td>${e.email}</td>
									<td>${e.salaire}</td>
									<td>${e.manager.empId}</td>
									<td><fmt:formatDate value="${e.startDate}" type="date"
											pattern="yyyy-MM-dd" /></td>
									<td>
										<!-- display the update link --> <a href="${updateLink}">
											<i class="fas fa-user-edit"></i>
									</a> | <a href="${deleteLink}"
										onclick="if (!(confirm('Are you sure you want to delete this employee?'))) return false">
											<i class="fas fa-user-times"></i>
									</a>
									</td>

								</tr>

							</c:forEach>

						</table>

					</div>
				</div>
				<tg:paging pagedListHolder="${pagedListHolder}"
					pagedLink="${pagedLink}" />
			</div>


		</div>

	</div>
</body>
</html>