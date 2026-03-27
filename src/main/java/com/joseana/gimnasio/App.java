package com.joseana.gimnasio;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        //crear objeto 
        Entrenamientos e = new Entrenamientos();

        Scanner sc= new Scanner(System.in);
        Integer opcion;

        // menu
        
        System.out.println("¡Hola! Bienvenid@ a tu App de Entrenamiento.");

        do {
        System.out.println("¿Que quieres hacer?");
            System.out.println("1. Añadir ejercicio");
            System.out.println("2. Ver ejercicios");
            System.out.println("3. Eliminar ejercicio");
            System.out.println("4. Buscar ejercicio");
            System.out.println("5. Total calorias");
            System.out.println("6. Tiempo total de entreno");
            System.out.println("7. Recuperar sesion");
            System.out.println("8. Exportar sesion");
            System.out.println("0. Salir");
        
            opcion= sc.nextInt();
            sc.nextLine();//por si quedan residuos lo limpiamos

            switch(opcion){
                case 1:
                     //pedimos datos
                    System.out.println("¿Qué tipo de ejercicio quieres añadir? 1: Cardio , 2: Fuerza, 3: Flexibilidad");
                    Integer tipo = sc.nextInt();
                    sc.nextLine();
                    
                        switch (tipo) {
                            case 1: 
                                System.out.println("ID");
                                String idc = sc.nextLine();
                                // validación regex
                                if(!idc.matches("[A-Z]{2}\\d{2}")){ //mayusculas, dos letras, 2 numeros
                                    System.out.println("ID inválido");
                                    continue;//para que vuelva al menu
                                }

                                System.out.println("Nombre:");
                                String nc = sc.nextLine();
                                
                                System.out.println("Duración (min):");
                                Integer duracionc = sc.nextInt();

                                System.out.println("Distancia (km):");
                                double distanciac = sc.nextDouble();

                                System.out.println("Ritmo medio:");
                                double rc = sc.nextDouble();

                                Cardio c = new Cardio(distanciac, rc, idc, nc, duracionc);
                                e.agregarEjercicio(c);
                 
                                break; 

                            case 2: 

                                System.out.println("ID");
                                String idf = sc.nextLine();
                                
                                if(!idf.matches("[A-Z]{2}\\d{2}")){
                                    System.out.println("ID inválido");
                                    continue;
                                }

                                System.out.println("Nombre:");
                                String nf = sc.nextLine();
                                
                                System.out.println("Duración (min):");
                                Integer duracionf = sc.nextInt();

                                System.out.println("Repeticiones");
                                Integer repeticionesf = sc.nextInt();

                                System.out.println("Peso (kg)");
                                double pf = sc.nextDouble();

                                Fuerza f = new Fuerza(repeticionesf, pf, idf, nf, duracionf);
                                e.agregarEjercicio(f);
                 
                                break;

                            case 3: 
                                System.out.println("ID");
                                String idflex= sc.nextLine();
                                
                                if(!idflex.matches("[A-Z]{2}\\d{2}")){ 
                                    System.out.println("ID inválido");
                                    continue;
                                }

                                System.out.println("Nombre:");
                                String nflex= sc.nextLine();
                                
                                System.out.println("Duración (min):");
                                Integer duracionflex = sc.nextInt();

                                System.out.println("Nivel intensidad:");
                                Integer iflex = sc.nextInt();

                                Flexibilidad flex = new Flexibilidad(iflex, idflex, nflex, duracionflex);
                                e.agregarEjercicio(flex);
                 
                                break; 

                        }


                    System.out.println("¡Ejercicio añadido!");
                    break;

                    

                case 2:
                    e.verEjercicios();
                    break;

                case 3:
                    System.out.println("ID a eliminar:");
                    String idEliminar = sc.nextLine();
                    e.eliminarEjercicio(idEliminar);
                    
                    break;

                case 4:
                    System.out.println("Introduce el ID a buscar:");
                    String idBuscar = sc.nextLine();

                    Ejercicio encontrado = e.buscarPorId(idBuscar);
                    
                    if (encontrado != null){
                        System.out.println("Ejercicio encontrado:");
                        System.out.println(encontrado.resumen());
                    } else {
                        System.out.println("No existe ningún ejercicio con ese ID.");
                    }
                    break;

                case 5:
                    System.out.println("Total calorias: " + e.totalCalorias());
                    break;

                 case 6:
                    System.out.println("Tiempo total de entreno: " + e.tiempoTotal());
                    break;

                case 7:
                    e.importarJSON("datos.json");
                    break;

                case 8:
                    e.exportarJSON("datos.json");
                    break;

            

                case 0:
                    System.out.println("¡Hasta pronto!");

            } 
        }while (opcion != 0);

            

        sc.close();
    }
}
