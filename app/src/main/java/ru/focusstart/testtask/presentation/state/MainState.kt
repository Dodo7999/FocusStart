package ru.focusstart.testtask.presentation.state

sealed class MainState {
    object Neutral : MainState()
    object Loading : MainState()
    object Success : MainState()
    object Error : MainState()
}