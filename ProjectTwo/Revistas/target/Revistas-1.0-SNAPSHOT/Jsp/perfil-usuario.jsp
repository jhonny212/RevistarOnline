<%-- 
    Document   : perfil-usuario
    Created on : 10/09/2019, 09:05:59 PM
    Author     : jhonny
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="classes.usuario"%>
<%@page  session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
           <link rel="stylesheet" href="../Css/menu-bar-estilo.css">
        <title>USUARIO</title>
    </head>
    <body>
       
                    <%HttpSession Sesions=request.getSession();
        %>
         <header>
                      
            <nav class="navegacion">
                    <ul class="menu">
                        <li><a href="#">Cerrar sesion</a></li>
                        <li><a href="magazine.jsp">Revistas</a></li>
                        <li><a href="perfil-usuario.jsp">perfil</a></li>
                                                    
                    </ul>
                </nav>  
    </header>
      
          
                 <% 
                     usuario tmp =new usuario();
                     tmp=usuario.perfil(Sesions.getAttribute("usuario").toString());
                     

                char a='"';    
                String cadena=Character.toString(a);
                
                    %>
    <form method="post"  action="/Revistas/imagen" enctype="multipart/form-data">
       <%@include  file="../Html/perfil-usuario.html" %>
    </form>         
    </body>
</html>
