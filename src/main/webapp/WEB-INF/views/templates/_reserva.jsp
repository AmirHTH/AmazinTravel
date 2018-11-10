<p><span class="bold"><spring:message code="reserva.numeroReserva"/>:</span> <c:out value="${reservaBuscada.billeteId}"></c:out></p>
<div class="ficha">
	<h4><spring:message code="detallesViaje.viajeIda"/></h4>
	<p><span class="bold"><spring:message code="reserva.origen"/>:</span> <c:out value="${reservaBuscada.viajeIda.origen}"></c:out></p>
	<p><span class="bold"><spring:message code="reserva.destino"/>:</span> <c:out value="${reservaBuscada.viajeIda.destino}"></c:out></p>
	<p><span class="bold"><spring:message code="reserva.f_salida"/>:</span> <c:out value="${reservaBuscada.viajeIda.f_salida}"></c:out></p>
</div>

<div class="ficha">
	<h4><spring:message code="detallesViaje.viajeVuelta"/></h4>
	<p><span class="bold"><spring:message code="reserva.origen"/>:</span> <c:out value="${reservaBuscada.viajeVuelta.origen}"></c:out></p>
	<p><span class="bold"><spring:message code="reserva.destino"/>:</span> <c:out value="${reservaBuscada.viajeVuelta.destino}"></c:out></p>
	<p><span class="bold"><spring:message code="reserva.f_salida"/>:</span> <c:out value="${reservaBuscada.viajeVuelta.f_salida}"></c:out></p>
</div>

<div class="ficha">
	<h4><spring:message code="detallesViaje.otros"/></h4>
	<p><span class="bold"><spring:message code="reserva.plazasCompradas"/>:</span> <c:out value="${reservaBuscada.plazas}"></c:out></p>
	<p><span class="bold"><spring:message code="reserva.numeroMaletas15"/>:</span> <c:out value="${reservaBuscada.numMaletas15}"></c:out></p>
	<p><span class="bold"><spring:message code="reserva.numeroMaletas20"/>:</span> <c:out value="${reservaBuscada.numMaletas20}"></c:out></p>
	<p><span class="bold"><spring:message code="reserva.tipoCoche"/>:</span> <c:out value="${reservaBuscada.cocheTipo}"></c:out></p>
	<p><span class="bold"><spring:message code="reserva.precioFinal"/>:</span> <c:out value="${reservaBuscada.precioFinal}"></c:out></p>              
	
	<c:choose>
		<c:when  test = "${reservaBuscada.estado eq 'Confirmado'}">
			<p><span class="bold"><spring:message code="reserva.estado"/>:</span> <strong><spring:message code="reserva.estado.confirmado"/></strong></p>
		</c:when>
		<c:otherwise>
			<p><span class="bold"><spring:message code="reserva.estado"/>:</span> <strong><spring:message code="reserva.estado.cancelado"/></strong></p>
		</c:otherwise>
	</c:choose>
		
		
</div>
	