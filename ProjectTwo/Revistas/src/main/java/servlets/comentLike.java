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
         processRequest(request, response);
          PrintWriter s=response.getWriter();
        s.print(request.getParameter("id"));
       try {
            processRequest(request, response);
             HttpSession sesion=request.getSession();
            
            PreparedStatement crearUser=null;
            crearUser=iniciarConeccion.coneccion.prepareStatement("INSERT INTO Ilike (idrevista, user) values (?,?)");

            crearUser.setInt(1, Integer.parseInt(request.getParameter("id")));
            crearUser.setString(2, sesion.getAttribute("usuario").toString());
             crearUser.executeUpdate();
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
          try {
            processRequest(request, response);
             HttpSession sesion=request.getSession();
            
            PreparedStatement crearUser=null;
            crearUser=iniciarConeccion.coneccion.prepareStatement("INSERT INTO comentario ( comentario, idrevista, user) values (?,?,?)");
            crearUser.setString(1, request.getParameter("comentar"));
            crearUser.setInt(2, Integer.parseInt(request.getParameter("id")));
            crearUser.setString(3, sesion.getAttribute("usuario").toString());
             crearUser.executeUpdate();
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
