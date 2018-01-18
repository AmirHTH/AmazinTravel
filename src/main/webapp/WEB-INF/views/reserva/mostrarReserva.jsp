<%@ include file='../templates/_header.jsp'%>

	<h3><spring:message code="buscarViaje.titulo"/></h3>
	<p><spring:message code="buscarViaje.descripcionPagina"/></p>
	
	<%@ include file='../templates/_reserva.jsp'%>
	
	<c:if test = "${estaConfirmado == 'Confirmado'}">
		<input type="button" value="Print this page" onClick="window.print()">
	</c:if>
	

<%@ include file='../templates/_footer.jsp'%>

