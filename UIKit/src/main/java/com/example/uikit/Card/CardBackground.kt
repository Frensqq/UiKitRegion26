package com.example.uikit.Card

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.Components.Header
import com.example.uikit.UI.InputIcon
import com.example.uikit.UI.White

@Composable
fun CardBackground(content: @Composable () -> Unit){

    Box(modifier = Modifier.fillMaxWidth().height(138.dp)
        .clip(RoundedCornerShape(12.dp))
        .dropShadow(
            shape = RoundedCornerShape(12.dp),
            shadow = Shadow(radius = 20.dp, spread = 20.dp, color = Color(0x99E4E8F5)) )
        .background(White)) {

        content()

    }

}

@Preview
@Composable
fun PreviewCardBackground(){

    Column() {
        CardBackground({})
    }

}

