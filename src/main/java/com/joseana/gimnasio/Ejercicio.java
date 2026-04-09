package com.joseana.gimnasio;

public abstract class Ejercicio {
    protected String id;
    protected String nombre;
    protected Integer duracionMinutos;

    public Ejercicio(String id, String nombre, Integer duracionMinutos) {
        this.id = id;
        this.nombre = nombre;
        this.duracionMinutos = duracionMinutos;

        if (duracionMinutos < 0) {
            System.err.println("La duracion debe ser mayor a cero");
        }
        if (nombre.isEmpty()) {
            System.err.println("El nombre no puede estar vacio.");
        }

    }

    public String getId() {
        return id;
    }

    public abstract String resumen();

    public abstract String toJson();

public String getNombre() { return nombre; }
public Integer getDuracionMinutos() { return duracionMinutos; }


}
