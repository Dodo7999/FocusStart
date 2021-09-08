package ru.focusstart.testtask

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClientInstance {

    var retrofit: Retrofit? = null
    const val BASE_URL = "https://www.cbr-xml-daily.ru/"


    val retrofitInstance: Retrofit?
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build()
            }

            return retrofit
        }
}