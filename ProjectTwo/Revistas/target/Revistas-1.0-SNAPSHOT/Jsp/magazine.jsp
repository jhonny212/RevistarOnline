<%-- 
    Document   : magazine
    Created on : 12/09/2019, 11:29:04 AM
    Author     : jhonny
--%>

<%@page import="servlets.iniciarSesion"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="classes.iniciarConeccion"%>
<%@page import="java.util.LinkedList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="classes.categoria"  %>
<%@page import="classes.revista"  %>
<%@page import="classes.usuario"  %>

<%@page  session="true" %>
<!DOCTYPE html>

<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
           <link rel="stylesheet" href="../Css/revistaEstilo.css">
       
       
    <script src="http://code.jquery.com/jquery-1.11.3.min.js" ></script>
        <title>Revista</title>
     
    </head>

    <body >
    
        <%@include file="../Html/ArchivoRevista.html" %>
        <% HttpSession Sesions=request.getSession();
        revista.actualizarSuscripcion();
         
                 if(usuario.message==null){
        
            
            if(iniciarSesion.tip!=null){
                if(iniciarSesion.tip.equals("Usuario")){
     
       }else{
     
       response.sendRedirect("../Editor/Editor.jsp");
      
       } }else{
            
            response.sendRedirect("index.jsp");}
        }
         
               
              
        %>
          <div class="sidebar">
            <h2>MENU</h2>
            <ul>
                <li><a href="index.jsp?cerrar=true">Cerrar sesion</a></li>
                <li><a href="../Jsp/perfil-usuario.jsp">Perfil</a></li>
                <li><a href="magazine.jsp?name=suscripciones">Suscripciones</a></li>
                <li><a href="magazine.jsp?name=delete">Eliminar suscripcion</a></li>
                <li><a href="hacerPago.jsp">Pagos</a></li>
                
              
                <%
                // <link rel="stylesheet" href="../Css/estilorevista.css">
       
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
               
                        
                        <%if(request.getParameter("name")!=null ){
                            
                            
                        if(iniciarConeccion.coneccion==null){
                        iniciarConeccion.IniciarConeccion();
                        }
                      
    try {
        PreparedStatement read=null;
        String sql=null;
        ResultSet sesion=null;
        
           PreparedStatement read2=null;
        String sql2=null;
        ResultSet sesion2=null;
        
          PreparedStatement read3=null;
        String sql3=null;
        ResultSet sesion3=null;
        
        
         char as='"';    
             String agr=Sesions.getAttribute("usuario").toString();
          String cadenas=Character.toString(as);
           if( !request.getParameter("name").equals("suscripciones") && !request.getParameter("name").equals("delete")) {
          
               LinkedList <revista> lis=categoria.list(agr, request.getParameter("name"));
               
           
             for(int i=0; i<lis.size(); i++){
             out.print("<tr>"
                    + "<td style="+cadenas+"font-size: 20px; text-align: center;"+cadenas+
                    "> "
                    + lis.get(i).getNombre()
                    + "</td>"
                    + "<td>"
                    + lis.get(i).getDescripcion()
                    + "</td>"
                    + "<td>"
                    + "<a href="+cadenas+"suscribir.jsp?id="+lis.get(i).getId()+cadenas+""
                            + "target="+cadenas+"_blank"+cadenas
                            + ""
                                    + "><img  src="+cadenas+"../Imagenes/mpdf.png"+cadenas+" style="+cadenas+"width: 50px; height:50px;"+cadenas+
                    "></a>"
                            + ""
                            
                    + "</td>"
                            + "</tr>");
             
             
             }
      
           
           
           }else if(request.getParameter("name").equals("suscripciones")){
            
          
                  
               
               
           sql="select a.idrevista, a.nombre, a.descripcion FROM revista a join suscripcion b on a.idrevista=b.idrevista"
                   + " where b.estado='activo'  && b.user=?";
          read=iniciarConeccion.coneccion.prepareStatement(sql);
          read.setString(1, Sesions.getAttribute("usuario").toString());
          int count=0;
           
          sesion=read.executeQuery();
         
       
              while(sesion.next()){
                  
                  sql2="select versiones.idrevista from versiones  WHERE versiones.idrevista=?";
          read2=iniciarConeccion.coneccion.prepareStatement(sql2);
          read2.setInt(1,sesion.getInt("idrevista"));
          sesion2=read2.executeQuery();
          String newVersion="";
               
              while(sesion2.next()){
              
                 
                   newVersion+="<br><a href="+cadenas+"/Revistas/pdf2?id="+sesion.getInt("idrevista")+cadenas+""
                            + "target="+cadenas+"_blank"+cadenas
                            + " "
                                    + "><img  src="+cadenas+"../Imagenes/mpdf.png"+cadenas+" style="+cadenas+"width: 50px; height:50px;"+cadenas+
                    "></a><a href="+cadenas+"comentario"
                            + "Megusta.jsp?id="+sesion.getInt("idrevista")+cadenas+" tar"
                                    + "get="+cadenas+"_blank"+cadenas+" >Datos  </a>";   
                   
              
              }
               
            out.print("<tr>"
                    + "<td style="+cadenas+"font-size: 20px; text-align: center;"+cadenas+
                    "> "
                    + sesion.getString("nombre")
                    + "</td>"
                    + "<td>"
                    + sesion.getString("descripcion")
                    + "</td>"
                    + "<td>"
                    + "<a href="+cadenas+"/Revistas/pdf?id="+sesion.getInt("idrevista")+cadenas+""
                            + "target="+cadenas+"_blank"+cadenas
                            + " "
                                    + "><img  src="+cadenas+"../Imagenes/mpdf.png"+cadenas+" style="+cadenas+"width: 50px; height:50px;"+cadenas+
                    "></a><a href="+cadenas+"comentario"
                            + "Megusta.jsp?id="+sesion.getInt("idrevista")+cadenas+" tar"
                                    + "get="+cadenas+"_blank"+cadenas+" >Datos </a>"
                            
                    + ""+newVersion+"</td>"
                            + "</tr>");
            count++;
           }
     
           }else if(request.getParameter("name").equals("delete")){
               
           sql3="select * from suscripcion  WHERE user=?";
          read3=iniciarConeccion.coneccion.prepareStatement(sql3);
          read3.setString(1, Sesions.getAttribute("usuario").toString());
          sesion3=read3.executeQuery();
       
               
              if(sesion3.next()){
              out.print("<tr>"
                    + "<td style="+cadenas+"font-size: 20px; text-align: center;"+cadenas+
                    "> "
                    + sesion3.getString("user")
                    + "</td>"
                    + "<td>"
                    
                    + "</td>"
                    + "<td>"
                    + "<a href="+cadenas+"/Revistas/magazine?id="+sesion3.getInt("idrevista")+cadenas+"> Eliminar</a>"
                            
                    +"</td>"
                            + "</tr>");
              
              }
           }
       
            } catch (SQLException ex) {
                out.print(ex.getMessage());
            }
                            }
                            
                        
                        
                        
                        %>
       
                      
                        
                    </tbody>





                </table>
                
            </div>
     

        </div>
 
      
       
              <script src="../Js/abrir.js"></script>
        </body>
</html>
