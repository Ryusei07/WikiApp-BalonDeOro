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
            Estadisticas(32,8,"Benfica", "Primeira liga, Copa de europa", "Maximo goleador y figura clave en los titulos europeos del Benfica"),
            Estadisticas(22,6,"Manchester United", "Copa del mundo, FA cup", "Liderazgo y goles decisivos en la copa del mundo y en la liga inglesa"),
            Estadisticas(29,7,"Ferencváros", "Campeonato Hungaro", "Maximo goleador y motor ofensivo del equipo"),
            Estadisticas(28,10,"Manchester United", "Copa de europa, FA cup", "Habilidad, goles y asistencias decisivas en torneos nacionales y europeos"),
            Estadisticas(18,5,"AC Milan", "Coppa Italia", "Goles y asistencias determinantes para la conquista de la coppa italia"),
            Estadisticas(38,9,"Bayern de Múnich", "Bundesliga, Copa de alemania, Copa de europa", "Maximo goleador y lider ofensivo, decisivo en la obtencion de titulos nacionales y europeos"),
            Estadisticas(33,10,"Ajax", "Eredivisie, Copa de europa", "Maximo goelador y creador de juego, figura central en los titulos del Ajax"),
            Estadisticas(14,6,"Bayern de Múnich", "Bundesliga, Copa de europa", "Defensa y mediocampista con liderazgo clave en la obtencion de titulos"),
            Estadisticas(27,12,"Barcelona", "LaLiga, Copa del Rey", "Maximo goleador y generador de juego, fundamental para los titulos del Barça"),
            Estadisticas(22,25,"Barcelona", "LaLiga, SubCampeon del Mundo", "Mejor jugador del mundial 1974"),
            Estadisticas(18,6,"Dynamo de Kiev", "Liga Sovietica", "Maximo goleador y figura ofensiva clave del Dynamo"),
            Estadisticas(15,7,"Bayern de Múnich", "Bundesliga, Copa de europa",  "defensa lider y pieza central en titulos del club"),
            Estadisticas(19,7,"Borussia Mönchengladbach", "Bundesliga, Copa de europa", "Maximo goleador y motor ofensivo del equipo"),
            Estadisticas(17,6,"Hamburg", "Bundesliga", "Maximo goleador de la bundesliga, decisivo en victorias"),
            Estadisticas(20,9,"Hamburg", "Bundesliga", "Maximo goleador de la bundesliga, influencia decisiva en titulos"),
            Estadisticas(29,10,"Bayern de Múnich", "Bundesliga, Copa de Alemania", "Maximo goleador y lider del ataque del Bayern"),
            Estadisticas(27,9,"Bayern de Múnich", "Bundesliga, Copa de Alemania", "Maximo goleador y figura clave en titulos"),
            Estadisticas(20,5,"Juventus", "Serie A, Coppa de Italia", "Maximo goleador y figura en la conquista de titulos y mundial del 1982"),
            Estadisticas(18,6,"Juventus", "Serie A, Coppa de Italia", "Maximo goleador y creador de juego, decisivo para titulos"),
            Estadisticas(19,7,"Juventus", "Serie A, Coppa Italia", "Maximo goleador y lider del equipo"),
            Estadisticas(20,8,"Juventus", "Serie A, Coppa Italia", "Maximo goleador y decisivo en titulos"),
            Estadisticas(25,4,"Dynamo de Kiev", "Liga Sovietica", "Maximo goleador y figura ofensiva clave"),
            Estadisticas(15,5,"AC Milan", "Serie A, Coppa de Italia", "Lider ofensivo y versatil en titulos del club"),
            Estadisticas(26,6,"AC Milan", "Serie A, Coppa de Italia", "Maximo goleador y figura decisiva en titulos"),
            Estadisticas(28,7,"AC Milan", "Serie A, Coppa de Italia", "Maximo goleador y lider del ataque"),
            Estadisticas(22,8,"Internazionale", "Bundesliga, Copa de Alemania, Mundial del 1990", "Liderazgo y desempeño sobresaliente en liga y mundial"),
            Estadisticas(25,6,"Marsella", "Ligue 1, Copa de Francia", "Maximo goleador y figura decisiva"),
            Estadisticas(24,5,"AC Milan", "Serie A, Coppa de Italia", "Maximo goleador y lider del equipo"),
            Estadisticas(21,7,"Juventus", "Serie A, Coppa de Italia", "Creador de juego y goleador clave"),
            Estadisticas(20,6,"Barcelona", "LaLiga, Copa del Rey", "Maximo goleador y figura decisiva"),
            Estadisticas(16,5,"AC Milan", "Serie A, Coppa de Italia", "Maximo goleador y motor ofensivo del equipo"),
            Estadisticas(12,4,"Borussia Dortmund", "Bundesliga, Copa de Alemania", "Lider defensivo y mediocampista clave"),
            Estadisticas(25,7,"Internazionale", "Serie A, Coppa de Italia", "Maximo golador y figura ofensiva"),
            Estadisticas(14,6,"Juventus", "Serie A, Coppa de Italia", "Creatividad y liderazgo decisivo"),
            Estadisticas(24,8,"Barcelona", "LaLiga, Copa del Rey", "Maximo goleador y figura ofensiva"),
            Estadisticas(15,9,"Real Madrid", "LaLiga, Supercopa de España", "Creatividad y asistencias decisivas"),
            Estadisticas(16,7,"Liverpool", "Premier League, FA cup", "Maximo goleador y decisivo en partidos claves"),
            Estadisticas(23,6,"Real Madrid", "LaLiga, Copa del Rey", "Maximo goleador y lider ofensivo"),
            Estadisticas(18,5,"Juventus", "Coppa Italia", "Goles y asistencias determinantes para la conquista de la coppa Italia"),
            Estadisticas(24,6,"AC Milan", "Serie A, Coppa Italia", "Maximo goleador de la liga, figura clave en los titulos nacionales"),
            Estadisticas(26,9,"Barcelona", "LaLiga, Copa del Rey", "Maximo goleador y asistente, lider del equipo"),
            Estadisticas(5,2,"Real Madrid", "Copa del Mundo 2006(Italia), LaLiga", "Liderazgo defensivo y rendimiento destacado en el Mundial"),
            Estadisticas(20,8,"AC Milan", "Serie A,Liga de campeones de la UEFA", "Maximo goleador de la Champions, fugira en titulos nacionales"),
            Estadisticas(42,8,"Manchester United", "Premier League, FA cup,Liga de Campeones de la UEFA", "Maximo goleador de la liga y de la Champions"),
            Estadisticas(38,18,"Barcelona", "LaLiga,Copa del Rey,Liga de Campeones de la UEFA", "Maximo goleador y asistente,figura en titulos nacionales y internacionales "),
            Estadisticas(47,11,"Barcelona", "LaLiga, Supercopa de España", "Maximo goleador y asistente, rendimiento excepcional"),
            Estadisticas(73,29,"Barcelona", "LaLiga,Copa del Rey,Liga de Campeones de la UEFA", "Maximo goleador y asistente,figura en titulos nacionales y internacionales"),
            Estadisticas(91,22,"Barcelona", "LaLiga,Copa del Rey,Supercopa de españa", "Record de goles en un año calendario, rendimiento sobresaliente"),
            Estadisticas(59,15,"Real Madrid", "Copa del Rey", "Maximo goleador,figura clave en los tutilos nacionales"),
            Estadisticas(51,22,"Real Madrid", "Supercopa de España", "Maximo goleador, rendimiento destacado"),
            Estadisticas(58,27,"Barcelona", "LaLiga,Copa del Rey,Liga de Campeones de la UEFA", "Maximo goleador y asistente, figura en titulos nacionales e internacionales"),
            Estadisticas(27,12,"", "", ""), // 2016 messi
            Estadisticas(27,12,"", "", ""),
            Estadisticas(27,12,"", "", ""),
            Estadisticas(27,12,"", "", ""),
        )
        return estadisticas
    }
}

fun crearJugadores(){
    val jugadores: List<Jugador> = listOf(
        //
    )



}