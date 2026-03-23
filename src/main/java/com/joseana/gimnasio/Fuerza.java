package com.joseana.gimnasio;

public class Fuerza extends Ejercicio implements Medible, Exportable {
    protected Integer repeticiones;
    protected Double pesoKG;

    public Fuerza(Integer repeticiones,Double pesoKG,String id,String nombre,Integer duracionMinutos){
        super(id, nombre, duracionMinutos);
        this.repeticiones=repeticiones;
        this.pesoKG=pesoKG;
    }
    public Integer getRepeticiones(){
        return repeticiones;
    }
    public Double getPesoKG(){
        return pesoKG;
    }

    @Override
    public Double calcularCalorias() {
        return null;
    }
    @Override
    public String resumen() {
        return null;
    }
    //metodos de las interfaces medible y exportable
    @Override
    public double obtenerValorMedicion() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String toJson() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    

}
