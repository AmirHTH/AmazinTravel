<%@ include file='../templates/_header.jsp'%>


	<h3><spring:message code="mostrarReservasUsuario.h3.titulo"/></h3>
	<p><spring:message code="mostrarReservasUsuario.descripcionPagina"/></p>
	
	
	<c:choose>
		<c:when test="${not empty reservasUsuario}" >
	
			<table class="table table-bordered table-condense">
				<tr>
					<th><spring:message code="reserva.numeroReserva"/></th>
					<th><spring:message code="reserva.viajeIda"/></th>
					<th><spring:message code="reserva.viajeVuelta"/></th>
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
						<td><c:out value="${billete.viajeIda.origen}"></c:out> - <c:out value="${billete.viajeIda.destino}"></c:out></td>
						<td><c:out value="${billete.viajeVuelta.origen}"></c:out> - <c:out value="${billete.viajeVuelta.destino}"></c:out></td>
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
				<p><spring:message code="mostrarReservasUsuario.no_reserva_encontrada"/></p>
			</c:if>
		</c:otherwise>
	</c:choose>	

	
<%@ include file='../templates/_footer.jsp'%>

