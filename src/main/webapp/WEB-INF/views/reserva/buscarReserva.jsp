<%@ include file='../templates/_header.jsp'%>


	<h3><spring:message code="buscarViaje.titulo"/></h3>
	<p><spring:message code="buscarViaje.descripcionPagina"/></p>
	
	Buscar Reserva
	

	
	
	<form:form action="buscarReserva" commandName="paramBuscarReserva">
	
		<spring:hasBindErrors name="paramBuscarReserva">
			<section id="errors">
				<p><spring:message code="confirmarReservs.mensajeErrorCabecera"/></p>
			</section>
	    </spring:hasBindErrors>
	

		
		<p>Identificador Reserva: <form:input path="idReserva" value="1"/> <form:errors class="validationError" path="idReserva"/></p>
		
		<p>Correo electrónico: <form:input path="mail" value="amir@amazin.com"/><form:errors class="validationError" path="mail"/></p>
		
		<input type="submit" value="Buscar"/>
		
	</form:form>
	
	<c:if test="${not empty reservaBuscada }" >
		<p>Código de Reserva: <c:out value="${reservaBuscada.billeteId}"></c:out></p>
		<p>Viaje Id: <c:out value="${reservaBuscada.viajeId}"></c:out></p>
		<p>Plazas Compradas: <c:out value="${reservaBuscada.plazas}"></c:out></p>
		<p>Numero maletas 15 kg: <c:out value="${reservaBuscada.numMaletas15}"></c:out></p>
		<p>Numero maletas 20 kg: <c:out value="${reservaBuscada.numMaletas20}"></c:out></p>
		<p>Tipo de coche de alquiler: <c:out value="${reservaBuscada.cocheTipo}"></c:out></p>
		<p>Precio Final: <c:out value="${reservaBuscada.precioFinal}"></c:out></p>
		<p>Billete de Vuelta Id:<c:out value="${reservaBuscada.billeteVueltaId}"></c:out></p>
		<p>Estado:<c:out value="${reservaBuscada.estado}"></c:out></p>
			
		<c:if test="${reservaBuscada.estado =='Confirmado'}" >
			<a href="cancelarReserva"><spring:message code="reserva.cancelarReserva"/>s</a>
		</c:if>
			
	</c:if>
		
	
<%@ include file='../templates/_footer.jsp'%>

