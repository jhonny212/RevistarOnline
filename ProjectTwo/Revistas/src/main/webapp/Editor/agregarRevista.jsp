<%--
    Document   : agregarRevista
    Created on : 4/10/2019, 04:33:16 PM
    Author     : jhonny
--%>

<%@page import="classes.iniciarConeccion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <link rel="stylesheet" href="../Css/menu-bar-estilo.css">
               <link rel="stylesheet" href="../Css/revistaEstilo.css">
        <title>JSP Page</title>
    </head>
    <body>
          <header>

              <%
                   if(iniciarConeccion.coneccion==null){
                           iniciarConeccion.IniciarConeccion();
                           }
               char as='"';
          String cadenas=Character.toString(as);
          String id=request.getParameter("id");
              %>
            <nav class="navegacion">
                    <ul class="menu">
                       <%
                         out.print("<li><a href="+cadenas+"likes.jsp?id="+id+cadenas+">Likes</a></li>");
                        out.print("<li><a href="+cadenas+"comentarios.jsp?id="+id+cadenas+">Comentarios</a></li>");
                         out.print("<li><a href="+cadenas+"suscripciones.jsp?id="+id+cadenas+">Suscripcion</a></li>");
                         out.print("<li><a href="+cadenas+"ganancias.jsp?id="+id+cadenas+">Ganancias</a></li>");
                         out.print("<li><a href="+cadenas+"agregarRevista.jsp?id="+id+cadenas+">Agregar contenido de revista</a></li>");

                        %>

                    </ul>
                </nav>
    </header>
                        <div style="width: 100%; "><br>
                            <br>
                            <br>
                        <div style="margin:auto; width: 300px;">
                          <form class="" action="/Revistas/suscripciones" enctype="multipart/form-data" method="post">
                                  <%out.print("<input type="+cadenas+"text"+cadenas+"name="+cadenas+"id"+cadenas+"style="+cadenas+"opacity: 0; "
            + "cursor: none; height: 0;"
            + ""+cadenas+" value="+cadenas+id+cadenas+" >");
                        
      %> 
                            <input type="file" required name="archivo" >
                            <br>
                            <br>

                            <input type="submit"value="Cargar version" >

                          </form>
                        </div>
                      </div>
    </body>
</html>
