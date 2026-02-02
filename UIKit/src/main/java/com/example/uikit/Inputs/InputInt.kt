package com.example.uikit.Inputs

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.UI.ColorInput
import com.example.uikit.UI.InputBg
import com.example.uikit.UI.Typography
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun InputInt(
    value: String,
    onChangeValue: (String) -> Unit,
    focusRequester: FocusRequester,
    index: Int,
    focuses: List<FocusRequester>
) {
    OutlinedTextField(
        value = value,
        onValueChange = { newValue ->
            if (newValue.length <= 1) {
                val oldValue = value
                onChangeValue(newValue)

                // Вперед при вводе
                if (newValue.isNotEmpty() && oldValue.isEmpty() && index < focuses.size - 1) {
                    CoroutineScope(Dispatchers.Main).launch {
                        focuses[index + 1].requestFocus()
                    }
                }
                // Назад при удалении
                else if (newValue.isEmpty() && index > 0) {
                    CoroutineScope(Dispatchers.Main).launch {
                        focuses[index - 1].requestFocus()
                    }
                }
            }
        },
        colors = ColorInput(),
        modifier = Modifier
            .size(48.dp)
            .focusRequester(focusRequester),
        shape = RoundedCornerShape(10.dp),
        textStyle = Typography().TextRegular
    )
}

@Preview
@Composable
fun PreviewInputInt() {
    val count = 4
    val values = remember { mutableStateListOf(*Array(count) { "" }) }
    val focuses = remember { List(count) { FocusRequester() } }

    Row {
        repeat(count) { index ->
            InputInt(
                value = values[index],
                onChangeValue = { values[index] = it },
                focusRequester = focuses[index],
                index = index,
                focuses = focuses
            )
        }
        Text(text = values.toString())
    }
}