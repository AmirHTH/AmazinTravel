<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!doctype html>
<html>
<head>
 	<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
	<title><spring:message code="title"/></title>
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link href="<c:url value="/resources/css/bootstrap/bootstrap.min.css" />" rel="stylesheet">
</head>
<body>
	<header>
		<p><a href="<c:url value="/"/>"><img src="<c:url value="/resources/images/amazin_logo2.png" />" /></a></p>
		<div id="barra_login">
			<sec:authorize access="!isAuthenticated()">
				<form name='loginForm' action="<c:url value='j_spring_security_check' />" method='POST'>
					<label><spring:message code="header.usuario"/></label>
					<input type='text' name='j_username' value=''>
					
					<label><spring:message code="header.pass"/></label>
					<input type='password' name='j_password' />
						
					<spring:message code="header.iniciarSesion" var="submitText"/>
					<input class="btn btn-dark btn-lg" name="submit" type="submit" value="${submitText}" />
				</form>
			</sec:authorize>
			
			<sec:authorize access="isAuthenticated()">
				<sec:authentication property="principal.username" />
				<a class="btn btn-dark btn-lg" href="<c:url value="/logout" />"><spring:message code="header.cerrarSesion"/></a>
			</sec:authorize>
			
		</div>
		
		<h1><spring:message code="title"/></h1>
		<h2><spring:message code="welcome"/></h2>
		
	</header>
	
	<nav>
		<ul>
			<li><a href="<c:url value="/"/>"><spring:message code="header.buscarViaje"/></a></li>
			<li><a href="buscarReserva"><spring:message code="header.cancelarReserva"/></a></li>
			<sec:authorize access="isAuthenticated()">
				<li><a href="mostrarReservasUsuario"><spring:message code="header.buscarReservasUsuario"/></a></li>
			</sec:authorize>
		</ul>
	</nav>
	
	<section>