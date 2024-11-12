package com.plcoding.cryptotracker.core.data.networking

import com.plcoding.cryptotracker.core.domain.util.NetworkError
import io.ktor.client.statement.HttpResponse
import io.ktor.util.network.UnresolvedAddressException

suspend inline fun <reified  T> safeCall(
    execute : () ->HttpResponse
) : Result<T, NetworkError> {
    val response = try{
        execute()
    } catch (e : UnresolvedAddressException){
        return  Result.Error(NetworkError.NO_INTERNET)
    }
}