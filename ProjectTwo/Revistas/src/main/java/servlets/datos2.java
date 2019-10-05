/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import classes.iniciarConeccion;
import classes.revista;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        // variable fecha
         java.util.Date date1=null;
        java.sql.Date sqlStartDate1=null;
        HttpSession sesion=request.getSession();
        
        
      
            PrintWriter s=response.getWriter();
         try {
         // seleccionar todas las suscripciones para ver el estado, de dicho usuario
        
         PreparedStatement read2=null;
         String sql2=null;
         ResultSet sesion2=null;
         sql2="SELECT * FROM suscripcion where user=? && idrevista=?";
         
          
         
         read2=iniciarConeccion.coneccion.prepareStatement(sql2);
         read2.setString(1,sesion.getAttribute("usuario").toString());
         read2.setInt(2,Integer.parseInt(request.getParameter("btn")));
         sesion2=read2.executeQuery();
        
         
             String  sql=null;
                    
    
           
         while(sesion2.next()){
              // obtener fehca de suscripcion
              
              
             date1 = sesion2.getDate("fecha");
              sqlStartDate1 = new java.sql.Date(date1.getTime()); 
             /// statement diferencia de meses
         PreparedStatement read3=null;
         String sql3=null;
         ResultSet sesion3=null;
        sql3="SELECT TIMESTAMPDIFF(MONTH, '"+sesion2.getDate("fecha")+"', '"+request.getParameter("fecha")+"') AS meses_transcurridos;";
         
         
         
         read3=iniciarConeccion.coneccion.prepareStatement(sql3);
       
                     
         String startDate=request.getParameter("fecha");
SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
    java.util.Date date = null;
// parsear fecha
        try {
            date = sdf1.parse(startDate);
        } catch (ParseException ex) {
       
        }
 java.sql.Date sqlStartDate = new java.sql.Date(date.getTime()); 
        
         sesion3=read3.executeQuery();
                   PreparedStatement iniciarSesion=null;
            if(sesion3.next()){
              
                //condicion 1 si ni con el pago actualiza la suscripcion
             if(sesion3.getLong(1)<0){
                sql="UPDATE suscripcion SET fecha=? WHERE idrevista=? && user=? ";
           
                iniciarSesion=iniciarConeccion.coneccion.prepareStatement(sql);
          
                iniciarSesion.setDate(1,sqlStartDate);
         
                
              
         iniciarSesion.setString(3,sesion.getAttribute("usuario").toString());
         iniciarSesion.setInt(2,Integer.parseInt(request.getParameter("btn")));
         s.print("entra acasi");
              iniciarSesion.executeUpdate();
              s.print("entra ssa");
              int codtmo=(int) Math.abs(sesion3.getLong(1));
              // funcion pago
              pago(Integer.parseInt(request.getParameter("btn")),
                      sesion.getAttribute("usuario").toString(), codtmo,startDate, sqlStartDate1);
             }else{
                 // si el pago es suficiente
                 s.print("no entra");
                 sql="UPDATE suscripcion SET estado=?, fecha=? WHERE idrevista=? && user=? ";
                iniciarSesion=iniciarConeccion.coneccion.prepareStatement(sql);
          
                iniciarSesion.setString(1,"activo");
                 iniciarSesion.setDate(2,sqlStartDate);
         
         iniciarSesion.setString(4,sesion.getAttribute("usuario").toString());
         iniciarSesion.setInt(3,Integer.parseInt(request.getParameter("btn")));
           iniciarSesion.executeUpdate();
            int codtmo=(int) Math.abs(sesion3.getLong(1));
            s.print(codtmo+"wtf");
           pago(Integer.parseInt(request.getParameter("btn")),sesion.getAttribute("usuario").toString(), 
                   codtmo,startDate,sqlStartDate1);
            
             }
             
        
         
          
         
         
         }
         
         }
         
         
         
          
         
     } catch (SQLException ex) {
         s.print(ex.getMessage());
     }
        
           
     revista.actualizarSuscripcion();
     response.sendRedirect("Jsp/magazine.jsp");
     
    }
    public void pago(int id, String cod, int cod2,String fecha,   java.sql.Date fecha1){
    double ganancia=0;
            double g=1.53;
            int costo=0;
            int gananciaEdit=0;
            
            // obetener datos para hacer pago
                try {
            PreparedStatement crearUser=null;
            String sql="select tarifa, costo FROM revista  WHERE idrevista=?";
            crearUser=iniciarConeccion.coneccion.prepareStatement(sql);
            crearUser.setInt(1, id);
            ResultSet tm=crearUser.executeQuery();
           
            while(tm.next()){
            // costo por dia
            costo=(cod2*30*(tm.getInt("tarifa")));
            // ganancia editor
            gananciaEdit=(cod2*(tm.getInt("costo")));
            }
            
          
            
        } catch (SQLException ex) {
        }
                
          try {
            PreparedStatement crearUser=null;
            String sql="select porcentaje FROM datosGlobales ";
            crearUser=iniciarConeccion.coneccion.prepareStatement(sql);
           
            ResultSet tm=crearUser.executeQuery();
           
            while(tm.next()){
            // ganacia cliente
            ganancia=(((tm.getInt("porcentaje"))*gananciaEdit));
            
            }
        
          
            
        } catch (SQLException ex) {
        }
          
            double gs=ganancia/100;

              try {
            
            PreparedStatement crearUser=null; 
             crearUser=iniciarConeccion.coneccion.prepareStatement("INSERT INTO datos ("
                     + "pago,ganancia, idrevista,user, "
                    + "fecha, gananciaEditor,fecha1) VALUES (?,?,?,?,?,?,?)");
         
           // parsear fecha que se hara pagi 
         String startDate=fecha;
SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
java.util.Date date = null;
        try {
            date = sdf1.parse(startDate);
        } catch (ParseException ex) {
       
        }
 java.sql.Date sqlStartDate = new java.sql.Date(date.getTime()); 
        
        // crear pago
             
            crearUser.setInt(1, costo);
            crearUser.setDouble(2, gs);
            crearUser.setInt(3,id);
            crearUser.setString(4,cod);
            crearUser.setDate(5, sqlStartDate);
            
            crearUser.setDouble(6, (gananciaEdit-gs));
            crearUser.setDate(7, fecha1);
          
       
            
         crearUser.executeUpdate();
         
        } catch (SQLException ex) {
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
