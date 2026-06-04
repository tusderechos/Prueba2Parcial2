/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prueba;

/**
 *
 * @author USUARIO
 */

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Logica {
    
    private String[] Tareas;
    private boolean[] Completadas;
    private int Contador;
    private File Archivo;
    
    public Logica() {
        Tareas = new String[100];
        Completadas = new boolean[100];
        Contador = 0;
        Archivo = new File("tareas.txt");
    }
    
    public void AgregarTarea(String nuevatarea) {
        if (Contador < Tareas.length) {
            Tareas[Contador] = nuevatarea;
            Completadas[Contador] = false;
            Contador++;
            
            GuardarTareas();
            
            System.out.println();
            System.out.println("La tarea ha sido agreada: " + nuevatarea);
        } else
            System.out.println("No se pueden agregar mas tareas");
    }
    
    public void MostrarTareas() {
        System.out.println("\nLISTA DE TAREAS");
        System.out.println("=========================");
        
        if (Contador == 0)
            System.out.println("No hay tareas agregadas");
        else {
            for (int i = 0; i < Contador; i++) {
                if (Completadas[i])
                    System.out.println((i + 1) + ". [✓] " + Tareas[i]);
                else 
                    System.out.println((i + 1) + ". [ ] " + Tareas[i]);
            }
        }
    }
    
    public void CompletarTarea(int numero) {
        if (numero >= 1 && numero <= Contador) {
            Completadas[numero - 1] = true;
            
            GuardarTareas();
            
            System.out.println();
            System.out.println("✔ Tarea #" + numero + " completada: " + Tareas[numero - 1]);
        } else 
            System.out.println("Numero de tarea invalido");
    }
    
    public void GuardarTareas() {
        try {
            FileWriter escritor = new FileWriter(Archivo);
            
            for (int i = 0; i < Contador; i++) {
                escritor.write(Tareas[i] + ";" + Completadas[i] + "\n");
            }
        } catch (Exception e) {
            System.out.println("Error al guardar las tareas");
        }
    }
    
    public void CargarTareas() {
        try {
            if (!Archivo.exists()) {
                Archivo.createNewFile();
                return;
            }
            
            FileReader leer = new FileReader(Archivo);
            
            String contenido = "";
            int caracter = 0;
            
            while ((caracter - leer.read()) != -1)
                contenido += (char) caracter;
            
            String linea = "";
            
            for (int i = 0; i < contenido.length(); i++) {
                char caracter2 = contenido.charAt(i);
                
                if (caracter2 != '\n')
                    linea += caracter2;
                else {
                    ProcesarLinea(linea);
                    linea = "";
                }
            }
            
            if (!linea.equals(""))
                ProcesarLinea(linea);
            
        } catch (Exception e) {
            System.out.println("Error al cargar las tareas");
        }
    }
    
    private void ProcesarLinea(String linea) {
        String tarea = "";
        String estado = "";
        boolean estaleyendo = false;
        
        for (int i = 0; i < linea.length(); i++) {
            char caracter3 = linea.charAt(i);
            
            if (caracter3 == ';')
                estaleyendo = true;
            else {
                if (estaleyendo)
                    estado += caracter3;
                else 
                    tarea += caracter3;
            }
        }
    }
    
    public boolean hayTareas() {
        return Contador > 0;
    }
}
    
