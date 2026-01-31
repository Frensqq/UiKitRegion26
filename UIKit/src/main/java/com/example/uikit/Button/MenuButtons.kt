package com.example.uikit.Button

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.Components.SpacerW
import com.example.uikit.R
import com.example.uikit.UI.Accent
import com.example.uikit.UI.Typography

@Composable
fun MenuButtons(onClick:()->Unit, count: String){

    Row(Modifier.fillMaxWidth().height(64.dp).clickable{onClick()},
        verticalAlignment = Alignment.CenterVertically) {
        Image(painter = painterResource(R.drawable.document),
            contentDescription = null
        )

        SpacerW(17)

        Column(Modifier.fillMaxHeight().padding(vertical = 6.dp),
            verticalArrangement = Arrangement.SpaceBetween) {
            Text("Результаты расчета", style = Typography().Title3Semibold)

            Text("$count новый результат", color = Color(0xff939396))
        }

    }

}

@Preview
@Composable
fun PreviewMenuButtons(){

    Column() {
        MenuButtons({},"1")
    }

}
