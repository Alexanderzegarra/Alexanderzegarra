/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package controlador;

/**
 *
 * @author zegar
 */

import modelo.LenguajeProgramacion;

public class GestionLenguaje {
    private static final int FACTOR_CRECIMIENTO = 2;
    private static final LenguajeProgramacion[] ArregloLenguajes = new LenguajeProgramacion[FACTOR_CRECIMIENTO];
    private int ContadorLenguajes = 0;

    public void agregarLenguaje(int anioCreacion, String caracteristicaPrincipal, String nombre, String utilizacion) {
        if (ContadorLenguajes == ArregloLenguajes.length) {
            
        }
        ArregloLenguajes[ContadorLenguajes++] = new LenguajeProgramacion(anioCreacion, caracteristicaPrincipal, nombre, utilizacion);
       
    }


    public LenguajeProgramacion buscarLenguaje(String nombre) {
        for (int i = 0; i < ContadorLenguajes; i++) {
            if (ArregloLenguajes[i].getNombre().equalsIgnoreCase(nombre)) {
                return ArregloLenguajes[i];
            }
        }
        return null;
    }

    public boolean eliminarLenguaje(String nombre) {
        for (int i = 0; i < ContadorLenguajes; i++) {
            if (ArregloLenguajes[i].getNombre().equalsIgnoreCase(nombre)) {
                for (int j = i; j < ContadorLenguajes - 1; j++) {
                    ArregloLenguajes[j] = ArregloLenguajes[j + 1];
                }
                ArregloLenguajes[--ContadorLenguajes] = null;
                return true;
            }
        }
        return false;
    }

    public LenguajeProgramacion[] getArregloLenguajes() {
        LenguajeProgramacion[] copia = new LenguajeProgramacion[ContadorLenguajes];
        System.arraycopy(ArregloLenguajes, 0, copia, 0, ContadorLenguajes);
        return copia;
    }

    public void imprimirLenguajes() {
        if (ContadorLenguajes == 0) {
            System.out.println("No hay lenguajes registrados.");
        } else {
            for (int i = 0; i < ContadorLenguajes; i++) {
                System.out.println(ArregloLenguajes[i]);
            }
        }
    }
}