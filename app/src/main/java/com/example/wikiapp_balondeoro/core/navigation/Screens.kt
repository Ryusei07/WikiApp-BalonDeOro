package com.example.wikiapp_balondeoro.core.navigation

import kotlinx.serialization.Serializable

@Serializable
object Home

@Serializable
object History

@Serializable
object Players

@Serializable
data class PlayersDetails(val playerIndex: Int)

@Serializable
object Clubs
