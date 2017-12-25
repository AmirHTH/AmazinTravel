

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
	<br> El libro en oferta es...
	<br />
	<c:out value="${book.title }" />
	y lo puedes conseguir por
	<b><c:out value="${book.price }" /></b>
	<br />
</body>

</html>
