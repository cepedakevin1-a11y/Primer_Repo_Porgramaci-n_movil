package com.example.myapplication.java.legacy;

import java.util.Scanner;

public class GestionJava {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese ID: ");
        String id = sc.next();
        System.out.print("Ingrese Nombre: ");
        String nombre = sc.next();
        System.out.print("Ingrese Precio: ");
        double precio = sc.nextDouble();

        // Riesgo de NPE al transformar a mayúsculas [cite: 34]
        System.out.println("Procesando: " + nombre.toUpperCase());

        // Clasificación con switch (Sentencia) [cite: 37, 38]
        String categoria;
        if (precio > 500) {
            categoria = "Premium";
        } else if (precio >= 100) {
            categoria = "Estándar";
        } else {
            categoria = "Económico";
        }

        Producto p1 = new Producto(id, nombre, precio);
        System.out.println(p1);
        System.out.println("Categoría: " + categoria);
    }
}