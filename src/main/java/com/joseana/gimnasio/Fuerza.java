package com.joseana.gimnasio;

public class Fuerza extends Ejercicio {
    protected Integer repeticiones;
    protected Double pesoKG;

    public Fuerza(Integer repeticiones,Double pesoKG,String id,String nombre,Integer duracionMinutos){
        super(id, nombre, duracionMinutos);
        this.repeticiones=repeticiones;
        this.pesoKG=pesoKG;
    }

    @Override
    public Double calcularCalorias() {
        return null;
    }
    @Override
    public String resumen() {
        return null;
    }
    

}
