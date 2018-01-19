<%@ include file='../templates/_header.jsp'%>


	<h3><spring:message code="pagar.h3.titulo"/></h3>
	<p><spring:message code="pagar.descripcionPagina"/></p>

	
	<form:form action="pagarViaje" commandName="usuario">
		<spring:hasBindErrors name="paramBusquedaViaje">
			<section id="errors">
				<p><spring:message code="pagar.mensajeErrorCabecera"/></p>
			</section>
    	</spring:hasBindErrors>
		
		<p>
			<form:label path="nombre"><spring:message code="pagar.nombre"/></form:label>
			<form:input path="nombre" value="Amir" />
			<form:errors path="nombre" class="validationError"/>
		</p>
		<p>
			<form:label path="apellidos"><spring:message code="pagar.apellidos"/></form:label>
			<form:input path="apellidos" value="Tofigh" />
			<form:errors path="apellidos" class="validationError"/>
		</p>
		<p>
			<form:label path="dni"><spring:message code="pagar.numeroIdentificacion"/></form:label>
			<form:input path="dni" value="789789789" />
			<form:errors path="dni" class="validationError"/>
		</p>
		
		<p>
			<form:label path="mail"><spring:message code="pagar.correo"/></form:label>
			<form:input path="mail" value="amir@amazin.com" />
			<form:errors path="mail" class="validationError"/>
		</p>
		
		<spring:message code="pagar.form.submit" var="pagar"/>
		<input type="submit" value="${pagar}" />	
		
	</form:form>		

	
<%@ include file='../templates/_footer.jsp'%>

