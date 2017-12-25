

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
	<br> Su carrito de la compra:
	<br>
	<table>
		<tr>
			<td><b>Titulo</b></td>
			<td><b>Autor</b></td>
			<td><b>Cantidad</b></td>
		</tr>
		
		
		<c:forEach items="${shoppingCart.entries}" var="entry">
			<tr>
				<td><c:out value="${entry.key.title}"></c:out></td>
				<td><c:out value="${entry.key.author}"></c:out></td>
				<td><c:out value="${entry.value}"></c:out></td>
				
			</tr>
		</c:forEach>
	</table>
	<a href="seekBooks">Volver</a>
</body>
</html>

