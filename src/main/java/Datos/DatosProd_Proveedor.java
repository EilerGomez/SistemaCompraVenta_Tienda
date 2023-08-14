/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import Conexion.Conexion;
import Controlador.Productos_Proveedor;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author HP
 */
public class DatosProd_Proveedor {

    public void traerTodaTabla(Conexion conexion) {
        String query = "select * from prod_proveedor;";
        try {
            PreparedStatement stmt = conexion.getConnection().prepareStatement(query);
            conexion.setResultSet(stmt.executeQuery());
            System.out.println("hecho");
        } catch (SQLException e) {
            System.out.println("Error al consultar las productos_proveedores:" + e);
        }
    }
    
    public void guardarNuevoProd_Prov(Conexion conexion, Productos_Proveedor pp){
        String query = "insert into prod_proveedor(c_producto,id_proveedor) values(?,?);";
         try (PreparedStatement stmt = conexion.getConnection().prepareStatement(query)) {
            stmt.setString(1, pp.getCodigoProducto());
            stmt.setInt(2, pp.getCodigoProveedor());
            stmt.executeUpdate();
            stmt.close();
            System.out.println("hecho");
        } catch (SQLException e) {
            System.out.println("Error al guardar producto_proveedor: " + e);
        }
    }
}
