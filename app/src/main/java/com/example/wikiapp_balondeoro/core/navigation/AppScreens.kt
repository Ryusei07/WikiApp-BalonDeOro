package com.example.wikiapp_balondeoro.core.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class AppScreens

@Serializable
data object Home : AppScreens()

@Serializable
data object History : AppScreens()

@Serializable
data object Players : AppScreens()

@Serializable
data object Clubs : AppScreens()

@Serializable
data class PlayersDetails(val playerIndex: Int) : AppScreens()
