/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import classes.iniciarConeccion;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author jhonny
 */
@WebServlet(name = "suscripciones", urlPatterns = {"/suscripciones"})  @MultipartConfig (maxFileSize = 16177215) 
 public class suscripciones extends HttpServlet {

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
            
            HttpSession sesion=request.getSession();
            PrintWriter s=response.getWriter();
           
         
            double ganancia=0;
            double g=1.53;
            int costo=0;
                try {
            PreparedStatement crearUser=null;
            String sql="select costo FROM revista  WHERE idrevista=?";
            crearUser=iniciarConeccion.coneccion.prepareStatement(sql);
            crearUser.setInt(1, Integer.parseInt(request.getParameter("id")));
            ResultSet tm=crearUser.executeQuery();
           
            while(tm.next()){
            
            costo=(tm.getInt("costo"));
            
            }
            
          
            
        } catch (SQLException ex) {
        s.print(ex.getMessage());
        }
                
          try {
            PreparedStatement crearUser=null;
            String sql="select porcentaje FROM datosGlobales ";
            crearUser=iniciarConeccion.coneccion.prepareStatement(sql);
           
            ResultSet tm=crearUser.executeQuery();
           
            while(tm.next()){
            
            ganancia=(((tm.getInt("porcentaje"))*costo));
            
            }
        
          
            
        } catch (SQLException ex) {
        s.print(ex.getMessage());
        }
            double gs=ganancia/100;

              try {
            
            PreparedStatement crearUser=null; 
             crearUser=iniciarConeccion.coneccion.prepareStatement("INSERT INTO datos ("
                     + "pago,ganancia, idrevista,user, "
                    + "fecha) VALUES (?,?,?,?,?)");
         
            
         String startDate=request.getParameter("fecha");
SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
java.util.Date date = null;
        try {
            date = sdf1.parse(startDate);
        } catch (ParseException ex) {
       
        }
 java.sql.Date sqlStartDate = new java.sql.Date(date.getTime()); 
        
        
             
            crearUser.setInt(1, costo);
            crearUser.setDouble(2, gs);
            crearUser.setInt(3, Integer.parseInt(request.getParameter("id")));
            crearUser.setString(4, sesion.getAttribute("usuario").toString());
            crearUser.setDate(5, sqlStartDate);
            
          
       
            
         crearUser.executeUpdate();
         
            PreparedStatement suscrip=null; 
             suscrip=iniciarConeccion.coneccion.prepareStatement("INSERT INTO suscripcion ("
                     + "user,idrevista, estado, "
                    + "fecha) VALUES (?,?,?,?)");
             suscrip.setString(1, sesion.getAttribute("usuario").toString());
             suscrip.setInt(2,  Integer.parseInt(request.getParameter("id")));
             suscrip.setString(3, "activo");
             suscrip.setDate(4, sqlStartDate);
         suscrip.executeUpdate();
        
        } catch (SQLException ex) {
            s.print(ex.getMessage());
        }
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
           if(iniciarConeccion.coneccion==null){
            iniciarConeccion.IniciarConeccion();
            }
          InputStream input= null;
    Part filePart = request.getPart("archivo");
     input=filePart.getInputStream();
        
     String sql = "INSERT INTO versiones (idrevista, revistaG) VALUES(?,?)";
      PreparedStatement ps2 = null;
        try {
            ps2 = iniciarConeccion.coneccion.prepareStatement(sql);
           
            
            ps2.setInt(1, Integer.parseInt(request.getParameter("id")));
         
            ps2.setBlob(2, input);
         
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

}
