<%@page import="dao.DaoLivros"%>
<%@page import="beans.BeanLivros"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="sortcut icon" href="./images/book.svg" type="image/x-icon" />
<link href="https://fonts.googleapis.com/css2?family=Trispace&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="./styles/menu.css">
<title>Book Status</title>
</head>
<body>
	<h2 class="center">Admin page: My library control</h2>
		<nav id="menu">
    	<ul>
        	<li><a href ="./cadastro-usuario.jsp">Register a new user</a></li>
        	<li><a href ="./cadastro-livro.jsp">Register a new book</a></li>
        	<li><a href ="#">View/Change book status</a></li>
        	<li><a href ="./user-list.jsp">Verify all users</a></li>
        	<li><a href="./admin-login.jsp">Logout</a></li>
    	</ul>
	</nav>
	<div class="book-status-form">
		<h2>Set Book status</h2>
		<form method ="post" action ="AtualizarLivro">
		<table>
		<tr>
			<td>Name:</td>
			<td><input type ="text" name ="nome" id ="nome"></td>
		</tr>
		<tr>
			<td>Status:</td>
			<td><input type ="text" name = "status" id ="status"></td>
		</tr>
			
		</table>
		<input type = "submit" value = "Submit">
		</form>
	</div>
	<div class = "book-status">
		<h1>Books</h1>
	 	<table>
   			 <tr>
    			<td style="width: 170px;"><h2>Title</h2></td>
    			<td style="width: 170px;"><h2>Status</h2></td>
    		<td><h2>ID</h2></td>
    	</tr>
    
    	</table>
        	<%
        		ArrayList<BeanLivros> listaLivro = new ArrayList<BeanLivros>();
        		try{
            		DaoLivros daoListarLivro = new DaoLivros();
            		listaLivro = daoListarLivro.getlistaLivro();

        		}catch(Exception e){
            		e.printStackTrace();
        		}
        		for(BeanLivros l:listaLivro){


    		%>
    	<table>

    		<tr>
        		<td style="width: 170px;"><h3><%=l.getNome()%></h3></td>
        		<br>
        		<td style="width: 170px;"><h3><%=l.getStatus()%></h3></td>
				<br>
				<td><h3><%=l.getId() %></h3>
    		</tr>
        	<%} %>
    	</table>
	</div>
</body>
</html>