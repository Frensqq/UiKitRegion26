package com.example.uikit.Card

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.Button.SmallButton
import com.example.uikit.Components.SpacerH
import com.example.uikit.UI.Black
import com.example.uikit.UI.Typography

@Composable
fun PrimaryCard(titleText: String,stateButton: Boolean , onClick:() -> Unit, Type: String, cost: String){

    var textbutton =  if (stateButton) "Добавить" else "Убрать"

    CardBackground {
        Column(modifier = Modifier.height(138.dp).fillMaxWidth().padding(16.dp), verticalArrangement = Arrangement.SpaceBetween) {

            Text(titleText, style = Typography().HeadlineMedium, color = Black, maxLines = 2)

            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom) {
                Column(
                    Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    SpacerH(16)
                    Text(Type, style = Typography().CaptionSemibold, color = Color(0xff939396))

                    Text("$cost ₽", style = Typography().Title3Semibold, color = Black)
                }

                SmallButton(textbutton, onClick,stateButton )
            }

        }
    }

}

@Preview
@Composable
fun PreviewPrimaryCard(){

    Column() {
        PrimaryCard("Рубашка Воскресенье для машинного \n" +
                "вязания",false, {},"Мужская одежда", "300")
    }

}
