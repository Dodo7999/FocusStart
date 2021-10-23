package ru.focusstart.testtask.uitest.screen

import android.view.View
import com.agoda.kakao.edit.KEditText
import com.agoda.kakao.recycler.KRecyclerItem
import com.agoda.kakao.screen.Screen
import com.agoda.kakao.recycler.KRecyclerView
import com.agoda.kakao.text.KButton
import com.agoda.kakao.text.KTextView
import org.hamcrest.Matcher
import ru.focusstart.testtask.R

object MainScreen : Screen<MainScreen>() {

    val button = KButton { withId(R.id.refresh_button) }

    val currencyList = KRecyclerView(
        builder = { withId(R.id.currency_recycler) },
        itemTypeBuilder = { itemType(::CurrencyItem) }
    )

    class CurrencyItem(parent: Matcher<View>) : KRecyclerItem<CurrencyItem>(parent) {

        val name = KTextView(parent) { withId(R.id.currency_name) }
        val amountOfRubles = KEditText(parent) { withId(R.id.amount_of_rubles) }
        val currencyInputAmount = KEditText(parent) { withId(R.id.currency_input_amount) }
    }
}