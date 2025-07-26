/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import javax.swing.*;
import java.awt.*;

public class vista {

    public static void main(String[] args) {
        JFrame ventana = new JFrame("Ventana ajustada al contenido");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear panel principal
        JPanel panelPrincipal = new JPanel(new BorderLayout());

        // Tabla de ejemplo con muchas columnas
        String[] columnas = {"ID", "Nombre", "Apellido", "Edad", "Ciudad", "País", "Teléfono", "Correo"};
        Object[][] datos = new Object[100][columnas.length];
        for (int i = 0; i < 100; i++) {
            datos[i][0] = i + 1;
            datos[i][1] = "Nombre " + (i + 1);
            datos[i][2] = "Apellido " + (i + 1);
            datos[i][3] = 20 + i;
            datos[i][4] = "Ciudad " + (i + 1);
            datos[i][5] = "País";
            datos[i][6] = "123-456-7890";
            datos[i][7] = "correo@example.com";
        }

        JTable tabla = new JTable(datos, columnas);
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        JScrollPane scrollPane = new JScrollPane(tabla);
        panelPrincipal.add(scrollPane, BorderLayout.CENTER);

        // Otro componente adicional (botón)
        JPanel panelBoton = new JPanel();
        panelBoton.add(new JButton("Aceptar"));
        panelPrincipal.add(panelBoton, BorderLayout.SOUTH);

        // Agregar contenido al frame
        ventana.setContentPane(panelPrincipal);

        // Ajustar automáticamente el tamaño al contenido
        ventana.pack();

        // Limitar el tamaño máximo al de la pantalla
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        int anchoMaximo = pantalla.width - 100; // dejar margen
        int altoMaximo = pantalla.height - 100;

        Dimension tamanoActual = ventana.getSize();
        int anchoFinal = Math.min(tamanoActual.width, anchoMaximo);
        int altoFinal = Math.min(tamanoActual.height, altoMaximo);
        ventana.setSize(anchoFinal, altoFinal);

        // Centrar la ventana
        ventana.setLocationRelativeTo(null);

        ventana.setVisible(true);
    }
}
