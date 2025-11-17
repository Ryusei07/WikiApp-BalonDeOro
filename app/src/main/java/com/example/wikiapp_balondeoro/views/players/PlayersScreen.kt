package com.example.wikiapp_balondeoro.views.players

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.wikiapp_balondeoro.R
import com.example.wikiapp_balondeoro.clases.Jugador
import com.example.wikiapp_balondeoro.clases.crearJugadores

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlayersScreen(navController: NavController) {
    val jugadores = crearJugadores()
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "GANADORES BALÓN DE ORO",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = { navController.popBackStack() }
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Volver",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFD4AF37)
                )
            )
        }
    ) { innerPadding ->
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.p_inicio_balon_de_oro),
                contentDescription = "Fondo del Balón de Oro",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .drawBehind {
                        drawRect(color = Color.Black.copy(alpha = 0.3f))
                    }
            )
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                item {
                    Text(
                        text = "${jugadores.size} Ganadores Históricos",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp)
                    )
                }

                items(jugadores) { jugador ->
                    ItemJugador(
                        jugador = jugador,
                        onJugadorClicked = {
                            navController.navigate("details/${jugadores.indexOf(jugador)}")
                        }
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemJugador(jugador: Jugador, onJugadorClicked: (Jugador) -> Unit) {
    val nombrePais = when (jugador.nacionalidad) {
        "Ingles" -> "Inglaterra"
        "Argentino/Español" -> "Argentina/España"
        "Frences/Polaco" -> "Francia/Polonia"
        "Español" -> "España"
        "Argentina/Italiana" -> "Argentina/Italia"
        "Republica Checa" -> "República Checa"
        "Union Sovietica" -> "Unión Soviética"
        "Británica" -> "Reino Unido"
        "hungaro" -> "Hungría"
        "Norte de Irlanda" -> "Irlanda del Norte"
        "Aleman" -> "Alemania"
        "Paises Bajos" -> "Países Bajos"
        "bulgaro" -> "Bulgaria"
        "Brazileño" -> "Brasil"
        "Ucraniano" -> "Ucrania"
        "Croata" -> "Croacia"
        "Frances" -> "Francia"
        "Escocés" -> "Escocia"
        else -> jugador.nacionalidad
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White.copy(alpha = 0.95f)
        ),
        onClick = { onJugadorClicked(jugador) }
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .size(70.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .drawBehind {
                        drawRect(color = Color(0xFFF5F5F5))
                    },
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = jugador.imagen),
                    contentDescription = "Foto de ${jugador.nombre}",
                    modifier = Modifier
                        .size(65.dp)
                        .clip(RoundedCornerShape(10.dp)),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = jugador.nombre,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1a1a1a),
                    maxLines = 2,
                    lineHeight = 18.sp
                )

                Spacer(modifier = Modifier.height(6.dp))

                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                        jugador.imagen_pais.forEach { imagenId ->
                            Image(
                                painter = painterResource(id = imagenId),
                                contentDescription = null, // Decorative image
                                modifier = Modifier.height(16.dp)
                            )
                        }
                        Text(
                            text = nombrePais,
                            fontSize = 12.sp,
                            color = Color(0xFF666666),
                            fontWeight = FontWeight.Medium
                        )
                    }

                    Text(
                        text = "📅 ${jugador.añosBalones.joinToString(", ")}",
                        fontSize = 12.sp,
                        color = Color(0xFF666666),
                        fontWeight = FontWeight.Medium
                    )
                }
            }
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .drawBehind {
                        drawRect(color = Color(0xFFD4AF37))
                    },
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Balones de Oro",
                        tint = Color.White,
                        modifier = Modifier.size(18.dp)
                    )
                    Text(
                        text = jugador.cantidadBalones.toString(),
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PlayersScreenPreview() {
    PlayersScreen(navController = rememberNavController())
}
