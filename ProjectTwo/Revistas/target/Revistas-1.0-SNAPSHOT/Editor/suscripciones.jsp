<%-- 
    Document   : suscripciones
    Created on : 2/10/2019, 09:36:10 AM
    Author     : jhonny
--%>

<%@page import="java.sql.PreparedStatement"%>
<%@page import="classes.iniciarConeccion"%>
<%@page import="classes.iniciarConeccion"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page  session="true" %>
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
                         out.print("<li><a href="+cadenas+"agregarRevista.jsp?id="+id+cadenas+">Agregar Revista</a></li>");
                       
                        %>
                        
                                                    
                    </ul>
                </nav>  
                        
                        
                        
                        
    </header>
                  <div class="KindRevistas">    
                        <%//out.print("<form method="+cadenas+"GET"+cadenas+"action="+cadenas+"suscripciones.jsp?id=3"+cadenas+id+cadenas+">");
                        
                        %>  
                        <form method="get" action="suscripciones.jsp">
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
          <table>
                    <thead>
                        <tr>
                            <th style="height: 30px; " id="nombre">Usuario suscrito</th>
                            <th id="descripcion">estado</th>
                            <th id="pdf">fecha suscripcion</th>
                            <th >id revsita</th>
                            <th >nombre</th>
                              
                            </tr>
                    </thead>

                    <tbody> 
      <% 
                       
     HttpSession sesion=request.getSession();
                       
                          try {
     String  sql=null;
  
    
     if(request.getParameter("f1")!=null){
      
         
          String f1=request.getParameter("f1").toString();
                        String f2=request.getParameter("f2").toString();
     sql="select a.user, a.estado, a.idrevista, a.fecha, b.username, b.nombre from suscripcion a join"
             + " revista b on b.idrevista=a.idrevista WHERE (username=? && (a.fecha between '"+f1+"' and  '"+f2+"'))"
             + " order by (a.idrevista);";
     
     }
     
    
      
           PreparedStatement iniciarSesion=iniciarConeccion.coneccion.prepareStatement(sql);
           iniciarSesion.setString(1,sesion.getAttribute("usuario").toString());
           
          
           ResultSet res=iniciarSesion.executeQuery();
           
          
           while(res.next()){
           
          out.print("<tr>"
                  + "<td style="+cadenas+"font-size: 20px; color:gray; text-align: center;height:30px"+cadenas+" >"+res.getString("user")+"</td>"
                  + "<td style="+cadenas+"font-size: 20px; color:gray;text-align: center;height:30px"+cadenas+">"+res.getString("estado")+"</td>"
                          + "<td style="+cadenas+"font-size: 20px;color:gray; text-align: center;height:30px"+cadenas+">"+res.getDate("fecha")+"</td>"
                                  + "<td style="+cadenas+"font-size: 20px;color:gray; text-align: center;height:30px"+cadenas+">"+res.getInt("idrevista")+"</td>"
                                          + "<td style="+cadenas+"font-size: 20px;color:gray; text-align: center;height:30px"+cadenas+">"+res.getString("nombre")+"</td></tr><br>");
           } 
          
           }
  
        catch (SQLException ex) {
         }
                    

                    
%> 
                    </tbody></table></div>
    </body>
</html>
