package ru.focusstart.networking.domain.mapper

import ru.focusstart.networking.data.dto.CurrencyDto
import ru.focusstart.networking.data.dto.ValuteDto
import ru.focusstart.networking.domain.entities.CurrencyEntities

fun CurrencyDto.toEntities(): CurrencyEntities =
    CurrencyEntities(
        id = id,
        numCode = numCode,
        charCode = charCode,
        nominal = nominal,
        name = name,
        valueCurrency = valueCurrency,
        previous = previous
    )

fun ValuteDto.toListCurrencyEntities(): List<CurrencyEntities>{
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
    return currencyList.map { it.toEntities() }.toList()
}
