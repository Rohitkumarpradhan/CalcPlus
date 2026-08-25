package com.example.calcplus.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.calcplus.logic.CalculatorState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.calcplus.logic.calculate
import com.example.calcplus.logic.formatRes


class CalculatorViewModel : ViewModel(){
    var state by mutableStateOf(CalculatorState())

    fun addNum(number: String) {

        if(state.hasError){
          state = state.copy(
              display = number,
              hasError = false
          )
        }else if (state.display == "0"){
            state = state.copy(
                display = number

            )
        }else{
            state = state.copy(

                display = state.display +number

            )
        }
    }


    fun allclear(){
        state = CalculatorState()

    }



    fun setOperator(newOperator: String) {

        if (state.hasError) return

        val currentExpression = state.expression

        state = if (currentExpression.isEmpty()) {
            state.copy(
                expression = state.display + " " + newOperator + " ",
                display = "0"
            )
        } else {
            state.copy(
                expression = currentExpression + state.display + " " + newOperator + " ",
                display = "0"
            )
        }
    }


    fun calculateResult() {

        if (state.hasError) return

        var expression = state.expression + state.display

        expression = expression.trim()

        val parts = expression.split(" ")

        if (parts.size < 3) return

        val numbers = mutableListOf<Double>()
        val operators = mutableListOf<String>()

        numbers.add(parts[0].toDouble())

        var i = 1

        while (i < parts.size) {
            operators.add(parts[i])
            numbers.add(parts[i + 1].toDouble())
            i += 2
        }

        // First: × and ÷
        var index = 0

        while (index < operators.size) {

            if (operators[index] == "x" || operators[index] == "/") {

                val first = numbers[index]
                val second = numbers[index + 1]

                val result = if (operators[index] == "x") {
                    first * second
                } else {
                    if (second == 0.0) {
                        state = state.copy(
                            display = "Error",
                            hasError = true
                        )
                        return
                    }

                    first / second
                }

                numbers[index] = result
                numbers.removeAt(index + 1)
                operators.removeAt(index)

            } else {
                index++
            }
        }

        // Then: + and -
        var result = numbers[0]

        for (j in operators.indices) {

            when (operators[j]) {

                "+" -> {
                    result += numbers[j + 1]
                }

                "-" -> {
                    result -= numbers[j + 1]
                }
            }
        }

        state = state.copy(
            display = formatRes(result),
            expression = "",
            firstnum = null,
            operator = null
        )
    }


    fun addDecimal() {
        if (state.hasError) {
            return
        }

        if (!state.display.contains(".")) {
            state = state.copy(
                display = state.display + "."
            )
        }
    }

    fun deleteLast() {
        if (state.hasError) {
            state = CalculatorState()
            return
        }

        if (state.display.length > 1) {
            state = state.copy(
                display = state.display.dropLast(1)
            )
        } else {
            state = state.copy(
                display = "0"
            )
        }
    }

    fun percentage() {

        if (state.hasError) return

        val current = state.display.toDouble()

        // If we already have an expression like "12 - "
        if (state.expression.isNotEmpty()) {

            val parts = state.expression.trim().split(" ")

            if (parts.size >= 2) {

                val first = parts[0].toDouble()
                val operator = parts[1]

                val percentageValue = when (operator) {
                    "+", "-" -> first * current / 100
                    "x", "/" -> current / 100
                    else -> current / 100
                }

                state = state.copy(
                    display = formatRes(percentageValue)
                )

                return
            }
        }

        // Normal standalone percentage
        state = state.copy(
            display = formatRes(current / 100)
        )
    }

    fun toggleSign(){
        if(state.display == "0" || state.hasError){
            return
        }else{
            val value = state.display.toDouble()
                state = state.copy(
                    display = formatRes(-value)

                )

        }
    }


}