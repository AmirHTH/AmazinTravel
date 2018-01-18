<%@ include file='../templates/_header.jsp'%>


	<h3><spring:message code="buscarReserva.h3.titulo"/></h3>
	<p><spring:message code="buscarReserva.descripcionPagina"/></p>
	
	
	<form:form action="buscarReserva" commandName="paramBuscarReserva">
	
		<spring:hasBindErrors name="paramBuscarReserva">
			<section id="errors">
				<p><spring:message code="buscarReserva.mensajeErrorCabecera"/></p>
			</section>
	    </spring:hasBindErrors>
	
		<p>
			<form:label path="idReserva"><spring:message code="buscarReserva.form.idReserva"/></form:label>
			<form:input path="idReserva" value="1"/> <form:errors class="validationError" path="idReserva"/>
		</p>
		
		<p>
			<form:label path="mail"><spring:message code="buscarReserva.form.mail"/></form:label>
			<form:input path="mail" value="amir@amazin.com"/><form:errors class="validationError" path="mail"/>
		</p>
		
		<p>
			<spring:message code="buscarReserva.form.submit" var="submitText"/>
			<input name="submit" type="submit" value="${submitText}" />
		</p>
		
	</form:form>
	
	
	<c:if test="${not empty billete }" >
	
		<%@ include file='../templates/_reserva.jsp'%>
		
		<c:choose>
			<c:when test="${billete.estado =='Confirmado'}">
				<p><spring:message code="buscarReserva.cancelarReserva"/></p>
				<p><a href="cancelarReserva"><spring:message code="reserva.cancelarReserva"/></p>
			</c:when>
			<c:otherwise>	
				<p><spring:message code="buscarReserva.reservaCanceladaPreviamente"/></p>
			</c:otherwise>
		</c:choose>
			
	</c:if>
		
	
<%@ include file='../templates/_footer.jsp'%>

