<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Amazin Travels</title>
</head>
<body>
	<center>
		<h1><spring:message code="title"/></h1>
		<br>
		<h2><spring:message code="welcome"/></h2>
	</center>
	<br />
	<br /> <spring:message code="choose.option"/>
	
	<br />
	<a href="seekBooks"><spring:message code="show.catalog"/></a>
	<br />
	<a href="showSpecialOffer"><spring:message code="show.offers"/>s</a>

</body>
</html>