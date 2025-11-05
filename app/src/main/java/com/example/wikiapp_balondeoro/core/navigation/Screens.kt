package com.example.wikiapp_balondeoro.core.navigation

import com.example.wikiapp_balondeoro.clases.Jugador
import kotlinx.serialization.Serializable

@Serializable
object Home

@Serializable
object History

@Serializable
object Players

@Serializable
data class PlayersDetails(val jugador: Jugador)

@Serializable
object Clubs