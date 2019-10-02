<%-- 
    Document   : comentarios
    Created on : 2/10/2019, 09:35:40 AM
    Author     : jhonny
--%>

<%@page import="classes.usuario"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="classes.iniciarConeccion"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <link rel="stylesheet" href="../Css/suscribir.css">
        <link rel="stylesheet" href="../Css/coment-like.css">
            <link rel="stylesheet" href="../Css/menu-bar-estilo.css">
        <title>JSP Page</title>
    </head>
    <body>
           
              <% 
               char as='"';    
          String cadenas=Character.toString(as);
          String id=request.getParameter("id");
              %>
        
          <header>
              
            <nav class="navegacion">
                    <ul class="menu">
                       <% 
                         out.print("<li><a href="+cadenas+"likes.jsp?id="+id+cadenas+">Likes</a></li>");
                        out.print("<li><a href="+cadenas+"comentarios.jsp?id="+id+cadenas+">Comentadas</a></li>");
                         out.print("<li><a href="+cadenas+"suscripciones.jsp?id="+id+cadenas+">Suscrip</a></li>");
                       
                        %>
                                                    
                    </ul>
                </nav>  
    </header>
                        <h1>Listado de comentarios de revista</h1>
                        <h2>Puedes eliminar el comentario pulsando el boton correspondiente al comentario</h2>
        <%HttpSession Sesions=request.getSession();
                  usuario tmp=new usuario();
                  tmp=usuario.userDatos(Sesions.getAttribute("usuario").toString());
                   char a='"';    
                String cadena=Character.toString(a);
                  
        %>  <div class="comentario">
           <% 
                       
                         HttpSession sesion=request.getSession();
                        
                          try {
            String  sql="select comentario from comentario WHERE idrevista=? && user=? ";
                    
        
           PreparedStatement iniciarSesion=iniciarConeccion.coneccion.prepareStatement(sql);
           iniciarSesion.setInt(1,Integer.parseInt(request.getParameter("id")));
           iniciarSesion.setString(2, sesion.getAttribute("usuario").toString());
         
          
           ResultSet res=iniciarSesion.executeQuery();
           
          
           while(res.next()){
          out.print("<textarea disabled cols="+cadena+"30"+cadena+"rows="+cadena+"5"+cadena+">"+res.getString("comentario")
                  +"</textarea>");
           }
  
       } catch (SQLException ex) {
           out.print(ex.getMessage());
         }
                    

                    
%></div>
    </body>
</html>
