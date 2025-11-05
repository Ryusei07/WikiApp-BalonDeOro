package com.example.wikiapp_balondeoro.views.clubs

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController

@Composable
fun ClubsScreen(viewModel: ClubsViewModel = viewModel(), navController: NavHostController) {
    Text(text = "Clubs Screen")
}