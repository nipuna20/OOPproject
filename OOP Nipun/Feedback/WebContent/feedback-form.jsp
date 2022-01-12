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
					class="nav-link">Feedback</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${feedback != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${feedback == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h3>
						<c:if test="${feedback != null}">
            			Edit Feedback
            		</c:if>
						<c:if test="${feedback == null}">
            			New Feedback
            		</c:if>
					</h3>
				</caption> <br>

				<c:if test="${feedback != null}">
					<input type="hidden" name="id" value="<c:out value='${feedback.id}' />" />
				</c:if>
				
				
				<div class="form-group">
                               <label>Game</label>
                                <select id="inputState"  class="form-control" name="game" required>
                                    <option selected disabled>Choose the Game</option>
                                    <option value="Dota 2">Dota 2</option>
                                    <option value="League of Legends">League of Legends</option>
                                    <option value="Apex Legends">Apex Legends</option>
                                    <option value="Call of Duty">Call of Duty</option>
                                    <option value="Valorant">Valorant</option>
                                    <option value="Fortnite">Fortnite</option>
                                </select>
                            </div>
				

				<fieldset class="form-group">
					<label>Customer Name</label> <input type="text"
						value="<c:out value='${feedback.name}' />" class="form-control"
						name="name" required="required">
				</fieldset>

				<div class="form-group">
                               <label>Rate</label>
                                <select id="inputState"  class="form-control" name="rate" required>
                                    <option selected disabled>Choose Rate</option>
                                    <option value="1 Star">1 Star</option>
                                    <option value="2 Star">2 Star</option>
                                    <option value="3 Star">3 Star</option>
                                    <option value="4 Star">4 Star</option>
                                    <option value="5 Star">5 Star</option>
                                </select>
                            </div>
				
				
				
				<fieldset class="form-group">
					<label>Comment</label> <input type="text"
						value="<c:out value='${feedback.comment}' />" class="form-control"
						name="comment" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Date</label> <input type="date"
						value="<c:out value='${feedback.date}' />" class="form-control"
						name="date" required="required">
				</fieldset>

				

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>