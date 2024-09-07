<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <!-- 1.<p:set>-->
        <!-- 2.<p:out>-->
        <!-- 3.<p:choose>-->
        <!-- 4.<p:when>-->
        <!-- 5.<p:otherwise>-->
        <!--6.<p:forEach>-->
        <!--6.<p:url>-->
        <!--6.<p:param>-->
        <!--6.<p:url>-->
        
        
        <c:set var="i" value="0" scope="application"></c:set>
        <h1><c:out value="${i}"></c:out></h1>
        <c:if test="${i >= 23}">
            <h1> This is true block i >= 23</h1>
        </c:if>
        <c:choose>
            <c:when test="${i > 0}">
                <h1>This is positive block</h1>
            </c:when>
            <c:when test="${i < 0}">
                <h1>This is negative block</h1>
            </c:when>
            <c:otherwise>
                <h1>This is zero</h1>
            </c:otherwise>
        </c:choose>
        <c:forEach var="j" begin="1" end="10">
            <h1>value of j : <c:out value="${j}"></c:out></h1>
        </c:forEach>
            
        <c:url var="myurl" value="https://www.google.com/search">
            <c:param name="q" value="learn code with durgesh servlet"></c:param>
        </c:url>
        <h1><c:out value="${myurl}"></c:out></h1>
        <%--<c:redirect url="${myurl}"></c:redirect>--%>
    </body>
</html>
