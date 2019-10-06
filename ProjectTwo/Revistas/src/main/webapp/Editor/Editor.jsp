<%-- 
    Document   : revistasEditor
    Created on : 24/09/2019, 04:51:06 PM
    Author     : jhonny
--%>

<%@page import="servlets.iniciarSesion"%>
<%@page import="classes.usuario"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="classes.iniciarConeccion"%>
<%@page  session="true" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <link rel="stylesheet" href="../Css/menu-bar-estilo.css">
            <link rel="stylesheet" href="../Css/revistasEdit.css">
             
        <title>JSP Page</title>
    </head>
    <body>
        
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
             <%HttpSession Sesions=request.getSession();
             ;
            
        %>
        <script type="text/javascript">
function check(e)
{
if (document.form.elements[e-1].checked==true){document.form.elements[e].disabled=false}
if (document.form.elements[e-1].checked==false){document.form.elements[e].disabled=true}
}
</script>
         <nav class="navegacion">
                <ul class="menu">
                    <li><a href="../Jsp/index.jsp?cerrar=true">Cerrar sesion</a></li>
                    <li><a href="revistas-Editor.jsp" >Revistas</a></li>
                    <li><a href="perfil-editor.jsp" target="blank">perfil</a></li>
                    <li><a href="Editor.jsp">crearRevista</a></li>
                                               
                </ul>
            </nav>  

         <div class="contenedor">
           <form method="POST" action="/Revistas/upload" enctype="multipart/form-data">

            <div id="categoria">
                <input type="checkbox" name="check1" onclick="check(1)"  />
                <input type="text" name="text1"   placeholder="crear nueva categoria" /> 
               <textarea name="descripcion" cols="30"  required rows="10">Descripcion</textarea>
               
            </div>
            
            <div id="datos"> 
                <input type="text"  name="nombre" placeholder="nombre revista" required >
            <select name="categorias" >
                <%
                         if(iniciarConeccion.coneccion==null){
            iniciarConeccion.IniciarConeccion();
            }
        try {
           
           PreparedStatement iniciarSesion=iniciarConeccion.coneccion.prepareStatement("SELECT * FROM categoria");
     
           ResultSet sesion=iniciarSesion.executeQuery();
           char tmps='"' ;
           String tm2=Character.toString(tmps);
           
           while(sesion.next()){
               String cad=sesion.getString("idcategoria");
              out.print("<option >"+cad+"</option>");
         
           }
              
            } catch (SQLException ex) {
          
            
            }
                    %>
                    
            </select >

            <input type="number" name="costo" placeholder="costo de revista"  >
               <input type="date" name="fecha" required>
            </div> 
           
            
                    <div>
                     <input type="file"  required name="fichero"   >
              
            
                    </div>
            
                <div id="datos">
             
                <input type="submit" value="Crear">
                
            </div>
        </form>
         </div> 
        
    </body>
</html>