package com.example.uikit.Button

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.Components.SpacerW
import com.example.uikit.Controls.Counter
import com.example.uikit.Controls.Toggle
import com.example.uikit.R
import com.example.uikit.UI.ColorButton
import com.example.uikit.UI.Typography
import com.example.uikit.UI.White

@Composable
fun CartButtonsStack(onClick:() -> Unit, cost: String
){
    Button(onClick = onClick,
        modifier = Modifier.fillMaxWidth().height(56.dp),
        shape = RoundedCornerShape(10.dp),
        colors = ColorButton(),
        contentPadding = PaddingValues(16.dp)
    )
    {
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Row() {
                Icon(painter = painterResource(R.drawable.icon_shopping_cart),
                    tint = White, contentDescription = null)
                SpacerW(16)
                Text("В корзину", style = Typography().Title3Semibold, color = White)

            }
            Text("$cost ₽", style = Typography().Title3Semibold, color = White)
        }
    }
}

@Preview
@Composable
fun PreviewCartButtonsStack(){

    Column() {
        CartButtonsStack({}, "500")
    }

}