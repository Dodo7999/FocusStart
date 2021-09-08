package ru.focusstart.testtask.dto

import com.google.gson.annotations.SerializedName

class CurrencyDto(
    @SerializedName("ID") var id: Int,
    @SerializedName("NumCode") var numCode: Int,
    @SerializedName("CharCode") var charCode: String,
    @SerializedName("Nominal") var nominal: Int,
    @SerializedName("Name") var name: String,
    @SerializedName("Value") var valueCurrency: Double,
    @SerializedName("Previous") var previous: Double
) {
}