package com.example.wikiapp_balondeoro.views.details_player

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.wikiapp_balondeoro.clases.Jugador

@Composable
fun DetailsPlayerScreen(viewModel: DetailPlayerViewModel = viewModel(), jugador: Jugador, navController: NavHostController) {
    Text(text = "Details Player Screen: ${jugador.nombre}")
}