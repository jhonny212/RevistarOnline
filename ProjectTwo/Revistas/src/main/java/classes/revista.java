/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import static java.lang.System.out;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

/**
 *
 * @author jhonny
 */
public class revista {
public static LinkedList deudas(String user){
LinkedList <revista>tmp=new LinkedList();
    if(iniciarConeccion.coneccion==null){
    iniciarConeccion.IniciarConeccion();
    }
  try {
         
        
         PreparedStatement read2=null;
         String sql2=null;
         ResultSet sesion2=null;
         sql2="SELECT * FROM suscripcion WHERE user=?";
         read2=iniciarConeccion.coneccion.prepareStatement(sql2);
         read2.setString(1, user);
         sesion2=read2.executeQuery();
        
         while(sesion2.next()){
         
         if(sesion2.getString("estado").equals("descativo")){
             revista s=new revista();
             s.setId(sesion2.getInt("idrevista"));
             s.setUser(sesion2.getString("user"));
             tmp.add(s);
         }
         
        
         
         }
         
         
         
          
         
     } catch (SQLException ex) {
         out.print(ex.getMessage());
     }



return tmp;
}
    
    public revista(){}
    private String user;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    private String nombre;
            private int id;
            
    private String descripcion;        

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public revista(String user, String nombre, int id){
    this.user=user;
    this.nombre=nombre;
    this.id=id;
    }
    
    public static void actualizarSuscripcion(){
    
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
                
             if(sesion3.getLong(1)<0){
                 
                
             }else{
                  actualizarSus(sesion2.getInt("idrevista"), sesion2.getString("user"));
            
         
             }
         
         }
         
         }
         
         
         
          
         
     } catch (SQLException ex) {
         out.print(ex.getMessage());
     }
    }
    public static void actualizarSus(int aInt, String string) {
        
          try {
            String  sql="UPDATE suscripcion SET estado=? WHERE idrevista=? && user=? ";
                    
        
           PreparedStatement iniciarSesion=iniciarConeccion.coneccion.prepareStatement(sql);
           iniciarSesion.setString(1,"descativo");
         
           iniciarSesion.setInt(2,aInt);
           iniciarSesion.setString(3,string);
         
          
           iniciarSesion.executeUpdate();
     
       } catch (SQLException ex) {
         }
        
        
    }
}
