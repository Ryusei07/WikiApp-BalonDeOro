package com.example.wikiapp_balondeoro.core.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed interface Route {
    @Serializable
    data object Home : Route

    @Serializable
    data object Players : Route

    @Serializable
    data object Clubs : Route

    @Serializable
    data object History : Route

    @Serializable
    data class PlayersDetails(val playerIndex: Int) : Route
}

