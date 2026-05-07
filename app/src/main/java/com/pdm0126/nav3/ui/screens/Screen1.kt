package com.pdm0126.nav3.ui.screens

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Screen1(onBack: () -> Unit, modifier: Modifier = Modifier) {

    Text(text = "Screen 1")
    Spacer(modifier = Modifier.height(16.dp))
    Button(
        onClick = onBack,
        modifier = modifier
    ) {Text("Back") }
}