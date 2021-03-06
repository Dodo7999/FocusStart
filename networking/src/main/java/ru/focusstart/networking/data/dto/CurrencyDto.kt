package ru.focusstart.networking.data.dto

import com.google.gson.annotations.SerializedName

data class CurrencyList(
    @SerializedName("Valute") var valute: ValuteDto
)

data class ValuteDto(
    @SerializedName("AUD") var aud: CurrencyDto,
    @SerializedName("AZN") var azn: CurrencyDto,
    @SerializedName("GBP") var gbp: CurrencyDto,
    @SerializedName("AMD") var amd: CurrencyDto,
    @SerializedName("BYN") var byn: CurrencyDto,
    @SerializedName("BGN") var bgn: CurrencyDto,
    @SerializedName("BRL") var brl: CurrencyDto,
    @SerializedName("HUF") var huf: CurrencyDto,
    @SerializedName("HKD") var hkd: CurrencyDto,
    @SerializedName("DKK") var dkk: CurrencyDto,
    @SerializedName("USD") var usd: CurrencyDto,
    @SerializedName("EUR") var eur: CurrencyDto,
    @SerializedName("INR") var inr: CurrencyDto,
    @SerializedName("KZT") var kzt: CurrencyDto,
    @SerializedName("CAD") var cad: CurrencyDto,
    @SerializedName("KGS") var kgs: CurrencyDto,
    @SerializedName("CNY") var cny: CurrencyDto,
    @SerializedName("MDL") var mld: CurrencyDto,
    @SerializedName("NOK") var nok: CurrencyDto,
    @SerializedName("PLN") var pln: CurrencyDto,
    @SerializedName("RON") var ron: CurrencyDto,
    @SerializedName("XDR") var xdr: CurrencyDto,
    @SerializedName("SGD") var sgd: CurrencyDto,
    @SerializedName("TJS") var tjs: CurrencyDto,
    @SerializedName("TRY") var try949: CurrencyDto,
    @SerializedName("TMT") var tmt: CurrencyDto,
    @SerializedName("UZS") var uzs: CurrencyDto,
    @SerializedName("UAH") var uah: CurrencyDto,
    @SerializedName("CZK") var czk: CurrencyDto,
    @SerializedName("SEK") var sek: CurrencyDto,
    @SerializedName("CHF") var chf: CurrencyDto,
    @SerializedName("ZAR") var zar: CurrencyDto,
    @SerializedName("KRW") var krw: CurrencyDto,
    @SerializedName("JPY") var jyp: CurrencyDto,
)

data class CurrencyDto(
    @SerializedName("ID") var id: String,
    @SerializedName("NumCode") var numCode: String,
    @SerializedName("CharCode") var charCode: String,
    @SerializedName("Nominal") var nominal: Int,
    @SerializedName("Name") var name: String,
    @SerializedName("Value") var valueCurrency: Double,
    @SerializedName("Previous") var previous: Double
)