/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class Conexion {
    public static Connection conn;
 
    static Statement statement;

    public static Connection getConnection() {
        return conn;
    }

    public static void setConn(Connection conn) {
        Conexion.conn = conn;
    }

    public static Statement getStatement() {
        return statement;
    }

    public static void setStatement(Statement statement) {
        Conexion.statement = statement;
    }

    public ResultSet getResultado() {
        return resultado;
    }

    public static void setResultSet(ResultSet resultado) {
        Conexion.resultado = resultado;
    }

    public static PreparedStatement getPs() {
        return ps;
    }

    public static void setPs(PreparedStatement ps) {
        Conexion.ps = ps;
    }
    static ResultSet resultado;
    static PreparedStatement ps;
    public void conectar(){
        String driver = "com.mysql.cj.jdbc.Driver";
        String user = "proyectoTienda";
        String password = "eiler123";
        String url = "jdbc:mysql://localhost:3306/Tienda";
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            statement = conn.createStatement();
            System.out.println("Conexion establecida");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error de conexion" + e);
        }

    }
    public void cerrarConexion(){
            try {
                conn.close();
                System.out.println("Conexion cerrada");
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);

            }
    }
}
