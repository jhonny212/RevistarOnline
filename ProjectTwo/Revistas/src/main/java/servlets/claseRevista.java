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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            String  sql="UPDATE revista SET tarifa=?, revistacol=? WHERE idrevista=? ";
                    
        
           PreparedStatement iniciarSesion=iniciarConeccion.coneccion.prepareStatement(sql);
           iniciarSesion.setInt(1,costo);
         iniciarSesion.setString(2, "activo");
           iniciarSesion.setInt(3,Integer.parseInt(request.getParameter("btn")));
          
           iniciarSesion.executeUpdate();
     
       } catch (SQLException ex) {
                   
   s.print(ex.getMessage());
            }
       response.sendRedirect("Administrador/fijarCosto.jsp");
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
                      
       HttpSession sesion=request.getSession();
            String nombre=request.getParameter("nombre");
        String costo=request.getParameter("costo");  
        String cat1=request.getParameter("text1");  
        String descripcion=request.getParameter("descripcion");
         PrintWriter s=response.getWriter();;
        
           InputStream input= null;
    Part filePart = request.getPart("fichero");
     input=filePart.getInputStream();
        
         if(cat1==null){
            
              s.print("joder");
          cat1=request.getParameter("categorias");
         }else{
              if(cat1.equals("")){
              cat1=request.getParameter("categorias");
             s.print(cat1);
             }else{
                    s.print("joder3");
            try {
                PreparedStatement crearcat=iniciarConeccion.coneccion.prepareStatement("INSERT INTO categoria  (idcategoria) VALUES (?)");
                crearcat.setString(1, cat1);
                crearcat.executeUpdate();
            } catch (SQLException ex) {
            }
     }
              
           
         }
        
      String sql = "INSERT INTO revista (nombre, username, idcategoria, costo,revistaG, descripcion, tarifa, revistacol) VALUES(?,"
              + " ?, ?,?, ?,?,?,? );";  
      PreparedStatement ps2 = null;
        try {
            ps2 = iniciarConeccion.coneccion.prepareStatement(sql);
            ps2.setString(1,nombre);
            ps2.setString(2, sesion.getAttribute("usuario").toString());
            ps2.setString(3, cat1);
            ps2.setInt(4, 10);
            ps2.setBlob(5, input);
            ps2.setString(6, descripcion);
            ps2.setInt(7, 1);
            ps2.setString(8, "descativo");
            ps2.executeUpdate();
           
        } catch (Exception ex) {
            response.sendRedirect("Editor/Editor.jsp");
        
        } 
      response.sendRedirect("Editor/Editor.jsp");    
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
