/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import classes.iniciarConeccion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import classes.iniciarConeccion;
import java.sql.ResultSet;

/**
 *
 * @author jhonny
 */
@WebServlet(name = "admin", urlPatterns = {"/admin"})
public class admin extends HttpServlet {

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
        }
           try {
            PreparedStatement admin=null;
            
            admin=iniciarConeccion.coneccion.prepareStatement("INSERT INTO administrador"
                    + " (username, contraseña, nombre  ) VALUES (?,?,?)");
            
            admin.setString(3, request.getParameter("nombre"));
            
            admin.setString(1, request.getParameter("user"));
            
            admin.setString(2, request.getParameter("password"));
            
            admin.executeUpdate();
            response.sendRedirect("/Revistas/Administrador/admin.jsp");
        } catch (SQLException ex) {
        PrintWriter ss=response.getWriter();
        ss.print(ex.getMessage());
            response.sendRedirect("/Revistas/Administrador/registrar.jsp?m=error");
           
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
        
        
          try {
           String sql=null;
              sql="SELECT * FROM administrador WHERE username=? && contraseña=?";
        
           PreparedStatement iniciarSesion=iniciarConeccion.coneccion.prepareStatement(sql);
     
           iniciarSesion.setString(1, request.getParameter("usuario"));
           iniciarSesion.setString(2,request.getParameter("password"));
           ResultSet sesion=iniciarSesion.executeQuery();
           boolean valid=false;
          while(sesion.next()){
              valid=true;
           }
          
          if(valid){
          
          }
              response.sendRedirect("Administrador/funcionesAdmin.jsp");   
            } catch (SQLException ex) {
               response.sendRedirect("Administrador/admin.jsp");  
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
