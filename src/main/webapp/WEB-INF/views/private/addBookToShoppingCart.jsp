

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
	Seleccione libre y cantidad:
	<form:form commandName="order">
		<form:select itemValue="id" itemLabel="title"  path="book.id" items="${bookList}"/>
		<form:select path="number" items="${numbers}"/>
		<input type="submit"/>
	</form:form>
	<!-- En caso de que hubiese algún mensaje de error, lo mostramos -->
	<p style="color: red;">
		<c:out value="${message}"/>
	</p>
	
</body>
</html>

