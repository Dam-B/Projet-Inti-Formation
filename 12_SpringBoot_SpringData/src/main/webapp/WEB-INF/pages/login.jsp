<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false"%> 
<!DOCTYPE html> 
<html>
<head>
 
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"	href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"	href="${pageContext.request.contextPath}/css/style.css">
 
<title>DEMAINNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN</title>

</head>
<body>
 
    <div style="text-align: right;padding:5px;margin:5px 0px;background:#ccc;">
       <a href="${pageContext.request.contextPath}/employee/login?lang=en">En</a>
       &nbsp;&nbsp;
       <a href="${pageContext.request.contextPath}/employee/login?lang=fr">Fr</a>
       &nbsp;&nbsp;
       <a href="${pageContext.request.contextPath}/employee/login?lang=gr">Gr</a>
    </div>
	<div class="container">
    <div class="sidenav">
         <div class="login-main-text">
            <h2>Application<br> Register Page</h2>
            <p>Login or register from here to access.</p>
         </div>
      </div>
      <div class="main">
         <div class="col-md-6 col-sm-12">
            <div class="login-form">
               <form method="post" action="/employee/Register">
                  <div class="form-group">
                     <label>UserName</label>
                     <input type="text" class="form-control" placeholder="User Name">
                  </div>
                  <div class="form-group">
                     <label>Password</label>
                     <input type="password" class="form-control" placeholder="Password">
                  </div>
                  <button type="submit" class="btn btn-secondary">Register</button>
               </form>
            </div>
         </div>
      </div>
      </div>
</body>
</html>