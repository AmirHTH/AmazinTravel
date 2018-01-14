
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
	<br> Nuestro catálogo:
	<br>
	<table>
		<tr>
			<td>Origen</td>
			<td>Destino</td>
			<td>Fecha Salida</td>
			<td>Fecha Llegada</td>
			<td>Plazas Totales</td>
			<td>Plazas Quedan</td>
		</tr>
		
		<c:forEach items="${viajesList}" var="viaje">
			<tr>
				<td><c:out value="${viaje.origen}"></c:out></td>
				<td><c:out value="${viaje.destino}"></c:out></td>
				<td><c:out value="${viaje.f_salida}"></c:out></td>
				<td><c:out value="${viaje.plazas_totales}"></c:out></td>
				<td><c:out value="${viaje.plazas_quedan}"></c:out></td>
				<td><c:out value="${viaje.precio}"></c:out></td>	
			</tr>
		</c:forEach>
	</table>
	
	<a href="newBook">Añadir nuevos libros al catálogo</a>
	<a href="shoppingCart">Añadir  libros al carrito de la compra</a>
	
</body>
</html>

