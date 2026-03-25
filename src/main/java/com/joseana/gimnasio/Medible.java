package com.joseana.gimnasio;

public interface Medible {
     /**
     * Devuelve un valor numérico del ejercicio.
     * @return valor medido (distancia, peso total, intensidad…)
     */
    double obtenerValorMedicion();
    

 /** Calcula las calorías del ejercicio */
public abstract Double calcularCalorias();

 //objeto serie: repeticiones, series y tiempo de descanso = tiempo total
 //objeto que contenga las lista de ejercicios calcula el total quemado

 }

 