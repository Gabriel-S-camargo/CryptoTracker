package com.plcoding.cryptotracker.crypto.presentation.coin_list

import androidx.compose.runtime.Immutable
import com.plcoding.cryptotracker.crypto.presentation.data.CoinUi

// Nesta Classe aqui estou criando um estado dois coins que vou puxar via API para poder saber se ja carregou as informações
// além de carregar a lista de moedas da API

@Immutable
data class CoinListState(
    val isLoading : Boolean = false,
    val coins : List<CoinUi> = emptyList(),
    val selectedCoin : CoinUi?= null
)
