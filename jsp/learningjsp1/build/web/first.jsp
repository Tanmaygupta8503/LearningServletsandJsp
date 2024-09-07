<%-- 
    Document   : first.jsp
    Created on : 7 Jul 2024, 11:40:41 pm
    Author     : adity
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style='background: #e2e2e2'> 
        <%! // declarative tag
            int a = 10;
            int b = 30;

            public int doSum(int a, int b) {
                return a + b;
            }
            String name = "Tanmay Gupta";

            public String reverse(String s) {
                StringBuffer sb = new StringBuffer(s);
                return sb.reverse().toString();
            }
        %>
        
        <% // scriptlet Tag
            out.print("<h1> "+a+"+"+b+"="+""+doSum(a , b)+"</h1>");
        %>
        <h1 style='color: red'>
            <%= 
            // scriptlet tag
            "my mane is "+ name + " " + "and reverse is " +reverse(name)
            %>
        </h1>
    </body>
</html>
