package com.example.myapplication.kotlin.evolution

import java.util.Scanner

// Data class: genera automáticamente getters, setters, toString, equals y hashCode [cite: 55, 58]
data class Producto(val id: String, val nombre: String, val precio: Double)

fun main() {
    val lector = Scanner(System.`in`) // "in" escapado con comillas invertidas [cite: 60, 62]
    println("--- Registro de Inventario Kotlin ---")

    print("Ingrese ID: ")
    val idInput = lector.next()

    print("Ingrese Nombre: ")
    // Operador Elvis (?:) para evitar fallos por nulidad [cite: 65, 70]
    val nombreInput = readLine() ?: "Sin Nombre"

    print("Ingrese Precio: ")
    val precioInput = lector.nextDouble()

    val p1 = Producto(idInput, nombreInput, precioInput)

    // 'when' como expresión: asignación directa y concisa [cite: 78, 80]
    val categoria = when {
        p1.precio > 500.0 -> "Premium"
            p1.precio in 100.0..500.0 -> "Estándar"
        else -> "Económico"
    }

    println("\nProducto: $p1") // String templates y toString automático [cite: 89]
    println("Categoría: $categoria")

    // Comparación estructural con == [cite: 87, 95]
    val p2 = Producto(idInput, nombreInput, precioInput)
    println("¿Son idénticos?: ${p1 == p2}")
}