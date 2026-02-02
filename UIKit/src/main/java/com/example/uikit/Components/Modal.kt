package com.example.uikit.Components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.Button.BigButton
import com.example.uikit.R
import com.example.uikit.UI.Black
import com.example.uikit.UI.Description
import com.example.uikit.UI.InputIcon
import com.example.uikit.UI.Placeholder
import com.example.uikit.UI.Typography
import com.example.uikit.UI.White

@Composable
fun Modal(
    Title: String,
    ApproximateСost: String,
    Text: String,
    Cost: String,
    onClick: () -> Unit
){
    Overlay() {
        Box(Modifier.fillMaxSize().padding(horizontal = 20.dp), contentAlignment = Alignment.BottomCenter) {
            Column(
                modifier = Modifier.fillMaxWidth().height(636.dp)
                    .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)).background(White)
                    .padding(20.dp), verticalArrangement = Arrangement.Bottom
            ) {

                SpacerH(4)
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top
                ) {
                    Text(
                        Title,
                        style = Typography().Title2Semibold,
                        color = Black,
                        maxLines = 2,
                        modifier = Modifier.fillMaxWidth(0.7f)
                    )

                    Box(
                        Modifier.size(24.dp).clip(CircleShape).background(InputIcon),
                        contentAlignment = Alignment.Center
                    ) {

                        Icon(
                            painter = painterResource(R.drawable.icon_close), tint = Description,
                            contentDescription = null
                        )
                    }
                }

                SpacerH(20)

                Text("Описание", style = Typography().HeadlineMedium, color = Placeholder)
                SpacerH(8)
                Text(Text, style = Typography().TextRegular, color = Black)

                Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Bottom) {
                    Text(
                        "Примерный расход:",
                        style = Typography().CaptionSemibold,
                        color = Placeholder
                    )
                    SpacerH(4)
                    Text(ApproximateСost, style = Typography().HeadlineMedium, color = Black)
                    SpacerH(19)
                    BigButton("Добавить за $Cost ₽", { onClick() }, true)
                    SpacerH(20)

                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewModal(){
    Modal(
        "Рубашка воскресенье для \n" +
                "машинного вязания",
        "80-90 г",
        "Мой выбор для этих шапок – кардные составы, которые раскрываются деликатным пушком. Кашемиры, мериносы, смесовки с ними отлично подойдут на шапку.\n" +
                "Кардные составы берите в большое количество сложений, вязать будем резинку 1х1, плотненько.\n" +
                "Пряжу 1400-1500м в 100г в 4 сложения, пряжу 700м в 2 сложения. Ориентир для конечной толщины – 300-350м в 100г.\n" +
                "Артикулы, из которых мы вязали эту модель: Zermatt Zegna Baruffa, Cashfive, Baby Cashmere Loro Piana, Soft Donegal и другие.\n" +
                "Примерный расход на шапку с подгибом 70-90г.",
        "690",
        {}
    )
}