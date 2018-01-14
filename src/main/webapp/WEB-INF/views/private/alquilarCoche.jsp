

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
	
	
	¿Qué coche desea alquilar?
	
	<form:form action="alquilarCoche" commandName="billete">
		<form:errors path=""/>
		<br/>
		
		<p>
		<form:select path="cocheTipo">		
			<option value="Ninguno">Ninguno</option>
			<option value="Utilitario">Utilitario</option>
			<option value="Furgoneta">Furgoneta</option>
		</form:select>
		</p>

		<input type="submit" value="Seleccionar"/>
	</form:form>
		

	
	<!-- En caso de que hubiese algún mensaje de error, lo mostramos -->
	<p style="color: red;">
		<c:out value="${message}"/>
	</p>
	
</body>
</html>

