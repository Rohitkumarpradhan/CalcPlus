package com.example.calcplus.logic

import android.view.Display


data class CalculatorState(
    val display: String = "0",
    val firstnum : Double ?= null,
    val hasError: Boolean = false,
    val operator: String ?= null,

)
fun calculate(
    first: Double,
    second: Double,
    operator: String
): Double? {

    return when (operator) {
        "+" -> first + second
        "-" -> first - second
        "x" -> first * second
        "/" -> {
            if (second != 0.0) {
                first / second
            } else {
                null
            }
        }
        else -> null
    }
}


fun formatRes(result : Double) : String {
    if(result % 1 == 0.0){
        return result.toInt().toString()
    }else{
        return result.toString()
    }
}

