package com.joseana.gimnasio;

public interface  Exportable {
    /**
     * Permite que las clases generen su JSON
     * @return JSON del ejercicio.
     */

    String toJson();

    //usar string builder
    
}
