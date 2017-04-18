<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html>
<head>
<style type="text/css">
#formLogin {
	margin: auto;
	margin-top: 20%;
	width: 300px
}
</style>

<script type="text/javascript">
	function validaCampos(valor, field){
		
		var regexp = /(^[a-zA-Z0-9]{8,10})$/;
		
		var val = valor ;
		
		if(field.name == 'usuario' && val == ''){
			return false;
		}else if(field.name == 'password'){
			var result = val.match(regexp);
			return result;
		}
		return true;
	}
	
</script>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/js/resources/css/ext-all.css">

<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/ext-all.js"></script>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/vistas/login.js"></script>

</head>
<body>

	<div id="formLogin">
	</div>
</body>
</html>