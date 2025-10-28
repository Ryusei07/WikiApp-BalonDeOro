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
            Club("Paris Saint-Germain\n", 8, "Italia"),
            Club("Blackpool\n", 8, "Italia"),
            Club("Dukla Praga\n", 8, "Italia"),
            Club("Dynamo Moscú\n", 8, "Italia"),
            Club("Benfica\n", 8, "Italia"),
            Club("Ferencváros\n", 8, "Italia"),
            Club("Ajax\n", 8, "Italia"),
            Club("Borussia Mönchengladbach\n", 8, "Italia"),
            Club("Marsella\n", 8, "Italia"),
            Club("Borussia Dortmund\n", 8, "Italia"),
            Club("Liverpool\n", 8, "Italia"),
            Club("Inter Miami\n", 8, "Italia"),
            Club("Manchester City\n", 8, "Italia"),
        )
        return clubes
    }

    fun crearEstadisticas(): List<Estadisticas>{
        val estadisticas: List<Estadisticas> = listOf(
            Estadisticas(17,5,"Jugador importante para conseguir la primera FA Cup del Blackpool luego de perder 2 finales anteriormente"),
            Estadisticas(31,10,"Maximo goleador del Real Madrid, ganadores de LaLiga y su segunda Copa de Europa consecutiva"),
            Estadisticas(23,8,"Goles importantes para ganar LaLiga y la tercera Copa de Europa consecutiva del Real Madrid")

        )
        return estadisticas
    }
}

fun crearJugadores(){
    val jugadores: List<Jugador> = listOf(
        //
    )



}