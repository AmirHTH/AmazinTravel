

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
		<h2>Bienvenido a la m�s peque�a tienda virtual del mundo</h2>
	</center>
	<br>
	<br> Nuestro cat�logo:
	<br>
	<table>
		<tr>
			<td><b>Titulo</b></td>
			<td><b>Autor</b></td>
			<td><b>Descripci�n</b></td>
			<td><b>Precio</b></td>
		</tr>
		<c:forEach items="${booklist}" var="book">
			<tr>
				<td><c:out value="${book.title}"></c:out></td>
				<td><c:out value="${book.author}"></c:out></td>
				<td><c:out value="${book.description}"></c:out></td>
				<td><c:out value="${book.price}"></c:out></td>
			</tr>
		</c:forEach>
	</table>
	
	<a href="newBook">A�adir nuevos libros al cat�logo</a>
	<a href="shoppingCart">A�adir  libros al carrito de la compra</a>
	
</body>
</html>

