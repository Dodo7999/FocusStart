package ru.focusstart.testtask.dto

import com.google.gson.annotations.SerializedName

data class CurrencyDto(
    @SerializedName("ID") var id: String,
    @SerializedName("NumCode") var numCode: String,
    @SerializedName("CharCode") var charCode: String,
    @SerializedName("Nominal") var nominal: Int,
    @SerializedName("Name") var name: String,
    @SerializedName("Value") var valueCurrency: Double,
    @SerializedName("Previous") var previous: Double
) {
}