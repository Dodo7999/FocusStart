package ru.focusstart.testtask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.focusstart.testtask.databinding.ActivityMainBinding
import java.util.*
import kotlin.concurrent.timerTask


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: CurrencyViewModel
    private lateinit var currencyList: RecyclerView
    private val TIMER_VALUE = 100000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(CurrencyViewModel::class.java)
        bindMainActivity()
        currencyListFetch()
        setRecyclerViewAdapter()
        setTimer()
    }

    private fun bindMainActivity(){
        binding.includeToolbar.refreshButton.setOnClickListener { viewModel.fetchValute() }
        currencyList = binding.currencyRecycler
        val linear = LinearLayoutManager(this)
        currencyList.layoutManager = linear
        currencyList.hasFixedSize()
    }

    private fun currencyListFetch(){
        if (viewModel.currency.value == null)
            viewModel.fetchValute()
    }

    private fun setTimer(){
        val t = Timer()
        t.schedule(timerTask {
            viewModel.fetchValute()
        }, TIMER_VALUE, TIMER_VALUE)
    }

    private fun setRecyclerViewAdapter(){
        viewModel.currency.observe(this, Observer {
            val adapter = CurrencyAdapter(it)
            currencyList.adapter = adapter
        })
    }
}