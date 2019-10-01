<%-- 
    Document   : registrar
    Created on : 1/10/2019, 08:01:43 AM
    Author     : jhonny
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
    <link rel="stylesheet" href="../Css/menu-bar-estilo.css">
    <link rel="stylesheet" href="../Css/formregistro.css">
        <title>JSP Page</title>
    </head>
    <body>
        <form class="formbox" action="/Revistas/admin" method="GET">
                <h1 id="titulo">REGISTRAR</h1>
                <input type ="text" id="nombre" name="nombre" placeholder=" nombre completo" required /> 
                <input type ="text" id="user" name="user" placeholder=" nombre usuario" required/> 
                
                
                <input type ="password" id="contraseña" name="password" placeholder=" contraseña " required/>
              
                
                <button type="submit" name="btn" >Registrar</button>
              
               
              </form>
    </body>
</html>
