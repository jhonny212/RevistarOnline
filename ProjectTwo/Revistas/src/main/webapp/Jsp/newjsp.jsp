<%-- 
    Document   : newjsp
    Created on : 1/10/2019, 06:08:00 PM
    Author     : jhonny
--%>

<%@page import="java.util.Calendar"%>
<%@page import="java.sql.Date"%>
<%@page import="classes.iniciarConeccion"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.util.LinkedList"%>
<%@page import="classes.revista"%>
<%@page import="java.sql.SQLException"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
                 if(iniciarConeccion.coneccion==null){
            iniciarConeccion.IniciarConeccion();
            }
          
                 
                 
                 
                 
Calendar c1 = Calendar.getInstance();
String dia = Integer.toString(c1.get(Calendar.DATE));
String mes = Integer.toString(c1.get(Calendar.MONTH));
String annio = Integer.toString(c1.get(Calendar.YEAR));

String data=annio+"-"+mes+"-"+dia;

     try {
         
        
         PreparedStatement read2=null;
         String sql2=null;
         ResultSet sesion2=null;
         sql2="SELECT * FROM datos WHERE iddatos=?";
         
         
         
         read2=iniciarConeccion.coneccion.prepareStatement(sql2);
         read2.setInt(1, 2);
         sesion2=read2.executeQuery();
        
         while(sesion2.next()){
        
         
          PreparedStatement read3=null;
         String sql3=null;
         ResultSet sesion3=null;
         sql3="SELECT TIMESTAMPDIFF(MONTH, '"+sesion2.getDate("fecha")+"', '"+data+"') AS meses_transcurridos;";
         
         
         
         read3=iniciarConeccion.coneccion.prepareStatement(sql3);
       
         sesion3=read3.executeQuery();
        
         if(sesion3.next()){
              out.print(sesion3.getLong(1));
             if(sesion3.getLong(1)<0){
            out.print(sesion3.getLong(1));
             }else{
         
             }
         
         }
         
         }
         
         
         
          
         
     } catch (SQLException ex) {
         out.print(ex.getMessage());
     }
              
        %>
    </body>
</html>
