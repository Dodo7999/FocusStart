package ru.focusstart.testtask.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import ru.focusstart.networking.domain.entities.CurrencyEntities
import ru.focusstart.networking.domain.repositories.CurrencyRepository
import ru.focusstart.networking.domain.usecases.getRepositoryUseCase
import ru.focusstart.testtask.presentation.state.MainState
import kotlin.coroutines.CoroutineContext

class CurrencyViewModel : ViewModel() {

    private val parentJob = Job()

    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Default

    private val scope = CoroutineScope(coroutineContext)

    private val repository: CurrencyRepository = getRepositoryUseCase()

    private val _uiState = MutableStateFlow<MainState>(MainState.Neutral)
    val state: Flow<MainState>
        get() = _uiState

    val currency = MutableStateFlow<List<CurrencyEntities>>(emptyList())

    private val handler = CoroutineExceptionHandler { _, _ ->
        _uiState.value = MainState.Error
    }

    fun fetchCurrency() {
        scope.launch(handler) {
            _uiState.value = MainState.Loading
            val newCurrency = repository.getCurrency()
            currency.value =
                newCurrency ?: throw IllegalArgumentException("Currency is not be null")
            _uiState.value = MainState.Success
        }
    }

    fun cancelAllRequests() = coroutineContext.cancel()

}