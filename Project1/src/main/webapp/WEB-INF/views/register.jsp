<!doctype html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
	<meta name="generator" content="Jekyll v4.0.1">
	<title>Register</title>

	<link rel="canonical" href="https://getbootstrap.com/docs/4.5/examples/sign-in/">

	<!-- Bootstrap core CSS -->
	<link rel="stylesheet" href="css/bootstrap/bootstrap.min.css">

	<!-- external jQ js lib -->
	<script src="js/login.js"></script>

	<style>
		.bd-placeholder-img {
			font-size: 1.125rem;
			text-anchor: middle;
			-webkit-user-select: none;
			-moz-user-select: none;
			-ms-user-select: none;
			user-select: none;
		}

		@media (min-width: 768px) {
			.bd-placeholder-img-lg {
				font-size: 3.5rem;
			}
		}
	</style>
	<!-- Custom styles for this template -->
	<link href="css/login.css" rel="stylesheet">

</head>


<body class="text-center">

	<form class="form-signin" method=POST action="/register">
		<img class="mb-4" src="assets/brand/login_user.svg" alt="" width="72" height="72">
		<h1 class="h3 mb-3 font-weight-normal">Enter the sign-up form </h1>

		<label style="text-align: left;">
			<span>Username</span>
			<input type="text" name="username" class="form-control" placeholder="Uername" required autofocus>
		</label>
		<label style="text-align: left;">
			<span>Email</span>
			<input type="email" name="email" class="form-control" placeholder="abc@example.com" required>
		</label>
		<br>
		<label style="text-align: left;">
			<span>Password</span>
			<input type="password" name="password" class="form-control" placeholder="Password" required>
		</label>
		<br>
		<!-- <div class="checkbox mb-3">
	<label>
		<input type="checkbox" value="remember-me"> Remember me
	</label>
	</div> -->


		<button class="btn btn-lg btn-primary btn-block" type="submit">Sign Up</button>

		<p class="mt-5 mb-3 text-muted">&copy; 2017-2020</p>

	</form>

</body>

</html>