package com.example.wikiapp_balondeoro.views.clubs

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import androidx.navigation.compose.rememberNavController
import com.example.wikiapp_balondeoro.R
import com.example.wikiapp_balondeoro.clases.Club
import com.example.wikiapp_balondeoro.clases.crearClubes
import com.example.wikiapp_balondeoro.ui.theme.*

@Composable
fun ClubsScreen(navController: NavController) {
    val clubes = crearClubes()

    Box(modifier = Modifier.fillMaxSize()) {
        // 1. FONDO DE PANTALLA
        Image(
            painter = painterResource(id = R.drawable.p_inicio_balon_de_oro), // Usando la imagen del estadio
            contentDescription = "Fondo de pantalla",
            modifier = Modifier
                .fillMaxSize()
                .blur(10.dp), // Efecto de desenfoque
            contentScale = ContentScale.Crop
        )

        // Capa de color oscuro semitransparente sobre el fondo
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.4f))
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // 2. BARRA SUPERIOR PERSONALIZADA
            TopBarEquipos(navController)

            // 3. LISTA DENTRO DE UN SURFACE TRANSPARENTE
            Surface(
                color = Color.Transparent,
                modifier = Modifier.fillMaxSize()
            ) {
                LazyColumn(
                    contentPadding = PaddingValues(vertical = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp) // Espacio entre cada botón
                ) {
                    items(clubes) { club ->
                        ClubButton(
                            club = club,
                            onClick = {
                                // TODO: Aquí irá la navegación a la página de detalles del club
                                // Ejemplo: navController.navigate(ClubDetails(club.id))
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun TopBarEquipos(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconButton(onClick = { navController.popBackStack() }) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Volver",
                tint = Color.White,
                modifier = Modifier.size(32.dp)
            )
        }
        Text(
            text = "Equipos",
            color = Color.White,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Center
        )
        // Espacio para mantener el título centrado
        Spacer(modifier = Modifier.size(48.dp))
    }
}

@Composable
fun ClubButton(club: Club, onClick: () -> Unit) {
    val buttonColor = when (club.nombre) {
        "Real Madrid" -> BlancoMadid
        "FC Barcelona" -> RojoBarca
        "Juventus" -> BlancoJuventus
        "AC Milan" -> RojoAcMilan
        "Bayern de Múnich" -> RojoBayern
        "Manchester United" -> RojoManchesterUnited
        "Dinamo de Kiev" -> AzulDinamoKiev
        "Hamburg" -> AzulHamburg
        "Internazionale" -> AzulInternazionale
        "Paris Saint-Germain" -> AzulParis
        "Blackpool" -> NaranjaBlackpool
        "Dukla Praga" -> RojoDuklaPraga
        "Dynamo Moscú" -> AzulDynamoMoscu
        "Benfica" -> RojoBenfica
        "Ferencváros" -> VerdeFerencvaros
        "Ajax" -> RojoAjax
        "Borussia Mönchengladbach" -> BlancoBorussiaM
        "Marsella" -> CelesteMarcella
        "Borussia Dortmund" -> AmarilloBorussiaDortmund
        "Liverpool" -> RojoLiverpool
        "Inter Miami" -> RosadoInterMiami
        "Manchester City" -> AzulManchesterCity
        else -> MaterialTheme.colorScheme.surface
    }

    // Lógica corregida para el color del texto
    val textColor = when (club.nombre) {
        "Real Madrid", "Juventus", "Borussia Mönchengladbach" -> Color.Black
        else -> Color.White
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(50), // Bordes totalmente redondeados
        colors = CardDefaults.cardColors(containerColor = buttonColor)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = club.imagen),
                contentDescription = "Logo de ${club.nombre}",
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = club.nombre,
                color = textColor,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(1f) // Ocupa el espacio disponible
            )
            Text(
                text = club.cantidadBalones.toString(),
                color = textColor,
                fontSize = 22.sp,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ClubsScreenPreview() {
    WikiAppBalonDeOroTheme(darkTheme = true) {
        ClubsScreen(navController = rememberNavController())
    }
}
