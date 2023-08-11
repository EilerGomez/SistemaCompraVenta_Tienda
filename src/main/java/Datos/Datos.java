/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import Conexion.Conexion;
import Modelo.Proveedores;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    public void actualizarProveedor(Proveedores proveedor, Conexion conexion) {
        String query = "update proveedores set nombre=?, telefono=?, direccion=?, ciudad=?,email=?,apuntes=? where id=?;";
        try {
            PreparedStatement stmt = conexion.getConnection().prepareStatement(query);
            stmt.setString(1, proveedor.getNombre());
            stmt.setInt(2, proveedor.getTelefono());
            stmt.setString(3, proveedor.getDireccion());
            stmt.setString(4, proveedor.getCiudad());
            stmt.setString(5, proveedor.getEmail());
            stmt.setString(6, proveedor.getApuntes());
            stmt.setInt(7, proveedor.getId());
            stmt.executeUpdate();
            stmt.close();
        } catch (Exception e) {
        }
    }
    public void eliminarProveedor(int idProveedor, Conexion conexion) {
        try {
            PreparedStatement stm = conexion.getConnection().prepareStatement("delete from proveedores where id=?;");
            stm.setInt(1, idProveedor);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
