<%@ include file='../templates/_header.jsp'%>

	<h3><spring:message code="buscarViaje.titulo"/></h3>
	<p><spring:message code="buscarViaje.descripcionPagina"/></p>
	
	
	
	
	
	<c:if test="${not empty billete }" >
	
	<h2>Confirme que desea cancelar la reserva</h2>
	
		<%@ include file='../templates/_reserva.jsp'%>		
		
		<a href="cancelarReserva"><spring:message code="reserva.cancelarReserva"/></a>
		
	</c:if>
		

	
	
<%@ include file='../templates/_footer.jsp'%>


