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
        
        
        
        <div >
                  
                    <%@include  file="../Html/formregistro.html" %>
                    
                   
                    
        </div>
                    <% int a;
                    a=2;
                    
                     if(usuario.getMessage()!=null){
                     String alert="alert('"+"Este usuario ya existe"+"');";
                     out.print("<script>"+alert+"</script>");
                     }   
                    
                    %>
   
    
             

     
       
    
    </body>
</html>
