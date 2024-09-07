<%-- 
    Document   : operation
    Created on : 8 Jul 2024, 4:10:30 pm
    Author     : adity
--%>
<%@page errorPage="something_went_wrong.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>result Page</title>
    </head>
    <body>
        <%
            String n1 = request.getParameter("n1");
            String n2 = request.getParameter("n2");
            int a = Integer.parseInt(n1);
            int b = Integer.parseInt(n2);
            int c = a / b;
        %>
        <h1>Result is: <%= c%></h1>
    </body>
</html>
