package com.joseana.gimnasio;

public interface  Exportable {
    /**
     * Permite que las clases generen su JSON. 
     * Crea un String, escribe cada atributo como un par clave-valor y devuelve el texto.
     * @return JSON del ejercicio.
     */

    String toJson();


    
}
