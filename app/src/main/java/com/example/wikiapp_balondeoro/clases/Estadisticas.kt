package com.example.wikiapp_balondeoro.clases
import kotlinx.serialization.Serializable

@Serializable
data class Estadisticas (
    val cantidadGoles: Int,
    val cantidadAsitencias: Int,
    val club: String,
    val premios: String,
    val logrosDestacados: String

){
}