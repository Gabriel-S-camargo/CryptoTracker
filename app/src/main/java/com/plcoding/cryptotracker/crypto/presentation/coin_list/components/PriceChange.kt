package com.plcoding.cryptotracker.crypto.presentation.coin_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.plcoding.cryptotracker.crypto.presentation.data.DisplayableNumber
import com.plcoding.cryptotracker.ui.theme.CryptoTrackerTheme
import com.plcoding.cryptotracker.ui.theme.greenBackground

@Composable
fun PriceChange(
    change : DisplayableNumber,
    modifier: Modifier = Modifier
) {

    // Nestas duas variáveis abaixo estou testando o valor da Currency para saber a cor de fundo e da fonte do display
    // na tela do CoinListItem, testando a partir do value que será passado
    val contentColor = if(change.value < 0.0){
        MaterialTheme.colorScheme.onErrorContainer
    }else{
        Color.Green
    }

    val backgroundColor = if(change.value < 0.0){
        MaterialTheme.colorScheme.errorContainer
    }else{
        greenBackground
    }

    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(100f))
            .background(backgroundColor)
            .padding(horizontal = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(

            // Aqui é o mesmo teste do valor da currency para saber se o ícone deve ser a seta para cima ou para baixo
            imageVector = if(change.value < 0.0){
                Icons.Default.KeyboardArrowDown
            }else{
                Icons.Default.KeyboardArrowUp
            },
            contentDescription = null,
            modifier = Modifier.size(20.dp),
            tint = contentColor

        )
        // Aqui é o valor usando a formatação que defini na classe CoinUi, que é a classe coin mas com os valores corretos
        Text(
            text = "${change.formatted} %",
            color = contentColor,
            fontSize = 14.sp
        )
    }
}


// Teste de Light e dark theme do container do preço acima ou abaixo
@PreviewLightDark
@Composable
private fun PriceChangePreview(){
    CryptoTrackerTheme {
        PriceChange(
            change = DisplayableNumber(
                value = 2.43, formatted = "2.43"
            )
        )
    }
}
