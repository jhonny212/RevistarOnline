<%-- 
    Document   : hacerPago
    Created on : 1/10/2019, 07:43:50 PM
    Author     : jhonny
--%>

<%@page import="classes.revista"%>
<%@page import="classes.categoria"%>
<%@page import="java.util.LinkedList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../Css/admin.css">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="/Revistas/datos2" method="POST" >
              <div class="tarifa">
              
                       
               
    
                      
                </div>
                <table class="tabla"> 
                        <thead>
                                <tr>
                                    <th id="nombre">Usuario</th>
                                    <th id="descripcion">Nombre</th>
                                    <th id="pdf"> Hacer pago</th>
                                    
                                    
                                    </tr>
                            </thead>
                            <tbody >
                                    <%
                                            HttpSession Sesions=request.getSession();
                                    LinkedList <revista> tmp=revista.deudas(Sesions.getAttribute("usuario").toString());
                                 
                                char a='"';    
                                String cadena=Character.toString(a);
                                for(int i=0; i<tmp.size(); i++){
                                   out.print("<tr>"
                                           + "<td>"+tmp.get(i).getUser()+"</td>"
                                                   + "<td>"+tmp.get(i).getId()+"</td>"
                                                                   + "<td>  <input type="+cadena+"submit"+cadena+"name="+cadena+"btn"+cadena+"     value="+cadena+tmp.get(i).getId()+cadena+">"
                                                                   + "</tr>");
                                }
                                %>

                            </tbody>


                </table>
                                    
                           
                                <br>
            <div class="sub">
                <input type="date" name="fecha" required>
            </div>
            
        </form>
      
    </body>
</html>
