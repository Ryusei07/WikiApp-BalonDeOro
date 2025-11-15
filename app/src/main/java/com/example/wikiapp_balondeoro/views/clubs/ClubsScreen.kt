package com.example.wikiapp_balondeoro.views.clubs

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.wikiapp_balondeoro.clases.crearClubes
import com.example.wikiapp_balondeoro.views.common.Barra

@Composable
fun ClubsScreen(navController: NavController) {
    val clubes = crearClubes()
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(clubes) { club ->
            Barra(
                titulo = club.nombre
            )
        }
    }
}

@Preview(showBackground = true, heightDp = 1200)
@Composable
fun ClubsScreenPreview() {
    ClubsScreen(navController = rememberNavController())
}