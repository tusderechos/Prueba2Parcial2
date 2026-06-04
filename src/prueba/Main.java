/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Prueba;

/**
 *
 * @author USUARIO
 */

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        Logica logica = new Logica();
        logica.CargarTareas();
        
        int opcion = 0;
        
        do {            
            System.out.println();
            System.out.println("GESTOR DE TAREAS");
            System.out.println("====================");
            System.out.println("1. Agregar Tarea");
            System.out.println("2. Mostrar Tareas");
            System.out.println("3. Completar Tarea");
            System.out.println("4. Salir");
            System.out.println("Selecciona una opcion (1, 2, 3, 4): ");
            opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1: //Agregar
                    System.out.println("Ingresa la nueva tarea: ");
                    String tarea = scanner.next();
                    logica.AgregarTarea(tarea);
                    break;
                case 2: //Mostrar
                    logica.MostrarTareas();
                    break;
                case 3: //Completar
                    logica.MostrarTareas();
                    
                    if (logica.hayTareas()) {
                        System.out.println("Escribir el numero de la tarea a completar: ");
                        int numero = scanner.nextInt();
                        logica.CompletarTarea(numero);
                    }
                    
                    break;
                case 4: //Salir
                    logica.GuardarTareas();
                    System.out.println("hasta la proximaaaaa....");
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        } while (opcion != 4);
    }
}
