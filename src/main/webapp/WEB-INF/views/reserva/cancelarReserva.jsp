<%@ include file='../templates/_header.jsp'%>

	<h3><spring:message code="buscarViaje.titulo"/></h3>
	<p><spring:message code="buscarViaje.descripcionPagina"/></p>
	
	<c:if test="${not empty reservaBuscada }" >
	
		<h3><spring:message code="reserva.cancelarReserva.h3"/></h3>
	
		<%@ include file='../templates/_reserva.jsp'%>		
		
		<a  class="btn btn-dark btn-lg" href="cancelarReserva"><spring:message code="reserva.cancelarReserva"/></a>
		
	</c:if>
	
<%@ include file='../templates/_footer.jsp'%>


