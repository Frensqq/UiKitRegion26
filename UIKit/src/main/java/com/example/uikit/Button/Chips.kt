package com.example.uikit.Button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.UI.Accent
import com.example.uikit.UI.ColorButton
import com.example.uikit.UI.ColorButtonType2
import com.example.uikit.UI.Description
import com.example.uikit.UI.InputBg
import com.example.uikit.UI.Typography
import com.example.uikit.UI.White

@Composable
fun Chips(
    onClick:()->Unit,
    state: Boolean,
    text: String
){

    Button(onClick = onClick,
        modifier = Modifier.widthIn(126.dp).height(48.dp),
        shape = RoundedCornerShape(10.dp),
        colors = if (state) ColorButton() else
            ButtonDefaults.buttonColors(
                containerColor = InputBg,
                contentColor = Description
            ),
        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 14.dp),
    )
    {
        Text(text, style = Typography().TextMedium, color = if(state) White else Description)
    }

}

@Preview
@Composable
fun PreviewBlockChips(){

    Column() {
        Chips({}, true, "Популярные")
    }

}

