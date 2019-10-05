<%-- 
    Document   : comentarios
    Created on : 2/10/2019, 09:35:40 AM
    Author     : jhonny
--%>

<%@page import="servlets.iniciarSesion"%>
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
                 if(usuario.message==null){
        
            response.sendRedirect("../Jsp/index.jsp");
            if(iniciarSesion.tip.equals("Usuario")){
       response.sendRedirect("../Jsp/magazine.jsp");
       
       } 
        }
          
               
               %>
           
              <% 
               char as='"';    
          String cadenas=Character.toString(as);
          String id=request.getParameter("id");
              %>
        
          <header>
              
            <nav class="navegacion">
                    <ul class="menu">
 <% 
                           if(iniciarConeccion.coneccion==null){
                           iniciarConeccion.IniciarConeccion();
                           }
                        
                        out.print("<li><a href="+cadenas+"likes.jsp?id="+id+cadenas+">Likes</a></li>");
                        out.print("<li><a href="+cadenas+"comentarios.jsp?id="+id+cadenas+">Comentarios</a></li>");
                         out.print("<li><a href="+cadenas+"suscripciones.jsp?id="+id+cadenas+">Suscripcion</a></li>");
                         out.print("<li><a href="+cadenas+"ganancias.jsp?id="+id+cadenas+">Ganancias</a></li>");
                         out.print("<li><a href="+cadenas+"agregarRevista.jsp?id="+id+cadenas+">Agregar Revista</a></li>");
                       
                        %>                    </ul>
                </nav>  
          </header>           <br>
                        <h1 style="margin: auto; width: 90%">Listado de comentarios de revista</h1>
                        <br>
        <%HttpSession Sesions=request.getSession();
                  usuario tmp=new usuario();
                  tmp=usuario.userDatos(Sesions.getAttribute("usuario").toString());
                   char a='"';    
                String cadena=Character.toString(a);
                  
        %>  <div class="comentario">
            
              <form method="get" action="comentarios.jsp">
                        <input type="date" name="f1"  >
                        
                        <br>
                        <br>
                        
                        <input type="date" name="f2" >
                        <br>
                        <input type="submit" style="width:70px" value="Ok">
    <%out.print("<input type="+cadenas+"text"+cadenas+"name="+cadenas+"id"+cadenas+"style="+cadenas+"opacity: 0; "
            + "cursor: none; height: 0;"
            + ""+cadenas+" value="+cadenas+id+cadenas+" >");
                        
      %>                         
                      </form>  
                      <br>
           <% 
                       
                         HttpSession sesion=request.getSession();
                        String f1=null;
                        String f2=null;
                          try {
                               if(request.getParameter("f1")!=null){
                               f1=request.getParameter("f1");
                        f2=request.getParameter("f2");
                        
                               }
             String  sql="select comentario, user from comentario WHERE (idrevista=? && user=? "
                    + "&&( fecha between '"+f1+"' and  '"+f2+"' )) ";
         
                    
        
           PreparedStatement iniciarSesion=iniciarConeccion.coneccion.prepareStatement(sql);
           iniciarSesion.setInt(1,Integer.parseInt(request.getParameter("id")));
           iniciarSesion.setString(2, sesion.getAttribute("usuario").toString());
         
          
           ResultSet res=iniciarSesion.executeQuery();
           
          
           while(res.next()){
          out.print("<textarea title="+cadena+res.getString("user")+cadena+" disabled cols="+cadena+"30"+cadena+"rows="+cadena+"5"+cadena+">"+res.getString("comentario")
                  +"</textarea>");
           }
  
       } catch (SQLException ex) {
        
         }
                    

                    
%></div>
    </body>
</html>
