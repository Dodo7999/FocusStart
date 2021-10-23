package ru.focusstart.testtask.uitest

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ru.focusstart.testtask.ui.MainActivity
import ru.focusstart.testtask.uitest.annotation.TestCase
import ru.focusstart.testtask.uitest.screen.MainScreen

@RunWith(AndroidJUnit4::class)
class CurrencyTest : KTestCase() {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    @TestCase(name = "Test-1", description = "Check currency content")
    fun checkCurrencyContent(){
        run {
            step("Check currency content") {
                checkCurrency(
                    CurrencyItem(name = "Австралийский доллар", amountOfRubles = "53.196"),
                    CurrencyItem(name = "Фзербайджанский манат", amountOfRubles = "41.7082"),
                    CurrencyItem(name = "Фунт стерлингов Соединенного королевства", amountOfRubles = "97.6482"),
                    CurrencyItem(name = "Армянских драмов", amountOfRubles = "14.8372"),
                    CurrencyItem(name = "Белорусский рубль", amountOfRubles = "29.1903")
                )
            }
        }
    }

    class CurrencyItem(
        val name: String,
        val amountOfRubles: String,
        val currencyInputAmount: String = ""
    )

    private fun checkCurrency(vararg currencies: CurrencyItem){
        currencies.forEachIndexed { index, currencyItem ->
            MainScreen {
                currencyList {
                    childAt<MainScreen.CurrencyItem>(index) {
                        name {
                            isDisabled()
                            hasText(currencyItem.name)
                        }
                        amountOfRubles{
                            isDisabled()
                            hasText(currencyItem.amountOfRubles)
                        }
                    }
                }
            }
        }
    }
}