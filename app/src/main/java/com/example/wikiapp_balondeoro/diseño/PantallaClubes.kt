package com.example.wikiapp_balondeoro.diseño

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.wikiapp_balondeoro.clases.crearClubes

@Preview(showBackground = true, heightDp = 1200)
@Composable
fun PantallaClubes() {
    val clubes = crearClubes()
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(clubes) { club ->
            Barra(titulo = club.nombre)
        }
    }
}
