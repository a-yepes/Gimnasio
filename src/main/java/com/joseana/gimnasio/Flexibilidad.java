package com.joseana.gimnasio;

public class Flexibilidad extends Ejercicio implements Medible, Exportable{
    protected Integer nivelIntensidad;


    public Flexibilidad(Integer nivelIntensidad, String id,String nombre,Integer duracionMinutos){
        super(id, nombre, duracionMinutos);
        this.nivelIntensidad=nivelIntensidad;
    }
    public Integer getNivelIntensidad(){
        return nivelIntensidad;
    }

    public Integer getDuracionMinutos(){
        return duracionMinutos;
    }

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
    double obtenerValorMedicion();

    @Override
    public String toJson() { 
       return new StringBuilder()
            .append("tipo: cardio,")
            .append("id:").append(id).append(",")
            .append("nombre: ").append(nombre).append(",")
            .append("duracion:").append(duracionMinutos).append(",")
            .append("intensidad:").append(nivelIntensidad).append(",")
              
            .toString();

    }
    

    
}
