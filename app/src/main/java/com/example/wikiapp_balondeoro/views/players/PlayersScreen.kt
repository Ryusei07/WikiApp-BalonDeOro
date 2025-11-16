package com.example.wikiapp_balondeoro.views.players

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.wikiapp_balondeoro.clases.crearJugadores
import com.example.wikiapp_balondeoro.core.navigation.Route
import com.example.wikiapp_balondeoro.views.details_player.DetailsPlayerScreen
import com.example.wikiapp_balondeoro.views.common.Barra

@Composable
fun PlayersScreen(navController: NavController) {
    val jugadores = crearJugadores()
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        itemsIndexed(jugadores) { index, jugador ->
            Barra(
                titulo = jugador.nombre,
                modifier = Modifier.clickable { navController.navigate(
                    Route.PlayersDetails(
                        playerIndex = index
                    )
                ) }
            )
        }
    }
}

@Preview(showBackground = true, heightDp = 1200)
@Composable
fun PlayersScreenPreview() {
    PlayersScreen(navController = rememberNavController())
}
