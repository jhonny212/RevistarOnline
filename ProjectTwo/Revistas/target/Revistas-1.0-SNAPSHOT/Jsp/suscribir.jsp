<%-- 
    Document   : suscribir
    Created on : 30/09/2019, 03:28:50 PM
    Author     : jhonny
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="classes.usuario"%>
<%@page  session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../Css/suscribir.css">
        <title>USUARIO</title>
    </head>
    <body>
       <div class="contenedor1">
                  <%HttpSession Sesions=request.getSession();
                  usuario tmp=new usuario();
                  tmp=usuario.userDatos(Sesions.getAttribute("usuario").toString());
                   char a='"';    
                String cadena=Character.toString(a);
                  
        %>
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
       </div>
                    
       <hr width=90%>
        
       <form action="/Revistas/suscripciones" method="GET">
        <input type="date" name="fecha" style="height: 25px" required id="" >
        <input type="submit" value="suscribir" style="height: 28px"  >
    </form>
      
         
    </body>
</html>