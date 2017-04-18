<%@page import="mx.com.mentoringit.model.dto.BancoDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<jsp:useBean id="cliente"
	class="mx.com.mentoringit.model.dto.ClienteDTO"
	scope="request"></jsp:useBean>

<%!public ArrayList<BancoDTO> bancos;%>

<%
	// ClienteDTO cliente = request.getAttribute("cliente");
	bancos = (ArrayList<BancoDTO>) request.getAttribute("bancos");
%>
</head>
<body>
	<h2>Nuevo cliente</h2>
	<form action="guardar" method="post">
		<input type="hidden" name="idCliente"
			value="<jsp:getProperty property="idCliente" name="cliente" />" /> <label>Nombre</label>
		<input type="text" name="nombre"
			value="<jsp:getProperty property="nombre" name="cliente" />">
		<br /> <label>Apaterno</label> <input type="text" name="apaterno"
			value="<jsp:getProperty property="apaterno" name="cliente"/>">
		<br /> <label>Amaterno</label> <input type="text" name="amaterno"
			value="<jsp:getProperty property="amaterno" name="cliente"/>">
		<br /> <label>Edad</label> <input type="text" name="edad"
			value="<jsp:getProperty property="edad" name="cliente"/>"> <br />

		<label>Banco</label> <select name="idBanco">
			<c:forEach items="${bancos}" var="banco">
				<c:choose>
					<c:when test="${banco.getIdBanco() == cliente.getIdBanco()}">
						<option value="${banco.getIdBanco()}" selected="selected">${banco.getNombre()}</option>
					</c:when>
					<c:otherwise>
						<option value="${banco.getIdBanco()}">${banco.getNombre()}</option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</select> <br /> <input type="submit" value="Guardar">

	</form>
</body>
</html>