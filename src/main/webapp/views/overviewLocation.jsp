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
<title>Overview Bird Spotting Location</title>
<spring:url value="/css/style.css" var="urlCss" />
<link rel="stylesheet" href="${urlCss}" type="text/css" />
</head>
<body>
	<h1>Overview of spotted birds in ${birdSpotLocation.name} </h1>
	<p><a href="/birdspotting/newbirdspotting">New spotting</a> - <a href="/birdspotting">Spotting locations overview</a></p>
	<table>
            <tr>
                <th>Index</th>
                <th>Specie</th>
                <th>Year of discovery</th>
                <th>Code index in the book of birds</th>
                <th>Spottings</th>
            </tr>

            
            <c:forEach items="${birdSpotLocation.spottedBirds}" var="bird" varStatus="status">
                <tr>
                    <td>
                          ${status.count}
                    </td> 
                	<td>${bird.birdSpecie.name}</td>
                	<td>${bird.birdSpecie.yearOfDiscovery}</td>
                	<td>${bird.birdSpecie.code}</td>
                	<td>${bird.count}</td>
            	</tr>
        </c:forEach>
    </table>
    <br>
</body>
</html>