package com.example.wikiapp_balondeoro.views.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Barra(titulo: String, modifier: Modifier = Modifier){
    Column (
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(color = Color(0xFFEFEFEF))
            .padding(16.dp)


    ){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .clip(RoundedCornerShape(6.dp))
                .background(color = Color(0xFF000000)),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(titulo, color = Color.Yellow)
        }

    }
}

@Preview(showBackground = true)
@Composable
fun BarraPreview(){
    Barra(titulo = "Jugador de prueba")
}
