/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
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
        
        
         String applicationPath = request.getServletContext().getRealPath("");
         Part filePart = request.getPart("imagen");
          String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.

            
          PrintWriter s=response.getWriter();
            
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
        
             Connection coneccion=null;
        String user = "root";
		String password = "isma2001";
		String stringConnection = "jdbc:mysql://localhost:3306/archivos";

        try {
             coneccion= DriverManager.getConnection(stringConnection, user, password);
        } catch (SQLException ex) {
        System.out.println("Fallo");
        }
        
        
            InputStream inputStream = null;
    Part filePart = request.getPart("imagen");
     inputStream=filePart.getInputStream();
     
         String sql = "INSERT INTO pdf (archivopdf) VALUES(?);";  
         PreparedStatement ps2 = null;
      
        
    try {
            ps2 = coneccion.prepareStatement(sql);
           
            ps2.setBlob(1, inputStream);
            ps2.executeUpdate();
        } catch (SQLException ex) {
          PrintWriter s=response.getWriter();
          s.print(ex.getMessage());
        } catch (Exception ex) {
            
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
