package com.example.myapplication

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CounterViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {

    // Obtener valor inicial guardado o 0 por defecto
    private val initialCount: Int = savedStateHandle.get("counter_key") ?: 0

    // Estte es el estado interno muable, lo cual debe permitirme realir la practica sin problemas
    private val _count = MutableStateFlow(initialCount)

    // Estado expuesto como inmutable (solo lectura)
    val count: StateFlow<Int> = _count.asStateFlow()

    fun increment() {
        val newValue = _count.value + 1
        _count.value = newValue
        // Guardar en SavedStateHandle para Process Death
        savedStateHandle["counter_key"] = newValue
    }
}