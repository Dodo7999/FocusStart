package ru.focusstart.testtask.dto

import com.google.gson.annotations.SerializedName

data class CurrencyList(
    @SerializedName("Valute") var valute : String
)
