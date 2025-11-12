package com.example.wikiapp_balondeoro.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.wikiapp_balondeoro.clases.Jugador
import com.example.wikiapp_balondeoro.diseño.PantallaJugadores
import com.example.wikiapp_balondeoro.views.clubs.ClubsScreen
import com.example.wikiapp_balondeoro.views.details_player.DetailsPlayerScreen
import com.example.wikiapp_balondeoro.views.history.HistoryScreen
import com.example.wikiapp_balondeoro.views.home.HomeScreen
import kotlinx.serialization.json.Json
import kotlin.reflect.typeOf

@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Home) {
        composable<Home> {
            HomeScreen(navController = navController)
        }
        composable<History> {
            HistoryScreen(navController = navController)
        }
        composable<Players> {
            PantallaJugadores()
        }
        composable<PlayersDetails>(
            typeMap = mapOf(typeOf<Jugador>() to object : NavType<Jugador>(isNullableAllowed = false) {
                override val name = "Jugador"
                override fun get(bundle: android.os.Bundle, key: String): Jugador? =
                    bundle.getString(key)?.let { Json.decodeFromString<Jugador>(it) }

                override fun parseValue(value: String): Jugador =
                    Json.decodeFromString(value)

                override fun put(bundle: android.os.Bundle, key: String, value: Jugador) {
                    bundle.putString(key, Json.encodeToString(value))
                }
            })
        ) { backStackEntry ->
            val args = backStackEntry.toRoute<PlayersDetails>()
            DetailsPlayerScreen(jugador = args.jugador, navController = navController)
        }
        composable<Clubs> {
            ClubsScreen(navController = navController)
        }
    }
}
