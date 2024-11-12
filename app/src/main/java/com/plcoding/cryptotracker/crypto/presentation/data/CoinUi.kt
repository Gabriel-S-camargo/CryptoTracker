package com.plcoding.cryptotracker.crypto.presentation.data

import androidx.annotation.DrawableRes
import com.plcoding.cryptotracker.crypto.domain.Coin
import com.plcoding.cryptotracker.core.presentation.util.getDrawableIdForCoin
import java.text.NumberFormat
import java.util.Locale


// Esta é a mesma classe que a Coin, mas ajustada para que seja mais simples de fazer o display na tela do usuário
data class CoinUi(
    val id : String,
    val rank : Int,
    val name : String,
    val symbol : String,
    val priceUsd : DisplayableNumber,
    val marketCapUsd : DisplayableNumber,
    val changePercent24Hr : DisplayableNumber,
    @DrawableRes val iconRes : Int

)

data class DisplayableNumber(
    val value : Double,
    val formatted : String
)

// Conversão de Coin para CoinUi
fun Coin.toCoinUi() : CoinUi{
    return CoinUi(
        id = id,
        name = name,
        symbol = symbol,
        rank = rank,
        priceUsd = priceUsd.toDisplayableNumber(),
        marketCapUsd = marketCapUsd.toDisplayableNumber(),
        changePercent24Hr = changePercent24Hr.toDisplayableNumber(),
        iconRes = getDrawableIdForCoin(symbol)

    )
}


// Função de Tranfosmação de Valor Double para valor correto de exibição
fun Double.toDisplayableNumber() : DisplayableNumber{
    val formatter = NumberFormat.getNumberInstance(Locale.getDefault()).apply {
        minimumFractionDigits = 2
        maximumFractionDigits = 2
    }

    return DisplayableNumber(
        value = this,
        formatted = formatter.format(this)
    )
}

