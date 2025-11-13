package com.example.wikiapp_balondeoro.diseño

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wikiapp_balondeoro.R
import com.example.wikiapp_balondeoro.clases.Estadisticas
import com.example.wikiapp_balondeoro.clases.Jugador

@Composable
fun PantallaDetalleJugadores(jugador: Jugador){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = jugador.imagen),
            contentDescription = "Foto de ${jugador.nombre}"
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Nombre: ${jugador.nombre}")
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Años Balón de Oro: ${jugador.añosBalones.joinToString()}")
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Nacionalidad: ${jugador.nacionalidad}")
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Estadísticas:")
        jugador.stats.forEach { stat ->
            Text(text = "  Goles: ${stat.cantidadGoles}")
            Text(text = "  Asistencias: ${stat.cantidadAsitencias}")
            Text(text = "  Club: ${stat.club}")
            Text(text = "  Titulos: ${stat.premios}")
            Text(text = "  Descripcion: ${stat.logrosDestacados}")
            Spacer(modifier = Modifier.height(8.dp))
        }
    }

}

@Preview(showBackground = true)
@Composable
fun PantallaDetalleJugadoresPreview(){
    val jugador = Jugador(
        "Lionel Messi",
        "Argentino",
        listOf(2009, 2010, 2011, 2012, 2015, 2019, 2021, 2023),
        8,
        listOf(Estadisticas(91, 22, "Barcelona", "LaLiga, Copa del Rey, Supercopa de españa", "Record de goles en un año calendario, rendimiento sobresaliente")),
        R.drawable.lionel_messi_2009
    )
    PantallaDetalleJugadores(jugador = jugador)
}