package com.joseana.gimnasio;

public class Cardio extends Ejercicio implements Medible, Exportable {
    protected Double distanciaKM;
    protected Double ritmoMedio;

    public Cardio(Double distanciaKM, Double ritmoMedio, String id, String nombre, Integer duracionMinutos) {
        super(id, nombre, duracionMinutos);
        this.distanciaKM = distanciaKM;
        this.ritmoMedio = ritmoMedio;
    }

    public Double getDistanciaKM() {
        return this.distanciaKM;
    }

    // metodos heredados de ejercicio

    @Override
    public Double calcularCalorias() {

        return distanciaKM * ritmoMedio;

    }

    @Override
    public String resumen() {
        return "Cardio: " + nombre + " - " + distanciaKM + " km en " + duracionMinutos + " min";
    }

    // metodos de las interfaces medible y exportable
    @Override
    public double obtenerValorMedicion() {
        return distanciaKM;
    }

    @Override
    public String toJson() {
        return new StringBuilder()
                .append("{")
                .append("tipo: cardio,")
                .append("id:").append(id).append(",")
                .append("nombre:").append(nombre).append(",")
                .append("duracion:").append(duracionMinutos).append(",")
                .append("distancia:").append(distanciaKM).append(",")
                .append("ritmo:").append(ritmoMedio)
                .append("}")
                .toString();
    }

}
