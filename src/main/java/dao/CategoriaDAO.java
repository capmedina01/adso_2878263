/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Config.ConexionBD;
import Models.Categoria;
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
public class CategoriaDAO {
    
    private Connection connection;
    private ConexionBD conexionBD;
    
    public CategoriaDAO(){
        conexionBD = new ConexionBD();
        connection = conexionBD.getConexion();         
    }
    
    public void crearCategoria(Categoria categoria){
        String sql = "INSERT INTO categoria (nombre) VALUES (?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, categoria.getNombre());
            statement.executeUpdate();
        
        }catch (SQLException e){
           System.out.println("Error al guardar los datos" + e.getMessage());
         }    
    }
    
    public List<Categoria> leerCategoria(){
        List<Categoria> listCategoria = new ArrayList<>();
        String sql = "SELECT * FROM categoria";
        try(Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)){
            while(resultSet.next()){
            int id = resultSet.getInt("categoriaID");
            String nombre = resultSet.getString("nombre");
            Categoria categoria = new Categoria(id, nombre);
            listCategoria.add(categoria);
            }
        
        }catch (SQLException e){
           System.out.println("Error al consultar los datos" + e.getMessage());
         } 
        
        return listCategoria;
    }
    
    public void actualizarCategoria(Categoria categoria){
        String sql = "UPDATE categoria SET nombre = ? WHERE categoriaID =?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, categoria.getNombre());
            statement.setInt(2, categoria.getCategoriaID());
            statement.executeUpdate();
        } catch (SQLException e){
           System.out.println("Error al actualizar los datos" + e.getMessage());
         }    
    }
    
    public void eliminarCategoria(int id){
       String sql = "DELETE FROM categoria WHERE id = ?";
       try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, id);
            statement.executeUpdate();
       } catch (SQLException e){
           System.out.println("Error al eliminar los datos" + e.getMessage());
         }   
    }
    
    public void cerrarConexion(){
        conexionBD.closeConnection(connection);
    
    
    }
    
}
