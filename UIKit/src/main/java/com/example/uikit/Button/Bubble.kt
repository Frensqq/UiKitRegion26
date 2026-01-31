package com.example.uikit.Button

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import com.example.uikit.UI.Description
import com.example.uikit.UI.InputBg

@Composable
fun BubbleBack(
    onClick:()-> Unit
){
    Box(Modifier.size(32.dp)
        .clip(RoundedCornerShape(8.dp))
        .background(InputBg).clickable{onClick()}, contentAlignment = Alignment.Center) {

        Icon(painter = painterResource(R.drawable.icon_chevron_left),
            contentDescription = null, tint = Description
        )

    }
}

@Preview
@Composable
fun PreviewBubbleBack(){

    Column() {
        BubbleBack({})
    }

}
