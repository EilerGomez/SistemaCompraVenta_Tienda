/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.mitienda;

import Conexion.Conexion;
import Controlador.ControladorProductos;
import Controlador.ControladorProveedores;
import Modelo.Productos;
import Modelo.Proveedores;
import Vista.VentanaPrincipal;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class MiTienda {
    static ControladorProductos cp= new ControladorProductos();
    static ControladorProveedores cpv= new ControladorProveedores();
    public static Conexion conexion = new Conexion();
    static VentanaPrincipal ventana;
    public static ArrayList<Proveedores> datosProveedores;

    public static void main(String[] args) {
        MiTienda mt = new MiTienda();    
        

    }
    
    public MiTienda(){
        ventana = new VentanaPrincipal();
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
        ventana.setEnabled(true);
        ventana.setResizable(false);
        conexion.conectar();
        datosProveedores=cpv.todosProveedores();
        LlenarTablaProductos();
        llenarTablaProveedores(datosProveedores);
        
    }
    
    public void LlenarTablaProductos(){
        ArrayList<Productos> datos=cp.todosProductos();
        DefaultTableModel tabla = new DefaultTableModel();
        String[] fila = new String[4];
        tabla.addColumn("Codigo");
        tabla.addColumn("Nombre");
        tabla.addColumn("Precio");
        tabla.addColumn("Cantidad");
        for (int i = 0; i < datos.size(); i++) {            
            fila[0] = Integer.toString(datos.get(i).getCodigo());
            fila[1]=datos.get(i).getNombre();
            fila[2]="Q.  "+Double.toString(datos.get(i).getPrecio());
            fila[3]=Integer.toString(datos.get(i).getCantidad());
            tabla.addRow(fila);
        }
        ventana.productosTabla.setModel(tabla);
    }
    
    public static void llenarTablaProveedores(ArrayList<Proveedores> proveedores){
        
        DefaultTableModel tabla = new DefaultTableModel();
        String[] fila = new String[6];
        tabla.addColumn("Id");
        tabla.addColumn("Nombre");
        tabla.addColumn("Telefono");
        tabla.addColumn("Direccion");
        tabla.addColumn("Ciudad");
        tabla.addColumn("Email");
        for (int i = 0; i < proveedores.size(); i++) {            
            fila[0] = Integer.toString(proveedores.get(i).getId());
            fila[1]=proveedores.get(i).getNombre();
            fila[2]=Integer.toString(proveedores.get(i).getTelefono());
            fila[3]=proveedores.get(i).getDireccion();
            fila[4]=proveedores.get(i).getCiudad();
            fila[5]=proveedores.get(i).getEmail();
            tabla.addRow(fila);
        }
        ventana.tablaProveedores.setModel(tabla);
        
    }
    
    
}
