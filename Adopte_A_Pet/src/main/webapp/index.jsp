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
<link href="resources/img/favicon.ico" rel="icon">

<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Raleway:400,500,700|Roboto:400,900"
	rel="stylesheet">

<!-- Bootstrap CSS File -->
<link href="resources/lib/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Libraries CSS Files -->
<link href="resources/lib/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">

<!-- Main Stylesheet File -->
<link href="resources/css/style.css" rel="stylesheet">

<!-- =======================================================
    Theme Name: Bell
    Theme URL: https://bootstrapmade.com/bell-free-bootstrap-4-template/
    Author: BootstrapMade.com
    Author URL: https://bootstrapmade.com
  ======================================================= -->
</head>

<body>
	<!-- Page Content
    ================================================== -->
	<!-- Hero -->

	<section class="hero">
		<div class="container text-center">
			<div class="row">
				<div class="col-md-12">
					<a class="hero-brand" href="index.html" title="Home"> <img
						alt="Bell Logo" src="resources/img/logo.png"></a>
				</div>
			</div>

			<div class="col-md-12">
				<h1>Adopt A Pet</h1>

				<p class="tagline">Don't buy your companion, choose adoption.</p>
				<a class="btn btn-full" href="#about">Get Started</a>
			</div>
		</div>

	</section>
	<!-- /Hero -->

	<!-- Header -->
	<header id="header">
		<div class="container">

			<div id="logo" class="pull-left">
				<a href="index.html"><img src="resources/img/logo-nav.png"
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

	<!-- About -->

	<section class="about" id="about">
		<div class="container text-center">
			<h2>About Our Association</h2>

			<p>Voluptua scripserit per ad, laudem viderer sit ex. Ex alia
				corrumpit voluptatibus usu, sed unum convenire id. Ut cum nisl
				moderatius, per nihil dicant commodo an. Eum tacimates erroribus ad.
				Atqui feugiat euripidis ea pri, sed veniam tacimates ex. Menandri
				temporibus an duo.</p>

			<div class="row stats-row">
				<div class="stats-col text-center col-md-3 col-sm-6">
					<div class="circle">
						<span class="stats-no" data-toggle="counter-up">100</span> Number
						of Animals
					</div>
				</div>

				<div class="stats-col text-center col-md-3 col-sm-6">
					<div class="circle">
						<span class="stats-no" data-toggle="counter-up">50</span> Number
						of Host Family
					</div>
				</div>

				<div class="stats-col text-center col-md-3 col-sm-6">
					<div class="circle">
						<span class="stats-no" data-toggle="counter-up">35</span> Number
						of Adopters
					</div>
				</div>

				<div class="stats-col text-center col-md-3 col-sm-6">
					<div class="circle">
						<span class="stats-no" data-toggle="counter-up">80</span> Number
						of Users
					</div>
				</div>
				<div class="container text-center" style="margin-top: 20px;">
					<a class="btn btn-full" href="#">Connexion</a> <a
						class="btn btn-full" href="#portfolio">See our pets</a> <a
						class="btn btn-full" href="#">Inscription</a>
				</div>
			</div>
		</div>
	</section>

	<!-- /Call to Action -->
	<!-- Portfolio -->

	<section class="portfolio" id="portfolio">
		<div class="container text-center">
			<h2>Our Animals</h2>

			<p>From here you can directly choose a category or see all the
				animals</p>
		</div>

		<div class="portfolio-grid">
			<div class="row">
				<div class="col-lg-3 col-sm-6 col-xs-12">
					<div class="card card-block">
						<a href="#"><img alt="" src="resources/img/dogs.jpg">
							<div class="portfolio-over">
								<div>
									<h3 class="card-title">Dogs Category</h3>

									<p class="card-text">See all our Doggy</p>
								</div>
							</div></a>
					</div>
				</div>

				<div class="col-lg-3 col-sm-6 col-xs-12">
					<div class="card card-block">
						<a href="#"><img alt="" src="resources/img/cats.jpg">
							<div class="portfolio-over">
								<div>
									<h3 class="card-title">Cats Category</h3>

									<p class="card-text">See all our cuty Cats</p>
								</div>
							</div></a>
					</div>
				</div>

				<div class="col-lg-3 col-sm-6 col-xs-12">
					<div class="card card-block">
						<a href="#"><img alt="" src="resources/img/rodents.jpg">
							<div class="portfolio-over">
								<div>
									<h3 class="card-title">Rodents Category</h3>

									<p class="card-text">See all our little Rodents</p>
								</div>
							</div></a>
					</div>
				</div>

				<div class="col-lg-3 col-sm-6 col-xs-12">
					<div class="card card-block">
						<a href="#"><img alt="" src="resources/img/exotics.jpg">
							<div class="portfolio-over">
								<div>
									<h3 class="card-title">Exotics pets Category</h3>

									<p class="card-text">See all our Exotics Pets</p>
								</div>
							</div></a>
					</div>
				</div>

				<div class="col-lg-3 col-sm-6 col-xs-12">
					<div class="card card-block">
						<a href="#"><img alt="" src="resources/img/all.jpg">
							<div class="portfolio-over">
								<div>
									<h3 class="card-title">All Categories</h3>

									<p class="card-text">See all our Pets</p>
								</div>
							</div></a>
					</div>
				</div>

			</div>
		</div>
	</section>
	<!-- /Portfolio -->
	<!-- Team -->

	<section class="team" id="team">
		<div class="container">
			<h2 class="text-center">Meet our team</h2>

			<div class="row">
				<div class="col-sm-3 col-xs-6">
					<div class="card card-block">
						<a href="#"><img alt="" class="team-img"
							src="resources/img/damien.jpg">
							<div class="card-title-wrap">
								<span class="card-title">Damien Bertinaria</span> <span
									class="card-text">President</span>
							</div>

							<div class="team-over">
								<h4 class="hidden-md-down">Find me on social media</h4>

								<nav class="social-nav">
									<a href="#"><i class="fa fa-linkedin"></i></a> <a href="#"><i
										class="fa fa-envelope"></i></a>
								</nav>

								<p>Lorem ipsum dolor sit amet, eu sed suas eruditi
									honestatis.</p>
							</div> </a>
					</div>
				</div>

				<div class="col-sm-3 col-xs-6">
					<div class="card card-block">
						<a href="#"><img alt="" class="team-img"
							src="resources/img/nina.jpg">
							<div class="card-title-wrap">
								<span class="card-title">Nina Chrétien</span> <span
									class="card-text">President</span>
							</div>

							<div class="team-over">
								<h4 class="hidden-md-down">Find me on social media</h4>

								<nav class="social-nav">
									<a href="#"><i class="fa fa-linkedin"></i></a> <a href="#"><i
										class="fa fa-envelope"></i></a>
								</nav>

								<p>Lorem ipsum dolor sit amet, eu sed suas eruditi
									honestatis.</p>
							</div> </a>
					</div>
				</div>
			</div>
		</div>

	</section>
	<!-- /Team -->
	<!-- @component: footer -->

	<section id="contact">
		<div class="container">
			<div class="row">
				<div class="col-md-12 text-center">
					<h2 class="section-title">Contact Us</h2>
				</div>
			</div>

			<div class="row justify-content-center">
				<div class="col-lg-3 col-md-4">
					<div class="info">
						<div>
							<i class="fa fa-map-marker"></i>
							<p>
								33 Avenue du Maine<br>Paris, 75014
							</p>
						</div>

						<div>
							<i class="fa fa-envelope"></i>
							<p>adoptapet@gmail.com</p>
						</div>

						<div>
							<i class="fa fa-phone"></i>
							<p>+33 XX XX XX XX</p>
						</div>

					</div>
				</div>

				<div class="col-lg-5 col-md-8">
					<div class="form">
						<div id="sendmessage">Your message has been sent. Thank you!
							We will give you an answer in the best delays</div>
						<div id="errormessage"></div>
						<form action="" method="post" role="form" class="contactForm">
							<div class="form-group">
								<input type="text" name="name" class="form-control" id="name"
									placeholder="Your Name" data-rule="minlen:4"
									data-msg="Please enter at least 4 chars" />
								<div class="validation"></div>
							</div>
							<div class="form-group">
								<input type="email" class="form-control" name="email" id="email"
									placeholder="Your Email" data-rule="email"
									data-msg="Please enter a valid email" />
								<div class="validation"></div>
							</div>
							<div class="form-group">
								<select name="type" class="form-control" name="subject"
									id="subject">
									<option>Please choose the subject of your mail :</option>
									<option value="pet">Informations about a pet</option>
									<option value="host_fa">I want to be a Host Family</option>
									<option value="adoption">I have a pet to be adopted</option>
									<option value="center">Add a center to the list of
										partner centers</option>
									<option value="other">Other Reasons</option>
								</select>
								<div class="validation"></div>
							</div>
							<div class="form-group">
								<textarea class="form-control" name="message" rows="5"
									data-rule="required" data-msg="Please write something for us"
									placeholder="Message"></textarea>
								<div class="validation"></div>
							</div>
							<div class="text-center">
								<button type="submit">Send Message</button>
							</div>
						</form>
					</div>
				</div>

			</div>
		</div>
	</section>

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
							<li class="list-inline-item"><a href="#">Home</a></li>

							<li class="list-inline-item"><a href="#about">About Us</a></li>

							<li class="list-inline-item"><a href="#portfolio">Our
									pets</a></li>

							<li class="list-inline-item"><a href="#team">Our Team</a></li>

							<li class="list-inline-item"><a href="#contact">Contact</a>
							</li>
						</ul>
					</div>

				</div>
			</div>
		</div>
	</footer>
	<a class="scrolltop" href="#"><span class="fa fa-angle-up"></span></a>


	<!-- Required JavaScript Libraries -->
	<script src="lib/jquery/jquery.min.js"></script>
	<script src="lib/jquery/jquery-migrate.min.js"></script>
	<script src="lib/superfish/hoverIntent.js"></script>
	<script src="lib/superfish/superfish.min.js"></script>
	<script src="lib/tether/js/tether.min.js"></script>
	<script src="lib/stellar/stellar.min.js"></script>
	<script src="lib/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="lib/counterup/counterup.min.js"></script>
	<script src="lib/waypoints/waypoints.min.js"></script>
	<script src="lib/easing/easing.js"></script>
	<script src="lib/stickyjs/sticky.js"></script>
	<script src="lib/parallax/parallax.js"></script>
	<script src="lib/lockfixed/lockfixed.min.js"></script>

	<!-- Template Specisifc Custom Javascript File -->
	<script src="js/custom.js"></script>

	<script src="contactform/contactform.js"></script>

</body>
</html>
