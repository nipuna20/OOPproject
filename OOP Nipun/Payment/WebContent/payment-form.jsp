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
					class="nav-link">Payment</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${payment != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${payment == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h3>
						<c:if test="${payment != null}">
            			Edit Payment
            		</c:if>
						<c:if test="${payment == null}">
            			New Payment
            		</c:if>
					</h3>
				</caption> <br>

				<c:if test="${payment != null}">
					<input type="hidden" name="id" value="<c:out value='${payment.id}' />" />
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
					<label>Name on Card</label> <input type="text"
						value="<c:out value='${payment.name}' />" class="form-control"
						name="name" required="required">
				</fieldset>
				
				
				<fieldset class="form-group">
					<label>Card No</label> <input type="text"
						value="<c:out value='${payment.card}' />" class="form-control"
						name="card" required="required">
				</fieldset>
				
				
				<fieldset class="form-group">
					<label>CVV</label> <input type="text"
						value="<c:out value='${payment.cvv}' />" class="form-control"
						name="cvv" pattern="[0-9]{3}" required="required">
				</fieldset>
                            
                            
                            <fieldset class="form-group">
					<label>Expire Date</label> <input type="date"
						value="<c:out value='${payment.expire}' />" class="form-control"
						name="expire" required="required">
				</fieldset>
                            

				<fieldset class="form-group">
					<label>Amount</label> <input type="text"
						value="<c:out value='${payment.amount}' />" class="form-control"
						name="amount" required="required">
				</fieldset>



				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>