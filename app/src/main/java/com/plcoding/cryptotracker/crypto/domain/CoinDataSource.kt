package com.plcoding.cryptotracker.crypto.domain

import com.plcoding.cryptotracker.core.domain.util.Result

import com.plcoding.cryptotracker.core.domain.util.NetworkError

interface CoinDataSource {
    suspend fun getCoins(): Result<List<Coin>, NetworkError>
}