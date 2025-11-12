// En: com/example/wikiapp_balondeoro/MainActivity.kt
package com.example.wikiapp_balondeoro

import androidx.compose.ui.tooling.preview.Preview
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.wikiapp_balondeoro.diseño.PantallaClubes
import com.example.wikiapp_balondeoro.diseño.PantallaInicio
import com.example.wikiapp_balondeoro.diseño.PantallaJugadores
import com.example.wikiapp_balondeoro.ui.theme.WikiAppBalonDeOroTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WikiAppBalonDeOroTheme {
                AppNavigation()
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "pantalla_inicio"
    ) {
        composable("pantalla_inicio") {
            // Pasamos ambas acciones de navegación a PantallaInicio
            PantallaInicio(
                onJugadoresClicked = {
                    navController.navigate("pantalla_jugadores")
                },
                onEquiposClicked = {
                    navController.navigate("pantalla_clubes")
                }
            )
        }

        composable("pantalla_jugadores") {
            PantallaJugadores()
        }

        // Añadimos la nueva ruta para la pantalla de clubes
        composable("pantalla_clubes") {
            PantallaClubes()
        }
    }
}
