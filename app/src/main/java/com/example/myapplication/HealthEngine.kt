package com.example.myapplication


fun clasificarIMC(peso: Double, altura: Double): String {
    // Cálculamos el IMC, mediante la logica estableida en el laboratorio
    val imc = peso / (altura * altura)

    // Estructura de control moderna para retornar la categoría
    return when {
        imc < 18.5 -> "Bajo peso"
        imc in 18.5..24.9 -> "Peso normal"
        imc in 25.0..29.9 -> "Sobrepeso"
        else -> "Obesidad"
    }
}
fun main() {
    val resultado = clasificarIMC(70.0, 1.75)
    println("El resultado para 70kg y 1.75m es: $resultado")
}