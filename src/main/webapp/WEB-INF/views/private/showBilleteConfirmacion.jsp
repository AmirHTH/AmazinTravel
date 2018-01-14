
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
	
	<h2>Comprueba los datos de tu billete</h2>
	
	<p>Por favor, compruebe que todos los datos son correctos.: </p>
	
	<p>Código de Reserva: <c:out value="${billete.billeteId}"></c:out></p>
	<p>Viaje Id: <c:out value="${billete.viajeId}"></c:out></p>
	<p>Plazas Compradas: <c:out value="${billete.plazas}"></c:out></p>
	<p>Numero maletas 15 kg: <c:out value="${billete.numMaletas15}"></c:out></p>
	<p>Numero maletas 20 kg: <c:out value="${billete.numMaletas20}"></c:out></p>
	<p>Tipo de coche de alquiler: <c:out value="${billete.cocheTipo}"></c:out></p>
	<p>Precio Final: <c:out value="${billete.precioFinal}"></c:out></p>
	<p>Billete de Vuelta Id:<c:out value="${billete.billeteVueltaId}"></c:out></p>
	
	<h3>Datos de Cobro</h3>
	<p>Nombre: <c:out value="${usuario.nombre}"></c:out></p>
	<p>Apellidos: <c:out value="${usuario.apellidos}"></c:out></p>
	<p>Número de identificación: <c:out value="${usuario.dni}"></c:out></p>
	<p>Correo electrónico: <c:out value="${usuario.mail}"></c:out></p>

	<p>
		<a href="procesarBillete">Confirmar y Finalizar</a>
	</p>
	
</body>
</html>

