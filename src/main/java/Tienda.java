
import Controllers.CategoriaController;
import Controllers.ProductoController;
import Models.Categoria;
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
       
       CategoriaController categoriaController = new CategoriaController();
        categoriaController.mostrarMenu();
        
        ProductoController productoController = new ProductoController();
        productoController.mostrarMenu();
    }   
}
