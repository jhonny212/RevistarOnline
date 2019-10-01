/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import classes.iniciarConeccion;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import classes.usuario;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author jhonny
 */
@WebServlet(name = "iniciarSesion", urlPatterns = {"/iniciarSesion"})
public class iniciarSesion extends HttpServlet {
public static String user;
public static String pass;
public static String tip;
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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet iniciarSesion</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet iniciarSesion at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
      usuario.iniciarSesion(request.getParameter("usuario"),request.getParameter("password"), request.getParameter("joder"));
      
        
       
               
          
                if(usuario.message.equals("correcto")){
                 try {
                     // RequestDispatcher dispatcher = request.getRequestDispatcher("Jsp/registrar.jsp");
                     user=null;
                     user=request.getParameter("usuario");
                     pass=null;
                     pass=request.getParameter("password");
                     tip=request.getParameter("joder");
                     
                     
                     if(request.getParameter("joder").equals("Usuario")){
                     response.sendRedirect("Jsp/index.jsp");
                 
                     }
                     else{
                     response.sendRedirect("Jsp/index.jsp");
                 }
                     //request.setAttribute("error", true);
                     //dispatcher.forward(request, response);
                 } catch (IOException ex) {
                 }
                      
               
        }else {
        
            try {
                     // RequestDispatcher dispatcher = request.getRequestDispatcher("Jsp/registrar.jsp");
                     
                     
                     response.sendRedirect("Jsp/index.jsp");
                     //request.setAttribute("error", true);
                     //dispatcher.forward(request, response);
                 } catch (IOException ex) {
                 }
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
