<%@ include file='../templates/_header.jsp'%>

	<h3><spring:message code="detallesViaje.h3.titulo"/></h3>
	<p><spring:message code="detallesViaje.descripcionPagina"/></p>
	
	
		<div class="ficha">
			<h4><spring:message code="detallesViaje.viajeIda"/></h4>
			<p><spring:message code="detallesViaje.origen"/>: <c:out value="${billete.viajeIda.origen}"></c:out></p>
			<p><spring:message code="detallesViaje.destino"/>: <c:out value="${billete.viajeIda.destino}"></c:out></p>
			<p><spring:message code="detallesViaje.f_salida"/>: <c:out value="${billete.viajeIda.f_salida}"></c:out></p>
		</div>

	
	
		<div class="ficha">
			<h4><spring:message code="detallesViaje.viajeVuelta"/></h4>
			<p><spring:message code="detallesViaje.origen"/>: <c:out value="${billete.viajeVuelta.origen}"></c:out></p>
			<p><spring:message code="detallesViaje.destino"/>: <c:out value="${billete.viajeVuelta.destino}"></c:out></p>
			<p><spring:message code="detallesViaje.f_salida"/>: <c:out value="${billete.viajeVuelta.f_salida}"></c:out></p>
		</div>
		
		
	<div class="ficha">
		<h4><spring:message code="detallesViaje.otros"/></h4>
		<p><spring:message code="detallesViaje.maletas15"/>: <c:out value="${billete.numMaletas15}"></c:out></p>
		<p><spring:message code="detallesViaje.maletas20"/>: <c:out value="${billete.numMaletas20}"></c:out></p>
		<p><spring:message code="detallesViaje.cocheAlquiler"/>: <c:out value="${billete.cocheTipo}"></c:out></p>
		<p><spring:message code="detallesViaje.precioFinal"/>: <c:out value="${billete.precioFinal}"></c:out></p>
	</div>
	
	<h4><spring:message code="detallesViaje.desglose"/></h4>
	
		<jsp:useBean id="BilleteClass" class="com.miw.model.Billete" scope="session"/>
		
		<table class="table table-bordered table-condense">
				<tr>
					<th><spring:message code="detallesViaje.desglose.Cantidad"/></th>
					<th><spring:message code="detallesViaje.desglose.Concepto"/></th>
					<th><spring:message code="detallesViaje.desglose.Precio"/></th>	
					<th><spring:message code="detallesViaje.desglose.Total"/></th>
				</tr>
				
				<tr>
					<td><c:out value="${billete.plazas}"></c:out></td>
					<td><spring:message code="detallesViaje.viajeIda"/>: <c:out value="${billete.viajeIda.origen}" /> - <c:out value="${billete.viajeIda.destino}" /></td>
					<td class="alinear_derecha"><c:out value="${billete.viajeIda.precio}" /> Euros</td>
					<td class="alinear_derecha"><c:out value="${billete.plazas * billete.viajeIda.precio}"></c:out> Euros</td>
				</tr>
				<c:if test="${billete.tipo == 'vuelta'}">
					<tr>
						<td><c:out value="${billete.plazas}"></c:out></td>
						<td><spring:message code="detallesViaje.viajeVuelta"/>: <c:out value="${billete.viajeVuelta.origen}" /> - <c:out value="${billete.viajeVuelta.destino}" /></td>
						<td class="alinear_derecha"><c:out value="${billete.viajeVuelta.precio}" /> <spring:message code="detallesViaje.desglose.euros"/></td>
						<td class="alinear_derecha"><c:out value="${billete.plazas * billete.viajeVuelta.precio}"></c:out> <spring:message code="detallesViaje.desglose.euros"/></td>
					</tr>
				</c:if>
				<tr>
					<td><c:out value="${billete.numMaletas15}"></c:out></td>
					<td><spring:message code="detallesViaje.maletas15"/></td>
					<td class="alinear_derecha"><c:out value="${billete.precioMaleta15}" /> <spring:message code="detallesViaje.desglose.euros"/></td>
					<td class="alinear_derecha"><c:out value="${billete.numMaletas15 * billete.precioMaleta15}"></c:out> <spring:message code="detallesViaje.desglose.euros"/></td>
				</tr>
				<tr>
					<td><c:out value="${billete.numMaletas20}"></c:out></td>
					<td><spring:message code="detallesViaje.maletas20"/></td>
					<td class="alinear_derecha"><c:out value="${billete.precioMaleta20}" /> <spring:message code="detallesViaje.desglose.euros"/></td>
					<td class="alinear_derecha"><c:out value="${billete.numMaletas20 * billete.precioMaleta20}"></c:out> <spring:message code="detallesViaje.desglose.euros"/></td>
				</tr>
				<tr>
					<td>
						<c:choose>
						    <c:when test="${billete.cocheTipo=='Ninguno'}">
						    	<c:set var="vehiculos" scope="session" value="0"/>
						        0
						    </c:when>    
						    <c:otherwise>
						    	<c:set var="vehiculos" scope="session" value="1"/>
						    	1
						    </c:otherwise>
						</c:choose>
					</td>
					<td><spring:message code="detallesViaje.vehiculo"/>: <c:out value="${billete.cocheTipo}" /></td>
					<td class="alinear_derecha">
						<c:choose>
						    <c:when test="${billete.cocheTipo=='Ninguno'}">
						         <c:set var="precioVehiculo" scope="session" value="0"/>
						    </c:when>    
						    <c:otherwise>
						    	<c:choose>
								    <c:when test="${billete.cocheTipo=='Utilitario'}">
								        <c:set var="precioVehiculo" scope="session" value="${billete.precioCocheAlquilerUtilitario}"/>  
								    </c:when>    
								    <c:otherwise>
								    	<c:set var="precioVehiculo" scope="session" value="${billete.precioCocheAlquilerFurgoneta}"/>
								    </c:otherwise>
								</c:choose>
						    </c:otherwise>
						</c:choose>
						
						<c:out value="${precioVehiculo}" /> <spring:message code="detallesViaje.desglose.euros"/>
						
					</td>
					<td class="alinear_derecha"><c:out value="${vehiculos * precioVehiculo}"></c:out> <spring:message code="detallesViaje.desglose.euros"/></td>
				</tr>
				<tr>
					<td colspan="3">Total</td>
					<td class="alinear_derecha"><c:out value="${billete.precioFinal}"></c:out> <spring:message code="detallesViaje.desglose.euros"/></td>
				</tr>
		</table>
	
	
	<c:choose>
		<c:when  test = "${estaConfirmado == 'Confirmado'}">
			<spring:message code="imprimir" var="imprimir" />
		
			<spring:message code="enviarMail" var="enviarMail" />
			<form action="enviarCorreo" method="post">
	    		<input class="btn btn-dark btn-lg" type="text" name="mail" >
	    		<input class="btn btn-dark btn-lg" type="submit" value="${enviarMail}" />
	    		<button class="btn btn-dark btn-lg" type="button" onClick="window.print()" ><c:out value="${imprimir}" /></button>
			</form>
		</c:when>
		<c:otherwise>
			<p>
				<a class="btn btn-dark btn-lg" href="<c:url value="facturar"/>"><spring:message code="detallesViaje.facturar"/></a>
				<a class="btn btn-dark btn-lg" href="<c:url value="alquilarCoche"/>"><spring:message code="detallesViaje.alquilarCoche"/></a>
				<a class="btn btn-dark btn-lg" href="<c:url value="pagarViaje"/>"><spring:message code="detallesViaje.confirmar"/></a>				
			</p>
		</c:otherwise>
	</c:choose>
	
<%@ include file='../templates/_footer.jsp'%>
