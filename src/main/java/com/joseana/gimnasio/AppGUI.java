package com.joseana.gimnasio;

import com.joseana.gimnasio.gui.GUI;

public class AppGUI {
    public static void main(String[] args) {

        // Recomendación estándar de Swing:
        // Ejecutar la GUI en el hilo de eventos (EDT)
        javax.swing.SwingUtilities.invokeLater(() -> {
            new GUI();   // Lanza la ventana principal
        });
    }
}

