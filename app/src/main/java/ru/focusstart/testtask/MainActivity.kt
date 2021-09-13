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
    private lateinit var currencyViewModel: CurrencyViewModel
    private lateinit var currencyList: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bindContent()

        currencyList = binding.currencyRecycler
        val linear = LinearLayoutManager(this)
        currencyList.layoutManager = linear
        currencyList.hasFixedSize()
        currencyViewModel = ViewModelProvider(this).get(CurrencyViewModel::class.java)
        if (currencyViewModel.currency.value == null)
            currencyViewModel.fetchValute()
        /*val t = Timer()
        t.schedule(timerTask {
            Log.v("1", "fetch")
            currencyViewModel.fetchValute()
        }, 0, 1000000)*/
        currencyViewModel.currency.observe(this, Observer {
            val adapter = CurrencyAdapter(it)
            currencyList.adapter = adapter
        })
    }

    fun bindContent(){
        binding.includeToolbar.refreshButton.setOnClickListener { currencyViewModel.fetchValute() }
    }
}