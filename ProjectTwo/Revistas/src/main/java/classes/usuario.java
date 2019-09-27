/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    
    public static String message=null;

    public static String getMessage() {
        return message;
    }
    
    private String nombre;
    private String user;
    private String edad;
    private String direccion;
    private String fecha;
    private String contraseña;
    private String tipoUser;
    
    public usuario(HttpServletRequest request)
    {
    this.nombre=request.getParameter("nombre");
    this.user=request.getParameter("user");
    this.edad=request.getParameter("edad");
    this.direccion=request.getParameter("direccion");
    this.fecha=request.getParameter("fecha");
    this.contraseña=request.getParameter("password");
    this.tipoUser=request.getParameter("tipoUsuario");
    message=null;
    
    }

    public String getTipoUser() {
        return tipoUser;
    }
    
    public static void actualizarUser(String kind,HttpServletRequest request){
          if(iniciarConeccion.coneccion==null){
            iniciarConeccion.IniciarConeccion();
            }
        try {
           String sql=null;
           if(kind.equals("Usuario")){
            sql="UPDATE usuario (SET nombre=?, edad=?, direccion=?, hobbies=?, temaInteres=?"
                    + "descripcion=?, estatura=?, aboutYou=?, nacimiento=?)"
                    + "WHERE user=?";
        }else{
           sql="SELECT editor.username, editor.password FROM editor WHERE username=? && password=?";
           }
           PreparedStatement iniciarSesion=iniciarConeccion.coneccion.prepareStatement(sql);
           
           
           iniciarSesion.executeUpdate();
     
       } catch (SQLException ex) {
                message=ex.getMessage();
            
            }
        
    
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
    public static void iniciarSesion(String user, String contraseña, String kind ){
     if(iniciarConeccion.coneccion==null){
            iniciarConeccion.IniciarConeccion();
            }
        try {
           String sql=null;
           if(kind.equals("Usuario")){
            sql="SELECT usuario.user, usuario.password FROM usuario WHERE user=? && password=?";
        }else{
           sql="SELECT editor.username, editor.password FROM editor WHERE username=? && password=?";
           }
           PreparedStatement iniciarSesion=iniciarConeccion.coneccion.prepareStatement(sql);
     
           iniciarSesion.setString(1, user);
           iniciarSesion.setString(2, contraseña);
           ResultSet sesion=iniciarSesion.executeQuery();
           message=null;
           message="";
           while(sesion.next()){
            message="correcto";
           }
              
            } catch (SQLException ex) {
                message=ex.getMessage();
            
            }
        
        
        
    }
    
    public void registrarUsuario(usuario user){
   
        try {
            
            PreparedStatement crearUser=null; 
            if(user.getTipoUser().equals("Usuario")){
            
            crearUser=iniciarConeccion.coneccion.prepareStatement("INSERT INTO usuario (nombre,user, edad,direccion, "
                    + "nacimiento, password) VALUES (?,?,?,?,?,?)");
            
            }else{
            
            crearUser=iniciarConeccion.coneccion.prepareStatement("INSERT INTO editor (nombre,username, edad,direccion, "
                    + "nacimiento, password, suscripcionGlobal) VALUES (?,?,?,?,?,?,?)");
              crearUser.setInt(7,20);
            }
            
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
            message="registrado";
            
        
        
        } catch (SQLException ex) {
                message="error";
            
            }catch (ParseException e) {
         
        }
    }

   

}
