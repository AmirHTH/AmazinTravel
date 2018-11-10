<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file='templates/_header.jsp'%>

	<h3>Registro de usuario nuevo</h3>
	
	<p>Hemos visto que eres un usuario nuevo. Por favor, rellena este formulario de registro para que puedas consultar posteriormente tus reservas.</p>

	<form:form action="registroEnCompra" commandName="usuario">
		<spring:hasBindErrors name="usuario">
			<section id="errors">
			 	<c:set var="validationErrors" value="true" />
				<p>No se ha podido registrar el usuario. Por favor, revise los errores</p>
				<ul>
					<c:forEach var="error" items="${errors.allErrors}">
						<li><spring:message message="${error}" /></li>
					</c:forEach>
					
				</ul>
			</section>
    	</spring:hasBindErrors>
		
		<p>
			<form:label path="nombre"><spring:message code="pagar.nombre"/></form:label>
			<form:input path="nombre" value="${usuario.nombre}" />
			<form:errors path="nombre" class="validationError"/>
		</p>
		<p>
			<form:label path="apellidos"><spring:message code="pagar.apellidos"/></form:label>
			<form:input path="apellidos" value="${usuario.apellidos}" />
			<form:errors path="apellidos" class="validationError"/>
		</p>
		<p>
			<form:label path="tipoDocumento"><spring:message code="pagar.tipoDocumento"/></form:label>
			<form:select path="tipoDocumento">		
			
				<c:choose>
					<c:when test="${usuario.tipoDocumento eq 'NIF'}">
	            		<option value="NIF" selected><spring:message code="pagar.nif"/></option>
	        		</c:when>
	        		<c:otherwise>
	          			<option value="NIF" selected><spring:message code="pagar.nif"/></option>
	        		</c:otherwise>
        		</c:choose>
        		
        		<c:choose>
					<c:when test="${usuario.tipoDocumento eq 'NIF'}">
	            		<option value="Pasaporte" selected><spring:message code="pagar.pasaporte"/></option>
	        		</c:when>
	        		<c:otherwise>
	          			<option value="Pasaporte"><spring:message code="pagar.pasaporte"/></option>
	        		</c:otherwise>
        		</c:choose>
        		
        		<c:choose>
					<c:when test="${usuario.tipoDocumento eq 'NIF'}">
	            		<option value="NIE" selected><spring:message code="pagar.nie"/></option>
	        		</c:when>
	        		<c:otherwise>
	          			<option value="NIE"><spring:message code="pagar.nie"/></option>
	        		</c:otherwise>
        		</c:choose>
			
			</form:select>
			 			
			<form:label path="dni"><spring:message code="pagar.numeroDocumento"/></form:label>
			<form:input path="dni" value="789789789" />
		</p>
		
		<p>
			<form:label path="mail"><spring:message code="pagar.correo"/></form:label>
			<form:input path="mail" value="${usuario.mail}" />
			<form:errors path="mail" class="validationError"/>
		</p>
		
		<p>
			<form:label path="password"><spring:message code="pagar.pass"/></form:label>
			<form:password path="password" />
			<form:errors path="password" class="validationError"/>
		</p>
		
		<p>
			<form:label path="passwordConfirmation"><spring:message code="pagar.confirmPass"/></form:label>
			<form:password path="passwordConfirmation" />
			<form:errors path="passwordConfirmation" class="validationError"/>
		</p>
		
		<spring:message code="pagar.form.submit" var="pagar"/>
		<input class="btn btn-dark btn-lg" type="submit" value="${pagar}" />	
		
	</form:form>		


</body>
</html>
