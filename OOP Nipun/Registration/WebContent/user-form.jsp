<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Online Gaming System</title>
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
				<a href="https://www.javaguides.net" class="navbar-brand"> Online Gaming System </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">User Registration</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${user != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${user == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h3>
						<c:if test="${user != null}">
            			Edit User
            		</c:if>
						<c:if test="${user == null}">
            			New User Registration
            		</c:if>
					</h3>
				</caption>
				<br>

				<c:if test="${user != null}">
					<input type="hidden" name="id" value="<c:out value='${user.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>User Name</label> <input type="text"
						value="<c:out value='${user.name}' />" class="form-control"
						name="name" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Password</label> <input type="password"
						value="<c:out value='${user.password}' />" class="form-control"
						name="password" required="required">
				</fieldset>

				<div class="form-group">
					<label>Gender</label> <select id="inputState" class="form-control"
						name="gender" required>

						<option value="Male">Male</option>
						<option value="Female">Female</option>
					</select>
				</div>



				<fieldset class="form-group">
					<label>Age</label> <input type="text"
						value="<c:out value='${user.age}' />" class="form-control"
						name="age" required="required">
				</fieldset>


				<fieldset class="form-group">
					<label>Email</label> <input type="email"
						value="<c:out value='${user.address}' />" class="form-control"
						name="address" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Contact No</label> <input type="text"
						value="<c:out value='${user.phone}' />" class="form-control"
						name="phone" pattern="[0-9]{10}" required="required">
				</fieldset>





				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>