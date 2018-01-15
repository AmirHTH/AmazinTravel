

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
		
		<p>Correo electr�nico: <form:input path="mail" value="amir@amazin.com"/><form:errors path="mail"/></p>
		
		<input type="submit" value="Buscar"/>
		
	</form:form>
	
	<c:if test="${not empty reservaBuscada }" >
		<p>C�digo de Reserva: <c:out value="${reservaBuscada.billeteId}"></c:out></p>
		<p>Viaje Id: <c:out value="${reservaBuscada.viajeId}"></c:out></p>
		<p>Plazas Compradas: <c:out value="${reservaBuscada.plazas}"></c:out></p>
		<p>Numero maletas 15 kg: <c:out value="${reservaBuscada.numMaletas15}"></c:out></p>
		<p>Numero maletas 20 kg: <c:out value="${reservaBuscada.numMaletas20}"></c:out></p>
		<p>Tipo de coche de alquiler: <c:out value="${reservaBuscada.cocheTipo}"></c:out></p>
		<p>Precio Final: <c:out value="${reservaBuscada.precioFinal}"></c:out></p>
		<p>Billete de Vuelta Id:<c:out value="${reservaBuscada.billeteVueltaId}"></c:out></p>
	</c:if>
		
	<a href="cancelarReserva"><spring:message code="reserva.cancelarReserva"/>s</a>
	
	<!-- En caso de que hubiese alg�n mensaje de error, lo mostramos -->
	<p style="color: red;">
		<c:out value="${message}"/>
	</p>
	
</body>
</html>

