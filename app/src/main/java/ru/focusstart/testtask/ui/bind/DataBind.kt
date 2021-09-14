package ru.focusstart.testtask.ui.bind

import androidx.lifecycle.LifecycleCoroutineScope
import androidx.recyclerview.widget.LinearLayoutManager
import ru.focusstart.testtask.presentation.CurrencyViewModel
import ru.focusstart.testtask.ui.MainActivity

fun MainActivity.bindData(scope: LifecycleCoroutineScope, viewModel: CurrencyViewModel) {
    bindButton(viewModel)
    bindRecyclerView()
    bindUiState(viewModel.state)
}

private fun MainActivity.bindButton(viewModel: CurrencyViewModel){
    binding.includeToolbar.refreshButton.setOnClickListener {
        viewModel.fetchValute()
    }
}

private fun MainActivity.bindRecyclerView(){
    currencyList = binding.currencyRecycler
    val linear = LinearLayoutManager(this)
    currencyList.layoutManager = linear
    currencyList.hasFixedSize()
}