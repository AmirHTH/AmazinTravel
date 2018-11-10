 <%@ include file='../templates/_header.jsp'%>

	<h3><spring:message code="facturar.h3.titulo"/></h3>
	<p><spring:message code="facturar.h3.descripcionPagina"/></p>
	

	<form:form action="facturar" commandName="billete">
		<spring:hasBindErrors name="billete">
			<section id="errors">
				<ul>
					<c:forEach var="error" items="${errors.allErrors}">
						<li><spring:message message="${error}" /></li>
					</c:forEach>
				</ul>
			</section>
    	</spring:hasBindErrors>

		<p>
			<form:label path="numMaletas15"><spring:message code="facturar.tipo.normal"/></form:label>
			<form:select path="numMaletas15">		
				<c:forEach begin="0" end="20" var="i"> 
					<c:choose>
					    <c:when test="${i eq billete.numMaletas15}">
	            			<option value="${i}" selected>${i}</option>
	        			</c:when>
	        			<c:otherwise>
	          				<option value="${i}">${i}</option>
	        			</c:otherwise>
        			</c:choose>
				</c:forEach>
			</form:select>
			<spring:message code="facturar.tipo.maletas"/>
		</p>
		
		<p>
			<form:label path="numMaletas20"><spring:message code="facturar.tipo.grande"/></form:label>
			<form:select path="numMaletas20">		
				<c:forEach begin="0" end="20" var="i">
				    <c:choose>
					    <c:when test="${i eq billete.numMaletas20}">
	            			<option value="${i}" selected>${i}</option>
	        			</c:when>
	        			<c:otherwise>
	          				<option value="${i}">${i}</option>
	        			</c:otherwise>
        			</c:choose>
				</c:forEach>
			</form:select>
			<spring:message code="facturar.tipo.maletas"/>
		</p>
		
		<spring:message code="seleccionar" var="seleccionar"/>
		<input class="btn btn-dark btn-lg" type="submit" value="${seleccionar}"/>
		
	</form:form>
		
	
<%@ include file='../templates/_footer.jsp'%>
