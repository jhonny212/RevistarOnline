/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import classes.iniciarConeccion;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author jhonny
 */
@WebServlet(name = "perfilEditor", urlPatterns = {"/perfilEditor"})
@MultipartConfig (maxFileSize = 16177215) public class perfilEditor extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
      
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           
        processRequest(request, response);
        
         if(iniciarConeccion.coneccion==null){
            iniciarConeccion.IniciarConeccion();
            }else{
         ts="js";}
         
         
        String sql = "";  
         PreparedStatement ps2 = null;
         ResultSet tmp=null;
          InputStream input=null;
          OutputStream out=null;
          BufferedInputStream bf=null;
          BufferedOutputStream of=null;
          response.setContentType("/image*");
          
          
       try {
            ps2 = iniciarConeccion.coneccion.prepareStatement("SELECT perfil FROM editor where username=?");
            ps2.setString(1, request.getParameter("user"));
            tmp=ps2.executeQuery();
              out=response.getOutputStream();
           if(tmp.next()){
               input=tmp.getBinaryStream("perfil");
           
           
           
           }
           bf=new  BufferedInputStream (input);
           of=new BufferedOutputStream(out);
           int i=0;
           while((i=bf.read())!=-1){
               of.write(i);
           }
        
          
        } catch (SQLException ex) {
            ts=ex.getMessage();
    
        } catch (Exception ex) {
            ts=ex.getMessage();
    
        }
      
        
        
        
        
        
    }
private static String ts;

    public static String getTs() {
        return ts;
    }

    public static void setTs(String ts) {
        perfilEditor.ts = ts;
    }
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        processRequest(request, response);
        
         InputStream inputStream = null;
    Part filePart = request.getPart("archivo");
     inputStream=filePart.getInputStream();
        
     
     
         if(iniciarConeccion.coneccion==null){
            iniciarConeccion.IniciarConeccion();
            }
        try {
            
           String sql=null;
            sql="UPDATE editor SET nombre=?,  direccion=?, "
                    + "descripcion=?, sexo=?, suscripcionGlobal=?, perfil=? WHERE username=?"
                    + "";
     
           PreparedStatement iniciarSesion=iniciarConeccion.coneccion.prepareStatement(sql);
           iniciarSesion.setString(1, request.getParameter("nombre"));
           iniciarSesion.setString(2, request.getParameter("direccion"));
           iniciarSesion.setString(3, request.getParameter("descripcion"));
          iniciarSesion.setString(4, request.getParameter("opcion"));
            iniciarSesion.setInt(5,Integer.parseInt( request.getParameter("suscrip")));
           
            iniciarSesion.setBlob(6, inputStream);
           iniciarSesion.setString(7, request.getParameter("user"));
           
           
           
           
           iniciarSesion.executeUpdate();
             PrintWriter a=response.getWriter();
                a.print("sda");
            
           
       } catch (SQLException ex) {
                PrintWriter s=response.getWriter();
                s.print(ex.getMessage());
            
            }
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
