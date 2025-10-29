package com.example.wikiapp_balondeoro.clases

class Funciones {

    fun crearClubes(): List<Club>{
        val clubes: List<Club> = listOf(
            Club("Real Madrid", 12, "España"),
            Club("Barcelona", 12, "España"),
            Club("Juventus", 8, "Italia"),
            Club("AC Milan", 8, "Italia"),
            Club("Bayern de Múnich", 5, "Alemania"),
            Club("Manchester United", 4, "Ingraterra"),
            Club("Dynamo de Kiev", 2, "Ucrania"),
            Club("Hamburg", 2, "Alemania"),
            Club("Internazionale", 2, "Italia"),
            Club("Paris Saint-Germain", 2, "Francia"),
            Club("Blackpool", 1, "Inglaterra"),
            Club("Dukla Praga", 1, "República Checa"),
            Club("Dynamo Moscú", 1, "Rusia"),
            Club("Benfica", 1, "Portugal"),
            Club("Ferencváros", 1, "Hungria"),
            Club("Ajax", 1, "Paises Bajos"),
            Club("Borussia Mönchengladbach", 1, "Alemania"),
            Club("Marsella", 1, "Francia"),
            Club("Borussia Dortmund\n", 1, "Alemania"),
            Club("Liverpool\n", 1, "Inglaterra"),
            Club("Inter Miami\n", 1, "Estados Unidos"),
            Club("Manchester City\n", 1, "Inglaterra"),
        )
        return clubes
    }

    fun crearEstadisticas(): List<Estadisticas>{
        val estadisticas: List<Estadisticas> = listOf(
            Estadisticas(17,5,"Blackpool", "FA cup", "Desempeño sobresaliente como extremo, clave en los éxitos del Blackpool"),
            Estadisticas(31,10,"Real Madrid", "LaLiga, Copa de Europa", "Máximo goleador y líder en la consecución de títulos nacionales y europeos"),
            Estadisticas(23,8,"Real Madrid", "LaLiga, Copa de Europa", "Creatividad y goles decisivos en la liga y en la Copa de Europa"),

            Estadisticas(28,9,"Real Madrid", "LaLiga, Copa de Europa", "Máximo goleador y motor ofensivo de Real Madrid en todos los torneos"),
            Estadisticas(19,6,"Barcelona", "Copa de Europa, LaLiga", "Líder en asistencias y goles importantes, clave en los títulos"),
            Estadisticas(19,7,"Juventus", "Serie A, Copa de Italia", "Máximo goleador de la liga y decisivo en partidos de Copa"),
            Estadisticas(16,5,"Dukla Plaga", "Liga Checoslovaca", "Líder del mediocampo, excelente control de juego y goles clave"),
            Estadisticas(0,0,"Dynamo Moscú", "Ninguno", "Sobresaliente actuación como portero, clave en la defensa de su equipo"),
            Estadisticas(26,5,"Manchester United", "FA Cup", "Máximo goleador de la liga, decisivo en victorias importantes"),
            Estadisticas(23,8,"", "", ""),
            Estadisticas(23,8,"", "", ""),
            Estadisticas(23,8,"", "", ""),
            Estadisticas(23,8,"", "", ""),
            Estadisticas(23,8,"", "", ""),
            Estadisticas(23,8,"", "", ""),
            Estadisticas(23,8,"", "", ""),
            Estadisticas(23,8,"", "", ""),
            Estadisticas(23,8,"", "", "")
        )
        return estadisticas
    }
}

fun crearJugadores(){
    val jugadores: List<Jugador> = listOf(
        //
    )



}