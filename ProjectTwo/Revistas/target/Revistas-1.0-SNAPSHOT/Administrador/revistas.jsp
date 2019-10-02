<%-- 
    Document   : revistas
    Created on : 1/10/2019, 10:34:22 AM
    Author     : jhonny
--%>

<%@page import="java.util.LinkedList"%>
<%@page import="classes.revista"%>
<%@page import="classes.categoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <link rel="stylesheet" href="../Css/admin.css">
        <title>JSP Page</title>
    </head>
    <body>
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
