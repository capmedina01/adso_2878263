/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Config.ConexionBD;
import Models.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kalic
 */
public class ProductoDAO {
    private Connection connection;
    private ConexionBD conexionBD;
    
    public ProductoDAO(){
    conexionBD = new ConexionBD();
    connection = conexionBD.getConexion();    
    }
    
    public void crearProducto(Producto producto){
        String sql = "INSERT INTO producto(nombre, precio, categoriaId) VALUES(?, ?, ?)";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, producto.getNombreProducto());
            preparedStatement.setDouble(2, producto.getPrecio());
            preparedStatement.setInt(3, producto.getCategoria());
            preparedStatement.executeUpdate();
        
        }catch(SQLException e){
            System.out.println("Error al guardar el producto" + e.getMessage());
        
        }    
    }
    
     public List<Producto> leerProducto() {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM productos";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                double precio = resultSet.getDouble("precio");
                int categoriaId = resultSet.getInt("categoria_id");
                Producto producto = new Producto(id, nombre, precio, categoriaId);
                productos.add(producto);
            }
        } catch (SQLException e) {
                System.out.println("Error al consultar los datos: " + e.getMessage());
        }
        return productos;
    }

    public void actualizarProducto(Producto producto) {
        String sql = "UPDATE productos SET nombre = ?, precio = ?, categoria_id = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, producto.getNombreProducto());
            statement.setDouble(2, producto.getPrecio());
            statement.setInt(3, producto.getCategoria());
            statement.setInt(4, producto.getProductoID());
            statement.executeUpdate();
        } catch (SQLException e) {
                System.out.println("Error al actualizar los datos: " + e.getMessage());
        }
    }

    public void eliminarProducto(int id) {
        String sql = "DELETE FROM productos WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
                System.out.println("Error al eliminar los datos: " + e.getMessage());
        }
    }
    
    public void cerrarConexion() {
        conexionBD.closeConnection(connection);
    }
    
}
