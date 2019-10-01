<%-- 
    Document   : admin
    Created on : 1/10/2019, 07:57:22 AM
    Author     : jhonny
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
  <link rel="stylesheet" href="../Css/menu-bar-estilo.css">
  <link rel="stylesheet" href="../Css/admin.css">
  <link rel="stylesheet" href="../Css/Style2.css">
  <link rel="stylesheet" href="../Css/diseño3.css">
  <link rel="stylesheet" href="../Css/Style4.css">

        <title>JSP Page</title>
    </head>
    <body>

        <header >
            <div class="contenedoruno">
           
                <nav>
                   <a class="crearcuenta" href="registrar.jsp">Registrar</a>
                    
                </nav>
                </div> 
        </header>   


<div class="admincontent">
        <form class="from1" action="/Revistas/admin" method="POST" >
  <h2>Iniciar sesion</h2>

  <input type ="text" id="usuario" name="usuario" placeholder="&#128272; usuario " required/> 
  <!--Blue select-->


  <input type ="password" id="contraseña" name="password" required placeholder="&#128272; contraseña "/>
 
  
 <input type="submit" name ="btn" value="ingresar">

 
</form>

</div>
    
    </body>
</html>
