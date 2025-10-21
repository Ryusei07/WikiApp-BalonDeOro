package com.example.wikiapp_balondeoro.clases

data class Jugador (
    val nombre: String,
    val nacionalidad: String,
    val añosBalones: List<Int>,
    val cantidadBalones: Int,
    val stats: List<Estadisticas>,
    val equipo: Club
){
}