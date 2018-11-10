<%@ include file='../templates/_header.jsp'%>

	<h3><spring:message code="alquilar.h3.titulo"/></h3>
	<p><spring:message code="alquilar.h3.descripcionPagina"/></p>
	
	
	<form:form action="alquilarCoche" commandName="billete">
		<form:errors path=""/>
		<br/>
		
		<p>
		<label><spring:message code="alquilar.label"/></label>
		<form:select path="cocheTipo">		
			<option value="Ninguno"><spring:message code="alquilar.ninguno"/></option>
			<option value="Utilitario"><spring:message code="alquilar.utilitario"/></option>
			<option value="Furgoneta"><spring:message code="alquilar.furgoneta"/></option>
		</form:select>
		</p>

		<spring:message code="seleccionar" var="seleccionar"/>
		<input class="btn btn-dark btn-lg" type="submit" value="${seleccionar}"/>
	</form:form>
		

	
	<!-- En caso de que hubiese algún mensaje de error, lo mostramos -->
	<p style="color: red;">
		<c:out value="${message}"/>
	</p>
	
<%@ include file='../templates/_footer.jsp'%>


