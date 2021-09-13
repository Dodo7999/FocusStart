package ru.focusstart.networking.data.api

import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import ru.focusstart.networking.data.dto.CurrencyList

interface CurrencyApi {

    @GET("/daily_json.js")
    suspend fun getCurrencyAsync(): Deferred<Response<CurrencyList>>
}