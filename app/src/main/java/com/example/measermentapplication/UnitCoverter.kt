package com.example.measermentapplication

class LengthMeserment(var number: Double) {


    fun centimeterTOmeter(number: Double): Double {
        return number / 100
    }

    fun centimeterToKiloMeter(number:Double):Double{
        return  number / 100000
    }

    fun meterTOCentimeter(number: Double):Double{
        return number * 100
    }

    fun meterToKilometer(number: Double):Double{
        return  number / 1000
    }

    fun kiloMeterToCentimeter(number: Double):Double{
        return number * 100000
    }

    fun KiloMeterToMeter(number: Double):Double{
        return number * 1000
    }
}


