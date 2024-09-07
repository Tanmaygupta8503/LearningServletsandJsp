<%-- 
    Document   : taglib.jsp
    Created on : 8 Jul 2024, 1:38:16 pm
    Author     : adity
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page errorPage="./error_page.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Taglib Directives tutorials</title>
    </head>
    <body>
        <h1>Taglib Directives tutorials</h1>
        <hr><!-- comment -->
        <c:set var="name" value="Tanmay Gupta"></c:set>
        
        <c:out value="${name}"></c:out>
        
        <c:if test="${3<2}">
            <h2> This is True block for 3 > 2 </h2>
        </c:if>
            
        <%! 
            int a = 100;
            int b = 0;
        %>
        <h1><%= a/b %></h1>
    </body>
</html>
