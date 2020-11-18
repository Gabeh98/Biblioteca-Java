<%@page import="java.util.ArrayList"%>
<%@page import="dao.DaoEmprestimo"%>
<%@page import="beans.BeanUsuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="sortcut icon" href="./images/book.svg" type="image/x-icon" />
<link href="https://fonts.googleapis.com/css2?family=Trispace&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="./styles/menu.css">
<title>Library</title>
</head>
<body>
	<h2>Bem vindo(a), ${sessionScope.login}</h2><h2 class ="center">My books</h2>
	<nav id="menu">
    	<ul>
        	<li><a href="#">My books</a></li>
        	<li><a href="user-livros.jsp">Consult books</a></li>
        	<li><a href="index.jsp">Logout</a></li>
    	</ul>
	</nav>
	<div>
		<%
			String usuario = (String)request.getSession().getAttribute("login");
			ArrayList<BeanUsuario> lista = new ArrayList<BeanUsuario>();
			try{
				DaoEmprestimo daoListarUsuario = new DaoEmprestimo();
				lista = daoListarUsuario.getUsuario(usuario);
			
			}catch(Exception e){
				e.printStackTrace();
			}
		
			for(BeanUsuario b:lista){
			
		%>
		<table>
			<tr>
				<td>Name:</td>
				<td style="width: 170px;"><h3><%=b.getLogin()%></h3></td>
				<br>
				<td>You have the book with id:</td>
				<td><h3><%=b.getEmprestimo()%></h3></td>
			</tr>
		</table>
		<%} %>
	</div>
</body>
</html>