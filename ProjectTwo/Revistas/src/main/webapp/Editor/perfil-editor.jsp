<%-- 
    Document   : perfil-editor
    Created on : 30/09/2019, 04:23:59 PM
    Author     : jhonny
--%>

<%@page import="servlets.iniciarSesion"%>
<%@page import="classes.usuario"%>
<%@page import="servlets.perfilEditor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../Css/perfil-usuario.css">
        <title>Editor</title>
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
        <form action="/Revistas/perfilEditor" method="POST"  enctype="multipart/form-data">
                <div class="perfil">
                  
                      <%HttpSession Sesions=request.getSession();
        %>
                      <% 
                     usuario tmp =new usuario();
                  tmp=usuario.user(Sesions.getAttribute("usuario").toString());
                     

                char a='"';    
                String cadena=Character.toString(a);
              
                    %>   
                    <table>
                       
                            <tr>
                                <th>
                                    <div id="perfil-user">
                                       
                                        
             <img src="/Revistas/perfilEditor" height="100px" width="150px">
          
                                            <br>
                                            <p>Para cambiar tu foto carga una imagen</p>
                                            <br>
                                            <input type="file" name="archivo" > 
                                    </div>
                                </th>
                                <th>
                                        <div id="nombre-localidad">
                                            <h2 style="padding-top: 10px">Nombre y direccion</h2>
                                            <section>
                                                   <article>
                                                        <h3>Nombre </h3> 
                                          <input   name ="nombre" type="text" <%out.print("value="+cadena+
                                                tmp.getNombre()+cadena);
                                                %>  >
                                                   </article>
                                                    <article>
                
                                                    <h3>Direccion</h3> 
                                                  <input  name ="direccion" type="text" <%out.print("value="+cadena+
                                                tmp.getDireccion()+cadena);
                                                %> >
                                                    </article>
                                            </section>
                
                                        </div>
                                    </th>
                            </tr>
                
                            <tr style="height: 300px">
                                    <th id="bio">
                                        <br>
                                        
                                            <div id="biografia-profile">
                                                    <h3>Sobre ti:</h3> 
                                                  <textarea required name="descripcion" cols=40 rows=10
                                            
                                             >
                                                 <%out.print(
                                                tmp.getSobreti());
                                                %> 
                                   </textarea>   </div>
                                                         
                                     </th>
                                   
                            </tr>
                          
                            <tr style="height: 300px">
                                    <th  id="hobbies">
                                   
                                            <div id="pasatiempo">
                                                    <h3>Sexo</h3> 
                                                        <select name="opciom" id="">
                                                            <option >Hombre</option>
                                                            <option >Mujer</option>
                                                        </select>
                                            
                                                        <br>
                                                    <br>
                                            </div>
    
                                                         
                                     </th>
                                     <th  id="hobbies">
                                   
                                            <div id="pasatiempo">
                                                    <h3>Temas de interes</h3> 
                                                    <input type="number" name="suscrip"  id="sus" placeholder="suscripcion"
                                                           style="height: 40px" value="20">
                                                    <br>
                                                    <br>
                                                    <br>
                                                    <br>
                                            </div>
                                                         
                                     </th>
                            <input type="submit" style="width: 200px" value="Actualizar">
                            </tr>
                            
                       
                        </table>
                    </div>

        </form>
            
    </body>
</html>
