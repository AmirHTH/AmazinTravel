<%@ include file='../templates/_header.jsp'%>

	<h3><spring:message code="buscarViaje.titulo"/></h3>
	<p><spring:message code="buscarViaje.descripcionPagina"/></p>
	
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


