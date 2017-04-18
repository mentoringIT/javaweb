<%@page import="mx.com.mentoringit.model.dto.ClienteDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%!
	public  ArrayList<ClienteDTO> clientes ;
%>
<%
	clientes =  (ArrayList<ClienteDTO>)request.getAttribute("clientes");
%>
<link rel="stylesheet" href="table.css" type="text/css"/>	
</head>
<body>
<div class="CSS_Table_Example" style="width:600px;">
	<table>
	
		<tr>
			<th>idcliente</th>
			<th>nombre</th>
			<th>apaterno</th>
			<th>amaterno</th>
			<th>edad</th>
			<th>idbanco</th>
		</tr>
		
		<c:forEach var="cliente" items="${clientes}">
			<tr>
				<td>${cliente.getIdCliente()}</td>
				<td>${cliente.getNombre()}</td>
				<td>${cliente.getApaterno()}</td>
				<td>${cliente.getAmaterno()}</td>
				<td>${cliente.getEdad()}</td>
				<td>${cliente.getIdBanco()}</td>
				<td>
					<form action="eliminar" method="post">
						<input type="hidden" name="idCliente" value="${cliente.getIdCliente()}">
						<input type="submit" value="borrar">
					</form>
				</td>
				<td>
					<form action="actualizar" method="post">
						<input type="hidden" name="idCliente" value="${cliente.getIdCliente()}">
						<input type="submit" value="actualizar">					
					</form>
				</td>
			</tr>
		</c:forEach>		
	</table>
</div>
<div style="width: 600px" align="right">
	<a href="nuevo">Nuevo Cliente</a>
</div>
</body>
</html>

