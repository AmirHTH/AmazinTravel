<%@ include file='../templates/_header.jsp'%>


	<h3><spring:message code="buscarReserva.h3.titulo"/></h3>
	<p><spring:message code="buscarReserva.descripcionPagina"/></p>
	
	
	<form:form action="buscarReserva" commandName="paramBuscarReserva">
	
		<spring:hasBindErrors name="paramBuscarReserva">
			<section id="errors">
				<p><spring:message code="buscarReserva.mensajeErrorCabecera"/></p>
				<ul>
					<c:forEach var="error" items="${errors.allErrors}">
						<li><spring:message message="${error}" /></li>
					</c:forEach>
					
				</ul>
			</section>
	    </spring:hasBindErrors>
	
		<p>
			<form:label path="idReserva"><spring:message code="buscarReserva.form.idReserva"/></form:label>
			<form:input path="idReserva" value="${paramBuscarReserva.idReserva}"/>
		</p>
		
		<p>
			<form:label path="mail"><spring:message code="buscarReserva.form.mail"/></form:label>
			<form:input path="mail"  value="${paramBuscarReserva.mail}"/>
		</p>
		
		<p>
			<spring:message code="buscarReserva.form.submit" var="submitText"/>
			<input class="btn btn-dark btn-lg" name="submit" type="submit" value="${submitText}" />
		</p>
		
	</form:form>
	
	<c:if test="${not empty mensajeError}" >

		<spring:message code="${mensajeError}" var="mensajeErrorVar"/>
		<p><c:out value="${mensajeErrorVar}"/></p>
			
	</c:if>
	
	
	<c:if test="${not empty reservaBuscada }" >
	
		<h4><spring:message code="buscarReserva.h4"/></h4>
		<p><spring:message code="buscarReserva.resultadoBusquedaIntro"/></p>
	
		<%@ include file='../templates/_reserva.jsp'%>
		
		<c:choose>
			<c:when test="${reservaBuscada.estado =='Confirmado'}">
				<p><spring:message code="buscarReserva.cancelarReserva"/></p>
				<p><a class="btn btn-dark btn-lg" href="cancelarReserva"><spring:message code="reserva.cancelarReserva" /></a></p>
			</c:when>
			<c:otherwise>	
				<p><spring:message code="buscarReserva.reservaCanceladaPreviamente"/></p>
			</c:otherwise>
		</c:choose>
		
	</c:if>
	
	
		
	
<%@ include file='../templates/_footer.jsp'%>

