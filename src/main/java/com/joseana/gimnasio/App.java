package com.joseana.gimnasio;

import java.util.Scanner;

 /*3 mecanismos de E/S de ficheros: BufferedReader (lectura), FileWriter+BufferedWriter (escritura), RandomAccessFile (acceso por ID).
    Todos los accesos a fichero con try-with-resources.*/

public class App {
    public static void main(String[] args) {
       //crear objeto ejercicio
        System.out.println("¡Hola! Bienvenid@ a tu App de Entrenamiento.");
        Scanner sc= new Scanner(System.in);
        System.out.println("¿Que quieres hacer?");
        Integer opcion= sc.nextInt();
        
    }
}
