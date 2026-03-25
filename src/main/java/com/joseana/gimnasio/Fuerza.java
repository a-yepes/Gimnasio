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
        return repeticiones;
    }

    public Double getPesoKG() {
        return pesoKG;
    }

    @Override
    public Double calcularCalorias() {
        return repeticiones * pesoKG;
    }

    @Override
    public String resumen() {
        return "Fuerza: " + nombre + " - " + repeticiones + " reps con " + pesoKG + " kg";

    }

    // metodos de las interfaces medible y exportable
    @Override
    public double obtenerValorMedicion() {
        return repeticiones * pesoKG;
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

}
