<%@ include file='../templates/_header.jsp'%>

	<h3><spring:message code="buscarViaje.titulo"/></h3>
	<p><spring:message code="buscarViaje.descripcionPagina"/></p>
	
	
	<form:form action="facturar" commandName="billete">
		<form:errors path=""/>
		<br/>
		
		<p>
		Maletas normales (15 kg.)
		<form:select path="numMaletas15">		
			<c:forEach begin="0" end="20" var="i">
			    <option value="${i}">${i}</option>
			</c:forEach>
		</form:select>
		</p>
		
		<p>
			Maletas normales (20 kg.)
			<form:select path="numMaletas20">		
				<c:forEach begin="0" end="20" var="i">
				    <option value="${i}">${i}</option>
				</c:forEach>
			</form:select>
		</p>
		<input type="submit" value="Seleccionar"/>
	</form:form>
		
	
<%@ include file='../templates/_footer.jsp'%>
