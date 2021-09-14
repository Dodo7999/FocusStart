package ru.focusstart.testtask.ui.render

import androidx.core.view.isVisible
import ru.focusstart.testtask.R
import ru.focusstart.testtask.presentation.state.MainState
import ru.focusstart.testtask.ui.MainActivity

fun MainActivity.renderUiState(state: MainState) {
    when(state){
        MainState.Error -> renderErrorState()
        MainState.Loading -> renderLoadingState()
        MainState.Neutral -> {}
        MainState.Success -> renderSuccessState()
    }
}

private fun MainActivity.renderErrorState(){
    with(binding){
        stateText.isVisible = true
        stateText.setText(R.string.error_loading_currency_list_text)
        refreshButton.isVisible = true
        refreshButton.setText(R.string.refresh_button)
        binding.currencyRecycler.isVisible = false
    }
}

private fun MainActivity.renderLoadingState(){
    with(binding){
        stateText.isVisible = true
        stateText.setText(R.string.loading_currency_list_text)
        refreshButton.isVisible = false
        binding.currencyRecycler.isVisible = false
    }
}

private fun MainActivity.renderSuccessState(){
    with(binding){
        stateText.isVisible = false
        refreshButton.isVisible = false
        binding.currencyRecycler.isVisible = true
    }
}