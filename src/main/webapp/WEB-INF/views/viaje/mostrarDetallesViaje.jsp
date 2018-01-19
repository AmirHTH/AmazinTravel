<%@ include file='../templates/_header.jsp'%>

	<h3><spring:message code="detallesViaje.h3.titulo"/></h3>
	<p><spring:message code="detallesViaje.descripcionPagina"/></p>
	
	
	<p><spring:message code="detallesViaje.viajeIda"/> <c:out value="${billete.viajeId}"></c:out></p>
	<p><spring:message code="detallesViaje.viajeVuelta"/> <c:out value="${billete.billeteVueltaId}"></c:out></p>
	<p><spring:message code="detallesViaje.plazasCompradas"/> <c:out value="${billete.plazas}"></c:out></p>
	<p><spring:message code="detallesViaje.maletas15"/> <c:out value="${billete.numMaletas15}"></c:out></p>
	<p><spring:message code="detallesViaje.maletas20"/> <c:out value="${billete.numMaletas20}"></c:out></p>
	<p><spring:message code="detallesViaje.cocheAlquiler"/> <c:out value="${billete.cocheTipo}"></c:out></p>
	<p><spring:message code="detallesViaje.precioFinal"/> <c:out value="${billete.precioFinal}"></c:out></p>
	
	
	<c:choose>
		<c:when  test = "${estaConfirmado == 'Confirmado'}">
			<input type="button" value="Print this page" onClick="window.print()">
		</c:when>
		<c:otherwise>
			<p>
				<a href="<c:url value="facturar"/>"><spring:message code="detallesViaje.facturar"/></a>
				<a href="<c:url value="alquilarCoche"/>"><spring:message code="detallesViaje.alquilarCoche"/></a>
				<a href="<c:url value="pagarViaje"/>"><spring:message code="detallesViaje.confirmar"/></a>				
			</p>
		</c:otherwise>
	</c:choose>
	
<%@ include file='../templates/_footer.jsp'%>
