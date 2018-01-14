

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
	<title>Amazin</title>
</head>
<body>
	<center>
		<h1><spring:message code="title"/></h1>
		<br>
		<h2><spring:message code="welcome"/></h2>
	</center>
	<br>
	
	
	Pagar Billete
	
	<p>Por favor, introduzca los datos de pago </p>
	
	<form:form action="pagarBillete" commandName="usuario">
		<form:errors path=""/>
		<br/>
		
		<p>Nombre: <form:input path="nombre" value="Amir"/> <form:errors path="nombre"/></p>
		
		<p>Apellidos: <form:input path="apellidos" value="Tofigh"/><form:errors path="apellidos"/></p>
		
		<p>Número Identificación Personal: <form:input path="dni" value="789789789"/><form:errors path="dni"/></p>
		
		<p>Correo electrónico: <form:input path="mail" value="amir@amazin.com"/><form:errors path="mail"/></p>
		
		<input type="submit" value="Pagar"/>
		
	</form:form>
		

	
	<!-- En caso de que hubiese algún mensaje de error, lo mostramos -->
	<p style="color: red;">
		<c:out value="${message}"/>
	</p>
	
</body>
</html>

