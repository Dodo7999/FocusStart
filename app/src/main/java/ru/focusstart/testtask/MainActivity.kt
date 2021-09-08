package ru.focusstart.testtask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.ProgressDialog
import android.util.Log
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create
import ru.focusstart.testtask.databinding.ActivityMainBinding
import ru.focusstart.testtask.dto.CurrencyList


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        val service = RetrofitClientInstance.retrofitInstance?.create(GetValuteService::class.java)
        val call = service?.getValutes()
        call?.enqueue(object : Callback<CurrencyList>{
            override fun onResponse(call: Call<CurrencyList>, response: Response<CurrencyList>) {
                val body = response.body()
                val vatutes = body?.valute
                Log.v("size", vatutes.toString())
            }

            override fun onFailure(call: Call<CurrencyList>, t: Throwable) {
                Toast.makeText(applicationContext, "Error reading JSON", Toast.LENGTH_LONG).show()
            }

        })

    }


}