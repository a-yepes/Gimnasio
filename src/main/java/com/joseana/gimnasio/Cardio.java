package com.joseana.gimnasio;

public class Cardio extends Ejercicio implements Medible, Exportable {
    protected Double distanciaKM;
    protected Double ritmoMedio;

    public Cardio(Double distanciaKM,Double ritmoMedio, String id,String nombre,Integer duracionMinutos){
        super(id, nombre, duracionMinutos);
        this.distanciaKM=distanciaKM;
        this.ritmoMedio=ritmoMedio;
    }
    //metodos heredados de ejercicio
    @Override
    public Double calcularCalorias(){
        return null;

        
    }
    @Override
    public String resumen(){
        return null;
    }

    //metodos de las interfaces medible y exportable
    @Override
    public double obtenerValorMedicion() {
        return distanciaKm;
    }

    @Override
    public String toJson() {
        return "{ \"tipo\": \"cardio\", \"nombre\": \"" + nombre + "\", \"distancia\": " + distanciaKm + " }";
    }

    
}
