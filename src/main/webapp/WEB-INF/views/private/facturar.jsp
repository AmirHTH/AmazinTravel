

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
	<title>Amazin</title>
</head>
<body>
	<center>
		<h1><spring:message code="title"/></h1>
		<br>
		<h2><spring:message code="welcome"/></h2>
	</center>
	<br>
	
	
	¿Desea facturar maletas?
	
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
		

	
	<!-- En caso de que hubiese algún mensaje de error, lo mostramos -->
	<p style="color: red;">
		<c:out value="${message}"/>
	</p>
	
</body>
</html>

