package com.example.uikit.Inputs

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.uikit.Components.SpacerH
import com.example.uikit.UI.Error
import com.example.uikit.UI.Typography

@Composable
fun InputTextAndText(value: String,
                     onChangeValue:(String) ->Unit,
                     isPass: Boolean,
                     isError: Boolean,
                     placeholder: String,
                     errorText: String?,
                     text: String?){
    Column() {
        if (!text.isNullOrEmpty()){
            Text(text, style = Typography().CaptionRegular,
                color = Color(0xff939396))
            SpacerH(6)
        }
        InputText(value, onChangeValue, isPass, placeholder, isError)
        if (!errorText.isNullOrEmpty() && isError){
            SpacerH(8)
            Text(errorText, style = Typography().CaptionRegular,
                color = Error
            )
        }
    }
}