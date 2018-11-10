<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ include file='../templates/_header.jsp'%>

	<h3><spring:message code="buscarViaje.titulo"/></h3>
	<p><spring:message code="buscarViaje.descripcionPagina"/></p>
	
	<form:form action="buscarViaje" commandName="paramBusquedaViaje" >	
		<spring:hasBindErrors name="paramBusquedaViaje">
			<section id="errors">
			 	<c:set var="validationErrors" value="true" />
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
			<form:input path="origen" value="${paramBusquedaViaje.origen}"/>
			<form:label path="origen"><spring:message code="buscarViaje.form.destino"/></form:label>
			<form:input path="destino" value="${paramBusquedaViaje.destino}"/>
			
		</p>
		<p>
			<form:label path="fechaIda"><spring:message code="buscarViaje.form.fechaIda"/></form:label>
			<fmt:formatDate pattern="dd-MM-yyyy" value="${paramBusquedaViaje.fechaIda}" var="parsedFechaIda" />
			<form:input path="fechaIda" value="${parsedFechaIda}" />
			
			<form:label path="fechaVuelta"><spring:message code="buscarViaje.form.fechaVuelta"/></form:label>
			<fmt:formatDate pattern="dd-MM-yyyy" value="${paramBusquedaViaje.fechaVuelta}" var="parsedFechaVuelta" />
			<form:input  path="fechaVuelta" value="${parsedFechaVuelta}" />
		</p>
		<p>
			<form:label path="plazas"><spring:message code="buscarViaje.form.plazas"/></form:label>
			<form:input  path="plazas" value="${paramBusquedaViaje.plazas}"/>
		</p>
		
		<fieldset>
				<spring:message code="buscarViaje.form.idaVuelta" var="radioButtonIdaVuelta"/>
				<spring:message code="buscarViaje.form.soloIda" var="radioButtonSoloIda"/>
            	<form:radiobutton path="tipo" value="vuelta" label="${radioButtonIdaVuelta}" checked="checked"/>
            	<form:radiobutton path="tipo" value="solo_ida" label="${radioButtonSoloIda}" />
        </fieldset>
        
		<spring:message code="buscarViaje.form.submit" var="submitText"/>
		<input class="btn btn-dark btn-lg" name="submit" type="submit" value="${submitText}" />
	</form:form>
	
	<c:if test="${not empty viajesIdaList}" >
		<section id="imagenes_destinos">	
			<h4><spring:message code="buscarViaje.resultados.queVer"/> <c:out value="${paramBusquedaViaje.destino}"/></h4>	
			<c:set var="destino" value="${paramBusquedaViaje.destino}"/>
			<c:set var="destinoSinEspacios" value="${fn:replace(paramBusquedaViaje.destino, ' ', '')}"/>
	        <c:set var="destinoMinusculas" value="${fn:toLowerCase(destinoSinEspacios)}"/>
			<c:forEach begin="1" end="3" var="i">
				<img src="/amazin/resources/images/destinos/${destinoMinusculas}/${destinoMinusculas}${i}.jpg" />
			</c:forEach>
			<p></p>
		</section>
	</c:if>
	

	
	
	
	<c:if test="${!validationErrors}">
		<form:form action="processForm" method="post" commandName="billete">
			<c:choose>
				<c:when test="${not empty viajesIdaList}" >
					<h3><spring:message code="buscarViaje.h3.viajesIda"/></h3>
			
					<table class="table table-bordered table-condense">
						<tr>
							<th></th>
							<th><spring:message code="buscarViaje.resultados.origen"/></th>
							<th><spring:message code="buscarViaje.resultados.destino"/></th>
							<th><spring:message code="buscarViaje.resultados.fechaSalida"/></th>	
							<th><spring:message code="buscarViaje.resultados.plazasTotales"/></th>
							<th><spring:message code="buscarViaje.resultados.plazasQuedan"/></th>
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
						<spring:message code="${mensajeViajesIda}" var="mensajeViajesIdaVar"/>
						<p><c:out value="${mensajeViajesIdaVar}"/></p>
					
					</c:if>
				</c:otherwise>
			</c:choose>
	
			<c:if test="${param.tipo eq 'vuelta'}">
				<form:input path="tipo" type="hidden" value="vuelta"/>
				<c:choose>
					<c:when test="${not empty viajesVueltaList }" >
						<h3><spring:message code="buscarViaje.h3.viajesVuelta"/></h3>
								
							<table class="table table-bordered table-condense">
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
		
			<c:choose>
				<c:when test="${empty viajesIdaList && not empty viajesVueltaList && paramBusquedaViaje.tipo == 'vuelta'}" >
					<p><spring:message code="buscarViaje.mensaje.viajeIdaNoEncontrado"/></p>
					
				</c:when>
				
				<c:when test="${not empty viajesIdaList && empty viajesVueltaList && paramBusquedaViaje.tipo == 'vuelta'}" >
					<p><spring:message code="buscarViaje.mensaje.viajeVueltaNoEncontrado"/></p>
					
				</c:when>
				
				
				<c:when test="${not empty viajesIdaList && empty viajesVueltaList && paramBusquedaViaje.tipo == 'solo_ida'}" >
					<p>
						<spring:message code="buscarViaje.button.facturar" var="facturar"/>
						<spring:message code="buscarViaje.button.alquilar" var="alquilar"/>
						<spring:message code="buscarViaje.button.detalles" var="detalles"/>
						
						<input class="btn btn-dark btn-lg" name="facturar" type="submit" value="${facturar}" />	
						<input class="btn btn-dark btn-lg" name="alquilarCoche" type="submit" value="${alquilar}" />
						<input class="btn btn-dark btn-lg" name="detalles" type="submit" value="${detalles}" />			
					</p>
					
					<p>
						<spring:message code="imprimir" var="imprimir"/>
						<button class="btn btn-dark btn-lg" type="button" onClick="window.print()" ><c:out value="${imprimir}" /></button>
					</p>
					
				</c:when>
				<c:when test="${not empty viajesIdaList && not empty viajesVueltaList && paramBusquedaViaje.tipo=='vuelta'}" >
					<p>
						<spring:message code="buscarViaje.button.facturar" var="facturar"/>
						<spring:message code="buscarViaje.button.alquilar" var="alquilar"/>
						<spring:message code="buscarViaje.button.detalles" var="detalles"/>
						
						<input class="btn btn-dark btn-lg" name="facturar" type="submit" value="${facturar}" />	
						<input class="btn btn-dark btn-lg" name="alquilarCoche" type="submit" value="${alquilar}" />
						<input class="btn btn-dark btn-lg" name="detalles" type="submit" value="${detalles}" />			
					</p>
					
					<p>
						<spring:message code="imprimir" var="imprimir"/>
						<button class="btn btn-dark btn-lg" type="button" onClick="window.print()" ><c:out value="${imprimir}" /></button>
					</p>
					
				</c:when>
				<c:otherwise>
					
				</c:otherwise>
			</c:choose>
		</form:form>
	</c:if>

<%@ include file='../templates/_footer.jsp'%>