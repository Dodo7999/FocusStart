package ru.focusstart.testtask.dto

import com.google.gson.annotations.SerializedName

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
) {

    fun toListCurrencyDto(): List<CurrencyDto>{
        val currencyList = mutableListOf<CurrencyDto>()
        currencyList.add(aud)
        currencyList.add(azn)
        currencyList.add(gbp)
        currencyList.add(amd)
        currencyList.add(byn)
        currencyList.add(bgn)
        currencyList.add(brl)
        currencyList.add(huf)
        currencyList.add(hkd)
        currencyList.add(dkk)
        currencyList.add(usd)
        currencyList.add(eur)
        currencyList.add(inr)
        currencyList.add(kzt)
        currencyList.add(cad)
        currencyList.add(kgs)
        currencyList.add(cny)
        currencyList.add(mld)
        currencyList.add(nok)
        currencyList.add(pln)
        currencyList.add(ron)
        currencyList.add(xdr)
        currencyList.add(sgd)
        currencyList.add(tjs)
        currencyList.add(try949)
        currencyList.add(tmt)
        currencyList.add(uzs)
        currencyList.add(uah)
        currencyList.add(czk)
        currencyList.add(sek)
        currencyList.add(chf)
        currencyList.add(zar)
        currencyList.add(krw)
        currencyList.add(jyp)
        return currencyList.toList()
    }
}