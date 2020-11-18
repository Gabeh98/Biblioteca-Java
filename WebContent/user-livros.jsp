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
<title>Library</title>
</head>
<body>
	<h2>Bem vindo(a), ${sessionScope.login}</h2><h2 class="center">Consult books</h2>
	
	<nav id="menu">
    	<ul>
        	<li><a href="my-books.jsp">My books</a></li>
        	<li><a href="#">Consult books</a></li>
        	<li><a href="index.jsp">Logout</a></li>
    	</ul>
	</nav>
	
	<div class="user-container">
	<h1>Books</h1>
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

        <c:out value="---------------------------------------------------------"></c:out>
        <td><h3><%=l.getStatus()%></h3></td>

    </tr>
        <%} %>
    </table>
	</div>
</body>
</html>