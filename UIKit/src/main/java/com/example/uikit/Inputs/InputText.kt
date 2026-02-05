package com.example.uikit.Inputs

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.Button.BigButton
import com.example.uikit.Button.SmallButton
import com.example.uikit.Controls.Counter
import com.example.uikit.Controls.Toggle
import com.example.uikit.R
import com.example.uikit.UI.Black
import com.example.uikit.UI.ColorInput
import com.example.uikit.UI.Typography

@Composable
fun InputText(
    value: String,
    onChangeValue:(String) ->Unit,
    isPass: Boolean,
    placeholder: String,
    isError: Boolean = false,

){

    var passView by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = value,
        onValueChange = {onChangeValue(it)},
        modifier = Modifier.fillMaxWidth().height(48.dp),
        shape = RoundedCornerShape(10.dp),
        isError = isError,

        trailingIcon = {
            if (isPass){Icon(
                painter = painterResource(if (!passView) R.drawable.icon_eyeopen else R.drawable.icon_eyeclose),
                contentDescription = null, tint = Black,
                modifier = Modifier.clickable{passView = !passView}
            )}
        },
        visualTransformation = if (passView && isPass){
            PasswordVisualTransformation()
        }else VisualTransformation.None,
        colors = ColorInput(),
        placeholder = { Text(placeholder, style = Typography().TextRegular, color = Color(0xff939396)) },
        textStyle = Typography().TextRegular)
}

@Preview
@Composable
fun PreviewInputText(){

    Column() {
        InputText("",{}, true, "Введите имя")
    }

}