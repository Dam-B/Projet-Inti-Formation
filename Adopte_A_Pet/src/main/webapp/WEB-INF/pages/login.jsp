
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/style.css">

<title><spring:message code="label.title" /></title>

</head>
<body>
	<div class="container">
		<div class="sidenav">
			<div class="login-main-text">
				<h2>
					Application<br> Register Page
				</h2>
				<p>Login or register from here to access.</p>
			</div>
		</div>
		<div class="main">
			<div class="col-md-6 col-sm-8">
				<div class="login-form">
					<form method="POST" action="${contextPath}/login"
						class="form-signin">
						<h2 class="form-heading">Log in</h2>

						<div class="form-group ${error != null ? 'has-error' : ''}">
							<span>${message}</span> 
							<input name="username" type="text" class="form-control" placeholder="Username" autofocus="true" />
						</div>
						<div class="form-group">
							<input name="password" type="password" class="form-control"	placeholder="Password" />
							<span>${error}</span> 
							<input type="hidden" name="${_csrf.parameterName}"	value="${_csrf.token}" />
						</div>
							<button class="btn btn-lg btn-primary btn-block" type="submit">LogIn</button>
							<h4 class="text-center">
								<a href="${contextPath}/registration">Create an account</a>
							</h4>
						
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>