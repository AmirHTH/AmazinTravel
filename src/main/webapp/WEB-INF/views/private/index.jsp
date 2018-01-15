<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Amazin Travels</title>
</head>
<body>
		<h1><spring:message code="title"/></h1>
		<br>
		<h2><spring:message code="welcome"/></h2>
	<br />
	<br /> <spring:message code="choose.option"/>
	
	<br />
	<a href="seekBooks"><spring:message code="show.catalog"/></a>
	<br />
	<a href="showSpecialOffer"><spring:message code="show.offers"/>s</a>
	<a href="seekAllViajes"><spring:message code="show.seekViajes"/>s</a>
	<a href="seekViajes"><spring:message code="show.seekViajes"/>s</a>
	
	<a href="buscarReserva"><spring:message code="cancelarReserva"/></a>
	
	<a href="cancelarReserva"><spring:message code="cancelarReserva"/></a>
	
	
</body>
</html>