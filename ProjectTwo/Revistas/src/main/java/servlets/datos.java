/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import classes.iniciarConeccion;
import static classes.usuario.message;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jhonny
 */
@WebServlet(name = "datos", urlPatterns = {"/datos"})
public class datos extends HttpServlet {

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
            }
        try {
            String  sql="UPDATE revista SET costo=? WHERE idrevista=? ";
                    
        
           PreparedStatement iniciarSesion=iniciarConeccion.coneccion.prepareStatement(sql);
           iniciarSesion.setInt(1,Integer.parseInt((request.getParameter("costos"))));
         
           iniciarSesion.setInt(2,Integer.parseInt(request.getParameter("btn")));
          
           iniciarSesion.executeUpdate();
     
       } catch (SQLException ex) {
                    PrintWriter s=response.getWriter();
   s.print(ex.getMessage());
            }
        
        response.sendRedirect("Administrador/funcionesAdmin.jsp");
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
         PrintWriter s=response.getWriter();
        processRequest(request, response);
        
        if(Integer.parseInt( request.getParameter("porcentaje"))==0    
                || Integer.parseInt( request.getParameter("costo"))==0){
        
        }else{
            if(iniciarConeccion.coneccion==null){
            iniciarConeccion.IniciarConeccion();
            }
        try {
            String  sql="UPDATE datosGlobales SET porcentaje=?, costoDia=?  WHERE id=?";
                   
        
           PreparedStatement iniciarSesion=iniciarConeccion.coneccion.prepareStatement(sql);
           iniciarSesion.setInt(1,Integer.parseInt( request.getParameter("porcentaje")));
           iniciarSesion.setInt(2,Integer.parseInt( request.getParameter("costo")));
           iniciarSesion.setInt(3,1);
          
           iniciarSesion.executeUpdate();
     
       } catch (SQLException ex) {
             
              s.print(ex.getMessage());
            }
        
        
           response.sendRedirect("Administrador/funcionesAdmin.jsp");
        }
        /*if(Integer.parseInt( request.getParameter("porcentaje"))==0    
                || Integer.parseInt( request.getParameter("costo"))==0){
        
        
             
        
        }else{
        response.sendRedirect("");
        }
        */
        
        response.sendRedirect("Administrador/funcionesAdmin.jsp");
        
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
