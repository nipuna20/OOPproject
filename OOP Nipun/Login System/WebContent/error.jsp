<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Online Gaming System</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">


<style>
.center {
	text-align: center;
}
</style>


</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: black">
			<div>
				<a href="https://www.javaguides.net" class="navbar-brand">
					Online Gaming System </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">User Login</a></li>
			</ul>
		</nav>
	</header>


	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">


				<div class="center">
					<i class="material-icons" style="font-size: 48px; color: red">warning</i>
					<h2 align="center">Please insert correct username and password</h2>
				</div>

				<br>

			</div>
		</div>
	</div>

</body>
</html>