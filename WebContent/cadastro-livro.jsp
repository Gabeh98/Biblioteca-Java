<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="sortcut icon" href="./images/book.svg" type="image/x-icon" />
<link href="https://fonts.googleapis.com/css2?family=Trispace&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="./styles/menu.css">
<title>Insert Book</title>
</head>
<body>

<h2 class="center">Admin page: My library control</h2>
		<nav id="menu">
    	<ul>
        	<li><a href ="./cadastro-usuario.jsp">Register a new user</a></li>
        	<li><a href ="#">Register a new book</a></li>
        	<li><a href ="./book-status.jsp">View/Change book status</a></li>
        	<li><a href ="./user-list.jsp">Verify all users</a></li>
        	<li><a href="./admin-login.jsp">Logout</a></li>
    	</ul>
	</nav>
	<div class="form-container">
	<h2>Insert a new book at library</h2>
	<form method = "post" action="SalvarLivro">
		<table>
			<tr>
				<td>Title:</td>
				<td><input type ="text" id ="nome" name = "nome"></td>
			</tr>
			<tr>
				<td>Author:</td>
				<td><input type ="text" id ="autor" name = "autor"></td>
			</tr>
			<tr>
				<td>Status:</td>
				<td><input type ="text" id ="status" name = "status"></td>
			</tr>
			<tr>
				<td>ID:</td>
				<td><input type ="text" id ="id" name = "id"></td>
			</tr>
		</table>
		<input type = "submit" value="Submit">
	</form>
	</div>
</body>
</html>