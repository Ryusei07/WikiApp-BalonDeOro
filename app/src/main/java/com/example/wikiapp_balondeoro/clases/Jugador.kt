package com.example.wikiapp_balondeoro.clases
import kotlinx.serialization.Serializable

@Serializable
data class Jugador (
    val nombre: String,
    val nacionalidad: String,
    val añosBalones: List<Int>,
    val cantidadBalones: Int,
    val stats: List<Estadisticas>,
    val imagen: Int,
    val imagen_pais: List<Int>
){
}