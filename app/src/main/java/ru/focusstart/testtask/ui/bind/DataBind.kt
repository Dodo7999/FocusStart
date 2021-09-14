package ru.focusstart.testtask.ui.bind

import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.recyclerview.widget.LinearLayoutManager
import ru.focusstart.networking.domain.entities.CurrencyEntities
import ru.focusstart.testtask.presentation.CurrencyViewModel
import ru.focusstart.testtask.ui.CurrencyAdapter
import ru.focusstart.testtask.ui.MainActivity

fun MainActivity.bindData(viewModel: CurrencyViewModel) {
    bindButton(viewModel)
    bindRecyclerView()
    bindUiState(viewModel.state)
}

private fun MainActivity.bindButton(viewModel: CurrencyViewModel){
    binding.includeToolbar.updateCurrencyButton.setOnClickListener {
        viewModel.fetchValute()
    }
    binding.refreshButton.setOnClickListener {
        viewModel.fetchValute()
    }
}

private fun MainActivity.bindRecyclerView(){
    currencyList = binding.currencyRecycler
    val linear = LinearLayoutManager(this)
    currencyList.layoutManager = linear
    currencyList.hasFixedSize()
}

fun CurrencyAdapter.ViewHolder.bindData(currencyEntities: CurrencyEntities){
    bindText(currencyEntities)
    bindEditText(currencyEntities)
}

private fun CurrencyAdapter.ViewHolder.bindText(currencyEntities: CurrencyEntities){
    with(itemBinding) {
        currencyName.text = currencyEntities.name
        currencyTextAmount.text = currencyEntities.name
    }
}

private fun CurrencyAdapter.ViewHolder.bindEditText(currencyEntities: CurrencyEntities){
    with(itemBinding) {
        amountOfRubles.setText(currencyEntities.valueCurrency.toString())
        currencyInputAmount.setText(currencyEntities.nominal.toString())
        amountOfRubles.doAfterTextChanged {
            if (it.toString() != "") {
                val rub = it.toString().toDouble() / currencyEntities.valueCurrency
                currencyInputAmount.setText(rub.toString())
            } else {
                amountOfRubles.setText("0")
            }
        }
    }
}