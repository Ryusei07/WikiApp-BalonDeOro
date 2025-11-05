package com.example.wikiapp_balondeoro.views.home

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController

@Composable
fun HomeScreen(viewModel: HomeViewModel = viewModel(), navController: NavHostController) {
    Text(text = "Home Screen")
}