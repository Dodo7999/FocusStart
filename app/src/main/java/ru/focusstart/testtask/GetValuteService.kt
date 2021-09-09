package ru.focusstart.testtask

import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import ru.focusstart.testtask.dto.CurrencyList
import ru.focusstart.testtask.dto.ValuteDto

interface GetValuteService {

    @GET("/daily_json.js")
    fun getValutes(): Deferred<Response<CurrencyList>>
}