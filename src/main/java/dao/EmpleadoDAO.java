/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Config.ConexionBD;
import Models.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
    
    public void crearEmpleado(Empleado empleado){
        String sql = "INSERT INTO Empleado (nombre, direccion, telefono, email, cargo) VALUES (?, ?, ?, ?, ?)";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, empleado.getNombre());
            statement.setString(2, empleado.getDireccion());
            statement.setString(3, empleado.getTelefono());
            statement.setString(4, empleado.getEmail());
            
        }
        catch(SQLException e){
            System.out.println("Error al crear el empleado " + e.getMessage() );             
        }
        
    }
}
