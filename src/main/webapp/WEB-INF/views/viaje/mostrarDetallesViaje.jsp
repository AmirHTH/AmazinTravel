<%@ include file='../templates/_header.jsp'%>

	<h3><spring:message code="detallesViaje.titulo"/></h3>
	<p><spring:message code="detallesViaje.descripcionPagina"/></p>
	
	
	<br> Tu billete:
	<br>
	
	<p>Billete Id: <c:out value="${billete.billeteId}"></c:out></p>
	<p>Viaje Id: <c:out value="${billete.viajeId}"></c:out></p>
	<p>Plazas Compradas: <c:out value="${billete.plazas}"></c:out></p>
	<p>Numero maletas 15 kg: <c:out value="${billete.numMaletas15}"></c:out></p>
	<p>Numero maletas 20 kg: <c:out value="${billete.numMaletas20}"></c:out></p>
	<p>Tipo de coche de alquiler: <c:out value="${billete.cocheTipo}"></c:out></p>
	<p>Precio Final: <c:out value="${billete.precioFinal}"></c:out></p>
	<p>Billete de Vuelta Id:<c:out value="${billete.billeteVueltaId}"></c:out></p>
	
	<c:choose>
		<c:when  test = "${estaConfirmado == 'Confirmado'}">
			<input type="button" value="Print this page" onClick="window.print()">
		</c:when>
		<c:otherwise>
			<p>
				<a href="facturar">Facturar Maletas</a>
				<a href="alquilarCoche">Contratar coche de alquiler</a>
				<a href="pagarViaje">Confirmar y Pagar</a>
			</p>
		</c:otherwise>
	</c:choose>
	
<%@ include file='../templates/_footer.jsp'%>
