package ru.focusstart.testtask

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import ru.focusstart.networking.domain.entities.CurrencyEntities
import ru.focusstart.networking.domain.repositories.CurrencyRepository
import ru.focusstart.networking.domain.usecases.getRepositoryUseCase
import kotlin.coroutines.CoroutineContext

class CurrencyViewModel: ViewModel() {

    private val parentJob = Job()

    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Default

    private val scope = CoroutineScope(coroutineContext)

    private val repository: CurrencyRepository = getRepositoryUseCase()

    val currency = MutableLiveData<List<CurrencyEntities>>()

    fun fetchValute(){
        scope.launch {
            val valutes = repository.getCurrency()
                currency.postValue(valutes)
        }
    }

    fun cancelAllRequests() = coroutineContext.cancel()

}