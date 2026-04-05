package com.example.myapplication

fun main() {
    // Definición de variables de producto
    val productId: Int = 101
    val productName: String = "Smartphone X1"
    var productDescription: String? = null
    var stockQuantity: Int = 25
    val unitPrice: Double = 599.99


    // El compilador de Java 21/Kotlin 2.0 gestiona aquí la memoria eficientemente.
    println("--- Datos Iniciales Cargados ---")

    // 2. Aqui aplicaremos la Lógica de Impuestos
    val TAX_RATE = 0.15 // IVA del 15%
    val totalPriceWithTax = unitPrice * (1 + TAX_RATE)
    // Nota: No puede modificar 'unitPrice' porque es 'val'.
    // Si lo intenta, Android Studio marcar

    // 3. Uso del Operador Elvis (?:)
    // Si productDescription es null, se asigna el texto de la derecha.
    val descriptionToShow = productDescription ?: "Sin descripción disponible"
    println("Producto: $productName")
    println("Descripción: $descriptionToShow")

    // 4. simulacion del inventario

    val itemsSold = 5
    stockQuantity -= itemsSold // esta linea de codigo nos permite  actualizar el stock
    println("Stock Actualizado: $stockQuantity")
    // 5. generacion del reporte con platilla
    val report = """
        REPORTE DE INVENTARIO
        ID: $productId | Nombre: $productName
        Precio Final: $${String.format("%.2f", totalPriceWithTax)}
        Stock Actual: $stockQuantity
        Estado: ${if (stockQuantity > 10) "Suficiente" else "Critico"}
    """.trimIndent()

    println(report)





    // --- DESAFÍO EXTRA: VALIDADOR INDESTRUCTIBLE ---
    // Prueba A: Con número válido "650.50"
    // Prueba B: Con texto erróneo "No quiero pagar"
    val inputUsuario: String? = "No quiero pagar"

    // Conversión segura: si falla el texto, el precio es 0.0
    val precioCasteado = inputUsuario?.toDoubleOrNull() ?: 0.0
    val nuevoTotalConIVA = precioCasteado * (1 + TAX_RATE)

    println("\n--- RESULTADO DEL DESAFÍO ---")
    println("Entrada de usuario: $inputUsuario")
    println("Precio procesado: $precioCasteado")
    println("Nuevo Total con IVA: $${String.format("%.2f", nuevoTotalConIVA)}")
}