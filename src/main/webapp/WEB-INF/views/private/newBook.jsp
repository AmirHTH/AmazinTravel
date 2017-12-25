

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
	<title>Amazin</title>
</head>
<body>
	<center>
		<h1>AMAZIN.COM</h1>
		<br>
		<h2>Bienvenido a la más pequeña tienda virtual del mundo</h2>
	</center>
	<br>
	Introduzca los datos del nuevo libro:
	<form:form commandName="book">
		<form:errors path=""/>
		<br/>
		Title: <form:input path="title"/>
		<form:errors path="title"/>
		<br/>
		
		Description: <form:input path="description"/>
		<form:errors path="description"/>
		<br/>
		Author: <form:input path="author"/>
		<form:errors path="author"/>
		<br/>
		
		Precio base: <form:input path="basePrice"/>
		<form:errors path="basePrice"/>
		<br/>
		<input type="submit"/>
	</form:form>
	<!-- En caso de que hubiese algún mensaje de error, lo mostramos -->
	<p style="color: red;">
		<c:out value="${message}"/>
	</p>
	
</body>
</html>

