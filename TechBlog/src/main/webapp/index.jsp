<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP page</title>

<!-- css-->

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link href="css/MyStyle.css" rel="stylesheet" type="text/css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<style>
.banner-background {
	clip-path: polygon(0 0, 100% 0, 100% 30%, 100% 86%, 71% 94%, 31% 86%, 0 91%, 0% 30%
		);
}
</style>
</head>
<body>
	<!-- navbar -->

	<%@ include file="normal_navbar.jsp"%>

	<div class="container-fluid p-0 m-0">

		<div class="jumbotron primary-background text-white banner-background">
			<div class="container">
				<h3 class="display-3">Welcome to TechBlog</h3>
				<p>Welcome to TechBolg,Computer programming is the process of
					performing a particular computation usually by designing and
					building an executable computer program.</p>
				<button class="btn btn-outline-light btn-lg">
					<span class="fa fa-user "> </span>Start ! its Free
				</button>
				<a href="login.jsp" class="btn btn-outline-light btn-lg"><span
					class="fa fa-user-plus fa-spin"></span>Login</a>

			</div>
		</div>
	</div>

	<!-- Cards -->


	<div class="container">
		<div class="row mb-2">

			<div class="col-md-4">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Java Programing language</h5>
						<p class="card-text">Some quick example text to build on the
							card title and make you</p>
						<a href="#" class="btn primary-background text-white">Read
							More..</a>
					</div>
				</div>
			</div>

			<div class="col-md-4">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Java Programing language</h5>
						<p class="card-text">Some quick example text to build on the
							card title and make you</p>
						<a href="#" class="btn primary-background text-white">Read
							More..</a>
					</div>
				</div>
			</div>

			<div class="col-md-4">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Java Programing language</h5>
						<p class="card-text">Some quick example text to build on the
							card title and make you</p>
						<a href="#" class="btn primary-background text-white">Read
							More..</a>
					</div>
				</div>
			</div>

		</div>

		<div class="row">
			<div class="col-md-4">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Java Programing language</h5>
						<p class="card-text">Some quick example text to build on the
							card title and make you</p>
						<a href="#" class="btn primary-background text-white">Read
							More..</a>
					</div>
				</div>
			</div>

			<div class="col-md-4">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Java Programing language</h5>
						<p class="card-text">Some quick example text to build on the
							card title and make you</p>
						<a href="#" class="btn primary-background text-white">Read
							More..</a>
					</div>
				</div>
			</div>

			<div class="col-md-4">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Java Programing language</h5>
						<p class="card-text">Some quick example text to build on the
							card title and make you</p>
						<a href="#" class="btn primary-background text-white">Read
							More..</a>
					</div>
				</div>
			</div>

		</div>
	</div>


	<!-- Java Script -->
	<script src="https://code.jquery.com/jquery-3.6.4.min.js"
		integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8="
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
	<script src="js/MyJs.js" type="text/javascript"></script>



</body>
</html>