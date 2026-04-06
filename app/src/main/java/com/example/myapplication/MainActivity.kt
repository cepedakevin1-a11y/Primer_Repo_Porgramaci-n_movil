package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

// ... (tus imports anteriores)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Paso 3.1: Llamada a la pantalla principal
                    CalculadoraSaludScreen()
                }
            }
        }
    }
}

@Composable
fun CalculadoraSaludScreen() {
    // PASO 3.2: Declarar variables de estado DENTRO del Composable
    var pesoInput by remember { mutableStateOf("") }
    var alturaInput by remember { mutableStateOf("") }

    // PASO 3.3 y 3.4: Conversión segura y Operador Elvis
    val peso = pesoInput.toDoubleOrNull() ?: 0.0
    val altura = alturaInput.toDoubleOrNull() ?: 0.0

    // PASO 3.5: Vinculación de lógica
    val resultadoIMC = if (altura > 0 && peso > 0) {
        clasificarIMC(peso, altura)
    } else {
        "Ingrese datos válidos"
    }

    // --- Diseño de Interfaz ---
    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Calculadora de Salud IMC", style = MaterialTheme.typography.headlineLarge)

        Spacer(modifier = Modifier.height(32.dp))

        OutlinedTextField(
            value = pesoInput,
            onValueChange = { pesoInput = it },
            label = { Text("Peso (kg)") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = alturaInput,
            onValueChange = { alturaInput = it },
            label = { Text("Altura (m)") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(32.dp))

        Card {
            Text(
                text = "Categoría: $resultadoIMC",
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}