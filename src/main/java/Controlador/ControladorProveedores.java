/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Datos.Datos;
import Modelo.Proveedores;
import com.mycompany.mitienda.MiTienda;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class ControladorProveedores {
    Datos datos = new Datos();
    
     
    public ArrayList<Proveedores> todosProveedores(){
        ArrayList<Proveedores> proveedores = new ArrayList<>();
        datos.traerProveedores(MiTienda.conexion);
        try {
            while(MiTienda.conexion.getResultado().next()){
                Proveedores proveedor = new Proveedores();
                proveedor.setId(MiTienda.conexion.getResultado().getInt(1));
                proveedor.setNombre(MiTienda.conexion.getResultado().getString(2));
                proveedor.setTelefono(MiTienda.conexion.getResultado().getInt(3));
                proveedor.setDireccion(MiTienda.conexion.getResultado().getString(4));
                proveedor.setCiudad(MiTienda.conexion.getResultado().getString(5));
                proveedor.setEmail(MiTienda.conexion.getResultado().getString(6));
                proveedor.setApuntes(MiTienda.conexion.getResultado().getString(7));
                proveedores.add(proveedor);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return proveedores;
    }
    
}
