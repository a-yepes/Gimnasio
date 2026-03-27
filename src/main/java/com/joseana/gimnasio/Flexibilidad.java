package com.joseana.gimnasio;

public class Flexibilidad extends Ejercicio implements Medible, Exportable{
    protected Integer nivelIntensidad;


    public Flexibilidad(Integer nivelIntensidad, String id,String nombre,Integer duracionMinutos){
        super(id, nombre, duracionMinutos);
        this.nivelIntensidad=nivelIntensidad;
    }
    public Integer getNivelIntensidad(){
        return this.nivelIntensidad;
    }

    public Integer getDuracionMinutos(){
        return this.duracionMinutos;
    }

    @Override
    public Double calcularCalorias(){
        return (double) (getNivelIntensidad() * getDuracionMinutos());
        
    
    }
    @Override
    public String resumen(){
        return "Flexibilidad: " + nombre + " - intensidad " + nivelIntensidad + " durante " + duracionMinutos + " minutos";
    }

    @Override
    public String toJson() { 
       return new StringBuilder()
            .append("tipo: flexibilidad,")
            .append("id:").append(id).append(",")
            .append("nombre: ").append(nombre).append(",")
            .append("duracion:").append(duracionMinutos).append(",")
            .append("intensidad:").append(nivelIntensidad).append(",")
              
            .toString();
        
    }

    // método JSON
    public static Flexibilidad fromJson(String json) {
        String id = json.split("id:")[1].split(",")[0].trim();
        String nombre = json.split("nombre:")[1].split(",")[0].trim();
        int duracion = Integer.parseInt(json.split("duracion:")[1].split(",")[0].trim());
        int intensidad = Integer.parseInt(json.split("intensidad:")[1].trim().replace("}", ""));

        return new Flexibilidad(intensidad, id, nombre, duracion);
    }
       
}
