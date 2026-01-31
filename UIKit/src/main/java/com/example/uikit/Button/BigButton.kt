package com.example.uikit.Button

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.Controls.Counter
import com.example.uikit.Controls.Toggle
import com.example.uikit.UI.ColorButton
import com.example.uikit.UI.Typography
import com.example.uikit.UI.White

@Composable
fun BigButton(
    text: String,
    onClick:() -> Unit, state: Boolean
){

    Button(onClick = onClick,
        modifier = Modifier.fillMaxWidth().height(56.dp),
        enabled = state,
        shape = RoundedCornerShape(10.dp),
        colors = ColorButton()
    )
    {
        Text(text, style = Typography().Title3Semibold, color = White)
    }

}

@Preview
@Composable
fun PreviewBlock(){

    Column() {
        BigButton("Подтвердить",{}, false)
        Counter(0) { }
        Toggle(true) { }
        SmallButton("Подтвердить",{}, true)
    }

}