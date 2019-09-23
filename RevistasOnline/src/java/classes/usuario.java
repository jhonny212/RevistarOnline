/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author jhonny
 */
public class usuario {
    
    public static String message;

    public static String getMessage() {
        return message;
    }
    
    private String nombre;
    private String user;
    private String edad;
    private String direccion;
    private String fecha;
    private String contraseña;
    
    public usuario(HttpServletRequest request)
    {
    this.nombre=request.getParameter("nombre");
    this.user=request.getParameter("user");
    this.edad=request.getParameter("edad");
    this.direccion=request.getParameter("direccion");
    this.fecha=request.getParameter("fecha");
    this.contraseña=request.getParameter("password");
    message=null;
    
    }

    public String getNombre() {
        return nombre;
    }

    public String getUser() {
        return user;
    }

    public String getEdad() {
        return edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getFecha() {
        return fecha;
    }

    public String getContraseña() {
        return contraseña;
    }
    public static void iniciarSesion(String user, String contraseña ){
    
        try {
            PreparedStatement iniciarSesion =iniciarConeccion.coneccion.prepareStatement("SELECT usuario.user, usuario.password"
                    + "FROM usuario WHERE  VALUES (?,?,?,?,?,?)");
            
           
            message=null;
            } catch (SQLException ex) {
                message=ex.getMessage();
            
            }
        
        
        
    }
    
    public void registrarUsuario(usuario user){
   
        try {
            PreparedStatement crearUser =iniciarConeccion.coneccion.prepareStatement("INSERT INTO usuario (nombre,user, edad,direccion, "
                    + "nacimiento, password) VALUES (?,?,?,?,?,?)");
            
            crearUser.setString(1, user.getNombre());
            
            crearUser.setString(2,user.getUser());
            
            crearUser.setInt(3, Integer.parseInt(user.getEdad()));
            
            crearUser.setString(4, user.getDireccion());
             
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
             String dateInString = user.getFecha();
              Date date = formatter.parse(dateInString);
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            
            crearUser.setDate(5, sqlDate);
            
            crearUser.setString(6, user.getContraseña());
            crearUser.executeUpdate();
            message=null;
            } catch (SQLException ex) {
                message=ex.getMessage();
            
            }catch (ParseException e) {
         
        }
    }
}
