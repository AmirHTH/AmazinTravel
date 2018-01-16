<%@ include file='../templates/_header.jsp'%>
	<h3><spring:message code="buscarViaje.titulo"/></h3>
	<p><spring:message code="buscarViaje.descripcionPagina"/></p>


	
	Pagar Billete
	
	<p>Por favor, introduzca los datos de pago </p>
	
	<form:form action="pagarViaje" commandName="usuario">
		<form:errors path=""/>
		<br/>
		
		<p>Nombre: <form:input path="nombre" value="Amir"/> <form:errors path="nombre"/></p>
		
		<p>Apellidos: <form:input path="apellidos" value="Tofigh"/><form:errors path="apellidos"/></p>
		
		<p>N�mero Identificaci�n Personal: <form:input path="dni" value="789789789"/><form:errors path="dni"/></p>
		
		<p>Correo electr�nico: <form:input path="mail" value="amir@amazin.com"/><form:errors path="mail"/></p>
		
		<input type="submit" value="Pagar"/>
		
	</form:form>
		

	
	<!-- En caso de que hubiese alg�n mensaje de error, lo mostramos -->
	<p style="color: red;">
		<c:out value="${message}"/>
	</p>
	
<%@ include file='../templates/_footer.jsp'%>

