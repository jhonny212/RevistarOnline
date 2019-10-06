/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jhonny
 */
public class categoria {
 public static LinkedList list(String user, String cat)
 {
     LinkedList<revista> tmp=new LinkedList();
         
     try {
         
        
         PreparedStatement read2=null;
         String sql2=null;
         ResultSet sesion2=null;
         sql2="select * FROM revista WHERE idcategoria=? &&  revistacol='activo' ";
         
         
         
         read2=iniciarConeccion.coneccion.prepareStatement(sql2);
         read2.setString(1, cat);
         sesion2=read2.executeQuery();
         
          PreparedStatement read=null;
         String sql=null;
         ResultSet sesion=null;
         sql="select idrevista FROM suscripcion WHERE user=? && idrevista=?";
         
      
         while(sesion2.next()){
           read=iniciarConeccion.coneccion.prepareStatement(sql);
           read.setString(1,user);
           read.setInt(2, sesion2.getInt("idrevista"));
           sesion=read.executeQuery();
         if(sesion.next()){
       
         }
         
         else{
         revista ts=new revista();
         ts.setDescripcion(sesion2.getString("descripcion"));
         ts.setId(sesion2.getInt("idrevista"));
         ts.setNombre(sesion2.getString("nombre"));
         tmp.add(ts);
         }
         }
         
         
         
          
         
     } catch (SQLException ex) {
     }
 
 return tmp;}
 public categoria(){
 llenarCategoria();
 }
 public static LinkedList llenarCategoria(){
 LinkedList <String > categorias=new LinkedList();
               if(iniciarConeccion.coneccion==null){
            iniciarConeccion.IniciarConeccion();
            }
        try {
            PreparedStatement categoria =iniciarConeccion.coneccion.prepareStatement("SELECT * FROM categoria");
           ResultSet sesion=categoria.executeQuery();
            while(sesion.next()){
                categorias.add(sesion.getString("idcategoria"));
            }
              categorias.add(sesion.getString("nombre"));
            } catch (SQLException ex) {
               
            }
 
 
 
 
 
 return categorias;
 }
 
 
 public static LinkedList llenarCatporRevista(String nombreCat){
 LinkedList <String > revistas=new LinkedList();
     if(iniciarConeccion.coneccion==null){
            iniciarConeccion.IniciarConeccion();
            }
        try {
            PreparedStatement categoria =iniciarConeccion.coneccion.prepareStatement("SELECT idcategoria"
                    + " FROM revista");
           ResultSet sesion=categoria.executeQuery();
            while(sesion.next()){
               revistas.add(sesion.getString("idcategoria"));
            }
              revistas.add(sesion.getString("nombre"));
            } catch (SQLException ex) {
               
            }
 return revistas;}
 
  public static LinkedList llenarCatporRevistas(){
 LinkedList <revista > revistas=new LinkedList();
     if(iniciarConeccion.coneccion==null){
            iniciarConeccion.IniciarConeccion();
            }
        try {
            String sql="select a.nombre, b.username, a.idrevista FROM revista a join editor b on (a.username =b.username)";
            PreparedStatement categoria =iniciarConeccion.coneccion.prepareStatement(sql);
           ResultSet sesion=categoria.executeQuery();
            while(sesion.next()){
              
                revista tmp=new revista(sesion.getString("username"),
                sesion.getString("nombre"), sesion.getInt("idrevista"));
                revistas.add(tmp);
            }
             
            } catch (SQLException ex) {
               
            }
 return revistas;}
  public static LinkedList llenarCatporRevista(){
 LinkedList <revista > revistas=new LinkedList();
     if(iniciarConeccion.coneccion==null){
            iniciarConeccion.IniciarConeccion();
            }
        try {
            String sql="select a.nombre, b.username, a.idrevista FROM revista a join editor b on (a.username =b.username) where a.revistacol=?";
            PreparedStatement categoria =iniciarConeccion.coneccion.prepareStatement(sql);
            categoria.setString(1, "descativo");
           ResultSet sesion=categoria.executeQuery();
            while(sesion.next()){
              
                revista tmp=new revista(sesion.getString("username"),
                sesion.getString("nombre"), sesion.getInt("idrevista"));
                revistas.add(tmp);
            }
             
            } catch (SQLException ex) {
               
            }
 return revistas;}
}
