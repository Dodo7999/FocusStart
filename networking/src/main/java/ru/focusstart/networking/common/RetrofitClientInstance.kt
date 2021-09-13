package ru.focusstart.networking.data.repository

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.focusstart.networking.data.api.CurrencyApi

object ApiFactory {

    private const val BASE_URL = "https://www.cbr-xml-daily.ru/"


    private fun retrofit(): Retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(CoroutineCallAdapterFactory())
                    .build()

    val getCurrencyApi: CurrencyApi = retrofit().create(CurrencyApi::class.java)
}