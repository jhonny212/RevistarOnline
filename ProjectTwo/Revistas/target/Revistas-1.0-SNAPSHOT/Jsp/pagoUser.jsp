<%-- 
    Document   : Magazine
    Created on : 14/09/2019, 02:14:59 PM
    Author     : jhonny
--%>

<%@page import="servlets.iniciarSesion"%>
<%@page import="classes.usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../Css/revista.css">
        <title>Revistas</title>
    </head>
    <body >
        <header>
            <div>
                <nav>
                </nav>
            </div>
        </header>
      
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
       
      

        <table class="contenedor">
            <tr>
                <th> 
                    <img src="../Imagenes/img-perfil.jpg" alt="" >
                    <p> Lorem ipsum dolor sit amet consectetur adipisicing elit. Id, odio neque vitae cumque commodi sequi voluptates aliquid modi recusandae corrupti sunt illum provident ullam possimus quidem nisi reprehenderit libero veritatis?</p>
            
            </th>
            <th> 
                <img src="../Imagenes/img-perfil.jpg" alt="" >
                <p> Lorem ipsum dolor sit amet consectetur adipisicing elit. Id, odio neque vitae cumque commodi sequi voluptates aliquid modi recusandae corrupti sunt illum provident ullam possimus quidem nisi reprehenderit libero veritatis?</p>
            
            
        
        </th>

        <th> 
            <a href="">
                <img src="../Imagenes/img-perfil.jpg" alt="">
            
            </a>
    </th>
        </tr>
        
              <tr>
                <th> 
                    <img src="../Imagenes/img-perfil.jpg" alt="" >
                    <p> Lorem ipsum dolor sit amet consectetur adipisicing elit. Id, odio neque vitae cumque commodi sequi voluptates aliquid modi recusandae corrupti sunt illum provident ullam possimus quidem nisi reprehenderit libero veritatis?</p>
            
            </th>
            <th> 
                <img src="../Imagenes/img-perfil.jpg" alt="" >
                <p> Lorem ipsum dolor sit amet consectetur adipisicing elit. Id, odio neque vitae cumque commodi sequi voluptates aliquid modi recusandae corrupti sunt illum provident ullam possimus quidem nisi reprehenderit libero veritatis?</p>
            
            
        
        </th>

        <th> 
            <a href="">
                <img src="../Imagenes/img-perfil.jpg" alt="">
            
            </a>
    </th>
        </tr>
          
        </table>
    </body>
</html>
