package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.collectAsState
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    private val TAG = "LIFECYCLE_DEBUG"

    override fun onCreate(savedInstanceState: Bundle?) {
        // 🔥 DESAFÍO: Pasar savedInstanceState como parámetro
        detectAndLogStartupType(savedInstanceState)

        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: La Activity se está creando")

        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CounterApp()
                }
            }
        }
    }

    // 🔥 DESAFÍO: Recibir savedInstanceState como parámetro
    private fun detectAndLogStartupType(savedInstanceState: Bundle?) {
        Log.d(TAG, "=========================================")
        Log.d(TAG, "📱 TRACEBILIDAD DE INICIO")
        Log.d(TAG, "=========================================")

        if (savedInstanceState == null) {
            Log.d(TAG, "❄️ COLD START (Inicio Frío)")
            Log.d(TAG, "   → No hay estado guardado")
            Log.d(TAG, "   → La Activity se crea desde cero")
            Log.d(TAG, "   → El proceso se inició ahora")
        } else {
            Log.d(TAG, "🔥 WARM START (Inicio Cálido)")
            Log.d(TAG, "   → Hay estado guardado")
            Log.d(TAG, "   → La Activity se recrea")
            Log.d(TAG, "   → El proceso ya existía")
        }
        Log.d(TAG, "=========================================")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: La Activity es visible")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: La Activity tiene el foco (interactuable)")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: La Activity pierde el foco")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: La Activity ya no es visible")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: La Activity va a ser destruida")
    }
}

@Composable
fun CounterApp() {
    val viewModel: CounterViewModel = viewModel()
    val count by viewModel.count.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Contador SEGURO (sobrevive a rotación): $count",
            fontSize = 28.sp
        )
        Button(onClick = { viewModel.increment() }) {
            Text("Incrementar")
        }
    }
}