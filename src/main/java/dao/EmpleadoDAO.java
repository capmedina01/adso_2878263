/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Config.ConexionBD;
import Models.Empleado;
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
public class EmpleadoDAO {
    
    private Connection connection;
    private ConexionBD conexionBD;
    
    public EmpleadoDAO(){
        
        conexionBD = new ConexionBD();
        connection = conexionBD.getConexion();
    }
    
    public void crearEmpleado(Empleado empleado)
    {
        String sql = "INSERT INTO Empleado (nombre, direccion, telefono, email, cargo) VALUES (?, ?, ?, ?, ?)";
        try(PreparedStatement statement = connection.prepareStatement(sql))
        {
            statement.setString(1, empleado.getNombre());
            statement.setString(2, empleado.getDireccion());
            statement.setString(3, empleado.getTelefono());
            statement.setString(4, empleado.getEmail());
            
        }
        catch(SQLException e)
        {
            System.out.println("Error al crear el empleado " + e.getMessage());             
        }
        
    }
    
    public List<Empleado> listarempleado()
    {
        List<Empleado> empleados = new ArrayList<>();
        String sql = "SELECT * FROM Empleado";
         try(Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql))
        {
            while(resultSet.next())
            {
                int id = resultSet.getInt("empleadoID");
                String nombre = resultSet.getString("nombre");
                String direccion = resultSet.getString("direccion");
                String telefono = resultSet.getString("telefono");
                String email = resultSet.getString("email");
                String cargo = resultSet.getString("cargo");
                
                Empleado empleado = new Empleado(id, nombre, direccion, telefono, email, cargo);
                empleados.add(empleado);
            }            
        }
        catch(SQLException e)
        {
            System.out.println("Error al listar los empleados " + e.getMessage());  
        }
        
        return empleados;
    }
    
    public void actualizarEmpleado(Empleado empleado)
    {
        String sql = "UPDATE Cliente SET nombre = ?, direccion = ?, telefono = ?, email = ?, cargo = ? WHERE empleadoID = ?";
        try(PreparedStatement statement = connection.prepareStatement(sql))
        {
            statement.setString(1, empleado.getNombre());
            statement.setString(2, empleado.getDireccion());
            statement.setString(3, empleado.getTelefono());
            statement.setString(4, empleado.getEmail());
            statement.setString(5, empleado.getCargo());
            statement.setInt(6, empleado.getEmpleadoID());
            statement.executeUpdate();
        }
        catch(SQLException e)
        {
            System.out.println("Error al actualizar los datos del empleado " + e.getMessage());
        }
    }
    
    public void eliminarEmpleado(int id)
    {
        String sql = "DELETE FROM Empleado WHERE empleadoID = ?";
        try(PreparedStatement statement = connection.prepareStatement(sql))
        {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
        catch(SQLException e)
        {
            System.out.println("Error al eliminar el registro del empleado" + e.getMessage());
        }
        
    }
    public void cerrarConexion() {
        conexionBD.closeConnection(connection);
    }
}
