<%-- 
    Document   : second
    Created on : 8 Jul 2024, 11:46:46 am
    Author     : adity
--%>

<%@page import="java.util.Random,java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Directives</title>
    </head>
    <body>
        <%@include file="./header.jsp" %>
        <h1>Random number</h1>
        <h1>
            <%
                Random r = new Random();
                int n = r.nextInt(10);
            %>
            <%= n%>
        </h1>
    </body>
</html>
