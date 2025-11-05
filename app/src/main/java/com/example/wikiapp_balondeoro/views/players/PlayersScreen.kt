package com.example.wikiapp_balondeoro.views.players

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController

@Composable
fun PlayersScreen(viewModel: PlayersViewModel = viewModel(), navController: NavHostController) {
    Text(text = "Players Screen")
}