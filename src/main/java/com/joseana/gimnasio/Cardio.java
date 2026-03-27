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

    public Double getRitmoMedio(){
        return this.ritmoMedio;
    }

    // metodos heredados de ejercicio

    @Override
    public Double calcularCalorias() {
        return getDistanciaKM() * getRitmoMedio();
    }

    @Override
    public String resumen() {
        return "Cardio: " + nombre + " - " + distanciaKM + " km en " + duracionMinutos + " minutos";
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


    // método JSON para cardio
    public static Cardio fromJson(String json) {

    String id = json.split("id:")[1].split(",")[0].trim();
    String nombre = json.split("nombre:")[1].split(",")[0].trim();
    int duracion = Integer.parseInt(json.split("duracion:")[1].split(",")[0].trim());
    double distancia = Double.parseDouble(json.split("distancia:")[1].split(",")[0].trim());
    double ritmo = Double.parseDouble(json.split("ritmo:")[1].replace("}", "").trim());

    return new Cardio(distancia, ritmo, id, nombre, duracion);
}
}
