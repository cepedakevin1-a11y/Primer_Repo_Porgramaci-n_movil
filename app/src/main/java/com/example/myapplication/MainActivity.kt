package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ThermostatScreen()
        }
    }
}

@Composable
fun ThermostatScreen() {
    var temperature by remember { mutableIntStateOf(20) }

    fun increaseTemp() { if (temperature < 35) temperature++ }
    fun decreaseTemp() { if (temperature > 10) temperature-- }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TemperatureDisplay(temperature = temperature)

        Spacer(modifier = Modifier.height(32.dp))

        TemperatureControls(
            onIncrease = { increaseTemp() },
            onDecrease = { decreaseTemp() }
        )
    }
}

@Composable
fun TemperatureDisplay(temperature: Int) {
    val (displayColor, iconEmoji) = if (temperature >= 25) {
        Color.Red to "☀️"
    } else {
        Color.Blue to "❄️"
    }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = iconEmoji,
            fontSize = 80.sp,
            color = displayColor
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "$temperature°C",
            fontSize = 56.sp,
            fontWeight = FontWeight.Bold,
            color = displayColor
        )
    }
}

@Composable
fun TemperatureControls(
    onIncrease: () -> Unit,
    onDecrease: () -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Button(onClick = onDecrease) {
            Text("− Bajar")
        }
        Button(onClick = onIncrease) {
            Text("Subir +")
        }
    }
}