package ru.focusstart.testtask

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.recyclerview.widget.RecyclerView
import ru.focusstart.networking.domain.entities.CurrencyEntities
import ru.focusstart.testtask.databinding.RecyclerCurrencyItemBinding

class CurrencyAdapter (private val currencyList: List<CurrencyEntities>) :
    RecyclerView.Adapter<CurrencyAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = RecyclerCurrencyItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(itemBinding)
    }

    class ViewHolder(private val itemBinding: RecyclerCurrencyItemBinding) : RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(currencyEntities: CurrencyEntities){
            itemBinding.currencyName.text = currencyEntities.name
            itemBinding.currencyTextAmount.text = currencyEntities.name
            itemBinding.amountOfRubles.setText(currencyEntities.valueCurrency.toString())
            itemBinding.currencyInputAmount.setText((currencyEntities.valueCurrency / currencyEntities.valueCurrency).toString())
            itemBinding.amountOfRubles.doAfterTextChanged {
                val rub = it.toString().toDouble() / currencyEntities.valueCurrency
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