<%@ include file='../templates/_header.jsp'%>

	<h3><spring:message code="mostrarReserva.h3.titulo"/></h3>
	<p><spring:message code="mostrarReserva.descripcionPagina"/></p>
	
	<%@ include file='../templates/_reserva.jsp'%>
	
	<c:if test="${reservaBuscada.estado == 'Confirmado'}">
		<spring:message code="imprimir" var="imprimir" />
		
		<spring:message code="enviarMail" var="enviarMail" />
		<form action="enviarCorreo" method="post">
    		<input class="btn btn-dark btn-lg" type="email" name="mail" required />
    		<input class="btn btn-dark btn-lg" type="submit" value="${enviarMail}" />
    		<button class="btn btn-dark btn-lg" type="button" onClick="window.print()" ><c:out value="${imprimir}" /></button>
		</form>
	</c:if>


<%@ include file='../templates/_footer.jsp'%>

