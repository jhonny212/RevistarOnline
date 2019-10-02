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
import java.sql.ResultSet;
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
@WebServlet(name = "datos2", urlPatterns = {"/datos2"})
public class datos2 extends HttpServlet {

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
                 
                  int costo=0;
        PrintWriter s=response.getWriter();
        if(Integer.parseInt((request.getParameter("costos")))==0   ){
                 try {
            PreparedStatement crearUser=null;
            String sql="select costoDia FROM datosGlobales WHERE id=?";
            crearUser=iniciarConeccion.coneccion.prepareStatement(sql);
            crearUser.setInt(1, 1);
            ResultSet tm=crearUser.executeQuery();
           
            while(tm.next()){
            
            costo=(tm.getInt("costoDia"));
            
            }
            
          
            
        } catch (SQLException ex) {
            s.print(ex.getMessage());
        }
         
        }else{
        costo=Integer.parseInt((request.getParameter("costos")));
        }
            
        try {
            String  sql="UPDATE revista SET tarifa=? WHERE idrevista=? ";
                    
        
           PreparedStatement iniciarSesion=iniciarConeccion.coneccion.prepareStatement(sql);
           iniciarSesion.setInt(1,costo);
         
           iniciarSesion.setInt(2,Integer.parseInt(request.getParameter("btn")));
          
           iniciarSesion.executeUpdate();
     
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
