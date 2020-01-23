<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html xmlns="http://www.w3c.org/1999/xhtml"
	xmlns:h="http://xmlns.jcp.org/jsf/html"
	xmlns:p="http://primefaces.org/ui"
	xmlns:f="http://java.sun.com/jsf/core">

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

<h:form>
	<p:dataTable var="pet" value="#{dtFilterView.pet1}"
		widgetVar="carsTable1"
		emptyMessage="No pets found with given criteria"
		filteredValue="#{dtFilterView.filteredpet1}">

		<p:column filterBy="#{car.year}" headerText="Year" footerText="lte"
			filterMatchMode="lte">
			<f:facet name="filter">
				<p:spinner onchange="PF('carsTable1').filter()"
					styleClass="year-spinner custom-filter">
					<f:converter converterId="javax.faces.Integer" />
				</p:spinner>
			</f:facet>
			<h:outputText value="#{car.year}" />
		</p:column>

		<p:column filterBy="#{car.brand}" headerText="Brand"
			footerText="exact" filterMatchMode="exact">
			<f:facet name="filter">
				<p:selectOneMenu onchange="PF('carsTable1').filter()"
					styleClass="custom-filter">
					<f:selectItem itemLabel="Select One" itemValue="#{null}"
						noSelectionOption="true" />
					<f:selectItems value="#{dtFilterView.brands}" />
				</p:selectOneMenu>
			</f:facet>
			<h:outputText value="#{car.brand}" />
		</p:column>

		<p:column filterBy="#{car.color}" headerText="Color" footerText="in"
			filterMatchMode="in">
			<f:facet name="filter">
				<p:selectCheckboxMenu label="Colors"
					onchange="PF('carsTable1').filter()" scrollHeight="150"
					styleClass="custom-filter">
					<f:selectItems value="#{dtFilterView.colors}" />
				</p:selectCheckboxMenu>
			</f:facet>
			<h:outputText value="#{car.color}" />
		</p:column>

		<p:column filterBy="#{car.sold}" headerText="Status"
			footerText="equals" filterMatchMode="equals">
			<f:facet name="filter">
				<p:selectOneButton onchange="PF('carsTable1').filter()"
					styleClass="custom-filter">
					<f:converter converterId="javax.faces.Boolean" />
					<f:selectItem itemLabel="All" itemValue="" />
					<f:selectItem itemLabel="Sold" itemValue="true" />
					<f:selectItem itemLabel="Sale" itemValue="false" />
				</p:selectOneButton>
			</f:facet>
			<h:outputText value="#{car.sold ? 'Sold': 'Sale'}" />
		</p:column>

		<p:column filterBy="#{car.price}" headerText="Price"
			footerText="custom (min)"
			filterFunction="#{dtFilterView.filterByPrice}">
			<h:outputText value="#{car.price}">
				<f:convertNumber currencySymbol="$" type="currency" />
			</h:outputText>
		</p:column>
	</p:dataTable>

	<p:dataTable var="car" value="#{dtFilterView.cars2}"
		widgetVar="carsTable2"
		emptyMessage="No cars found with given criteria"
		filteredValue="#{dtFilterView.filteredCars2}"
		globalFilterFunction="#{dtFilterView.globalFilterFunction}">

		<f:facet name="header">
			<p:outputPanel>
				<h:outputText value="Search all fields using globalFilterFunction:" />
				<p:inputText id="globalFilter" onkeyup="PF('carsTable2').filter()"
					style="width:150px" placeholder="Enter keyword" />
			</p:outputPanel>
		</f:facet>

		<p:column headerText="Id">
			<h:outputText value="#{car.id}" />
		</p:column>

		<p:column headerText="Year">
			<h:outputText value="#{car.year}" />
		</p:column>

		<p:column headerText="Brand">
			<h:outputText value="#{car.brand}" />
		</p:column>

		<p:column headerText="Color">
			<h:outputText value="#{car.color}" />
		</p:column>

		<p:column headerText="Status">
			<h:outputText value="#{car.sold ? 'Sold': 'Sale'}" />
		</p:column>

		<p:column headerText="Price">
			<h:outputText value="#{car.price}">
				<f:convertNumber currencySymbol="$" type="currency" />
			</h:outputText>
		</p:column>
	</p:dataTable>
</h:form>
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