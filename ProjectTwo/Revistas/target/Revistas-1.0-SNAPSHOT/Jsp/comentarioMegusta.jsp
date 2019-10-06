<%-- 
    Document   : comentarioMegusta
    Created on : 2/10/2019, 12:01:37 AM
    Author     : jhonny
--%>

<%@page import="servlets.iniciarSesion"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="classes.iniciarConeccion"%>
<%@page import="java.sql.SQLException"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="classes.usuario"%>
<%@page  session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../Css/suscribir.css">
        <link rel="stylesheet" href="../Css/coment-like.css">
       
        <title>JSP Page</title>
    </head>
    <body>
           <%
        if(usuario.message==null){
        
            
            if(iniciarSesion.tip!=null){
                if(iniciarSesion.tip.equals("Usuario")){
     
       }else{
     
       response.sendRedirect("../Editor/Editor.jsp");
      
       } }else{
            
            response.sendRedirect("index.jsp");}
        }
         
         
               
               %>
         <%HttpSession Sesions=request.getSession();
                  usuario tmp=new usuario();
                  tmp=usuario.userDatos(Sesions.getAttribute("usuario").toString());
                   char a='"';    
                String cadena=Character.toString(a);
                  
        %>
        <div class="contenedor1">
          
        <div id="c1">
            <img src="/Revistas/perfilEditor?user="+<%= Sesions.getAttribute("usuario").toString()%>>
                    
        </div>
            
               <%String about=tmp.getSobreti();
               
                                                %> 
             
        <div id="c2">
            <label for="">Nombre</label> <input disabled type="text" <%out.print("value="+cadena+
                                                tmp.getNombre()+cadena);
                                                %>   >

            <label for="">direccion</label> <input disabled type="text"<%out.print("value="+cadena+
                                                tmp.getDireccion()+cadena);
                                                %>  >
         

            
            <label for="">Descripcion</label> 
  <textarea required disabled cols=40 rows=5
                                            
                                             >
                                                 <%out.print(
                                                tmp.getSobreti());
                                                %> 
                                   </textarea >

            <label for="">Sexo</label> <input disabled type="text" <%out.print("value="+cadena+
                                                tmp.getCorreo()+cadena);
                                                %> >


            <label for="">Nacimiento</label> <input disabled type="text" <%out.print("value="+cadena+
                                                tmp.getFecha()+cadena);
                                                %> >

            
         


        </div>
        <% 
        String ids=request.getParameter("id");
        out.print(ids+"holaaaaa");
        %>
       </div>
        
                 <div class="comentario">
                     
                     <form action="/Revistas/comentLike" class="likes" method="GET">
                          <input type="submit" id="boton" > 
                          
                          <input type="date" name="fecha" required >
               <input id="close" type="text" name="id" <%= "value="+cadena+ids+cadena %> >
                     <br>
                      </form>
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
                    

                    
                    %>
                    
                    
                   <form  method="POST" action="/Revistas/comentLike">
                        <textarea required name="comentar" id="" cols="30" rows="10"></textarea>
                       <input type="submit"  value="comentar">
                       <input type="date" name="fecha" required>
                       <input id="close" type="text" name="id" <%= "value="+cadena+ids+cadena %> >
                   </form>
                 </div>                               
    </body>
</html>
