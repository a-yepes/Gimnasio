package com.joseana.gimnasio;

public class Flexibilidad extends Ejercicio{
    protected Integer nivelIntensidad;


    public Flexibilidad(Integer nivelIntensidad, String id,String nombre,Integer duracionMinutos){
        super(id, nombre, duracionMinutos);
        this.nivelIntensidad=nivelIntensidad;
    }
    @Override
    public Double calcularCalorias(){
        return null;
    
    }
    @Override
    public String resumen(){
        return null;
    }

    
}
