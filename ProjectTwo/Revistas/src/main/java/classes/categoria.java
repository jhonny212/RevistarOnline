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

/**
 *
 * @author jhonny
 */
public class categoria {
 
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
}
