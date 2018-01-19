<%@ include file='../templates/_header.jsp'%>

	<h3><spring:message code="confirmarViaje.h3.titulo"/></h3>
	<p><spring:message code="confirmarViaje.descripcionPagina"/></p>
	
	<p><spring:message code="detallesViaje.viajeIda"/> <c:out value="${billete.viajeId}"></c:out></p>
	<p><spring:message code="detallesViaje.viajeVuelta"/> <c:out value="${billete.billeteVueltaId}"></c:out></p>
	<p><spring:message code="detallesViaje.plazasCompradas"/> <c:out value="${billete.plazas}"></c:out></p>
	<p><spring:message code="detallesViaje.maletas15"/> <c:out value="${billete.numMaletas15}"></c:out></p>
	<p><spring:message code="detallesViaje.maletas20"/> <c:out value="${billete.numMaletas20}"></c:out></p>
	<p><spring:message code="detallesViaje.cocheAlquiler"/> <c:out value="${billete.cocheTipo}"></c:out></p>
	<p><spring:message code="detallesViaje.precioFinal"/> <c:out value="${billete.precioFinal}"></c:out></p>
	

	
	<h3><spring:message code="confirmarViaje.h3.datosCobro"/></h3>
	<p><spring:message code="pagar.nombre"/>: <c:out value="${usuario.nombre}"></c:out></p>
	<p><spring:message code="pagar.apellidos"/>: <c:out value="${usuario.apellidos}"></c:out></p>
	<p><spring:message code="pagar.numeroIdentificacion"/>: <c:out value="${usuario.dni}"></c:out></p>
	<p><spring:message code="pagar.correo"/>: <c:out value="${usuario.mail}"></c:out></p>


	<c:choose>
		<c:when  test = "${billete.confirmado}">
			<input type="button" value="Print this page" onClick="window.print()">
			<a href="enviarCorreo">Enviar confirmación de Billete por E-mail</a>
		</c:when>
		<c:otherwise>
			<p>
				<a href="procesarReserva">Confirmar y Finalizar</a>
			</p>
		</c:otherwise>
	</c:choose>
	
<%@ include file='../templates/_footer.jsp'%>


