/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.mitienda;

import Conexion.Conexion;
import Controlador.ControladorProductos;
import Controlador.ControladorProductos_Proveedores;
import Controlador.ControladorProveedores;
import Controlador.Productos_Proveedor;
import Modelo.Productos;
import Modelo.Proveedores;
import Vista.VentanaPrincipal;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class MiTienda {
    public static int ultimoRegistroProveedores;
    static ControladorProductos cp= new ControladorProductos();
    static ControladorProveedores cpv= new ControladorProveedores();
    static ControladorProductos_Proveedores cpp=new ControladorProductos_Proveedores();
    public static Conexion conexion = new Conexion();
    public static VentanaPrincipal ventana;
    public static ArrayList<Proveedores> datosProveedores;
    public static ArrayList<Productos> datosProductos;
    public static ArrayList<Productos_Proveedor> datosProd_Proveedores;
    
    
    public static void main(String[] args) {
    try {
        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");       // Nimbus (moderno)
       //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());         // Sistema operativo (Windows, Linux, etc.)
        //UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel"); 
      //UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel"); // Viejo estilo UNIX

      
    } catch (Exception ex) {
        ex.printStackTrace();
    }
        MiTienda mt = new MiTienda();    
        
    }
    
    public MiTienda(){
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();

        ventana = new VentanaPrincipal();
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
        ventana.setEnabled(true);
        ventana.setResizable(true);
        ventana.setSize(pantalla);
        ventana.pack();
        conexion.conectar();
        datosProveedores=cpv.todosProveedores();
        datosProductos = cp.todosProductos();
        datosProd_Proveedores=cpp.traerTodos();
        
        ultimoRegistroProveedores=cpv.getUltimoRegistro();
        LlenarTablaProductos(datosProductos);
        llenarTablaProveedores(datosProveedores,ventana.tablaProveedores);
        
    }
    
    public static void LlenarTablaProductos(ArrayList<Productos> productos){
       
        DefaultTableModel tabla = new DefaultTableModel();
        String[] fila = new String[4];
        tabla.addColumn("Codigo");
        tabla.addColumn("Nombre");
        tabla.addColumn("Precio");
        tabla.addColumn("Cantidad");
        for (int i = 0; i < productos.size(); i++) {            
            fila[0] = (productos.get(i).getCodigo());
            fila[1]=productos.get(i).getNombre();
            fila[2]="Q.  "+Double.toString(productos.get(i).getPrecio());
            fila[3]=Integer.toString(productos.get(i).getCantidad());
            tabla.addRow(fila);
        }
        ventana.productosTabla.setModel(tabla);
    }
    
    public static void llenarTablaProveedores(ArrayList<Proveedores> proveedores,JTable tablaP){
        
        DefaultTableModel tabla = new DefaultTableModel();
        String[] fila = new String[6];
        tabla.addColumn("Id");
        tabla.addColumn("Nombre");
        tabla.addColumn("Telefono");/*
        tabla.addColumn("Direccion");
        tabla.addColumn("Ciudad");
        tabla.addColumn("Email");*/
        for (int i = 0; i < proveedores.size(); i++) {            
            fila[0] = Integer.toString(proveedores.get(i).getId());
            fila[1]=proveedores.get(i).getNombre();
            fila[2]=Integer.toString(proveedores.get(i).getTelefono());/*
            fila[3]=proveedores.get(i).getDireccion();
            fila[4]=proveedores.get(i).getCiudad();
            fila[5]=proveedores.get(i).getEmail();*/
            tabla.addRow(fila);
        }
        tablaP.setModel(tabla);
        
    }
    
    
}
