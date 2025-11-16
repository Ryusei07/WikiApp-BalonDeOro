package com.example.wikiapp_balondeoro.diseño

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
import com.example.wikiapp_balondeoro.R
import com.example.wikiapp_balondeoro.clases.Jugador
import com.example.wikiapp_balondeoro.clases.crearJugadores

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaJugadores(
    jugadores: List<Jugador>,
    onBackClicked: () -> Unit,
    onJugadorClicked: (Jugador) -> Unit = {}
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
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
                        onClick = onBackClicked
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Volver",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFFD4AF37)
                )
            )
        }
    ) { innerPadding ->
        Box(modifier = Modifier.fillMaxSize()) {
            // Imagen de fondo
            Image(
                painter = painterResource(id = R.drawable.p_inicio_balon_de_oro),
                contentDescription = "Fondo del Balón de Oro",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            // Overlay oscuro para mejor legibilidad
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .drawBehind {
                        drawRect(color = Color.Black.copy(alpha = 0.3f))
                    }
            )

            // Lista de jugadores
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                item {
                    // Header con contador
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
                        onJugadorClicked = onJugadorClicked
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemJugador(jugador: Jugador, onJugadorClicked: (Jugador) -> Unit) {
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
            // FOTO DEL JUGADOR
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
                    painter = obtenerFotoJugador(jugador.nombre),
                    contentDescription = "Foto de ${jugador.nombre}",
                    modifier = Modifier
                        .size(65.dp)
                        .clip(RoundedCornerShape(10.dp)),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            // Información del jugador
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
                    Text(
                        text = "🏴 ${jugador.nacionalidad}",
                        fontSize = 12.sp,
                        color = Color(0xFF666666),
                        fontWeight = FontWeight.Medium
                    )

                    Text(
                        text = "📅 ${jugador.añosBalones.joinToString(", ")}",
                        fontSize = 12.sp,
                        color = Color(0xFF666666),
                        fontWeight = FontWeight.Medium
                    )
                }
            }

            // Contador de Balones de Oro
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

@Composable
fun obtenerFotoJugador(nombreJugador: String) = when {
    // JUGADORES CON FOTOS ESPECÍFICAS
    nombreJugador.contains("Stoichkov", ignoreCase = true) ->
        painterResource(id = R.drawable.hristo_stoichkov_1994)

    nombreJugador.contains("Gullit", ignoreCase = true) ->
        painterResource(id = R.drawable.ruud_gullit_1987)

    nombreJugador.contains("Keegan", ignoreCase = true) ->
        painterResource(id = R.drawable.kevin_keegan_1979)

    nombreJugador.contains("Messi", ignoreCase = true) ->
        painterResource(id = R.drawable.lionel_messi_2009)

    nombreJugador.contains("Cristiano", ignoreCase = true) ->
        painterResource(id = R.drawable.cristiano_ronaldo_2008)

    nombreJugador.contains("Ronaldo", ignoreCase = true) && !nombreJugador.contains("Cristiano") ->
        painterResource(id = R.drawable.ronaldo_1997)

    nombreJugador.contains("Zidane", ignoreCase = true) ->
        painterResource(id = R.drawable.zinedine_zidane_1998)

    nombreJugador.contains("Platini", ignoreCase = true) ->
        painterResource(id = R.drawable.michel_platini_1983)

    nombreJugador.contains("Cruijff", ignoreCase = true) ->
        painterResource(id = R.drawable.johan_cruijff_1971)

    nombreJugador.contains("Beckenbauer", ignoreCase = true) ->
        painterResource(id = R.drawable.franz_beckenbauer_1972)

    nombreJugador.contains("Van Basten", ignoreCase = true) ->
        painterResource(id = R.drawable.marco_van_basten_1988)

    nombreJugador.contains("Baggio", ignoreCase = true) ->
        painterResource(id = R.drawable.roberto_baggio_1993)

    nombreJugador.contains("Weah", ignoreCase = true) ->
        painterResource(id = R.drawable.george_weah_1995)

    nombreJugador.contains("Figo", ignoreCase = true) ->
        painterResource(id = R.drawable.luis_figo_2000)

    nombreJugador.contains("Owen", ignoreCase = true) ->
        painterResource(id = R.drawable.michael_owen_2001)

    nombreJugador.contains("Nedvěd", ignoreCase = true) ->
        painterResource(id = R.drawable.pavel_nedved_2003)

    nombreJugador.contains("Shevchenko", ignoreCase = true) ->
        painterResource(id = R.drawable.andrei_chevtchenko_2004)

    nombreJugador.contains("Ronaldinho", ignoreCase = true) ->
        painterResource(id = R.drawable.ronaldinho_2005)

    nombreJugador.contains("Cannavaro", ignoreCase = true) ->
        painterResource(id = R.drawable.fabio_cannavaro_2006)

    nombreJugador.contains("Izecson", ignoreCase = true) ->
        painterResource(id = R.drawable.kaka_2007)

    nombreJugador.contains("Modrić", ignoreCase = true) ->
        painterResource(id = R.drawable.luka_modric_2018)

    nombreJugador.contains("Benzema", ignoreCase = true) ->
        painterResource(id = R.drawable.karim_benzema_2022)

    nombreJugador.contains("Rodrigo", ignoreCase = true) ->
        painterResource(id = R.drawable.rodri_2024)

    nombreJugador.contains("Matthews", ignoreCase = true) ->
        painterResource(id = R.drawable.stanley_matthews_1956)

    nombreJugador.contains("Di Stéfano", ignoreCase = true) ->
        painterResource(id = R.drawable.alfredo_di_stefano_1957)

    nombreJugador.contains("Kopa", ignoreCase = true) ->
        painterResource(id = R.drawable.raymond_kopa_1958)

    nombreJugador.contains("Suárez", ignoreCase = true) ->
        painterResource(id = R.drawable.luis_suarez_1960)

    nombreJugador.contains("Sívori", ignoreCase = true) ->
        painterResource(id = R.drawable.omar_sivori_1961)

    nombreJugador.contains("Masopust", ignoreCase = true) ->
        painterResource(id = R.drawable.josef_masopust_1962)

    nombreJugador.contains("Yashin", ignoreCase = true) ->
        painterResource(id = R.drawable.lev_yashin_1963)

    nombreJugador.contains("Law", ignoreCase = true) ->
        painterResource(id = R.drawable.denis_law_1964)

    nombreJugador.contains("Eusébio", ignoreCase = true) ->
        painterResource(id = R.drawable.eusebio_1965)

    nombreJugador.contains("Charlton", ignoreCase = true) ->
        painterResource(id = R.drawable.bobby_charlton_1966)

    nombreJugador.contains("Albert", ignoreCase = true) ->
        painterResource(id = R.drawable.florian_albert_1967)

    nombreJugador.contains("Best", ignoreCase = true) ->
        painterResource(id = R.drawable.george_best_1968)

    nombreJugador.contains("Rivera", ignoreCase = true) ->
        painterResource(id = R.drawable.gianni_rivera_1969)

    nombreJugador.contains("Müller", ignoreCase = true) ->
        painterResource(id = R.drawable.gerd_muller_1970)

    nombreJugador.contains("Blojín", ignoreCase = true) ->
        painterResource(id = R.drawable.oleg_blokhin_1975)

    nombreJugador.contains("Simonsen", ignoreCase = true) ->
        painterResource(id = R.drawable.allan_simonsen_1977)

    nombreJugador.contains("Rummenigge", ignoreCase = true) ->
        painterResource(id = R.drawable.karl_heinz_rummenigge_1980)

    nombreJugador.contains("Rossi", ignoreCase = true) ->
        painterResource(id = R.drawable.paolo_sossi_1982)

    nombreJugador.contains("Belánov", ignoreCase = true) ->
        painterResource(id = R.drawable.igor_belanov_1986)

    nombreJugador.contains("Papin", ignoreCase = true) ->
        painterResource(id = R.drawable.jean_pierre_papin_1991)

    nombreJugador.contains("Sammer", ignoreCase = true) ->
        painterResource(id = R.drawable.matthias_sammer_1996)

    nombreJugador.contains("Dembelé", ignoreCase = true) ->
        painterResource(id = R.drawable.ousmane_dembele_2025)

    nombreJugador.contains("Ferreira", ignoreCase = true) ->
        painterResource(id = R.drawable.rivaldo_1999)

    nombreJugador.contains("Herbert", ignoreCase = true) ->
        painterResource(id = R.drawable.lothar_matthaus_1990)

    // FOTO POR DEFECTO para jugadores sin foto específica
    else -> painterResource(id = R.drawable.lionel_messi_2023)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaJugadoresPreview() {
    // Preview que muestra TODOS los jugadores
    val jugadoresPreview = crearJugadores()

    PantallaJugadores(
        jugadores = jugadoresPreview,
        onBackClicked = {}
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PantallaJugadoresPreviewComposable() {
    PantallaJugadoresPreview()
}

// Preview alternativo con menos jugadores (más rápido)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaJugadoresPreviewPequeno() {
    // Solo muestra 5 jugadores para preview más rápido
    val jugadoresPreview = crearJugadores().take(5)

    PantallaJugadores(
        jugadores = jugadoresPreview,
        onBackClicked = {}
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PantallaJugadoresPreviewPequenoComposable() {
    PantallaJugadoresPreviewPequeno()
}