/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author jhonny
 */
public class iniciarConeccion {
  public static Connection coneccion;

    public static Connection getConeccion() {
        return coneccion;
    }
            
             public static void IniciarConeccion(){
    	String user = "root";
		String password = "isma2001";
		String stringConnection = "jdbc:mysql://localhost:3306/revistas";

        try {
             coneccion= DriverManager.getConnection(stringConnection, user, password);
        } catch (SQLException ex) {
        System.out.println("Fallo");
        }
            
    }
}
