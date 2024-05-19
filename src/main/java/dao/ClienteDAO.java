/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Config.ConexionBD;
import Models.Cliente;
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
public class ClienteDAO {
    
    private Connection connection;
    private ConexionBD conexionBD;
    
    public ClienteDAO(){
        conexionBD = new ConexionBD();
        connection = conexionBD.getConexion();   
    }
    
    public void crearCliente(Cliente cliente){
        String sql= "INSERT INTO Cliente (nombre, telefono, direccion, email) VALUES (?)";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, cliente.getNombre());
            statement.setString(2, cliente.getTelefono());
            statement.setString(3, cliente.getDireccion());                      
            statement.setString(4, cliente.getEmail());
            statement.executeUpdate();
        
        }catch(SQLException e){
               System.out.println("Error al guardar los datos"+ e.getMessage());    
         }      
    }
    
    public List<Cliente> listarClientes()
    {
        List<Cliente> listClientes = new ArrayList<>();
        String sql = "SELECT FROM * Cliente";
        
        try(Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql))
        {
            while(resultSet.next())
                    {
                        int id = resultSet.getInt("clienteID");
                        String nombre = resultSet.getString("nombre");
                        String telefono = resultSet.getString("telefono");
                        String direccion = resultSet.getString("direccion");
                        String email = resultSet.getString("email");
                        Cliente cliente = new Cliente(id, nombre, telefono, direccion, email);
                        listClientes.add(cliente);
                    }            
        }
        catch(SQLException e)
        {
            System.out.println("Error al consultar los datos" + e.getMessage());
        }   
        return listClientes;    
    }
    
    public void actualizarCliente(Cliente cliente)
    {
        String sql = ("UPDATE Cliente SET nombre = ?, telefono = ?, direccion = ?, email = ? WHERE clienteID = ?" );
        
        try( PreparedStatement statement = connection.prepareStatement(sql))
        {
            statement.setString(1, cliente.getNombre());
            statement.setString(2, cliente.getTelefono());
            statement.setString(3, cliente.getDireccion());
            statement.setString(4, cliente.getEmail());
            statement.setInt(5, cliente.getClienteID());
            statement.executeUpdate();
            
        }
        catch(SQLException e)
        {
            System.out.println("Error al actualizar el cliente " + e.getMessage());
        }
    }
    
}
