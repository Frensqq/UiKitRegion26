package com.example.uikit.Inputs

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.uikit.UI.ColorInput
import com.example.uikit.UI.InputBg
import com.example.uikit.UI.Typography

@Composable
fun InputInt(value: String,
             onChangeValue:(String) ->Unit){

    OutlinedTextField(
        value,
        onValueChange = {onChangeValue(it)},
        colors = ColorInput(),
        modifier = Modifier.size(48.dp),
        shape = RoundedCornerShape(10.dp),
        textStyle = Typography().TextRegular

    )

}