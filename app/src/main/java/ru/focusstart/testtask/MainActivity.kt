package ru.focusstart.testtask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ru.focusstart.testtask.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var currencyViewModel: CurrencyViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        currencyViewModel = ViewModelProvider(this).get(CurrencyViewModel::class.java)
        currencyViewModel.fetchValute()
        currencyViewModel.currency.observe(this, Observer {
            binding.textView.text = it.toString()
            Log.v("my", it.toString())
        })
    }


}