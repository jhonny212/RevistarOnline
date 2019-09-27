<%-- 
    Document   : index
    Created on : 7/09/2019, 09:55:08 PM
    Author     : jhonny
--%>

<%@page import="classes.iniciarConeccion"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="classes.usuario"  %>
<%@page import="servlets.iniciarSesion"  %>
<%@page  session="true" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../Css/Style2.css">
        <link rel="stylesheet" href="../Css/diseño3.css">
        <link rel="stylesheet" href="../Css/Style4.css">
        
        <title>Magazines online</title>
    </head>
    <body>
      
        <header >
            <div class="contenedoruno">
             
                <nav>
                   <a class="crearcuenta" href="./registrar.jsp">Registrar</a>
                    
                </nav>
                </div> 
        </header>   
        <% 
        iniciarConeccion a=new iniciarConeccion();
        a.IniciarConeccion();
        if(iniciarConeccion.coneccion!=null){
        out.print("  Nadie lee anuncios. La gente lee lo que le <br>interesa, y a veces eso es un anuncio.");
                      
        }else{}
        
        
        
        %>
        
                  
        

         <div class="contenedor">
            <section id="cdos">
                <article id="registro">
                    
                    <%@include  file="../Html/formulario-html.html" %>
                          <% 
                        if(usuario.message!=null){
                            out.print(usuario.message);
                      if(usuario.message.equals("correcto")){
                    
       HttpSession sesion=request.getSession();
       sesion.setAttribute("usuario",iniciarSesion.user);
       sesion.setAttribute("tipo",iniciarSesion.tip);
       if(iniciarSesion.tip.equals("Usuario")){
       response.sendRedirect("magazine.jsp");
       
       }else{
      out.print("dasds");
     
      
       }
      
            }}
                    %>
               
                </article>
                
                <article id="quote">
                    <h1 >
                        “Nadie lee anuncios. La gente lee lo que le <br>interesa, y a veces eso es un anuncio.”<br>
                        – Howard Gossage
                    </h1>

                  
                    </article>

                   
            </section>
           

        </div>    
        <div class="revistas"  >
            <table id="tabla">
                <tr>
                    <th><img src="../Imagenes/Magazines.jpg" alt="" > </th>
                    <th><img src="../Imagenes/revista1.jpg" alt=""></th>
                    <th><img src="../Imagenes/revista2.jpg" alt=""></th>
                </tr>
                    
                    <tr> 
                    <th><img src="../Imagenes/revista3.jpg" alt=""></th>
                    <th><img src="../Imagenes/revista4.jpg" alt=""></th>
                    <th><img src="../Imagenes/revista5.jpg" alt=""></th>
                    </tr>
                    
                    <tr> 
                    <th><img src="../Imagenes/revista6.jpg" alt=""></th>
                    <th><img src="../Imagenes/revista7.jpg" alt=""></th>
                    <th><img src="../Imagenes/revista8.jpg" alt=""></th>
                    </tr>
            </table>
        </div>
     
 
     
    </body>
</html>
