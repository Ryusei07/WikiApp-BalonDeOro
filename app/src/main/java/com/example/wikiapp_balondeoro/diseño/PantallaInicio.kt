package com.example.wikiapp_balondeoro.diseño

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.wikiapp_balondeoro.R

@Composable
fun PantallaInicio(
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
                    color = Color(0xFFD4AF37).copy(alpha = 0.6f)
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
                    color = Color(0xFFD4AF37).copy(alpha = 0.6f)
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
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    val textoDescriptivo = listOf(
                        "La revista francesa France Football, de publicación bisemanal instaurada en 1946, decidió por incentiva del prestigioso periodista y editor Gabriel Hanot, impulsor también de la Copa de Clubes Campeones Europeos, actual Liga de Campeones, otorgar un galardón individual que designase al mejor futbolista del momento.",
                        "En 1995 hubo un cambio en las reglas para permitir que los futbolistas no europeos fueran escogidos siempre y cuando pertenecieran a un club de dicho continente. Las normas fueron modificadas nuevamente en 2007 para que los futbolistas de cualquier nacionalidad y de cualquier club de todo el mundo pudieran ser elegidos para el premio. Hasta entonces no se celebraba ningún tipo de ceremonia pública de entrega del trofeo, pero a partir de ese año se comienza a celebrar una ceremonia anual para la entrega del premio.",
                        "También en las modificaciones de 2007 se amplió el número de periodistas que podían votar. Hasta ese momento el premio era designado por 53 periodistas europeos procedentes de cada uno de los países de la UEFA, pero se añadieron otros 43 no europeos procedentes de países cuyas selecciones nacionales habían disputado al menos una fase final de un Mundial."
                    )

                    items(textoDescriptivo) { parrafo ->
                        Text(
                            text = parrafo,
                            color = Color.White,
                            fontSize = 16.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(bottom = 12.dp)
                        )
                    }
                }
            }

            // --- NUEVA SECCIÓN DE BOTONES EN FILA ---
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 20.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Botón "Jugadores"
                Button(
                    onClick = onJugadoresClicked, // Asigna la función para jugadores
                    shape = RoundedCornerShape(50),
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF333333)
                    )
                ) {
                    Text(
                        text = "Jugadores",
                        fontSize = 18.sp,
                        color = Color.White,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                }

                // Botón "Equipos"
                Button(
                    onClick = onEquiposClicked, // Asigna la función para equipos
                    shape = RoundedCornerShape(50),
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF333333)
                    )
                ) {
                    Text(
                        text = "Equipos",
                        fontSize = 18.sp,
                        color = Color.White,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                }
            }
        }
    }
}



@Preview(showBackground = true, device = "id:pixel_4")
@Composable
fun PantallaInicioPreview() {
    // Actualizamos el preview para que siga funcionando
    PantallaInicio(onJugadoresClicked = {}, onEquiposClicked = {})
}
