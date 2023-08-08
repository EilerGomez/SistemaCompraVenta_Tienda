/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import Conexion.Conexion;
import Modelo.Proveedores;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author HP
 */
public class Datos {
    public void traerProductos(Conexion conexion) {
        String query = "select * from productos;";
        try {
            PreparedStatement stmt = conexion.getConnection().prepareStatement(query);
            conexion.setResultSet(stmt.executeQuery());
            System.out.println("hecho");
        } catch (SQLException e) {
            System.out.println("Error al consultar las consultas:" + e);
        }
    }
    
    public void traerProveedores(Conexion conexion){
        String query = "select * from proveedores;";
        try {
            PreparedStatement stmt = conexion.getConnection().prepareStatement(query);
            conexion.setResultSet(stmt.executeQuery());
            System.out.println("hecho");
        } catch (SQLException e) {
            System.out.println("Error al consultar las consultas:" + e);
        }
    }
    
    public void guardarNuevoProveedor(Conexion conexion, Proveedores proveedor){
        String query = "insert into proveedores(nombre,telefono, direccion, ciudad, email, apuntes) values(?,?,?,?,?,?);";
         try (PreparedStatement stmt = conexion.getConnection().prepareStatement(query)) {
            stmt.setString(1, proveedor.getNombre());
            stmt.setInt(2, proveedor.getTelefono());
            stmt.setString(3, proveedor.getDireccion());
            stmt.setString(4, proveedor.getCiudad());
            stmt.setString(5, proveedor.getEmail());
            stmt.setString(6, proveedor.getApuntes());
            stmt.executeUpdate();
            stmt.close();
            System.out.println("hecho");
        } catch (SQLException e) {
            System.out.println("Error al guardar proveedor: " + e);
        }
    }
}
