<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
 	<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
	<title><spring:message code="title"/></title>
</head>
<body>
	<header>
		<p><img src="<c:url value="/resources/images/Amazin_logo.PNG" />" /></p>
		<h1><spring:message code="title"/></h1>
		<h2><spring:message code="welcome"/></h2>
	</header>
	
	<nav>
		<ul>
			<li><a href="<c:url value="/"/>"><spring:message code="header.buscarViaje"/></a></li>
			<li><a href="buscarReserva"><spring:message code="header.buscarReserva"/></a></li>
			<li><a href="cancelarReserva"><spring:message code="header.cancelarReserva"/></a></li>
		</ul>
	</nav>
	
	<section>