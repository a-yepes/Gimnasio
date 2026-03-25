package com.joseana.gimnasio;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

//usar 4 stream, 1 regex,1 iterator, un array
public class Entrenamientos {
    //crud con araylist y hashmap

    private ArrayList<Ejercicio> lista; //para guardar los ejercicios
    private HashMap<String, Ejercicio> mapa; //para buscar por ID mas rapido

    public Entrenamientos(){
        lista = new ArrayList<>();
        mapa = new HashMap<>();
    }

    // create
    public void agregarEjercicio(Ejercicio e){
        lista.add(e);
        mapa.put(e.id, e);
    
    }

    // read
    public void verEjercicios(){
        for(Ejercicio e : lista){
            System.out.println(e.resumen());
        }
    }

    // update
    public void actualizarEjercicio(String id, Ejercicio nuevo){
        for(int i = 0; i < lista.size(); i++){
            if(lista.get(i).id.equals(id)){
                lista.set(i, nuevo);
                mapa.put(id, nuevo);
            }
        }
    }

    // delete con iterator obligatorio
    public void eliminarEjercicio(String id){

     Iterator<Ejercicio> it = lista.iterator();

        while(it.hasNext()){
            Ejercicio e = it.next();
            if(e.getId().equals(id)){
                it.remove(); 
                mapa.remove(id);
            }
        }

    }

    // calorias con stream
    public double totalCalorias(){
        
        return lista.stream()
            .mapToDouble(e -> ((Medible)e).calcularCalorias())
            .sum();
    }

    // tiempo total haciendo ejercicio
    public int tiempoTotal(){
        int total = 0;
        for(Ejercicio e : lista){
            total += e.duracionMinutos;
        }
        return total;
    }

    //filtrar con stream (por duracion?)
    //ordenar con stream 
    //agrupar con stream(por tipo?)
}