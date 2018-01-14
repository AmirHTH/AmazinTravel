
<%@ include file='header.jsp'%>
	
	<form:form commandName="paramBusquedaViaje" >	
		
		<spring:hasBindErrors name="paramBusquedaViaje">
			<section id="errors">
				<p>No hemos podido buscar su viaje. Por favor, revise los siguientes errores:</p>
				<ul>
					<c:forEach var="error" items="${errors.allErrors}">
						<li><spring:message message="${error}" /></li>
					</c:forEach>
				</ul>
			</section>
    	</spring:hasBindErrors>

		<p>Origen: <form:input  path="origen" value="Las Palmas"/>Destino: <form:input  path="destino"/> </p>
		<p>Fecha Ida: <form:input type="date"  path="fechaIda" value="12-01-2017" />Fecha Vuelta: <form:input  type="date" path="fechaVuelta" value="12-01-2017"/></p>
		Numero de Plazas: <form:input  path="plazas" value="1"/>
		
		<fieldset>
            	<form:radiobutton path="tipo" value="vuelta" label="Ida y Vuelta" checked="checked"/>
            	<form:radiobutton path="tipo" value="solo_ida" label="Solo Ida" />
        </fieldset>
		
		<input name="submit" type="submit" value="Buscar" />
	</form:form>
	
	<form:form action="processForm" method="post" commandName="billete">
	<c:choose>
		<c:when test="${not empty viajesIdaList}" >
			<h3>Viajes Ida</h3>
				
			<table>
				<tr>
					<td></td>
					<td>Origen</td>
					<td>Destino</td>
					<td>Fecha Salida</td>
					<td>Plazas Quedan</td>
					<td>Plazas Totales</td>
					<td>Precio</td>
				</tr>
				
				<c:forEach items="${viajesIdaList}" var="viaje">
					<tr>
						<td><form:radiobutton path="viajeId"  value="${viaje.viajeId}" /></td>
						<td><c:out value="${viaje.origen}"></c:out></td>
						<td><c:out value="${viaje.destino}"></c:out></td>
						<td><c:out value="${viaje.f_salida}"></c:out></td>
						<td><c:out value="${viaje.plazas_totales}"></c:out></td>
						<td><c:out value="${viaje.plazas_quedan}"></c:out></td>
						<td><c:out value="${viaje.precio}"></c:out></td>	
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<c:if test="${not empty param}">
				<h3>Viajes Ida</h3>
				<p><c:out value="${mensajeViajesIda}"/></p>
			</c:if>
		</c:otherwise>
	</c:choose>
	
	<c:if test="${param.tipo eq 'vuelta'}">
		<form:input path="tipo" type="hidden" value="vuelta"/>
		<c:choose>
			<c:when test="${not empty viajesVueltaList }" >
			<h3>Viajes Vuelta</h3>
					
				<table>
				<tr>
					<td></td>
					<td>Origen</td>
					<td>Destino</td>
					<td>Fecha Llegada</td>
					<td>Plazas Quedan</td>
					<td>Plazas Totales</td>
					<td>Precio</td>
				</tr>
				
				<c:forEach items="${viajesVueltaList}" var="viaje">
					<tr>
						<td><form:radiobutton path="billeteVueltaId"  value="${viaje.viajeId}" /></td>
						<td><c:out value="${viaje.origen}"></c:out></td>
						<td><c:out value="${viaje.destino}"></c:out></td>
						<td><c:out value="${viaje.f_salida}"></c:out></td>
						<td><c:out value="${viaje.plazas_totales}"></c:out></td>
						<td><c:out value="${viaje.plazas_quedan}"></c:out></td>
						<td><c:out value="${viaje.precio}"></c:out></td>	
					</tr>
				</c:forEach>
			</table>
			</c:when>
			<c:otherwise>
				<h3>Viajes Vuelta</h3>
				<p><c:out value="${mensajeViajesVuelta}"/></p>
			</c:otherwise>
		</c:choose>
	</c:if>
	
	
	<c:if test="${not empty viajesIdaList || not empty viajesVueltaList }" >
		<p>
			<input name="facturar" type="submit" value="Facturar Equipaje Adicional" />	
			<input name="alquilarCoche" type="submit" value="Contratar Coche de Alquiler" />
			<input name="confirmar" type="submit" value="Confirmar" />			
		</p>
	</c:if>
	
	</form:form>
	
</body>
</html>

