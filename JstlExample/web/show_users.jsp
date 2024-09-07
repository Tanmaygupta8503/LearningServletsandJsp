<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>All users are:</h1>
        <sql:setDataSource driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/registration" var="ds" user="root" password="root"/>
        <sql:query var="rs" dataSource="${ds}">SELECT DISTINCT name, id , email FROM users</sql:query>
        <table border="1">
            <tr>
                <th>User ID</th>
                <th>User Name</th>
                <th>User Email</th>
            </tr>
            <c:forEach items="${rs.rows}" var="row">
                <tr>
                    <td><c:out value="${row.id}"/></td>
                    <td><c:out value="${row.name}"/></td>
                    <td><c:out value="${row.email}"/></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
