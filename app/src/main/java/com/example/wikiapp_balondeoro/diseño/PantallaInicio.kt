package com.example.wikiapp_balondeoro.diseño

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wikiapp_balondeoro.R // Importa tu clase R

@Composable
fun PantallaInicio(onStartClicked: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize()) {
        // 1. Imagen de Fondo
        Image(
            painter = painterResource(id = R.drawable.p_inicio_balon_de_oro),
            contentDescription = "Fondo del Balón de Oro",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop // Escala la imagen para que cubra todo
        )

        // Contenedor para el contenido principal
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween // Empuja el contenido a los extremos
        ) {
            // Sección Superior (Títulos)
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(top = 60.dp) // Espacio desde arriba
            ) {
                // "Ballon D'Or" con fondo
                Surface(
                    shape = RoundedCornerShape(50), // Bordes redondeados
                    color = Color(0xFFD4AF37).copy(alpha = 0.8f) // Color dorado con transparencia
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

                // "France Football" con fondo
                Surface(
                    shape = RoundedCornerShape(50),
                    color = Color(0xFFD4AF37).copy(alpha = 0.8f)
                ) {
                    Text(
                        text = "France Football",
                        color = Color.White,
                        fontSize = 20.sp,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp)
                    )
                }
            }

            // Botón Inferior
            Button(
                onClick = onStartClicked,
                shape = RoundedCornerShape(50),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp, vertical = 40.dp), // Espacio desde abajo/lados
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF333333) // Color oscuro para el botón
                )
            ) {
                Text(
                    text = "Comenzar",
                    fontSize = 22.sp,
                    color = Color.White,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true, device = "id:pixel_4")
@Composable
fun PantallaInicioPreview() {
    // Asegúrate de tener una imagen de placeholder si es necesario para el preview
    // o simplemente vive con el error de recurso en el preview.
    PantallaInicio(onStartClicked = {})
}
