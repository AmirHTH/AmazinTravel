<%@ include file='../templates/_header.jsp'%>

	<h3><spring:message code="mostrarReserva.h3.titulo"/></h3>
	<p><spring:message code="mostrarReserva.descripcionPagina"/></p>
	
	
	<%@ include file='../templates/_reserva.jsp'%>
	
	<c:if test="${estaConfirmado == 'Confirmado'}">
		<spring:message code="imprimir" var="imprimir" />
		<input type="submit" value="${imprimir}" onClick="window.print()" />
	
		<a href="<c:url value="enviarCorreo"/>"><spring:message code="enviarMail" /></a>
		
		<spring:message code="enviarMail" var="enviarMail" />
		<form action="enviarCorreo" method="post">
    		<input type="text" name="mail" >
    		<button type="submit" value="${enviarMail}">Search</button>
		</form>
		
		
	
</c:if>


<%@ include file='../templates/_footer.jsp'%>

