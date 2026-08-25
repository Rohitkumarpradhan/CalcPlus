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



    fun setOperator(newOperator : String){
        if(state.firstnum == null){
            state = state.copy(
                operator = newOperator,
                firstnum = state.display.toDouble(),
                display = "0"

            )

        }else{
            val  first = state.firstnum

            if(first != null && state.operator != null){
                val secondNum = state.display.toDouble()
                val res = calculate(first , secondNum , state.operator!!)
                if(res != null){
                    state = state.copy(
                        firstnum = res,
                        operator = newOperator,
                        display = "0"
                    )
                }else{
                    state = state.copy(
                        display = "Error",
                        hasError = true
                    )
                }
            }
        }
    }


    fun calculateResult() {

        val first = state.firstnum
        val currentOperator = state.operator

        if (first != null && currentOperator != null) {

            val second = state.display.toDouble()

            val result = calculate(
                first,
                second,
                currentOperator
            )

            if (result != null) {

                state = state.copy(
                    display = formatRes(result),
                    firstnum = null,
                    operator = null
                )

            } else {

                state = state.copy(
                    display = "Error",
                    hasError = true
                )
            }
        }
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

    fun percentage(){
        if(state.display == "0" || state.hasError){
            return
        }else{
            state = state.copy(
                display = (state.display.toDouble()/100).toString()

            )
        }
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