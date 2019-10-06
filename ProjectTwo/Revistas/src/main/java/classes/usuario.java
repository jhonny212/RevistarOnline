/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;



import java.io.InputStream;
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
    
    
     private String sobreti;
   
 
    private String correo;
    private int telefono;
    private InputStream input;
    private String hobbies;
    private String temainteres;
    private String descripcion;

    public String getSobreti() {
        return sobreti;
    }

    public String getCorreo() {
        return correo;
    }

    public int getTelefono() {
        return telefono;
    }

    public InputStream getInput() {
        return input;
    }

    public String getHobbies() {
        return hobbies;
    }

    public String getTemainteres() {
        return temainteres;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    
    
    
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
            sql="UPDATE usuario (SET nombre=?, direccion=?, hobbies=?, temaInteres=?"
                    + "aboutYou=?, correo=?, telefono=?  )"
                    + "WHERE user=?";
        }else{
           sql="SELECT editor.username, editor.password FROM editor WHERE username=? && password=?";
           }
           PreparedStatement iniciarSesion=iniciarConeccion.coneccion.prepareStatement(sql);
           iniciarSesion.setString(1, request.getParameter("nombre"));
           iniciarSesion.setString(2, request.getParameter("direccion"));
           iniciarSesion.setString(5, request.getParameter("descripcion"));
           iniciarSesion.setString(6, request.getParameter("correo"));
           iniciarSesion.setInt(7, Integer.parseInt(request.getParameter("telefono")));
           iniciarSesion.setString(3, request.getParameter("hobbies"));
           iniciarSesion.setString(4, request.getParameter("temaInteres"));
           
           
           
           
           
           
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

    public static void setMessage(String message) {
        usuario.message = message;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setTipoUser(String tipoUser) {
        this.tipoUser = tipoUser;
    }

    public void setSobreti(String sobreti) {
        this.sobreti = sobreti;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setInput(InputStream input) {
        this.input = input;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public void setTemainteres(String temainteres) {
        this.temainteres = temainteres;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public usuario(){}
    
   public static usuario perfil(String user){
   usuario tmp=new usuario();
   tmp.setSobreti("");
   
   if(iniciarConeccion.coneccion==null){
            iniciarConeccion.IniciarConeccion();
            }
        try {
           String sql=null;
           sql="SELECT * FROM usuario WHERE user=?   " ;
           
           PreparedStatement iniciarSesion=iniciarConeccion.coneccion.prepareStatement(sql);
           iniciarSesion.setString(1, user);
      ResultSet sesion=iniciarSesion.executeQuery();
        
           while(sesion.next()){
          tmp.setNombre(sesion.getString("nombre"));
          tmp.setDireccion(sesion.getString("direccion"));
          if(sesion.getString("aboutYou")!=null){
          tmp.setSobreti(sesion.getString("aboutYou"));
          
          }
          if(sesion.getString("correo")!=null){
          tmp.setCorreo(sesion.getString("correo"));
          
          }else{
          tmp.setCorreo("");
          }
          tmp.setTelefono(sesion.getInt("telefono"));
      
      
          
      if(sesion.getString("hobbies")!=null){
          tmp.setHobbies(sesion.getString("hobbies"));
      
      }else{
      tmp.setHobbies("");}
      if(sesion.getString("temaInteres")!=null){
          tmp.setTemainteres(sesion.getString("temaInteres"));
      
      }else{
      tmp.setTemainteres("");}
           }
              
            } catch (SQLException ex) {
             
            
            }
   
   
   
   
   
   
   
   
   
   
   
   return tmp;
   }
   
     public static usuario user(String user){
   usuario tmp=new usuario();
   tmp.setSobreti("");
   
   if(iniciarConeccion.coneccion==null){
            iniciarConeccion.IniciarConeccion();
            }
        try {
           String sql=null;
           sql="SELECT * FROM editor WHERE username=?   " ;
           
           PreparedStatement iniciarSesion=iniciarConeccion.coneccion.prepareStatement(sql);
           iniciarSesion.setString(1, user);
      ResultSet sesion=iniciarSesion.executeQuery();
        
           while(sesion.next()){
          tmp.setNombre(sesion.getString("nombre"));
          tmp.setDireccion(sesion.getString("direccion"));
          if(sesion.getString("descripcion")!=null){
          tmp.setSobreti(sesion.getString("descripcion"));
          
          }
          if(sesion.getString("sexo")!=null){
          tmp.setCorreo(sesion.getString("sexo"));
          
          }else{
          tmp.setCorreo("");
          }
      
      
          
      if(sesion.getString("hobbies")!=null){
          tmp.setHobbies(sesion.getString("hobbies"));
      
      }else{
      tmp.setHobbies("");}
      if(sesion.getString("temaInteres")!=null){
          tmp.setTemainteres(sesion.getString("temaInteres"));
      
      }else{
      tmp.setTemainteres("");}
           }
              
            } catch (SQLException ex) {
             
            
            }
   
   
   
   
   
   
   
   
   
   
   
   return tmp;
   }
     
       public static usuario userDatos(String user){
   usuario tmp=new usuario();
   tmp.setSobreti("");
   
   if(iniciarConeccion.coneccion==null){
            iniciarConeccion.IniciarConeccion();
            }
        try {
           String sql=null;
           sql="select a.username, a.nombre,a.sexo, a.nacimiento, a.edad, a.direccion, a.descripcion from editor a join revista b on a.username=b.username where idrevista=? " ;
           
           PreparedStatement iniciarSesion=iniciarConeccion.coneccion.prepareStatement(sql);
           iniciarSesion.setInt(1, Integer.parseInt(user));
      ResultSet sesion=iniciarSesion.executeQuery();
        
           while(sesion.next()){
          tmp.setNombre(sesion.getString("nombre"));
          tmp.setDireccion(sesion.getString("direccion"));
          if(sesion.getString("descripcion")!=null){
          tmp.setSobreti(sesion.getString("descripcion"));
          
          }
          if(sesion.getString("sexo")!=null){
          tmp.setCorreo(sesion.getString("sexo"));
          
          }else{
          tmp.setCorreo("");
          }
          
          tmp.setFecha(sesion.getString("nacimiento"));
      
      
          
      if(sesion.getString("hobbies")!=null){
          tmp.setHobbies(sesion.getString("hobbies"));
      
      }else{
      tmp.setHobbies("");}
      if(sesion.getString("temaInteres")!=null){
          tmp.setTemainteres(sesion.getString("temaInteres"));
      
      }else{
      tmp.setTemainteres("");}
           }
              
            } catch (SQLException ex) {
             
            
            }
   
   
   
   
   
   
   
   
   
   
   
   return tmp;
   }

}
