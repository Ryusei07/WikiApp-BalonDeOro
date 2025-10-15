package com.example.wikiapp_balondeoro.clases

data class Jugador (
    val nombre: String,
    val edad: Int,
    val nacionalidad: String,
    val cantidadBalones: Int,
    val stats: Estadisticas,
    val equipo: Club
){
}