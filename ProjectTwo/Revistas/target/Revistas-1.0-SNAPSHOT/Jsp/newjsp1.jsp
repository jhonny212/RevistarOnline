<%-- 
    Document   : newjsp1
    Created on : 1/10/2019, 10:21:05 PM
    Author     : jhonny
--%>

<%@page import="classes.revista"%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.util.Calendar"%>
<%@page import="classes.iniciarConeccion"%>
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
        /*if(iniciarConeccion.coneccion==null){
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
         sql2="SELECT * FROM suscripcion";
         
         
         
         read2=iniciarConeccion.coneccion.prepareStatement(sql2);
       
         sesion2=read2.executeQuery();
        
         while(sesion2.next()){
         PreparedStatement read3=null;
         String sql3=null;
         ResultSet sesion3=null;
         sql3="SELECT TIMESTAMPDIFF(MONTH, '"+sesion2.getDate("fecha")+"', '"+data+"') AS meses_transcurridos;";
         
         
         
         read3=iniciarConeccion.coneccion.prepareStatement(sql3);
       
         sesion3=read3.executeQuery();
        
            while(sesion3.next()){
                
                out.println(sesion2.getDate("fecha"));
                out.println(data);
                
             if(sesion3.getLong(1)<0){
                 
                 revista.actualizarSus(sesion2.getInt("idrevista"), sesion2.getString("user"));
            
             }else{
       
         break;
                
             }
         
         }
         
         }
         
         
         
          
         
     } catch (SQLException ex) {
         out.print(ex.getMessage());
     }
        
        */
        
        %>
        <form method="GET" action="newjsp1.jsp" >
            <input type="date" >
            <a href="newjsp1.jsp?id=2" > hey</a>
        </form>
    </body>
</html>