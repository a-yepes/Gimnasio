package com.joseana.gimnasio.gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.joseana.gimnasio.Cardio;
import com.joseana.gimnasio.Ejercicio;
import com.joseana.gimnasio.Entrenamientos;
import com.joseana.gimnasio.Flexibilidad;
import com.joseana.gimnasio.Fuerza;

public class AddEjercicio extends JDialog {

    public AddEjercicio(JFrame padre, Entrenamientos entrenamientos) {
        super(padre, "Añadir ejercicio", true);

        setSize(400, 300);
        setLayout(new GridLayout(0, 2));
        setLocationRelativeTo(padre);

        
        //Campos comunes a todos los ejercicios
        
        JTextField campoId = new JTextField();
        JTextField campoNombre = new JTextField();
        JTextField campoDuracion = new JTextField();

        add(new JLabel("ID:"));
        add(campoId);

        add(new JLabel("Nombre:"));
        add(campoNombre);

        add(new JLabel("Duración (min):"));
        add(campoDuracion);

      
        //Tipo de ejercicio
      
        String[] tipos = {"Cardio", "Fuerza", "Flexibilidad"};
        JComboBox<String> comboTipo = new JComboBox<>(tipos);

        add(new JLabel("Tipo:"));
        add(comboTipo);

       
        // Campos especificos de cada ejercicio
        
        JTextField campo1 = new JTextField();
        JTextField campo2 = new JTextField();

        JLabel label1 = new JLabel("Distancia:");
        JLabel label2 = new JLabel("Ritmo Medio:");

        add(label1);
        add(campo1);
        add(label2);
        add(campo2);

        // Cambiar etiquetas según tipo
        comboTipo.addActionListener(e -> {
            String tipo = comboTipo.getSelectedItem().toString();

            switch (tipo) {
                case "Cardio":
                    label1.setText("Distancia (km):");
                    label2.setText("Ritmo medio:");
                    campo2.setVisible(true);
                    label2.setVisible(true);
                    break;

                case "Fuerza":
                    label1.setText("Repeticiones:");
                    label2.setText("Peso (kg):");
                    campo2.setVisible(true);
                    label2.setVisible(true);
                    break;

                case "Flexibilidad":
                    label1.setText("Intensidad:");
                    campo2.setVisible(false);
                    label2.setVisible(false);
                    break;
            }
        });

     
        // Boton guardar
      
        JButton botonGuardar = new JButton("Guardar");
        add(botonGuardar);

        botonGuardar.addActionListener(e -> {

            try {
                String id = campoId.getText();
                String nombre = campoNombre.getText();
                int duracion = Integer.parseInt(campoDuracion.getText());

                Ejercicio nuevo = null;

                switch (comboTipo.getSelectedItem().toString()) {

                    case "Cardio":
                        double dist = Double.parseDouble(campo1.getText());
                        double ritmo = Double.parseDouble(campo2.getText());
                        nuevo = new Cardio(dist, ritmo, id, nombre, duracion);
                        break;

                    case "Fuerza":
                        int reps = Integer.parseInt(campo1.getText());
                        double peso = Double.parseDouble(campo2.getText());
                        nuevo = new Fuerza(reps, peso, id, nombre, duracion);
                        break;

                    case "Flexibilidad":
                        int intensidad = Integer.parseInt(campo1.getText());
                        nuevo = new Flexibilidad(intensidad, id, nombre, duracion);
                        break;
                }

                entrenamientos.agregarEjercicio(nuevo);
                dispose();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Datos inválidos. Revisa los campos.");
            }
        });

        setVisible(true);
    }
}
