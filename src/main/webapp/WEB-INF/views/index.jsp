<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file='templates/_header.jsp'%>

	<h3><spring:message code="buscarViaje.titulo"/></h3>
	<p><spring:message code="buscarViaje.descripcionPagina"/></p>
	
	<form:form action="buscarViaje" commandName="paramBusquedaViaje" >	
		
		<spring:hasBindErrors name="paramBusquedaViaje">
			<section id="errors">
				<p><spring:message code="buscarViaje.mensajeErrorCabecera"/></p>
				<ul>
					<c:forEach var="error" items="${errors.allErrors}">
						<li><spring:message message="${error}" /></li>
					</c:forEach>
				</ul>
			</section>
    	</spring:hasBindErrors>

		<p>
			<form:label path="origen"><spring:message code="buscarViaje.form.origen"/></form:label>
			<form:input path="origen" value="Las Palmas"/>
			<form:label path="origen"><spring:message code="buscarViaje.form.destino"/></form:label>
			<form:input path="destino" value="Madrid"/>
			
		</p>
		<p>
			<form:label path="fechaIda"><spring:message code="buscarViaje.form.fechaIda"/></form:label>
			<form:input path="fechaIda" value="08-01-2017" />
			
			<form:label path="fechaVuelta"><spring:message code="buscarViaje.form.fechaVuelta"/></form:label>
			<form:input  path="fechaVuelta" value="12-01-2017"/>
		</p>
		<p>
			<form:label path="plazas"><spring:message code="buscarViaje.form.plazas"/></form:label>
			<form:input  path="plazas" value="1"/>
		</p>
		
		<fieldset>
            	<form:radiobutton path="tipo" value="vuelta" label="Ida y Vuelta" checked="checked"/>
            	<form:radiobutton path="tipo" value="solo_ida" label="Solo Ida" />
        </fieldset>
        
		<spring:message code="buscarViaje.form.submit" var="submitText"/>
		<input name="submit" type="submit" value="${submitText}" />
	</form:form>
	
	<form:form action="processForm" method="post" commandName="billete">
	<c:choose>
		<c:when test="${not empty viajesIdaList}" >
			<h3><spring:message code="buscarViaje.h3.viajesIda"/></h3>
	
			<table>
				<tr>
					<th></th>
					<th><spring:message code="buscarViaje.resultados.origen"/></th>
					<th><spring:message code="buscarViaje.resultados.destino"/></th>
					<th><spring:message code="buscarViaje.resultados.fechaSalida"/></th>
					<th><spring:message code="buscarViaje.resultados.plazasQuedan"/></th>
					<th><spring:message code="buscarViaje.resultados.plazasTotales"/></th>
					<th><spring:message code="buscarViaje.resultados.precio"/></th>
				</tr>
				
				<c:set var="selectFirstOne" value="true"/>
				<c:forEach items="${viajesIdaList}" var="viaje">
					<tr>
						<c:choose>
							<c:when test="${selectFirstOne = 'true'}">
								<td><form:radiobutton path="viajeId"  value="${viaje.viajeId}" name="viajeId" checked="checked" /></td>
								<c:set var="selectFirstOne" value="false"/>
							</c:when>
							<c:otherwise>
								<td><form:radiobutton path="viajeId"  value="${viaje.viajeId}" name="viajeId" /></td>
							</c:otherwise>
						</c:choose>
						
						<td><c:out value="${viaje.origen}"></c:out></td>
						<td><c:out value="${viaje.destino}"></c:out></td>
						<td><fmt:formatDate value="${viaje.f_salida}" pattern="yyyy-MM-dd HH:mm" /></td>
						<td><c:out value="${viaje.plazas_totales}"></c:out></td>
						<td><c:out value="${viaje.plazas_quedan}"></c:out></td>
						<td><c:out value="${viaje.precio}"></c:out></td>	
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
	
	<c:if test="${param.tipo eq 'vuelta'}">
		<form:input path="tipo" type="hidden" value="vuelta"/>
		<c:choose>
			<c:when test="${not empty viajesVueltaList }" >
			<h3><spring:message code="buscarViaje.h3.viajesVuelta"/></h3>
					
				<table>
				<tr>
					<th></th>
					<th><spring:message code="buscarViaje.resultados.origen"/></th>
					<th><spring:message code="buscarViaje.resultados.destino"/></th>
					<th><spring:message code="buscarViaje.resultados.fechaSalida"/></th>
					<th><spring:message code="buscarViaje.resultados.plazasQuedan"/></th>
					<th><spring:message code="buscarViaje.resultados.plazasTotales"/></th>
					<th><spring:message code="buscarViaje.resultados.precio"/></th>
				</tr>
				
				<c:forEach items="${viajesVueltaList}" var="viaje">
					<tr>
						<c:choose>
							<c:when test="${selectFirstOne = 'true'}">
								<td><form:radiobutton path="billeteVueltaId"  value="${viaje.viajeId}" name="billeteVueltaId" checked="checked"/></td>
								<c:set var="selectFirstOne" value="false"/>
							</c:when>
							<c:otherwise>
								<td><form:radiobutton path="billeteVueltaId"  value="${viaje.viajeId}" name="billeteVueltaId"/></td>
							</c:otherwise>
						</c:choose>
						<td><c:out value="${viaje.origen}"></c:out></td>
						<td><c:out value="${viaje.destino}"></c:out></td>
						<td><fmt:formatDate value="${viaje.f_salida}" pattern="yyyy-MM-dd HH:mm" /></td>
						<td><c:out value="${viaje.plazas_totales}"></c:out></td>
						<td><c:out value="${viaje.plazas_quedan}"></c:out></td>
						<td><c:out value="${viaje.precio}"></c:out></td>	
					</tr>
				</c:forEach>
			</table>
			</c:when>
			<c:otherwise>
				<h3><spring:message code="buscarViaje.h3.viajesVuelta"/></h3>
				<p><c:out value="${mensajeViajesVuelta}"/></p>
			</c:otherwise>
		</c:choose>
	</c:if>
	
	
	<c:if test="${not empty viajesIdaList || not empty viajesVueltaList }" >
		<p>
			<spring:message code="buscarViaje.button.facturar" var="facturar"/>
			<spring:message code="buscarViaje.button.alquilar" var="alquilar"/>
			<spring:message code="buscarViaje.button.detalles" var="detalles"/>
			
			<input name="facturar" type="submit" value="${facturar}" />	
			<input name="alquilarCoche" type="submit" value="${alquilar}" />
			<input name="detalles" type="submit" value="${detalles}" />			
		</p>
	</c:if>
	
	</form:form>
	
	
<%@ include file='templates/_footer.jsp'%>