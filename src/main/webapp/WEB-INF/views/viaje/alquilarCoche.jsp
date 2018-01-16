<%@ include file='../templates/_header.jsp'%>

	<h3><spring:message code="buscarViaje.titulo"/></h3>
	<p><spring:message code="buscarViaje.descripcionPagina"/></p>
	
	¿Qué coche desea alquilar?
	
	<form:form action="alquilarCoche" commandName="billete">
		<form:errors path=""/>
		<br/>
		
		<p>
		<form:select path="cocheTipo">		
			<option value="Ninguno">Ninguno</option>
			<option value="Utilitario">Utilitario</option>
			<option value="Furgoneta">Furgoneta</option>
		</form:select>
		</p>

		<input type="submit" value="Seleccionar"/>
	</form:form>
		

	
	<!-- En caso de que hubiese algún mensaje de error, lo mostramos -->
	<p style="color: red;">
		<c:out value="${message}"/>
	</p>
	
<%@ include file='../templates/_footer.jsp'%>


