<%-- 
    Document   : revistas
    Created on : 1/10/2019, 10:34:22 AM
    Author     : jhonny
--%>

<%@page import="classes.iniciarConeccion"%>
<%@page import="java.util.LinkedList"%>
<%@page import="classes.revista"%>
<%@page import="classes.categoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../Css/menu-bar-estilo.css">
           
            <link rel="stylesheet" href="../Css/admin.css">
        <title>JSP Page</title>
    </head>
    <body>
         <header>
              
              <% 
               char as='"';    
          String cadenas=Character.toString(as);
          String id=request.getParameter("id");
              %>
            <nav class="navegacion">
                    <ul class="menu">
                       <% 
                           if(iniciarConeccion.coneccion==null){
                           iniciarConeccion.IniciarConeccion();
                           }
                        out.print("<li><a href="+cadenas+"comentadas.jsp?id="+id+cadenas+">comentarios</a></li>");
                        out.print("<li><a href="+cadenas+"fijarCosto.jsp?id="+id+cadenas+">fijar costos</a></li>");
                         out.print("<li><a href="+cadenas+"funcionesAdmin.jsp?id="+id+cadenas+">funciones admin</a></li>");
                         out.print("<li><a href="+cadenas+"ganancias.jsp?id="+id+cadenas+">Ganancias</a></li>");
                         out.print("<li><a href="+cadenas+"likes.jsp?id="+id+cadenas+">likes</a></li>");
                         out.print("<li><a href="+cadenas+"revistas.jsp?id="+id+cadenas+">revistas</a></li>");
                         %>
                            
                        
                        
                
                                                    
                    </ul>
                </nav>  
    </header>
        <h1>Costo por dia de una revista</h1>
        <form action="/Revistas/datos2" method="GET">
           
                <table class="tabla"> 
                        <thead>
                                <tr>
                                    <th id="nombre">Usuario</th>
                                    <th id="descripcion">Nombre</th>
                                    <th id="pdf"> id-revista</th>
                                    <th id="pdf"> actualizar</th>
                                    
                                    
                                    </tr>
                            </thead>
                            <tbody >
                                    <%
   
                                    LinkedList <revista> tmp=categoria.llenarCatporRevistas();
                                   
                                char a='"';    
                                String cadena=Character.toString(a);
                                for(int i=0; i<tmp.size(); i++){
                                   out.print("<tr>"
                                           + "<td>"+tmp.get(i).getUser()+"</td>"
                                                   + "<td>"+tmp.get(i).getNombre()+"</td>"
                                                           + "<td>"+tmp.get(i).getId()+"</td>"
                                                                   + "<td>  <input type="+cadena+"submit"+cadena+"name="+cadena+"btn"+cadena+"     value="+cadena+tmp.get(i).getId()+cadena+">"
                                                                   + "</tr>");
                                }
                                %>

                            </tbody>


                </table>
                                    
                           
                                <br>
            <div class="sub">
            <input type="number" name="costos" value="0" placeholder="pulsa 0 para usar la tarifa global">
            </div>
        </form>
    </body>
</html>
