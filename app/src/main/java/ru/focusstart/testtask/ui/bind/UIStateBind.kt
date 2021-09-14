package ru.focusstart.testtask.ui.bind

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import ru.focusstart.testtask.presentation.state.MainState
import ru.focusstart.testtask.ui.MainActivity
import ru.focusstart.testtask.ui.render.renderUiState
import androidx.lifecycle.lifecycleScope

fun MainActivity.bindUiState(state: Flow<MainState>) {
    state.onEach(::renderUiState).launchIn(lifecycleScope)
}