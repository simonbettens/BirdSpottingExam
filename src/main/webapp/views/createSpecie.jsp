<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<spring:url value="/css/style.css" var="urlCss" />
<link rel="stylesheet" href="${urlCss}" type="text/css" />
<title>Create specie</title>
</head>
<body>
<h1>Create new bird specie</h1>
<c:if test="${not empty message}">
		<p>${message}</p>
</c:if>
<spring:url value="/birdspotting/" var="locationUrl" />
<form:form method="post" action="${locationUrl}${name}/newbirdspotting"
		modelAttribute="birdSpecie">

		<p>
			<label>Specie:</label>
			<form:input path="name" size="20" />
			&nbsp;
			<form:errors path="name" cssClass="error" />
		</p>

		<p>
			<label>Year of discovery:</label>
			<form:input path="yearOfDiscovery" size="20" />
			&nbsp;
			<form:errors path="yearOfDiscovery" cssClass="error" />
		</p>

		<p>
			<label>Books of birds code:</label>
			<form:input path="code" size="20" />
			&nbsp;
			<form:errors path="code" cssClass="error" />
		</p>

		<p>
			<input type="submit" value="Spot new bird" />
		</p>

	</form:form>
</body>
</html>