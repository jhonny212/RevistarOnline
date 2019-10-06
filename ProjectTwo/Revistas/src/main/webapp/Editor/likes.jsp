<%-- 
    Document   : likes
    Created on : 2/10/2019, 09:36:21 AM
    Author     : jhonny
--%>

<%@page import="classes.usuario"%>
<%@page import="servlets.iniciarSesion"%>
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
               <link rel="stylesheet" href="../Css/revistaEstilo.css">
        <title>JSP Page</title>
    </head>
    <body>
          <header>
              
                 <%
                 if(usuario.message==null){
        
            if(iniciarSesion.tip!=null){
                    if(iniciarSesion.tip.equals("Usuario")){
       response.sendRedirect("../Jsp/magazine.jsp");
       
       }else{
       response.sendRedirect("../Jsp/index.jsp");
                    
                    }
            }
            
         
        }
          
               
               %>
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
                         out.print("<li><a href="+cadenas+"agregarRevista.jsp?id="+id+cadenas+">Agregar Revista</a></li>");
                       
                        %>
                            
                        
                        
                        
                
                                                    
                    </ul>
                </nav>  
    </header>
    <div class="KindRevistas">   
           <form method="get" action="likes.jsp">
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
                            <th style="height: 30px; " id="nombre">Revista mas pupular</th>
                            <th id="descripcion">cantidad de likes</th>
                         
                            <th id="pdf"> id</th>
                            
                            </tr>
                    </thead>

                    <tbody> 
                           <% 
                                  char a='"';    
                String c=Character.toString(a);
             HttpSession sesion=request.getSession();
               String f1=null;
                        String f2=null;
                        
                               if(request.getParameter("f1")!=null){
                               f1=request.getParameter("f1");
                        f2=request.getParameter("f2");
                        
                               }           
             
                          try {
          //  String  sql="select Ilike.idrevista, revista.nombre,  count(Ilike.idrevista) as total from Ilike  join revista "
            //        + " on revista.idrevista=Ilike.idrevista where (Ilike.editor=?  ) group by(Ilike.idrevista) desc;";
          String sql="select Ilike.idrevista , revista.nombre,  count(Ilike.idrevista) as total from Ilike  join revista  on revista.idrevista=Ilike.idrevista where ( Ilike.editor=? && (Ilike.fecha between '"+f1+"' and  '"+f2+"') )group by(Ilike.idrevista) order by (total) desc;";
            PreparedStatement iniciarSesion=iniciarConeccion.coneccion.prepareStatement(sql);
         iniciarSesion.setString(1,sesion.getAttribute("usuario").toString());
          
           ResultSet res=iniciarSesion.executeQuery();
           
          
           while(res.next()){
         // out.print("<img src="+cadenas+"../Imagenes/like.png"+cadenas+"title="+cadenas+res.getString("user")+cadenas+">");
          
          out.print("<tr>"
                  + "<td style="+c+"font-size: 20px; color:gray; text-align: center;height:30px"+c+" >"+res.getString("nombre")+"</td>"
                  + "<td style="+c+"font-size: 20px; color:gray;text-align: center;height:30px"+c+">"+res.getInt("total")+"</td>"
                          + ""
                          + "<td style="+c+"font-size: 20px;color:gray; text-align: center;height:30px"+c+">"+res.getInt("idrevista")+"</td></tr><br>");
           }
  
       } catch (SQLException ex) {
           out.print(ex.getMessage());
         }
%>
</tbody> </table>
</div>
    </body>
</html>
