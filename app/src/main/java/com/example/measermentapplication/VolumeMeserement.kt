package com.example.measermentapplication

class VolumeMeserement(var number:Double){
    fun millilitterToLitter(number: Double):Double{
        return number / 1000
    }
    fun millilitterToGallon(number: Double):Double{
        return number / 3785.41178
    }
    fun  litterTOMilliLitter(number: Double):Double{
        return number * 1000
    }
    fun litterToGallon(number: Double):Double{
        return number / 3.78541178
    }
    fun gallonTOMillitter(number: Double):Double{
        return number * 3785.41178
    }
    fun gallonToLitter(number: Double):Double{
        return number * 3.78541178
    }
}