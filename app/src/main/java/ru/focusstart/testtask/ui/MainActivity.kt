package ru.focusstart.testtask.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ru.focusstart.testtask.databinding.ActivityMainBinding
import ru.focusstart.testtask.presentation.CurrencyViewModel
import ru.focusstart.testtask.presentation.state.MainState
import ru.focusstart.testtask.ui.bind.bindData
import java.util.*
import kotlin.concurrent.timerTask


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: CurrencyViewModel
    lateinit var currencyList: RecyclerView
    private val TIMER_VALUE = 100000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(CurrencyViewModel::class.java)
        bindData(viewModel)
        currencyListFetch()
        setRecyclerViewAdapter()
        setTimer()
    }

    private fun currencyListFetch() {
        if (viewModel.currency.value.isEmpty())
            viewModel.fetchValute()
    }

    private fun setTimer() {
        val t = Timer()
        t.schedule(timerTask {
            viewModel.fetchValute()
        }, TIMER_VALUE, TIMER_VALUE)
    }

    private fun setRecyclerViewAdapter() {
        lifecycleScope.launchWhenCreated {
            viewModel.state.collect {
                if (it is MainState.Success) {
                    val adapter = CurrencyAdapter(viewModel.currency.value)
                    currencyList.adapter = adapter
                }
            }
        }
    }
}