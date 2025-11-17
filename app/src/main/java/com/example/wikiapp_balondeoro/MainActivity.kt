package com.example.wikiapp_balondeoro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.wikiapp_balondeoro.diseño.HomeScreen
import com.example.wikiapp_balondeoro.views.clubs.ClubsScreen
import com.example.wikiapp_balondeoro.views.details_club.DetailsClubScreen
import com.example.wikiapp_balondeoro.views.details_player.DetailsPlayerScreen
import com.example.wikiapp_balondeoro.views.players.PlayersScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "home") {
                    composable("home") {
                        HomeScreen(
                            navController = navController,
                            onJugadoresClicked = { navController.navigate("players") },
                            onEquiposClicked = { navController.navigate("clubs") }
                        )
                    }
                    composable("players") {
                        PlayersScreen(navController = navController)
                    }
                    composable("clubs") {
                        ClubsScreen(navController = navController)
                    }
                    composable(
                        "details/{playerIndex}",
                        arguments = listOf(navArgument("playerIndex") { type = NavType.IntType })
                    ) { backStackEntry ->
                        DetailsPlayerScreen(
                            navController = navController,
                            playerIndex = backStackEntry.arguments?.getInt("playerIndex") ?: 0
                        )
                    }
                    composable(
                        "details_club/{clubName}",
                        arguments = listOf(navArgument("clubName") { type = NavType.StringType })
                    ) { backStackEntry ->
                        DetailsClubScreen(
                            navController = navController,
                            clubName = backStackEntry.arguments?.getString("clubName") ?: ""
                        )
                    }
                }
            }
        }
    }
}