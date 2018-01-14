<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
 	<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
	<title>Amazin Travels!</title>
</head>
<body>
	<header>
		<p><img src="<c:url value="/resources/images/Amazin_logo.PNG" />" /></p>
		<h1><spring:message code="title"/></h1>
		<h2><spring:message code="welcome"/></h2>
	</header>
	
	<nav>
	</nav>
	
	<section>