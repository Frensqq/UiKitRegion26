package com.example.uikit.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.uikit.UI.Black

@Composable
fun Overlay() {
    Box(Modifier.fillMaxSize().background(Black.copy(alpha = 0.6f)))
}