

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
	
	
	Buscar Reserva
	
	<p>Por favor, introduzca los datos de pago </p>
	
	<form:form action="buscarReserva" commandName="paramBuscarReserva">
		<form:errors path=""/>
		<br/>
		
		<p>Identificador Reserva: <form:input path="idReserva" value="1"/> <form:errors path="idReserva"/></p>
		
		<p>Correo electrónico: <form:input path="mail" value="amir@amazin.com"/><form:errors path="mail"/></p>
		
		<input type="submit" value="Buscar"/>
		
	</form:form>
		

	
	<!-- En caso de que hubiese algún mensaje de error, lo mostramos -->
	<p style="color: red;">
		<c:out value="${message}"/>
	</p>
	
</body>
</html>

