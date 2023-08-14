/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Datos.DatosProd_Proveedor;
import Modelo.Productos;
import com.mycompany.mitienda.MiTienda;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class ControladorProductos_Proveedores {
    DatosProd_Proveedor datos = new DatosProd_Proveedor();
    public ArrayList<Productos_Proveedor> traerTodos(){
        ArrayList<Productos_Proveedor> prod_proveedores = new ArrayList<>();
        datos.traerTodaTabla(MiTienda.conexion);
        try {
            while(MiTienda.conexion.getResultado().next()){
                Productos_Proveedor producto_proveedor = new Productos_Proveedor();
                producto_proveedor.setCodigoProducto(MiTienda.conexion.getResultado().getString(1));
                producto_proveedor.setCodigoProveedor(MiTienda.conexion.getResultado().getInt(2));
                prod_proveedores.add(producto_proveedor);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return prod_proveedores;
    }
    public void guardarProducto_Proveedor(String codigoProducto,int codigoProveedor){
        Productos_Proveedor pp = new Productos_Proveedor(codigoProducto,codigoProveedor);
        datos.guardarNuevoProd_Prov(MiTienda.conexion, pp);
        MiTienda.datosProd_Proveedores.add(pp);
    }
}
