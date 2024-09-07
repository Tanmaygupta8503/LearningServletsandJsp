<%-- 
    Document   : error_page
    Created on : 8 Jul 2024, 2:56:23 pm
    Author     : adity
--%>
<%@page isErrorPage="true" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Something is Wrong</title>
    </head>
    <body>
        <h1 style='color:blue ; background: #e2e2e2'>Oops !! Something went wrong !!</h1>
        <h3><%= exception %></h3> <!--print the exception info--> 
    </body>
</html>
