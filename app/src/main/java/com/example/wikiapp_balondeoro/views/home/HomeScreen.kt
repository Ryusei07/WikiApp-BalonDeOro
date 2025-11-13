package com.example.wikiapp_balondeoro.diseño

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
// import androidx.compose.foundation.lazy.items // Ya no se usa 'items', así que es opcional
import androidx.compose.foundation.shape.RoundedCornerShape // <-- EL IMPORT QUE FALTABA
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.wikiapp_balondeoro.R
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeScreen(navController: NavController,
               onJugadoresClicked: () -> Unit,
               onEquiposClicked: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        // 1. Imagen de Fondo
        Image(
            painter = painterResource(id = R.drawable.p_inicio_balon_de_oro),
            contentDescription = "Fondo del Balón de Oro",
            modifier = Modifier
                .fillMaxSize()
                .blur(radius = 15.dp),
            contentScale = ContentScale.Crop
        )

        // Contenedor principal
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            // --- SECCIÓN SUPERIOR ---
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(top = 60.dp)

            ) {
                Surface(
                    shape = RoundedCornerShape(50),
                    color = Color(0xFFD4AF37).copy(alpha = 0.1f) // Más transparente
                ) {
                    Text(
                        text = "Ballon D'Or",
                        color = Color.White,
                        fontSize = 50.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp)
                    )
                }
                Spacer(modifier = Modifier.height(12.dp))
                Surface(
                    shape = RoundedCornerShape(50),
                    color = Color(0xFFD4AF37).copy(alpha = 0.1f) // Más transparente
                ) {
                    Text(
                        text = "France Football",
                        color = Color.White,
                        fontSize = 20.sp,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp)
                    )
                }
            }


            // --- RECTÁNGULO CON TEXTO SCROLLING ---
            Surface(
                modifier = Modifier
                    .weight(1f)
                    .padding(vertical = 24.dp, horizontal = 16.dp),
                shape = RoundedCornerShape(16.dp),
                color = Color.Black.copy(alpha = 0.5f)
            ) {
                LazyColumn(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // --- Primer párrafo de texto ---
                    // --- IMAGEN CON FONDO Y FORMA ---
                    item {
                        Surface(
                            shape = RoundedCornerShape(3.dp),
                            color = Color.White.copy(alpha = 0.0f),
                            modifier = Modifier
                                .fillMaxWidth(0.8f)
                                .padding(vertical = 0.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.balon_oro_dos),
                                contentDescription = "Balón de Oro",
                                modifier = Modifier
                                    .padding(50.dp)
                                    .fillMaxWidth(),
                                contentScale = ContentScale.Fit
                            )
                        }
                    }

                    item {
                        Text(
                            text = "La revista francesa France Football, de publicación bisemanal instaurada en 1946, decidió por incentiva del prestigioso periodista y editor Gabriel Hanot, impulsor también de la Copa de Clubes Campeones Europeos, actual Liga de Campeones, otorgar un galardón individual que designase al mejor futbolista del momento.",
                            color = Color.White,
                            fontSize = 16.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(bottom = 16.dp)
                        )
                    }



                    // --- Segundo y tercer párrafo de texto ---
                    item {
                        Text(
                            text = "En 1995 hubo un cambio en las reglas para permitir que los futbolistas no europeos fueran escogidos siempre y cuando pertenecieran a un club de dicho continente. Las normas fueron modificadas nuevamente en 2007 para que los futbolistas de cualquier nacionalidad y de cualquier club de todo el mundo pudieran ser elegidos para el premio.",
                            color = Color.White,
                            fontSize = 16.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(bottom = 16.dp)
                        )
                    }
                    item {
                        Text(
                            text = "También en las modificaciones de 2007 se amplió el número de periodistas que podían votar. Hasta ese momento el premio era designado por 53 periodistas europeos procedentes de cada uno de los países de la UEFA, pero se añadieron otros 43 no europeos.",
                            color = Color.White,
                            fontSize = 16.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(bottom = 12.dp)
                        )
                    }
                }
            }


            // --- SECCIÓN DE BOTONES ---
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 20.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Button(
                    onClick = onJugadoresClicked,
                    shape = RoundedCornerShape(50),
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF333333))
                ) {
                    Text("Jugadores", fontSize = 18.sp, color = Color.White, modifier = Modifier.padding(vertical = 8.dp))
                }
                Button(
                    onClick = onEquiposClicked,
                    shape = RoundedCornerShape(50),
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF333333))
                ) {
                    Text("Equipos", fontSize = 18.sp, color = Color.White, modifier = Modifier.padding(vertical = 8.dp))
                }
            }
        }
    }
}

@Preview(showBackground = true, device = "id:pixel_4")
@Composable
fun HomeScreenPreview() {
    // Crea un NavController falso para la preview
    val navController = rememberNavController()

    // Ahora llama a HomeScreen con todos los parámetros requeridos
    HomeScreen(
        navController = navController,
        onJugadoresClicked = {},
        onEquiposClicked = {}
    )
}

