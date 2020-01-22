<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<title>Adopt A Pet</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="" name="keywords">
<meta content="" name="description">

<!-- Facebook Opengraph integration: https://developers.facebook.com/docs/sharing/opengraph -->
<meta property="og:title" content="">
<meta property="og:image" content="">
<meta property="og:url" content="">
<meta property="og:site_name" content="">
<meta property="og:description" content="">

<!-- Twitter Cards integration: https://dev.twitter.com/cards/  -->
<meta name="twitter:card" content="summary">
<meta name="twitter:site" content="">
<meta name="twitter:title" content="">
<meta name="twitter:description" content="">
<meta name="twitter:image" content="">

<!-- Favicon -->
<link href="../../resources/img/favicon.ico" rel="icon">

<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Raleway:400,500,700|Roboto:400,900"
	rel="stylesheet">

<!-- Bootstrap CSS File -->
<link href="../../resources/lib/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Libraries CSS Files -->
<link href="../../resources/lib/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">

<!-- Main Stylesheet File -->
<link href="../../resources/css/style.css" rel="stylesheet">

<!-- =======================================================
    Theme Name: Bell
    Theme URL: https://bootstrapmade.com/bell-free-bootstrap-4-template/
    Author: BootstrapMade.com
    Author URL: https://bootstrapmade.com
  ======================================================= -->
</head>
<!-- Header -->
<header id="header">
	<div class="container">

		<div id="logo" class="pull-left">
			<a href="index.html"><img src="../../resources/img/logo-nav.png"
				alt="" title="" /></img></a>
			<!-- Uncomment below if you prefer to use a text image -->
			<!--<h1><a href="#hero">Bell</a></h1>-->
		</div>

		<nav id="nav-menu-container">
			<ul class="nav-menu">
				<li><a href="#about">About Us</a></li>
				<li><a href="#portfolio">Our Pets</a></li>
				<li><a href="#team">Our Team</a></li>
				<li class="menu-has-children"><a href="#">More Options</a>
					<ul>
						<li class="menu-has-children"><a href="#">Go directly to
								:</a>
							<ul>
								<li><a href="#">Dogs Category</a></li>
								<li><a href="#">Cats Category</a></li>
								<li><a href="#">Rodents Category</a></li>
								<li><a href="#">Exotic Pets Category</a></li>
								<li><a href="#">All Categories</a></li>
							</ul></li>
						<li><a href="#">Admin options : <!-- ici chercher comment cacher et afficher des menus si admin --></a>
							<ul>
								<li><a href="#">Manage Pets</a></li>
								<li><a href="#">Manage Users</a></li>
								<li><a href="#">Manage transfer forms</a></li>
								<li><a href="#">Manage adoption forms</a></li>
							</ul></li>
						<li><a href="#">Host Family options : <!-- ici chercher comment cacher et afficher des menus si FA --></a>
							<ul>
								<li><a href="#">Manage Pets</a></li>
								<li><a href="#">Create transfer forms</a></li>
								<li><a href="#">Manage adoption forms</a></li>
							</ul></li>
						<li><a href="#">I want to become an adopter</a></li>
					</ul></li>
				<li><a href="#contact">Contact Us</a></li>
			</ul>
		</nav>
		<!-- #nav-menu-container -->

		<nav class="nav social-nav pull-right d-none d-lg-inline">
			<a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i
				class="fa fa-linkedin"></i></a> <a href="#"><i
				class="fa fa-envelope"></i></a>
		</nav>
	</div>
</header>
<!-- #header -->

<body>


	<div class="panel-body">
		<table class="table table-striped table-bordered">
			<tr>
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
						<!-- display the update link --> <a href="${updateLink}"> <i
							class="fas fa-user-edit"></i>
					</a> | <a href="${deleteLink}"
						onclick="if (!(confirm('Are you sure you want to delete this employee?'))) return false">
							<i class="fas fa-user-times"></i>
					</a>
					</td>

				</tr>

			</c:forEach>

		</table>
	</div>



</body>

<footer class="site-footer">
	<div class="bottom">
		<div class="container">
			<div class="row">

				<div class="col-lg-6 col-xs-12 text-lg-left text-center">
					<p class="copyright-text">BELL Theme</p>
					<div class="credits">
						<!--
                All the links in the footer should remain intact.
                You can delete the links only if you purchased the pro version.
                Licensing information: https://bootstrapmade.com/license/
                Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/buy/?theme=Bell
              -->
						Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
					</div>
				</div>

				<div class="col-lg-6 col-xs-12 text-lg-right text-center">
					<ul class="list-inline">
						<li class="list-inline-item"><a href="index.jsp">Home</a></li>

						<li class="list-inline-item"><a href="#about">About Us</a></li>

						<li class="list-inline-item"><a href="#portfolio">Our
								pets</a></li>

						<li class="list-inline-item"><a href="#team">Our Team</a></li>

						<li class="list-inline-item"><a href="#contact">Contact</a></li>
					</ul>
				</div>

			</div>
		</div>
	</div>
</footer>
<a class="scrolltop" href="#"><span class="fa fa-angle-up"></span></a>


<!-- Required JavaScript Libraries -->
<script src="../../resources/lib/jquery/jquery.min.js"></script>
<script src="../../resources/lib/jquery/jquery-migrate.min.js"></script>
<script src="../../resources/lib/superfish/hoverIntent.js"></script>
<script src="../../resources/lib/superfish/superfish.min.js"></script>
<script src="../../resources/lib/tether/js/tether.min.js"></script>
<script src="../../resources/lib/stellar/stellar.min.js"></script>
<script src="../../resources/lib/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="../../resources/lib/counterup/counterup.min.js"></script>
<script src="../../resources/lib/waypoints/waypoints.min.js"></script>
<script src="../../resources/lib/easing/easing.js"></script>
<script src="../../resources/lib/stickyjs/sticky.js"></script>
<script src="../../resources/lib/parallax/parallax.js"></script>
<script src="../../resources/lib/lockfixed/lockfixed.min.js"></script>

<!-- Template Specisifc Custom Javascript File -->
<script src="../../resources/js/custom.js"></script>

<script src="../../resources/contactform/contactform.js"></script>

</body>
</html>