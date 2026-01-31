package com.example.uikit.Selects

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
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
import androidx.compose.ui.unit.dp
import com.example.uikit.Components.SpacerH
import com.example.uikit.R
import com.example.uikit.UI.Black
import com.example.uikit.UI.ColorInput
import com.example.uikit.UI.Description
import com.example.uikit.UI.Typography
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DateSelect(textTitle: String,
    value: String,
               listValue: List<String>,
               onChangeValue:(String) ->Unit,
               placeholder: String
){
    var state by remember { mutableStateOf(false) }
    val formatted = remember{ SimpleDateFormat("yyyy-MM-dd", Locale.US) }


    Column(modifier = Modifier.fillMaxWidth()) {

        Text(textTitle, style = Typography().CaptionRegular, color = Description)
        SpacerH(4)

        OutlinedTextField(
            value = value,
            onValueChange = {},
            modifier = Modifier.fillMaxWidth().height(48.dp),
            shape = RoundedCornerShape(10.dp),
            trailingIcon = {
                Icon(
                    painter = painterResource(R.drawable.icon_chevron_down),
                    contentDescription = null, tint = Black,
                    modifier = Modifier.clickable { state = !state }
                )
            },
            colors = ColorInput(),
            placeholder = {
                Text(
                    placeholder,
                    style = Typography().TextRegular,
                    color = Color(0xff939396)
                )
            },
            textStyle = Typography().TextRegular,
            readOnly = true
        )

        if (state) {
            val datePickerState = rememberDatePickerState()
            DatePickerDialog(
                onDismissRequest = { state = false },
                confirmButton = {
                    TextButton({
                        datePickerState.selectedDateMillis?.let {
                            onChangeValue(formatted.format(Date(it)))
                        }
                        state = false
                    }) { Text("OK") }
                },
                dismissButton = {
                    TextButton({
                        state = false
                    }) { Text("Отмена") }
                }
            ) {
                DatePicker(datePickerState)
            }
        }
    }

}
