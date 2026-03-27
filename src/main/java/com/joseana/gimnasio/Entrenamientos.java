package com.joseana.gimnasio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

//usar 4 stream, 1 regex,1 iterator, un array
public class Entrenamientos {
    // crud con araylist y hashmap

    private ArrayList<Ejercicio> lista; // para guardar los ejercicios
    private HashMap<String, Ejercicio> mapa; // para buscar por ID mas rapido

    public Entrenamientos() {
        lista = new ArrayList<>();
        mapa = new HashMap<>();
    }

    // create
    public void agregarEjercicio(Ejercicio e) {
        lista.add(e);
        mapa.put(e.getId(), e);

    }

    // read
    public void verEjercicios() {
        for (Ejercicio e : lista) {
            System.out.println(e.resumen());
        }
    }

    // update
    public void actualizarEjercicio(String id, Ejercicio nuevo) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).id.equals(id)) {
                lista.set(i, nuevo);
                mapa.put(id, nuevo);
            }
        }
    }

    // delete con iterator obligatorio
    public void eliminarEjercicio(String id) {

        Iterator<Ejercicio> it = lista.iterator();
        boolean encontrado = false;//para comprobar si mete un ID que no existe, no lo borra

        while (it.hasNext()) {
            Ejercicio e = it.next();
            if (e.getId().equals(id)) {
                it.remove();
                mapa.remove(id);
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            System.out.println("¡Eliminado!");
        } else {
            System.out.println("El ID no existe.");
        }

    }

    // calorias con stream
    public double totalCalorias() {

        return lista.stream()
                .mapToDouble(e -> ((Medible) e).calcularCalorias())
                .sum();
    }

    // tiempo total haciendo ejercicio
    public int tiempoTotal() {
        int total = 0;
        for (Ejercicio e : lista) {
            total += e.duracionMinutos;
        }
        return total;
    }

    // stream para buscar por id
    public Ejercicio buscarPorId(String id) {
        return lista.stream()
                .filter(e -> e.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElse(null);
    }

    // stream para ordenar (por duración)
    public List<Ejercicio> ordenarPorDuracion() {
        return lista.stream()
                .sorted((a, b) -> a.duracionMinutos.compareTo(b.duracionMinutos))
                .toList();
    }

    // stream para agrupar (por tipo de ejercicio)
    public Map<String, List<Ejercicio>> agruparPorTipo() {
        return lista.stream()
                .collect(Collectors.groupingBy(e -> e.getClass().getSimpleName()));
    }
    // Devuelve un Map donde la clave es el nombre del tipo y el valor es la lista
    // de ejercicios

    // método importarJSON
    public void importarJSON(String ruta) {
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {

            StringBuilder sb = new StringBuilder();
            String linea;

            while ((linea = br.readLine()) != null) {
                sb.append(linea);
            }

            String contenido = sb.toString()
                    .replace("[", "")
                    .replace("]", "")
                    .trim();

            String[] objetos = contenido.split("},"); // separa cada ejercicio

            for (String obj : objetos) {
                obj = obj.trim();
                if (!obj.endsWith("}"))
                    obj += "}";

                if (obj.contains("tipo: cardio")) {
                    agregarEjercicio(Cardio.fromJson(obj));
                } else if (obj.contains("tipo: fuerza")) {
                    agregarEjercicio(Fuerza.fromJson(obj));
                } else if (obj.contains("tipo: flexibilidad")) {
                    agregarEjercicio(Flexibilidad.fromJson(obj));
                }
            }

            System.out.println("Importación completada.");

        } catch (Exception e) {
            System.err.println("Error importando JSON: " + e.getMessage());
        }
    }

    // método exportarJSON
    public void exportarJSON(String ruta) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {

            bw.write("[\n");

            for (int i = 0; i < lista.size(); i++) {
                bw.write(lista.get(i).toJson());
                if (i < lista.size() - 1) {
                    bw.write(",\n");
                }
            }
            bw.write("\n]");
            System.out.println("Exportado correctamente a " + ruta);

        } catch (Exception e) {
            System.err.println("Error exportando JSON: " + e.getMessage());
        }
    }
}