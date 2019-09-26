<%-- 
    Document   : revistas
    Created on : 25/09/2019, 10:18:07 AM
    Author     : jhonny
--%>

<%@page import="java.util.LinkedList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%@page import="classes.categoria"  %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="../Css/estilos-revista.css" type="text/css" media="screen"/>
       
        <title>JSP Page</title>
    </head>
    <body>
         <%
                    LinkedList <String> tmp=categoria.llenarCatporRevista(request.getParameter("name"));
                   
                char a='"';    
                String cadena=Character.toString(a);
                for(int i=0; i<tmp.size(); i++){
                out.print("<li><a href="+cadena+"revistas.jsp?name="+tmp.get(i)+cadena +">"+tmp.get(i)+"</a></li>");
                }
                %>
                
                <div class="datagrid">
        <table>
            <thead>
                <tr>
                    <th>Nombre</th>
                    <th>descripcion</th>
                    <th>Pdf</th>
                    
                </tr>
            </thead>
           
            <tbody>
               
                <tr>
                  <td>
                  </td>
                  
                    <td>
                           
                      asdas
                    </td>
                    <td >dassssssssss</td>
                </tr>
                
            </tbody>
        </table>
    </div>
    </body>
</html>
