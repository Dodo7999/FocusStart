package ru.focusstart.testtask.uitest

import android.util.Log
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
                    CurrencyItem(name = "Австралийский доллар", amountOfRubles = "53.1396"),
                    CurrencyItem(name = "Азербайджанский манат", amountOfRubles = "41.7082"),
                    CurrencyItem(name = "Фунт стерлингов Соединенного королевства", amountOfRubles = "97.6482"),
                    CurrencyItem(name = "Армянских драмов", amountOfRubles = "14.8372"),
                )
            }
            step( "Check currency transform"){
                MainScreen{
                    currencyList{
                        childAt<MainScreen.CurrencyItem>(0){
                            amountOfRubles{
                                clearText()
                                typeText("1000")
                            }
                            currencyInputAmount{
                                hasText("18.818357684288177")
                            }
                        }
                    }
                }
            }
        }
    }

    class CurrencyItem(
        val name: String,
        val amountOfRubles: String
    )

    private fun checkCurrency(vararg currencies: CurrencyItem){
        currencies.forEachIndexed { index, currencyItem ->
            Log.i("Test", "$index")
            MainScreen {
                currencyList {
                    childAt<MainScreen.CurrencyItem>(index) {
                        name {
                            isDisplayed()
                            hasText(currencyItem.name)
                        }
                        amountOfRubles{
                            isDisplayed()
                            hasText(currencyItem.amountOfRubles)
                        }
                    }
                }
            }
        }
    }
}