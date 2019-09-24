<%-- 
    Document   : newjsp
    Created on : 23/09/2019, 10:18:46 PM
    Author     : jhonny
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="classes.usuario"  %>
<%@page  session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
           <%
        HttpSession sesion=request.getSession();
        out.print(usuario.message);
        
        out.print(sesion.getAttribute("usuario"));
        
        
        %>
        
    </body>
</html>
