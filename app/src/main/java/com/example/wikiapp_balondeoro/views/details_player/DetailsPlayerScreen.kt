package com.example.wikiapp_balondeoro.views.details_player

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.wikiapp_balondeoro.clases.Jugador
import com.example.wikiapp_balondeoro.clases.crearJugadores

@Composable
fun DetailsPlayerScreen(viewModel: DetailPlayerViewModel = viewModel(), playerIndex: Int, navController: NavHostController) {
    val jugador = crearJugadores()[playerIndex]
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = jugador.imagen),
            contentDescription = "Foto de ${jugador.nombre}",
            modifier = Modifier.size(200.dp)

        )
        Spacer(modifier = Modifier.height(16.dp))
        Column(horizontalAlignment = Alignment.Start) {
            Text(text = "Nombre: ${jugador.nombre}")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Años Balón de Oro: ${jugador.añosBalones.joinToString()}")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Nacionalidad: ${jugador.nacionalidad}")
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Estadísticas:")
            Spacer(modifier = Modifier.height(16.dp))
            jugador.stats.forEachIndexed { index, stat ->
                if (jugador.stats.size > 1) {
                    Text(
                        text = "  Año: ${jugador.añosBalones[index]}",
                        fontWeight = FontWeight.Bold
                    )
                }
                Text(text = "  Goles: ${stat.cantidadGoles}")
                Text(text = "  Asistencias: ${stat.cantidadAsitencias}")
                Text(text = "  Club: ${stat.club}")
                Text(text = "  Titulos: ${stat.premios}")
                Text(text = "  Descripcion: ${stat.logrosDestacados}")
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailsPlayerScreenPreview(){
    DetailsPlayerScreen(playerIndex = 1, navController = rememberNavController())
}
