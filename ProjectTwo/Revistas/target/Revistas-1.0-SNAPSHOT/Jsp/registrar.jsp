<%-- 
    Document   : registrar
    Created on : 10/09/2019, 06:37:56 PM
    Author     : jhonny
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="classes.usuario"  %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
           <header>
        <nav class="navegacion">
                <ul class="menu">
                    <li><a href="#">Cerrar sesion</a></li>
                    <li><a href="#">Revistas</a></li>
                    <li><a href="#">perfil</a></li>
                    <li><a href="../Jsp/index.jsp">Inicio</a></li>
                                                
                </ul>
            </nav>  
</header>
        
        
        <div >
                  
                    <%@include  file="../Html/formregistro.html" %>
                    
                   
                    
        </div>
                    <%
                        if(usuario.message!=null){
                            if(usuario.message.equals("error")){
                     String alert="alert('"+"Este usuario ya existe"+"');";
                     out.print("<script>"+alert+"</script>");
                     
                            }   
                    usuario.message=null;
                        }
                     
                    %>
                    
                    <% 
                    HttpSession sesion=request.getSession();
                    
                    
                    if(sesion.getAttribute("usuario")!=null){
                   response.sendRedirect("magazine.jsp");
                    }
                    %>
   
    
             

     
       
    
    </body>
</html>
