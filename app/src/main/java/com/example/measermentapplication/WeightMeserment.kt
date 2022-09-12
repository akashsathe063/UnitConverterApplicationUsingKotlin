package com.example.measermentapplication

class WeightMeserment(var number:Double){
    fun gramToKiloGram(number: Double):Double{
        return number / 1000
    }
    fun gramToTonne(number: Double):Double{
        return number / 907185.8188
    }
    fun kilogramTOGram(number: Double):Double{
        return number * 1000
    }
    fun kilogramToTonne(number: Double):Double{
        return number / 1000
    }
    fun tonneToGram(number: Double):Double{
        return number * 907185.8188
    }
    fun tonneToKilogram(number: Double):Double{
        return number * 1000
    }
}