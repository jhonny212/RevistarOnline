<%-- 
    Document   : likes
    Created on : 2/10/2019, 09:36:21 AM
    Author     : jhonny
--%>

<%@page import="java.sql.PreparedStatement"%>
<%@page import="classes.iniciarConeccion"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page  session="true" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
           <link rel="stylesheet" href="../Css/menu-bar-estilo.css">
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
                         out.print("<li><a href="+cadenas+"likes.jsp?id="+id+cadenas+">Likes</a></li>");
                        out.print("<li><a href="+cadenas+"comentarios.jsp?id="+id+cadenas+">Comentadas</a></li>");
                         out.print("<li><a href="+cadenas+"suscripciones.jsp?id="+id+cadenas+">Suscrip</a></li>");
                       
                        %>
                            
                        
                        
                           <% 
                       
                         HttpSession sesion=request.getSession();
                        
                          try {
            String  sql="select user from Ilike WHERE idrevista=? ";
                    
        
           PreparedStatement iniciarSesion=iniciarConeccion.coneccion.prepareStatement(sql);
           iniciarSesion.setInt(1,Integer.parseInt(request.getParameter("id")));
           iniciarSesion.setString(2, sesion.getAttribute("usuario").toString());
         
          
           ResultSet res=iniciarSesion.executeQuery();
           
          
           while(res.next()){
          out.print("<textarea disabled cols="+cadenas+"30"+cadenas+"rows="+cadenas+"5"+cadenas+">"+res.getString("comentario")
                  +"</textarea>");
           }
  
       } catch (SQLException ex) {
           out.print(ex.getMessage());
         }
                    

                    
%>
                                                    
                    </ul>
                </nav>  
    </header>
    </body>
</html>
