package ru.focusstart.networking.domain.usecases

import ru.focusstart.networking.common.ApiFactory
import ru.focusstart.networking.domain.repositories.CurrencyRepository

fun getRepositoryUseCase(): CurrencyRepository = CurrencyRepository(ApiFactory.getCurrencyApi)