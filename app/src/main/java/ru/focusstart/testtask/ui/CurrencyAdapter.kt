package ru.focusstart.testtask.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.recyclerview.widget.RecyclerView
import ru.focusstart.networking.domain.entities.CurrencyEntities
import ru.focusstart.testtask.databinding.RecyclerCurrencyItemBinding
import ru.focusstart.testtask.ui.bind.bindData

class CurrencyAdapter (private val currencyList: List<CurrencyEntities>) :
    RecyclerView.Adapter<CurrencyAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = RecyclerCurrencyItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currencyDto = currencyList[position]
        holder.bindData(currencyDto)
    }

    class ViewHolder(val itemBinding: RecyclerCurrencyItemBinding) : RecyclerView.ViewHolder(itemBinding.root)

    override fun getItemCount(): Int = currencyList.size
}