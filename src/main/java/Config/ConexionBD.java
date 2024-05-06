/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author kalic
 */
public class ConexionBD {
    
    Connection connection = null;
    String usuario = "sa";
    String clave = "master123";
    String bd = "Tienda";
    String ip = "localhost";
    String puerto = "1433";
            
    String url = "jdbc:sqlserver://"+ip+":"+puerto+"/"+bd;
    

    public Connection getConexion() {        
        try {
            String url = "jdbc:sqlserver://localhost:"+puerto+";"+"databaseName="+bd+";trustServerCertificate=true";
            connection = DriverManager.getConnection(url, usuario, clave);
            System.out.println("Conexión exitosa");
        } catch (SQLException e) {
            System.out.println("Error: Conexión fallida" + e.getMessage());
        }

        return connection;
                
    }

    public void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println(" Cierre de conexión exitosa");
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión" + e.getMessage());
            }
        }

    }

}
