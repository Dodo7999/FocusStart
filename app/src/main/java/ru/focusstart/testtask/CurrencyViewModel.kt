package ru.focusstart.testtask

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import ru.focusstart.testtask.dto.CurrencyDto
import ru.focusstart.testtask.dto.ValuteDto
import kotlin.coroutines.CoroutineContext

class CurrencyViewModel: ViewModel() {

    private val parentJob = Job()

    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Default

    private val scope = CoroutineScope(coroutineContext)

    private val repository: CurrencyRepository = CurrencyRepository(ApiFactory.getValuteService)

    val currency = MutableLiveData<List<CurrencyDto>>()

    fun fetchValute(){
        Log.v("fetch","No")
        scope.launch {
            val valutes = repository.getCurrency()
                currency.postValue(valutes?.toListCurrencyDto())
        }
    }

    fun cancelAllRequests() = coroutineContext.cancel()

}