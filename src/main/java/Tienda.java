
import Controllers.CategoriaController;
import Controllers.ProductoController;
import Models.Categoria;
import Views.Login;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

/**
 *
 * @author kalic
 */
public class Tienda {

    public static void main(String[] args) { 
       
       Login login = new Login();
       login.setVisible(true);
       login.setLocationRelativeTo(null);
    }   
}
