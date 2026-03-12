package com.hien.myapplication.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import net.objecthunter.exp4j.ExpressionBuilder


data class CalculatorState(
    val expression: String = "",
    val result: String = "",
    val error: String? = null,
    val isDarkMode: Boolean = false
)

object ResultCalculator {
    fun calculate(expression: String): String {
        return try {

            val formatted = expression
                .replace("x", "*")
                .replace("÷", "/")
                .replace("%", "/100")

            val result = ExpressionBuilder(formatted)
                .build()
                .evaluate()

            result.toString()

        } catch (e: Exception) {
            "Error"
        }
    }
}

class CalculatorViewModel : ViewModel() {
    var state by mutableStateOf(CalculatorState())
        private set

    fun onInput(value: String) {

        when (value) {
            "C" -> {
                state = state.copy(expression = "", result = "")
            }

            "del" -> {
                if (state.expression.isNotEmpty()) {
                    state = state.copy(
                        expression = state.expression.dropLast(1)
                    )
                }
            }

            "=" -> {
                val result = ResultCalculator.calculate(state.expression)
                state = state.copy(
                    result = result
                )
            }
            
            "toggle_theme" -> {
                state = state.copy(isDarkMode = !state.isDarkMode)
            }

            else -> {
                state = state.copy(
                    expression = state.expression + value,
                    result = ""
                )
            }
        }
    }
}