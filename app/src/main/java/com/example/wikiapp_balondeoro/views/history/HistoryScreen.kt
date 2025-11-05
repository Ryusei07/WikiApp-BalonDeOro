package com.example.wikiapp_balondeoro.views.history

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController

@Composable
fun HistoryScreen(viewModel: HistoryViewModel = viewModel(), navController: NavHostController) {
    Text(text = "History Screen")
}