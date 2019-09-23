/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import classes.iniciarConeccion;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import classes.usuario;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author jhonny
 */
@WebServlet(name = "CrearUsuario", urlPatterns = {"/CrearUser"})
public class crearUsuario extends HttpServlet {

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
        //    response.setContentType("text/html;charset=UTF-8");
        
      
    
        
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
    {
        
         
             usuario user=new usuario(request);
        user.registrarUsuario(user);
        
        if(usuario.message!=null){
                 try {
                     // RequestDispatcher dispatcher = request.getRequestDispatcher("Jsp/registrar.jsp");
                     
                     
                     response.sendRedirect("Jsp/registrar.jsp");
                     //request.setAttribute("error", true);
                     //dispatcher.forward(request, response);
                 } catch (IOException ex) {
                     Logger.getLogger(crearUsuario.class.getName()).log(Level.SEVERE, null, ex);
                 }
                      
               
        }else{
        
          RequestDispatcher dispatcher = request.getRequestDispatcher("/registrar.jsp");
                 try {
                     dispatcher.forward(request, response);
                      request.setAttribute("error", true);
                 } catch (ServletException ex) {
                 
                 } catch (IOException ex) {
                 }
        }
        
       
        }
        
       
      
      
        
        
        
        
   
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */


