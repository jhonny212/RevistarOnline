<%-- 
    Document   : magazine
    Created on : 12/09/2019, 11:29:04 AM
    Author     : jhonny
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="../Css/Style8.css">
         <script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>

       
        <title>Revista</title>
        
    <script>
    function My_onLoad(){
       
        var alto= $(".sidebar").height();
             console.log(alto);
           
             if(alto>637){
                $(".contenido").height(alto);
             }else{
                $(".contenido").height(637);
                console.log("sa");
                $(".sidebar").height(637);
                 
             }

             
    }
    </script>
    </head>

    <body onload="My_onLoad()">
        <div class="sidebar">
            <h2>MENU</h2>
            <ul>
                <li><a href="">Cerrar sesion</a></li>
                <li><a href="../Jsp/perfil-usuario.jsp">Perfil</a></li>
                <li><a href="">Productos</a></li>
                <li><a href="">Contacto</a></li>

             

              

                


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
