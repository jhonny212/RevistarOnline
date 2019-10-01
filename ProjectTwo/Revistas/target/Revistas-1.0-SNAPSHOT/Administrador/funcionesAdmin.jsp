<%-- 
    Document   : funcionesAdmin
    Created on : 1/10/2019, 08:38:10 AM
    Author     : jhonny
--%>

<%@page import="classes.revista"%>
<%@page import="java.util.LinkedList"%>
<%@page import="classes.categoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../Css/admin.css">
        
        <title>actualizar datos</title>
    </head>
    <body>
        <br>
        <br>
         
<h1>Tarifas Globales</h1>
    
<form action="/Revistas/datos" method="POST">
        <div class="actualizar-datos">
            <div>
                    <label > Porcentaje de ganancia </label> 
                    <label > Tarifa costo por dia </label> 
                   
            </div>
                   
            <div>
                
                    <input type="number" name="porcentaje" value="0" >
                    <input type="number" name="costo" value="0" >
                   
            </div>
        </div>
        <div class="sub">
            <input type="submit" value="actualizar">
        </div>
    </form>
    <br>
 
<h1>
    Costo de suscripcion
</h1>
    <form action="/Revistas/datos" method="GET">
            <div class="tarifa">
              
                       
               
    
                      
                </div>
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
