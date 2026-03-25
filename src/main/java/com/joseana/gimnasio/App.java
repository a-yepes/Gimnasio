package com.joseana.gimnasio;

import java.util.Scanner;

 /*3 mecanismos de E/S de ficheros: BufferedReader (lectura), FileWriter+BufferedWriter (escritura), RandomAccessFile (acceso por ID).
    Todos los accesos a fichero con try-with-resources.*/

public class App {
    public static void main(String[] args) {
        //crear objeto 
        Entrenamientos e = new Entrenamientos();

        // menu
        System.out.println("¡Hola! Bienvenid@ a tu App de Entrenamiento.");
        Scanner sc= new Scanner(System.in);
        System.out.println("¿Que quieres hacer?");
            System.out.println("1. Añadir ejercicio");
            System.out.println("2. Ver ejercicios");
            System.out.println("3. Eliminar ejercicio");
            System.out.println("4. Buscar ejercicio");
            System.out.println("5. Total calorías");
            System.out.println("6. Tiempo total de entreno");
            System.out.println("0. Salir");
        
            Integer opcion= sc.nextInt();
            sc.nextLine();//por si quedan residuos lo limpiamos

            switch(opcion){
                case 1:
                    System.out.println("ID (formato AB12): ");
                    String id = sc.nextLine();

                    // validación regex
                    if(!id.matches("[A-Z]{2}\\d{2}")){ ////mayusculas, dos letras, 2 numeros
                        System.out.println("ID inválido");
                        break;
                    }
                     //pedimos datos
                    System.out.println("Nombre:");
                    String nombre = sc.nextLine();

                    System.out.println("Distancia:");
                    double d = sc.nextDouble();

                    System.out.println("Ritmo:");
                    double r = sc.nextDouble();

                    sc.nextLine(); 
                    // crear objeto para guardarlo ej: Cardio c = new cardio (datos nuevos de arriba) 
                    //¿Hay que hacerlo con cada categoria? (cardio,flexibilidad,fuerza)
                    

                    // guardar 
                    e.agregarEjercicio(x);

                    System.out.println("Ejercicio añadido");
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
                    //COMPLETAR
                    break;

                case 5:
                    System.out.println("Total calorias: " + e.totalCalorias());
                    break;

                 case 6:
                    System.out.println("Tiempo total de entreno: " + e.tiempoTotal());
                    break;

            

                case 0:
                    System.out.println("¡Hasta pronto!");

            }

            

        sc.close();
    }
}

        
    

