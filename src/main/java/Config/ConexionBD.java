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

    public Connection getConexion() {

        String url = "jdbc:sqlserver://localhost:1433/Tienda";
        String usuario = "sa";
        String clave = "masterkey";

        Connection connection = null;
        try {
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
