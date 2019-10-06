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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jhonny
 */
@WebServlet(name = "comentLike", urlPatterns = {"/comentLike"})
public class comentLike extends HttpServlet {

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
        
        
        String username=null;
        PreparedStatement edit=null;
        try {
            edit=iniciarConeccion.coneccion.prepareStatement("SELECT username FROM revista where idrevista=?");
            
            edit.setInt(1, Integer.parseInt(request.getParameter("id")));
            ResultSet ts=edit.executeQuery();
            if(ts.next()){
            username=ts.getString("username");
            }
        } catch (SQLException ex) {
        
        }

        
         processRequest(request, response);
                   
         String startDate=request.getParameter("fecha");
SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
java.util.Date date = null;
        try {
            date = sdf1.parse(startDate);
        } catch (ParseException ex) {
       
        }
 java.sql.Date sqlStartDate = new java.sql.Date(date.getTime()); 
        
          PrintWriter s=response.getWriter();
       try {
            processRequest(request, response);
             HttpSession sesion=request.getSession();
            
            PreparedStatement crearUser=null;
            crearUser=iniciarConeccion.coneccion.prepareStatement("INSERT INTO Ilike (idrevista, user, fecha,editor) values (?,?,?,?)");

            crearUser.setInt(1, Integer.parseInt(request.getParameter("id")));
            crearUser.setString(2, sesion.getAttribute("usuario").toString());
            crearUser.setDate(3, sqlStartDate);
            crearUser.setString(4, username);
             crearUser.executeUpdate();
        } catch (SQLException ex) {
        }
    response.sendRedirect("Jsp/comentarioMegusta.jsp");
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
        
               
         String startDate=request.getParameter("fecha");
SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
java.util.Date date = null;
        try {
            date = sdf1.parse(startDate);
        } catch (ParseException ex) {
       
        }
 java.sql.Date sqlStartDate = new java.sql.Date(date.getTime()); 
        
        
          try {
            processRequest(request, response);
             HttpSession sesion=request.getSession();
            
            PreparedStatement crearUser=null;
            crearUser=iniciarConeccion.coneccion.prepareStatement("INSERT INTO comentario ( comentario, idrevista, user, fecha) values (?,?,?,?)");
            crearUser.setString(1, request.getParameter("comentar"));
            crearUser.setInt(2, Integer.parseInt(request.getParameter("id")));
            crearUser.setString(3, sesion.getAttribute("usuario").toString());
            crearUser.setDate(4, sqlStartDate);
             crearUser.executeUpdate();
        } catch (SQLException ex) {
        PrintWriter s=response.getWriter();
        s.print(ex.getMessage());
        }
    response.sendRedirect("Jsp/comentarioMegusta.jsp");
         
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
