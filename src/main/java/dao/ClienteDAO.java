/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Config.ConexionBD;
import java.sql.Connection;

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
    
}
