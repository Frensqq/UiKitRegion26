package com.example.uikit.Button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.Controls.Counter
import com.example.uikit.Controls.Toggle
import com.example.uikit.UI.Accent
import com.example.uikit.UI.ColorButton
import com.example.uikit.UI.ColorButtonType2
import com.example.uikit.UI.Typography
import com.example.uikit.UI.White

@Composable
fun SmallButton(
    text: String,
    onClick:() -> Unit, state: Boolean
){

    Button(onClick = onClick,
        modifier = Modifier.width(96.dp).height(40.dp),
        shape = RoundedCornerShape(10.dp),
        colors = if (state) ColorButton() else ColorButtonType2(),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 10.dp),
        border = if (!state) BorderStroke(1.dp, Accent)
        else{BorderStroke(0.dp, Accent)}
    ) {
        Text(text, style = Typography().CaptionSemibold)
    }

}

@Preview
@Composable
fun PreviewBlockSmallButton(){

    Column() {
        SmallButton("Убрать",{}, false)
    }

}