<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

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
				<li><a href="<%=request.getContextPath()%>/login"
					class="nav-link">User Login</a></li>
			</ul>
		</nav>
	</header>


	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">


				<form method="post" action="LoginCheck">
					<table>
						<tr> <br>
							<td> <b>User Name </b> </td>
							<td><input type="text" name="username"></td>
						</tr>
						<tr>
							<td> <br> <b>Password </b> </td>
							<td> <br><input type="password" name="password"></td>
						</tr>
						<tr>
							<td></td>
							<td> <br><button type="submit" class="btn btn-success">Login</button>
							<button type="reset" class="btn btn-success value="Reset">Reset</button></td>
						</tr>
					</table> <br>
				</form>




			</div>
		</div>
	</div>

</body>
</html>