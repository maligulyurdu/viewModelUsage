package com.example.viewmodel_fragments

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MathViewModel: ViewModel() {
    private val _number1 = MutableLiveData<Double>()
    val number1: LiveData<Double> get() = _number1
    private val _number2 = MutableLiveData<Double>()
    val number2: LiveData<Double> get() = _number2
    private val _operation = MutableLiveData<String>()
    val operation: LiveData<String> get() = _operation
    private val _result = MutableLiveData<Double>()
    val result: LiveData<Double> get() = _result


    fun calculate(number1:Double,number2:Double,operation:String){
        _number1.value = number1
        _number2.value = number2
        _operation.value = operation
        Log.d("viewmodel","num1: $number1 , op: $operation")
        when(operation){
            "+" -> _result.value = number1 + number2
            "-" -> _result.value = number1 - number2
            "*" -> _result.value = number1 * number2
            "/" -> _result.value = number1 / number2
            else -> _result.value = Double.NaN
        }
        controlData()
    }

    fun controlData(){
        Log.d("kontrol2",_result.value.toString())
        Log.d("kontrol3",result.value.toString())
    }
}

