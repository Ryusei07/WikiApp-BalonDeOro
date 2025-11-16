// En: com/example/wikiapp_balondeoro/MainActivity.kt
package com.example.wikiapp_balondeoro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import com.example.wikiapp_balondeoro.diseño.PantallaInicio
import com.example.wikiapp_balondeoro.diseño.PantallaJugadores
import com.example.wikiapp_balondeoro.clases.crearJugadores

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Opción 1: Usar MaterialTheme directamente
            androidx.compose.material3.MaterialTheme {
                // Estado para controlar qué pantalla mostrar
                var mostrarPantallaJugadores by remember { mutableStateOf(false) }

                if (mostrarPantallaJugadores) {
                    PantallaJugadores(
                        jugadores = crearJugadores(),
                        onBackClicked = {
                            mostrarPantallaJugadores = false
                        }
                    )
                } else {
                    PantallaInicio(
                        onStartClicked = {
                            mostrarPantallaJugadores = true
                        }
                    )
                }
            }
        }
    }
}

// NO NECESITAS AppNavigation() NI @Preview aquí.
// El @Preview debe estar en los archivos de cada pantalla (como HomeScreen.kt)
// o en el propio NavigationWrapper.kt si quieres previsualizar la navegación.
