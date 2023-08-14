/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author HP
 */
public class Productos_Proveedor {
    private String codigoProducto;
    private int codigoProveedor;

    public Productos_Proveedor(String codigoProducto, int codigoProveedor) {
        this.codigoProducto = codigoProducto;
        this.codigoProveedor = codigoProveedor;
    }
    
    public Productos_Proveedor(){
        
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public int getCodigoProveedor() {
        return codigoProveedor;
    }

    public void setCodigoProveedor(int codigoProveedor) {
        this.codigoProveedor = codigoProveedor;
    }
    
}
