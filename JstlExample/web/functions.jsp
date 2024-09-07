<%-- 
    Document   : functions
    Created on : 10 Jul 2024, 12:17:56 pm
    Author     : adity
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <h1>
            <c:set var="name" value="TechSoft India"></c:set>
            <br> 
            <c:out value="${name}"></c:out>
            <br> 
            <c:out value="${fn:length(name)}"></c:out>
            <br>
            <c:out value="${fn:contains(name , 'India')}"></c:out>
            <br>
            <c:out value="${fn:toLowerCase(name)}"></c:out>            
        </h1>
        
    </body>
</html>
