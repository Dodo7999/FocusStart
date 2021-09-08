package ru.focusstart.testtask

import retrofit2.Call
import retrofit2.http.GET
import ru.focusstart.testtask.dto.CurrencyList

interface GetValuteService {

    @GET("/daily_json.js")
    fun getValutes(): Call<CurrencyList>
}