/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Conexion.Conexion;
import Datos.Datos;
import Modelo.Productos;
import com.mycompany.mitienda.MiTienda;
import java.awt.List;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class ControladorProductos {
    Datos datos = new Datos();
    public ArrayList<Productos> todosProductos(){
        ArrayList<Productos> productos = new ArrayList<>();
        datos.traerProductos(MiTienda.conexion);
        try {
            while(MiTienda.conexion.getResultado().next()){
                Productos producto = new Productos();
                producto.setCodigo(MiTienda.conexion.getResultado().getInt(2));
                producto.setNombre(MiTienda.conexion.getResultado().getString(3));
                producto.setPrecio(MiTienda.conexion.getResultado().getDouble(4));
                producto.setCantidad(MiTienda.conexion.getResultado().getInt(5));
                System.out.println(producto.toString());
                productos.add(producto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productos;
        
    }
}
