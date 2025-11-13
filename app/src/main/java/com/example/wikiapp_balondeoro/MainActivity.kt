// En: com/example/wikiapp_balondeoro/MainActivity.kt
package com.example.wikiapp_balondeoro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.wikiapp_balondeoro.core.navigation.NavigationWrapper // <-- ¡Importante!
import com.example.wikiapp_balondeoro.ui.theme.WikiAppBalonDeOroTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WikiAppBalonDeOroTheme {
                // Simplemente llama al composable que contiene toda tu lógica de navegación
                NavigationWrapper()
            }
        }
    }
}

// NO NECESITAS AppNavigation() NI @Preview aquí.
// El @Preview debe estar en los archivos de cada pantalla (como HomeScreen.kt)
// o en el propio NavigationWrapper.kt si quieres previsualizar la navegación.
