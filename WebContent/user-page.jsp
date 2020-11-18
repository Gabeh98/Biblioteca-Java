<%@page import="beans.BeanUsuario"%>
<%@page import="dao.DaoUsuario"%>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="sortcut icon" href="./images/book.svg" type="image/x-icon" />
<link href="https://fonts.googleapis.com/css2?family=Trispace&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="./styles/menu.css">
<title>${sessionScope.login} Page</title>
</head>
<body>
	<h2>Bem vindo(a), ${sessionScope.login}</h2>
	This is your personal library.
	<nav id="menu">
    	<ul>
        	<li><a href="my-books.jsp">My books</a></li>
        	<li><a href="user-livros.jsp">Consult books</a></li>
        	<li><a href="index.jsp">Logout</a></li>
    	</ul>
	</nav>
</body>
</html>