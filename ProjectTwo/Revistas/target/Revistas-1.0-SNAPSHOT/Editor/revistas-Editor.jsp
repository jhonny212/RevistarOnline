<%-- 
    Document   : revistas-Editor
    Created on : 25/09/2019, 05:32:10 PM
    Author     : jhonny
--%>


<%@page import="servlets.iniciarSesion"%>
<%@page import="classes.usuario"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.util.LinkedList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="classes.iniciarConeccion"%>
<%@page import="classes.categoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  session="true" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../Css/revistaEstilo.css">
       
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
    <body onload="My_onLoad()">
        <div class="sidebar">
            <h2>MENU</h2>
            <ul>
                <li><a href="../Jsp/index.jsp?cerrar=true">Cerrar sesion</a></li>
                <li><a href="perfil-editor.jsp" target="blank" >Perfil</a></li>
                <li><a href="Editor.jsp">Crear revista</a> </li>
                  <li><a href="revistas-Editor.jsp?name=delete">Eliminar suscripciones</a> </li>
                <%
                    LinkedList <String> tmp=categoria.llenarCategoria();
                   
                char a='"';    
                String cadena=Character.toString(a);
                for(int i=0; i<tmp.size(); i++){
                out.print("<li><a href="+cadena+"revistas-Editor.jsp?name="+tmp.get(i)+cadena +">"+tmp.get(i)+"</a></li>"
                        + "");
                
                }
                %>
                

            </ul>
        </div>
     
        <div class="contenido">
            <img src="../Imagenes/PERFIL.png" alt="" class="menu-bar"> 
                          
            <div class="KindRevistas" >
              
                <table>
                    <thead>
                        <tr>
                            <th id="nombre">Nombre</th>
                            <th id="descripcion">descripcion</th>
                            <th id="pdf"> Pdf</th>
                            
                        </tr>
                    </thead>

                    <tbody>
               
                          <%HttpSession Sesions=request.getSession();
        %>
                        
        <%if(request.getParameter("name")!=null && !request.getParameter("name").equals("delete")){
                            
                            
                        if(iniciarConeccion.coneccion==null){
                        iniciarConeccion.IniciarConeccion();
                        }
                      
    try {
           String sql="SELECT idrevista, nombre, descripcion FROM revista WHERE idcategoria=?"
                   + "&& username=?";
           
           PreparedStatement read=iniciarConeccion.coneccion.prepareStatement(sql);
           
          read.setString(1, request.getParameter("name"));
          read.setString(2, Sesions.getAttribute("usuario").toString());
          ResultSet sesion=read.executeQuery();
          char as='"';    
          String cadenas=Character.toString(as);
           while(sesion.next()){
               String tmps=null;
               if(sesion.getString("descripcion")==null){
               tmps="vacio";
               }
               
            out.print("<tr>"
                    + "<td>"
                    + sesion.getString("nombre")
                    + "</td>"
                    + "<td>"
                    + sesion.getString("descripcion")
                    + "</td>"
                    + "<td>"
                    + "<a href="+cadenas+"/Revistas/pdf?id="+sesion.getInt("idrevista")+cadenas+""
                            + "target="+cadenas+"_blank"+cadenas
                            + "> <img  src="+cadenas+"../Imagenes/mpdf.png"+cadenas+" style="+cadenas+"width: 50px; height:50px;"+cadenas+
                    "></a><br>"
                            + "<a href="+cadenas+"comentarios.jsp?id="+sesion.getInt("idrevista")+cadenas
                            
                    + "target="+cadenas+"_blank"+cadenas+">Consultas pdf </a></td>"
                            + "</tr>");
           }
            } catch (SQLException ex) {
                out.print(ex.getMessage());
                
                
                
                
                
            }
                            }else{
                       
               String sql="select a.user,a.idrevista, b.descripcion from suscripcion a join revista b on a.idrevista=b.idrevista where b.username=?";
           
           PreparedStatement read=iniciarConeccion.coneccion.prepareStatement(sql);
           

          read.setString(1, Sesions.getAttribute("usuario").toString());
          ResultSet sesion=read.executeQuery();
          char as='"';    
          String cadenas=Character.toString(as);
           while(sesion.next()){
            
               
            out.print("<tr>"
                    + "<td>"
                    + sesion.getString("a.user")
                    + "</td>"
                    + "<td>"
                    + sesion.getString("b.descripcion")
                    + "</td>"
                    + "<td>"
                    + "<a href="+cadenas+"/Revistas/delete?id="+sesion.getInt("a.idrevista")+"&user="+sesion.getString("a.user")+cadenas
                            + "> Eliminar suscripcion</a><br>"
                            + "</td>"
                            + "</tr>");
           } 
           
          
                        
                        }
                            
                        
                        
                        
                        %>
          </tbody>



                </table>
                
            </div>
            
            
        </div>

        <%
        String revista=null;
        revista=request.getParameter("name");
        if(revista==null){
        out.print("nulo");
        }else{
        out.print(revista);}
        %> 
   
      
       
              <script src="../Js/abrir.js"></script>
        </body>
</html>
