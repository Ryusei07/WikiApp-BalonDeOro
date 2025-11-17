package com.example.wikiapp_balondeoro.views.details_player

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.wikiapp_balondeoro.R
import com.example.wikiapp_balondeoro.clases.crearJugadores

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsPlayerScreen(playerIndex: Int, navController: NavHostController) {
    val jugador = crearJugadores()[playerIndex]

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = jugador.nombre, color = Color.White, fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Volver", tint = Color.White)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFD4AF37)
                )
            )
        }
    ) { paddingValues ->
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.p_inicio_balon_de_oro),
                contentDescription = "Fondo",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .drawBehind { drawRect(color = Color.Black.copy(alpha = 0.5f)) }
                    .padding(paddingValues)
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    item {
                        Image(
                            painter = painterResource(id = jugador.imagen),
                            contentDescription = "Foto de ${jugador.nombre}",
                            modifier = Modifier.height(300.dp)
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                    }

                    itemsIndexed(jugador.stats) { index, stat ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp),
                            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                            colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.9f))
                        ) {
                            Column(modifier = Modifier.padding(16.dp)) {
                                Text(
                                    text = "Año: ${jugador.añosBalones[index]}",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp,
                                    color = Color(0xFFD4AF37)
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                Text(text = "Goles: ${stat.cantidadGoles}", color = Color.Black)
                                Text(text = "Asistencias: ${stat.cantidadAsitencias}", color = Color.Black)
                                Text(text = "Club: ${stat.club}", color = Color.Black)
                                Text(text = "Títulos: ${stat.premios}", color = Color.Black)
                                Text(text = "Descripción: ${stat.logrosDestacados}", color = Color.Black)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailsPlayerScreenPreview() {
    DetailsPlayerScreen(playerIndex = 1, navController = rememberNavController())
}
