<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<sql:query var="rs" dataSource="jdbc/systembank">
select * from cliente
</sql:query>

</head>

<body>
	<ul>
		<li><a href="clientes">Listado de clientes</a></li>

		<c:forEach var="row" items="${rs.rows}">
    Cliente ${row.nombre}<br />
		</c:forEach>
	</ul>
</body>
</html>