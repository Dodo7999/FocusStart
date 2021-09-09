package ru.focusstart.testtask

import ru.focusstart.testtask.dto.ValuteDto

class CurrencyRepository(private val api: GetValuteService): BaseRepository() {

    suspend fun getCurrency(): ValuteDto?{
        val currencyResponse = safeApiCall(
            call = {api.getValutes().await()},
            errorMessage = "Error Fetching Currency"
        )

        return currencyResponse?.valute
    }
}