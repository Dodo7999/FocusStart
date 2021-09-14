package ru.focusstart.testtask.ui.render

import androidx.core.view.isVisible
import ru.focusstart.testtask.presentation.state.MainState
import ru.focusstart.testtask.ui.MainActivity

fun MainActivity.renderUiState(state: MainState) {
    binding.textView.isVisible = state is MainState.Loading
    binding.currencyRecycler.isVisible = state is MainState.Success
}