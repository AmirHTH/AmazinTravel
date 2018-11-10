<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file='templates/_header.jsp'%>

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
			<form:input path="origen" value="Praga"/>
			<form:label path="origen"><spring:message code="buscarViaje.form.destino"/></form:label>
			<form:input path="destino" value="Madrid"/>
			
		</p>
		<p>
			<form:label path="fechaIda"><spring:message code="buscarViaje.form.fechaIda"/></form:label>
			<form:input path="fechaIda" value="06-08-2018" />
			
			<form:label path="fechaVuelta"><spring:message code="buscarViaje.form.fechaVuelta"/></form:label>
			<form:input path="fechaVuelta" value="08-08-2018" />
		<p>
			<form:label path="plazas"><spring:message code="buscarViaje.form.plazas"/></form:label>
			<form:input path="plazas" value="1"/>
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
	
	
	<c:choose>
		<c:when test="${not empty destinosPopulares}" >
			<h3><spring:message code="inicio.h3.destinosPopulares"/></h3>
	
			<table class="table table-bordered table-condense">
				<tr>
					<th><spring:message code="inicio.tabla.plazasVendidas"/></th>
					<th><spring:message code="inicio.tabla.destino"/></th>
				</tr>
				
				<c:forEach items="${destinosPopulares}" var="destino">
					<tr>
						<td><c:out value="${destino.key}"></c:out></td>
						<td><c:out value="${destino.value}"></c:out></td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
	</c:choose>
	
	
	

<%@ include file='templates/_footer.jsp'%>