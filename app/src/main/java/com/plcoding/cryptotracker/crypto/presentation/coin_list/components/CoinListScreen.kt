package com.plcoding.cryptotracker.crypto.presentation.coin_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.plcoding.cryptotracker.crypto.presentation.coin_list.CoinListState
import com.plcoding.cryptotracker.ui.theme.CryptoTrackerTheme

@Composable
fun CoinListScreen(
    state : CoinListState,
    modifier: Modifier = Modifier
) {

   // Aqui vou testar o Fetch da API de Crypto, se ainda estiver dando fetch nas informações será feito o display do símbolo
    // de carregamento
    if(state.isLoading){
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            CircularProgressIndicator()
        }
    }else{
        // Caso ja tenha carregado irei fazer o display das informações das moedas carregadas
        LazyColumn (
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ){
            // aqui estou puxando um for each das moedas encontras e usando para cada uma a função CoinListItem para exibir
            // suas informações
            items(state.coins){ coinUi ->
                CoinListItem(
                    coinUi = coinUi,
                    onClick = {/*TODO*/},
                    modifier = Modifier.fillMaxWidth()

                )
                HorizontalDivider()
            }
        }
    }
}


// Teste com Light e Dark Theme da Lista de Moedas

@PreviewLightDark
@Composable
fun CoinListScreenPreview(){
    CryptoTrackerTheme {
        CoinListScreen(
            state = CoinListState(
                coins = (1 .. 100).map{
                    previewCoin.copy(id = it.toString())
                }
            ),
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
        )
    }
}










