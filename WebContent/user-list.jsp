<%@page import="java.util.ArrayList"%>
<%@page import="dao.DaoUsuario"%>
<%@page import="beans.BeanUsuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="sortcut icon" href="./images/book.svg" type="image/x-icon" />
<link href="https://fonts.googleapis.com/css2?family=Trispace&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="./styles/menu.css">
<title>Admin page</title>
</head>
<body>
	<h2 class="center">Admin page: My library control</h2>
	<nav id="menu">
    	<ul>
        	<li><a href ="./cadastro-usuario.jsp">Register a new user</a></li>
        	<li><a href ="./cadastro-livro.jsp">Register a new book</a></li>
        	<li><a href ="./book-status.jsp">View/Change book status</a></li>
        	<li><a href ="./user-list.jsp">Verify all users</a></li>
        	<li><a href="./admin-login.jsp">Logout</a></li>
    	</ul>
	</nav>
	<div class="book-status-form">
	<h2>New loan</h2>
		<form method = "post" action="Emprestar">
		<table>
			<tr>
			
				<td>User ID:</td>
				<td><input type ="text" id ="usuarioid" name = "usuarioid"></td>
			</tr>
			<tr>
				<td>Book ID:</td>
				<td><input type ="text" id ="livroid" name = "livroid"></td>
			</tr>
		</table>
		<input type = "submit" value="Submit">
	</form>
	</div>
	<div class="book-status">
	<h1>User list</h1>
	<table>
    	<tr>
    		<td style="width: 170px;"><h2>Name</h2></td>
    		<td style="width: 170px;"><h2>ID</h2></td>
    		<td><h2>Loan</h2></td>
    	</tr>
    </table>
	 	<%
        ArrayList<BeanUsuario> listaUsuario = new ArrayList<BeanUsuario>();
        try{
            DaoUsuario daoListaUsuario = new DaoUsuario();
            listaUsuario = daoListaUsuario.getlistaUsuario();

        }catch(Exception e){
            e.printStackTrace();
        }

        for(BeanUsuario l:listaUsuario){
    	%>
	 	<table>
    		<tr>
        		<td style="width: 170px;"><h3><%=l.getLogin()%></h3></td>
        		<br>
        		<td style="width: 170px;"><h3><%=l.getId()%></h3></td>
				<br>
				<td ><h3><%=l.getEmprestimo()%></h3></td>
				<br>
    		</tr>
        		<%} %>
    	</table>
	</div>
</body>
</html>