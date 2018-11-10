<%@ include file='../templates/_header.jsp'%>

	<h3><spring:message code="confirmarViaje.h3.titulo"/></h3>
	<p><spring:message code="confirmarViaje.descripcionPagina"/></p>
	
	<div class="ficha">

			<h4><spring:message code="detallesViaje.viajeIda"/></h4>
				<p><spring:message code="detallesViaje.viajeIda"/>: <c:out value="${billete.viajeIda.origen}"></c:out></p>
				<p><spring:message code="detallesViaje.viajeIda"/>: <c:out value="${billete.viajeIda.destino}"></c:out></p>
				<p><spring:message code="detallesViaje.viajeIda"/>: <c:out value="${billete.viajeIda.f_salida}"></c:out></p>

		

			<h4><spring:message code="detallesViaje.viajeVuelta"/></h4>
				<p><spring:message code="detallesViaje.viajeVuelta"/>: <c:out value="${billete.viajeVuelta.origen}"></c:out></p>
				<p><spring:message code="detallesViaje.viajeVuelta"/>: <c:out value="${billete.viajeVuelta.destino}"></c:out></p>
				<p><spring:message code="detallesViaje.viajeVuelta"/>: <c:out value="${billete.viajeVuelta.f_salida}"></c:out></p>
		
		<h4><spring:message code="detallesViaje.otros"/></h4>
			<p><spring:message code="detallesViaje.plazasCompradas"/> <c:out value="${billete.plazas}"></c:out></p>
			<p><spring:message code="detallesViaje.maletas15"/> <c:out value="${billete.numMaletas15}"></c:out></p>
			<p><spring:message code="detallesViaje.maletas20"/> <c:out value="${billete.numMaletas20}"></c:out></p>
			<p><spring:message code="detallesViaje.cocheAlquiler"/> <c:out value="${billete.cocheTipo}"></c:out></p>
			<p><spring:message code="detallesViaje.precioFinal"/> <c:out value="${billete.precioFinal}"></c:out></p>
	</div>

	
	<h3><spring:message code="confirmarViaje.h3.datosCobro"/></h3>
	<div class="ficha">
		<p><spring:message code="pagar.nombre"/>: <c:out value="${usuario.nombre}"></c:out></p>
		<p><spring:message code="pagar.apellidos"/>: <c:out value="${usuario.apellidos}"></c:out></p>		
		
		<c:choose>
			<c:when  test = "${usuario.tipoDocumento eq 'nif'}">
				<p><spring:message code="pagar.tipoDocumento"/>: <spring:message code="pagar.nif"/></p>
			</c:when>
			<c:when  test = "${usuario.tipoDocumento eq 'pasaporte'}">
				<p><spring:message code="pagar.tipoDocumento"/>: <spring:message code="pagar.pasaporte"/></p>
			</c:when>
			<c:otherwise>
				<p><spring:message code="pagar.tipoDocumento"/>: <spring:message code="pagar.nie"/></p>
			</c:otherwise>
		</c:choose>
		
		<p><spring:message code="pagar.numeroDocumento"/>: <c:out value="${usuario.dni}"></c:out></p>
		<p><spring:message code="pagar.correo"/>: <c:out value="${usuario.mail}"></c:out></p>
	</div>

	<c:choose>
		<c:when  test = "${billete.confirmado}">
			<spring:message code="imprimir" var="imprimir" />
		
			<spring:message code="enviarMail" var="enviarMail" />
			<form action="enviarCorreo" method="post">
	    		<input class="btn btn-dark btn-lg" type="text" name="mail" >
	    		<button class="btn btn-dark btn-lg" type="submit" value="${enviarMail}"><spring:message code="enviarMail" /></button>
	    		<button class="btn btn-dark btn-lg" type="button" onClick="window.print()" ><c:out value="${imprimir}" /></button>
			</form>
		</c:when>
		<c:otherwise>
			<p>
				<a class="btn btn-dark btn-lg" href="procesarReserva"><spring:message code="confirmarViaje.confirmar"/></a>
			</p>
		</c:otherwise>
	</c:choose>
	
<%@ include file='../templates/_footer.jsp'%>


