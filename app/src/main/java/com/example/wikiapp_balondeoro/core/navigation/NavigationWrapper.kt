package com.example.wikiapp_balondeoro.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.wikiapp_balondeoro.views.clubs.ClubsScreen
import com.example.wikiapp_balondeoro.views.details_player.DetailsPlayerScreen
import com.example.wikiapp_balondeoro.views.history.HistoryScreen
import com.example.wikiapp_balondeoro.views.home.HomeScreen
import com.example.wikiapp_balondeoro.views.players.PlayersScreen

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
            PlayersScreen(navController = navController)
        }
        composable<PlayersDetails> {
            val args = it.toRoute<PlayersDetails>()
            DetailsPlayerScreen(playerIndex = args.playerIndex, navController = navController)
        }
        composable<Clubs> {
            ClubsScreen(navController = navController)
        }
    }
}
