<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="./styles/main.css">
<link href="https://fonts.googleapis.com/css2?family=Trispace&display=swap" rel="stylesheet">
<link rel="sortcut icon" href="./images/book.svg" type="image/x-icon" />
<title>Library</title>
</head>
<body>
	<div class="login">

		<h1><font face = "Trispace" color = "black">Library</font></h1>
		
		<h2>Login</h2>
		
		<form method = "post" action = "LoginServlet">
			<label>Username:</label>
			<input id="a" type="text" placeholder="Username" name="login" required>

			<label>Password:</label>
			<input type="password" id="b" placeholder="Password..." name="senha" required>


			<input type="Submit" value="Login" id="Submit" name="Submit">


			<div class="forgot-pass">
				<p><a href="#">Forgot Password?</a></p>
				<p><a href="admin-login.jsp">Login has admin</a>
			</div>
		</form>
	</div>
	<div id = "main-image">
		<img src = "images/43122.svg" alt ="books" width="1000" height="500">
	</div>
</body>
</html>