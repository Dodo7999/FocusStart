package ru.focusstart.testtask

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ApiFactory {

    const val BASE_URL = "https://www.cbr-xml-daily.ru/"


    fun retrofit(): Retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(CoroutineCallAdapterFactory())
                    .build()

    val getValuteService: GetValuteService = retrofit().create(GetValuteService::class.java)
}