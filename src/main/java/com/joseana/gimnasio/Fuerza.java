package com.joseana.gimnasio;

public class Fuerza extends Ejercicio implements Medible, Exportable {
    protected Integer repeticiones;
    protected Double pesoKG;

    public Fuerza(Integer repeticiones, Double pesoKG, String id, String nombre, Integer duracionMinutos) {// series
        super(id, nombre, duracionMinutos);
        this.repeticiones = repeticiones;
        this.pesoKG = pesoKG;
    }

    public Integer getRepeticiones() {
        return this.repeticiones;
    }

    public Double getPesoKG() {
        return this.pesoKG;
    }

    @Override
    public Double calcularCalorias() {
        return getRepeticiones() * getPesoKG();
    }

    @Override
    public String resumen() {
        return "Fuerza: " + nombre + " - " + repeticiones + " reps con " + pesoKG + " kg";

    }

    @Override
    public String toJson() {
        return new StringBuilder()
                .append("{")
                .append("tipo: fuerza,")
                .append("id:").append(id).append(",")
                .append("nombre:").append(nombre).append(",")
                .append("duracion:").append(duracionMinutos).append(",")
                .append("repeticiones:").append(repeticiones).append(",")
                .append("peso:").append(pesoKG)
                .append("}")
                .toString();


    }

    // método JSON
    public static Fuerza fromJson(String json) {
        String id = json.split("id:")[1].split(",")[0].trim();
        String nombre = json.split("nombre:")[1].split(",")[0].trim();
        int duracion = Integer.parseInt(json.split("duracion:")[1].split(",")[0].trim());
        int repeticiones = Integer.parseInt(json.split("repeticiones:")[1].split(",")[0].trim());
        double peso = Double.parseDouble(json.split("peso:")[1].trim().replace("}", ""));

        return new Fuerza(repeticiones, peso, id, nombre, duracion);
    }
}
