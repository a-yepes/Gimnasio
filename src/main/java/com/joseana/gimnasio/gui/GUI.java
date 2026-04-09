package com.joseana.gimnasio.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.joseana.gimnasio.Ejercicio;
import com.joseana.gimnasio.Entrenamientos;
import com.joseana.gimnasio.Medible;

public class GUI extends JFrame {

    private Entrenamientos entrenamientos;
    private JTable tabla;
    private DefaultTableModel modeloTabla;
    private JTextField campoBuscar;

    public GUI() {

        
        // Configuracion de la ventana
     
        setTitle("FitLog - Gestor de Entrenamientos");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLayout(new BorderLayout());

        entrenamientos = new Entrenamientos();

        
        // Tabla
       
        String[] columnas = {"ID", "Nombre", "Tipo", "Duración", "Calorías"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        tabla = new JTable(modeloTabla);

        add(new JScrollPane(tabla), BorderLayout.CENTER);

        
        //Panel superior para buscar
       
        JPanel panelSuperior = new JPanel();
        campoBuscar = new JTextField(20);
        JButton botonBuscar = new JButton("Buscar");

        // Listener con LAMBDA 
        botonBuscar.addActionListener(e -> filtrarTabla());

        panelSuperior.add(new JLabel("Buscar por nombre: "));
        panelSuperior.add(campoBuscar);
        panelSuperior.add(botonBuscar);

        add(panelSuperior, BorderLayout.NORTH);

        
        // Botones de la parte de abajo
        
        JPanel panelBotones = new JPanel();

        JButton botonAñadir = new JButton("Añadir");
        JButton botonEliminar = new JButton("Eliminar");
        JButton botonGuardar = new JButton("Guardar JSON");

        // Listener con clase anonima
        botonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarSeleccionado();
            }
        });

        botonAñadir.addActionListener(e -> abrirDialogoAñadir());
        botonGuardar.addActionListener(e -> entrenamientos.exportarJSON("datos.json"));

        panelBotones.add(botonAñadir);
        panelBotones.add(botonEliminar);
        panelBotones.add(botonGuardar);

        add(panelBotones, BorderLayout.SOUTH);

        
        // WINDOW LISTENER 
     
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int opcion = JOptionPane.showConfirmDialog(
                        null,
                        "¿Guardar antes de salir?",
                        "Salir",
                        JOptionPane.YES_NO_CANCEL_OPTION
                );

                if (opcion == JOptionPane.YES_OPTION) {
                    entrenamientos.exportarJSON("datos.json");
                    System.exit(0);
                } else if (opcion == JOptionPane.NO_OPTION) {
                    System.exit(0);
                }
            }
        });

        setVisible(true);
    }

    
    //Metodo para actualizar la tabla

    private void refrescarTabla() {
        modeloTabla.setRowCount(0);

        for (Ejercicio e : entrenamientos.ordenarPorDuracion()) {
            modeloTabla.addRow(new Object[]{
                    e.getId(),
                    e.getNombre(),
                    e.getClass().getSimpleName(),
                    e.getDuracionMinutos(),
                    ((Medible) e).calcularCalorias()
            });
        }
    }

    
    // Metodo para buscar por nombre
   
    private void filtrarTabla() {
        String texto = campoBuscar.getText().toLowerCase();

        modeloTabla.setRowCount(0);

        for (Ejercicio e : entrenamientos.ordenarPorDuracion()) {
            if (e.getNombre().toLowerCase().matches(".*" + texto + ".*")) {
                modeloTabla.addRow(new Object[]{
                        e.getId(),
                        e.getNombre(),
                        e.getClass().getSimpleName(),
                        e.getDuracionMinutos(),
                        ((Medible) e).calcularCalorias()
                });
            }
        }
    }


    // Metodo para eliminar el ejercicio que se seleccione
    
    private void eliminarSeleccionado() {
        int fila = tabla.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona un ejercicio.");
            return;
        }

        String id = (String) modeloTabla.getValueAt(fila, 0);
        entrenamientos.eliminarEjercicio(id);
        refrescarTabla();
    }

    
    // Metodo para que se abra la ventana de añadir ejercicio
    
    private void abrirDialogoAñadir() {
        new AddEjercicio(this, entrenamientos);
        refrescarTabla();
    }
}
