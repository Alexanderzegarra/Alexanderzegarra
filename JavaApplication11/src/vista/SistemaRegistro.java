/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package vista;

/**
 *
 * @author egar
 */

import controlador.GestionLenguaje;
import java.util.Scanner;
import modelo.LenguajeProgramacion;

public class SistemaRegistro {
    private static final GestionLenguaje gestionLenguaje = new GestionLenguaje();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Scanner lector = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú de Gestión de Lenguajes de Programación ---");
            System.out.println("1. Agregar Lenguaje");
            System.out.println("2. Buscar Lenguaje");
            System.out.println("3. Eliminar Lenguaje");
            System.out.println("4. Imprimir Lenguajes");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = lector.nextInt();
            lector.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1 -> {
                    System.out.print("Ingrese el nombre del lenguaje: ");
                    String nombre = lector.nextLine();
                    System.out.print("Ingrese el año de creación: ");
                    int anioCreacion = lector.nextInt();
                    lector.nextLine();
                    System.out.print("Ingrese la característica principal: ");
                    String caracteristicaPrincipal = lector.nextLine();
                    System.out.print("Ingrese la utilización: ");
                    String utilizacion = lector.nextLine();
                    gestionLenguaje.agregarLenguaje(anioCreacion, caracteristicaPrincipal, nombre, utilizacion);
                    System.out.println("Lenguaje agregado exitosamente.");
                }
                case 2 -> {
                    System.out.print("Ingrese el nombre del lenguaje a buscar: ");
                    String nombre = lector.nextLine();
                    LenguajeProgramacion lenguaje = gestionLenguaje.buscarLenguaje(nombre);
                    if (lenguaje != null) {
                        System.out.println("Lenguaje encontrado: " + lenguaje);
                    } else {
                        System.out.println("Lenguaje no encontrado.");
                    }
                }
                case 3 -> {
                    System.out.print("Ingrese el nombre del lenguaje a eliminar: ");
                    String nombre = lector.nextLine();
                    if (gestionLenguaje.eliminarLenguaje(nombre)) {
                        System.out.println("Lenguaje eliminado exitosamente.");
                    } else {
                        System.out.println("No se encontró el lenguaje.");
                    }
                }
                case 4 -> gestionLenguaje.imprimirLenguajes();
                case 5 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción no válida, intente nuevamente.");
            }
        } while (opcion != 5);


    }
}
