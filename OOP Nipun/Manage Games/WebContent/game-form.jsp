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
				<a href="https://www.javaguides.net" class="navbar-brand"> Online Banking System </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Manage Games</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${game != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${game == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h3>
						<c:if test="${game != null}">
            			Edit Game
            		</c:if>
						<c:if test="${game == null}">
            			Add New Game
            		</c:if>
					</h3>
				</caption> <br>

				<c:if test="${game != null}">
					<input type="hidden" name="id" value="<c:out value='${game.id}' />" />
				</c:if>

				<div class="form-group">
                               <label>Game</label>
                                <select id="inputState"  class="form-control" name="name" required>
                                    <option selected disabled>Choose the Game</option>
                                    <option value="Dota 2">Dota 2</option>
                                    <option value="League of Legends">League of Legends</option>
                                    <option value="Apex Legends">Apex Legends</option>
                                    <option value="Call of Duty">Call of Duty</option>
                                    <option value="Valorant">Valorant</option>
                                    <option value="Fortnite">Fortnite</option>
                                </select>
                            </div>
                            
                            
                            <div class="form-group">
                               <label>Game Version</label>
                                <select id="inputState"  class="form-control" name="version" required>
                                    <option selected disabled>Choose the Version</option>
                                    <option value="Version 7.29c">Version 7.29c</option>
                                    <option value="Version 7.29b">Version 7.29b</option>
                                    <option value="Version 7.29">Version 7.29</option>
                                    <option value="Version 7.28c">Version 7.28c</option>
                                    <option value="Version 7.28b">Version 7.28b</option>
                                    <option value="Version 7.28a">Version 7.28a</option>
                                </select>
                            </div>
                            
                            
                            <fieldset class="form-group">
					<label>Initial Release Date</label> <input type="date"
						value="<c:out value='${game.date}' />" class="form-control"
						name="date" required="required">
				</fieldset>
                            

				<fieldset class="form-group">
					<label>Developer</label> <input type="text"
						value="<c:out value='${game.developer}' />" class="form-control"
						name="developer" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Publisher</label> <input type="text"
						value="<c:out value='${game.publisher}' />" class="form-control"
						name="publisher" required="required">
				</fieldset>



				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>