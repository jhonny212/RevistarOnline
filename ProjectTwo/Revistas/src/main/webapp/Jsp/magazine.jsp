<%-- 
    Document   : magazine
    Created on : 12/09/2019, 11:29:04 AM
    Author     : jhonny
--%>

<%@page import="java.util.LinkedList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="classes.categoria"  %>
<%@page  session="true" %>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         
       
        <title>Revista</title>
        
  
    </head>

    <body >
    
        <%@include file="../Html/ArchivoRevista.html" %>
         
          <div class="sidebar">
            <h2>MENU</h2>
            <ul>
                <li><a href="">Cerrar sesion</a></li>
                <li><a href="../Jsp/perfil-usuario.jsp">Perfil</a></li>
                <%
                    LinkedList <String> tmp=categoria.llenarCategoria();
                   
                char a='"';    
                String cadena=Character.toString(a);
                for(int i=0; i<tmp.size(); i++){
                out.print("<li><a href="+cadena+"magazine.jsp?name="+tmp.get(i)+cadena +">"+tmp.get(i)+"</a></li>");
                }
                %>
                

            </ul>
        </div>
        
        <div class="contenido">
            <img src="../Imagenes/img-perfil.jpg" alt="" class="menu-bar"> 
            <div id="slider">
                <a href="#" class="control_next">></a>
                <a href="#" class="control_prev"> < </a>
                <ul>
                  <li>
                      <img src="../Imagenes/img-perfil.jpg" style="height: 90%; width:90%;"  alt="">
                  </li>

                  <li>
                    <img src="../Imagenes/revista2.jpg" style="height: 90%; width:90%;"  alt="">
                </li>

                  <li style="background: #aaa;" ></li>
                  <li style="background: #aaa;">SLIDE 4</li>
                </ul>  
              </div>
              
              <div class="slider_option">
                <input type="checkbox" id="checkbox">
                <label for="checkbox">Autoplay Slider</label>
              </div> 
              
        </div>
   
      
       
              <script src="../Js/abrir.js"></script>
        </body>
</html>
