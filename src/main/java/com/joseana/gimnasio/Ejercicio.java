package com.joseana.gimnasio;

public abstract class Ejercicio {
    protected String id;
    protected String nombre;
    protected int duracionMinutos;

    public Ejercicio(String id,String nombre,int duracionMinutos){
        this.id=id;
        this.nombre=nombre;
        this.duracionMinutos=duracionMinutos;

        if(duracionMinutos<0){
            System.err.println("La duracion debe ser mayor a cero");
        }
        if(nombre.isEmpty()){
            System.err.println("El nombre no puede estar vacio.");
        }

    }
    public abstract double calcularCalorias();
    public abstract String resumen();

    
    
}
