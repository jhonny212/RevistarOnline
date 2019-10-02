/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import classes.iniciarConeccion;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
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
 @WebServlet("/upload") @MultipartConfig (maxFileSize = 16177215) public class  claseRevista extends HttpServlet {

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

         InputStream inputStream = null;
    Part filePart = request.getPart("fichero");
     inputStream=filePart.getInputStream();
      // inputStream=filePart.getInputStream();
        
        
        
       /* String nombre=request.getParameter("nombre");
        String costo=request.getParameter("costo");  
        String cat1=request.getParameter("text1");  
        String descripcion=request.getParameter("descripcion");
        
        
           InputStream input= null;
    Part filePart = request.getPart("imagen");
     input=filePart.getInputStream();
        
         if(cat1==null){
         cat1=request.getParameter("categorias");
         }else{
            try {
                PreparedStatement crearcat=iniciarConeccion.coneccion.prepareStatement("INSERT INTO categoria  (idcategoria) VALUES (?)");
                crearcat.setString(1, cat1);
                crearcat.executeUpdate();
            } catch (SQLException ex) {
            }
     
           
         }
        
      String sql = "INSERT INTO revista (nombre, username, idcategoria, costo,revistaG, descripcion) VALUES(?,"
              + " ?, ?,?, ?,? );";  
      PreparedStatement ps2 = null;
        try {
            ps2 = iniciarConeccion.coneccion.prepareStatement(sql);
            ps2.setString(1,"nombre");
            ps2.setString(2, "user111");
            ps2.setString(3, "fisica");
            ps2.setInt(4, 10);
            ps2.setBlob(5, input);
            ps2.setString(6, descripcion);
            ps2.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } 
             
             */
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
        
            String nombre=request.getParameter("nombre");
        String costo=request.getParameter("costo");  
        String cat1=request.getParameter("text1");  
        String descripcion=request.getParameter("descripcion");
        
        
           InputStream input= null;
    Part filePart = request.getPart("fichero");
     input=filePart.getInputStream();
        
         if(cat1==null){
         cat1=request.getParameter("categorias");
         }else{
            try {
                PreparedStatement crearcat=iniciarConeccion.coneccion.prepareStatement("INSERT INTO categoria  (idcategoria) VALUES (?)");
                crearcat.setString(1, cat1);
                crearcat.executeUpdate();
            } catch (SQLException ex) {
            }
     
           
         }
        
      String sql = "INSERT INTO revista (nombre, username, idcategoria, costo,revistaG, descripcion, tarifa) VALUES(?,"
              + " ?, ?,?, ?,?,? );";  
      PreparedStatement ps2 = null;
        try {
            ps2 = iniciarConeccion.coneccion.prepareStatement(sql);
            ps2.setString(1,nombre);
            ps2.setString(2, "user111");
            ps2.setString(3, cat1);
            ps2.setInt(4, 10);
            ps2.setBlob(5, input);
            ps2.setString(6, descripcion);
            ps2.setInt(7, 1);
            ps2.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
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
    

    /**
     * @param archivopdf2 the archivopdf2 to set
     */
   
}
