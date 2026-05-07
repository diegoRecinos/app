package com.pdm0126.nav3.ui.screens

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pdm0126.nav3.Routes

@Composable
fun HomeScreen(
    onNavigateToScreen1: () -> Unit,
    onNavigateToScreen2: () -> Unit

){
    Button(onClick = onNavigateToScreen1) {}
    Spacer(modifier = Modifier.height(16.dp))
    Button(onClick = onNavigateToScreen2) {}

}