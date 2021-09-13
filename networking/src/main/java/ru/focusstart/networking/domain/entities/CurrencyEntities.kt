package ru.focusstart.networking.domain.entities

data class CurrencyEntities(
    var id: String,
    var numCode: String,
    var charCode: String,
    var nominal: Int,
    var name: String,
    var valueCurrency: Double,
    var previous: Double
)