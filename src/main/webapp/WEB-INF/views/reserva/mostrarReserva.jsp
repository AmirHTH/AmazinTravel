<%@ include file='../templates/_header.jsp'%>

	<h3><spring:message code="buscarViaje.titulo"/></h3>
	<p><spring:message code="buscarViaje.descripcionPagina"/></p>
	
	<p>Billete Id: <c:out value="${billete.billeteId}"></c:out></p>
	<p>Viaje Id: <c:out value="${billete.viajeId}"></c:out></p>
	<p>Plazas Compradas: <c:out value="${billete.plazas}"></c:out></p>
	<p>Numero maletas 15 kg: <c:out value="${billete.numMaletas15}"></c:out></p>
	<p>Numero maletas 20 kg: <c:out value="${billete.numMaletas20}"></c:out></p>
	<p>Tipo de coche de alquiler: <c:out value="${billete.cocheTipo}"></c:out></p>
	<p>Precio Final: <c:out value="${billete.precioFinal}"></c:out></p>
	<p>Billete de Vuelta Id:<c:out value="${billete.billeteVueltaId}"></c:out></p>
	<p>Estado:<c:out value="${billete.estado}"></c:out></p>
	
	<c:if test = "${estaConfirmado == 'Confirmado'}">
		<input type="button" value="Print this page" onClick="window.print()">
	</c:if>
	

<%@ include file='../templates/_footer.jsp'%>

