package com.example.apptrescompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview
@Composable
fun Screen1() {
    Box(modifier = Modifier
        .padding(0.dp)
        .fillMaxSize()
        .background(Color.Blue),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Esta es la primera pantalla",
            fontSize = 32.sp,
            modifier = Modifier.padding(20.dp)
            // modifier = Modifier
            )
    }
}
@Preview
@Composable
fun Screen2() {
Column() {
    Screen1()
}


}