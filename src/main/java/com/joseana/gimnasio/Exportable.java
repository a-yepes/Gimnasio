package com.joseana.gimnasio;

public interface  Exportable {
    /**
     * Permite que las clases generen su JSON. 
     * Crea un String, escribe cada atributo como un par clave-valor y devuelve el texto.
     * @return JSON del ejercicio.
     */

    String toJson();

    /*usar string builder : ir construyendo con .append y luego juntarlo todo con .toString.
    fromjson: coge un entrenamiento, llama a todos los ejercicios tojson, crea un array y lo mete en un arhivo (y viceversa)

    
   */

    
}
