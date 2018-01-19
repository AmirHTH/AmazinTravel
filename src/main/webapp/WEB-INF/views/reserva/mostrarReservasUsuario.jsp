<%@ include file='../templates/_header.jsp'%>


	<h3><spring:message code="mostrarReservasUsuario.h3.titulo"/></h3>
	<p><spring:message code="mostrarReservasUsuario.descripcionPagina"/></p>
	
	
	<form action="mostrarReservasUsuario" method="post">
    	<p>
    		<label for="idUsuario"><spring:message code="mostrarReservasUsuario.form.idUsuario"/></label>
    		<input type="text" name="idUsuario" value="0" >
    	</p>
    	
    	<spring:message code="mostrarReservasUsuario.form.submit" var="submitText"/>
    	<p><input type="submit" value="${submitText}" /></p>
	</form>
	
	<c:choose>
		<c:when test="${not empty reservasUsuario}" >
			<h3><spring:message code="buscarViaje.h3.viajesIda"/></h3>
	
			<table>
				<tr>
					<th><spring:message code="reserva.numeroReserva"/></th>
					<th><spring:message code="reserva.identificadorViajeIda"/></th>
					<th><spring:message code="reserva.identificadorViajeVuelta"/></th>
					<th><spring:message code="reserva.plazasCompradas"/></th>
					<th><spring:message code="reserva.numeroMaletas15"/></th>
					<th><spring:message code="reserva.numeroMaletas20"/></th>
					<th><spring:message code="reserva.tipoCoche"/></th>
					<th><spring:message code="reserva.precioFinal"/></th>      
					<th><spring:message code="reserva.estado"/></th>		
				</tr>
			
				<c:forEach items="${reservasUsuario}" var="billete">
					<tr>						
						<td><c:out value="${billete.billeteId}"></c:out></td>
						<td><c:out value="${billete.viajeId}"></c:out></td>
						<td><c:out value="${billete.billeteVueltaId}"></c:out></td>
						<td><c:out value="${billete.plazas}"></c:out></td>
						<td><c:out value="${billete.numMaletas15}"></c:out></td>
						<td><c:out value="${billete.numMaletas20}"></c:out></td>
						<td><c:out value="${billete.cocheTipo}"></c:out></td>
						<td><c:out value="${billete.precioFinal}"></c:out></td>
						<td><c:out value="${billete.estado}"></c:out></td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<c:if test="${not empty param}">
				<h3><spring:message code="buscarViaje.h3.viajesIda"/></h3>
				<p><c:out value="${mensajeViajesIda}"/></p>
			</c:if>
		</c:otherwise>
	</c:choose>	

	
<%@ include file='../templates/_footer.jsp'%>

