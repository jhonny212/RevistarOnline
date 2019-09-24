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
 
        try {
            PreparedStatement categoria =iniciarConeccion.coneccion.prepareStatement("SELECT categoria.nombre "
                    + "FROM categoria WHERE  nombre=?)");
            
           ResultSet sesion=categoria.executeQuery();
            while(sesion.next()){
            }
              categorias.add(sesion.getString("nombre"));
            } catch (SQLException ex) {
               
            }
 
 
 
 
 
 return categorias;}
}
