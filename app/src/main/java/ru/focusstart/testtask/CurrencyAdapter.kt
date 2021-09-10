package ru.focusstart.testtask

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.widget.doAfterTextChanged
import androidx.recyclerview.widget.RecyclerView
import ru.focusstart.testtask.databinding.RecyclerCurrencyItemBinding
import ru.focusstart.testtask.dto.CurrencyDto

class CurrencyAdapter (private val currencyList: List<CurrencyDto>) :
    RecyclerView.Adapter<CurrencyAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = RecyclerCurrencyItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(itemBinding)
    }

    class ViewHolder(private val itemBinding: RecyclerCurrencyItemBinding) : RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(currencyDto: CurrencyDto){
            itemBinding.currencyName.text = currencyDto.name
            itemBinding.currencyTextAmount.text = currencyDto.name
            itemBinding.amountOfRubles.setText(currencyDto.valueCurrency.toString())
            itemBinding.currencyInputAmount.setText((currencyDto.valueCurrency / currencyDto.valueCurrency).toString())
            itemBinding.amountOfRubles.doAfterTextChanged {
                val rub = it.toString().toDouble() / currencyDto.valueCurrency
                itemBinding.currencyInputAmount.setText(rub.toString())
            }
        }
    }

    override fun getItemCount(): Int = currencyList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currencyDto = currencyList[position]
        holder.bind(currencyDto)
    }
}