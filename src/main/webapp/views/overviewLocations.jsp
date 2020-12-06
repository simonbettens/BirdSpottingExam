<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Overview Bird Spotting Locations</title>
<spring:url value="/css/style.css" var="urlCss" />
<link rel="stylesheet" href="${urlCss}" type="text/css" />
</head>
<body>
	<h1>Overview of bird spotting locations</h1>
	<p>Please select your location to add a spotting</p>
	<table>
            <tr>
                <th>Location</th>
                <th>BirdsSpotted</th>
            </tr>

            <spring:url value="/birdspotting/" var="locationUrl" />
            <c:forEach items="${birdSpotLocationList}" var="bsl" varStatus="status">
                <tr>
                    <td>
                            <a href="${locationUrl}${bsl.name}">${bsl.name}</a>
                    </td> 
                <td>${bsl.spottedBirds}</td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <form action='logout' method='post'>
		<input type="submit" value="Stop spotting" /> 
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
</body>
</html>