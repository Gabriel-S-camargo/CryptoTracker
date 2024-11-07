package com.plcoding.cryptotracker.crypto.domain


// Aqui vai ser a classe Base de uma Crypto que será utilizada
data class Coin(
    val id: String,
    val rank : Int,
    val name : String,
    val symbol : String,
    val marketCapUsd : Double,
    val priceUsd : Double,
    val changePercent24Hr : Double
)
