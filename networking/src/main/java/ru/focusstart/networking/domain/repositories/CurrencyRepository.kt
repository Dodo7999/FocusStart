package ru.focusstart.networking.domain.repositories

import ru.focusstart.networking.data.api.CurrencyApi
import ru.focusstart.networking.common.BaseRepository
import ru.focusstart.networking.domain.entities.CurrencyEntities
import ru.focusstart.networking.domain.mapper.toListCurrencyEntities

class CurrencyRepository(private val api: CurrencyApi): BaseRepository() {

    suspend fun getCurrency(): List<CurrencyEntities>? {
        val currencyResponse = safeApiCall(
            call = {api.getCurrencyAsync().await()},
            errorMessage = "Error Fetching Currency"
        )

        return currencyResponse?.valute?.toListCurrencyEntities()
    }
}