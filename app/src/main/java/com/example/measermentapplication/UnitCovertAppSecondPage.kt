package com.example.measermentapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.measermentapplication.databinding.ActivityMainBinding
import com.example.measermentapplication.databinding.ActivityUnitCovertAppSecondPageBinding
import java.util.*

class UnitCovertAppSecondPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_unit_covert_app_second_page)

        val secondPageBinding = ActivityUnitCovertAppSecondPageBinding.inflate(layoutInflater)
        setContentView(secondPageBinding.root)
        val secondPageArrayListParent = arrayListOf<String>("Length", "Weight", "Volume")
        val arrayAdapterParent =
            ArrayAdapter(applicationContext, R.layout.textview_blue, secondPageArrayListParent)
        secondPageBinding.parantSpinner.adapter = arrayAdapterParent

        val secondPageArrayListLengthMeaserment =
            arrayListOf<String>("Centimeter", "Meter", "Kilometer")
        val secondPageArrayListWeigthMeserment = arrayListOf<String>("Kilogram", "Gram", "Tonne")
        val secondPageArrayListVolumeMeserment =
            arrayListOf<String>("Gallon", "Litre", "MilliLitre")

        val arrayAdapterChild =
            ArrayAdapter(
                applicationContext,
                R.layout.textview_red,
                secondPageArrayListLengthMeaserment
            )
        secondPageBinding.firstChildspinner.adapter = arrayAdapterChild
        secondPageBinding.SecondChildSpinner.adapter = arrayAdapterChild
        secondPageBinding.thirdChildSpinner.adapter = arrayAdapterChild
        secondPageBinding.parantSpinner.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    p0: AdapterView<*>?,
                    p1: View?,
                    position: Int,
                    p3: Long
                ) {
                    when (position) {
                        0 -> {
                            val arrayAdapterChild = ArrayAdapter(
                                applicationContext,
                                R.layout.textview_red,
                                secondPageArrayListLengthMeaserment
                            )
                            secondPageBinding.firstChildspinner.adapter = arrayAdapterChild
                            secondPageBinding.SecondChildSpinner.adapter = arrayAdapterChild
                            secondPageBinding.thirdChildSpinner.adapter = arrayAdapterChild

                        }
                        1 -> {
                            val arrayAdapterChild = ArrayAdapter(
                                applicationContext,
                                R.layout.textview_red,
                                secondPageArrayListWeigthMeserment
                            )
                            secondPageBinding.firstChildspinner.adapter = arrayAdapterChild
                            secondPageBinding.SecondChildSpinner.adapter = arrayAdapterChild
                            secondPageBinding.thirdChildSpinner.adapter = arrayAdapterChild
                        }
                        2 -> {
                            val arrayAdapterChild = ArrayAdapter(
                                applicationContext,
                                R.layout.textview_red,
                                secondPageArrayListVolumeMeserment
                            )
                            secondPageBinding.firstChildspinner.adapter = arrayAdapterChild
                            secondPageBinding.SecondChildSpinner.adapter = arrayAdapterChild
                            secondPageBinding.thirdChildSpinner.adapter = arrayAdapterChild
                        }
                    }

                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }
        secondPageBinding.btnCalculate.setOnClickListener {
            var firstInputValue = secondPageBinding.editTextFirst.text.toString()
            var secondInputValue = secondPageBinding.editTextSecond.text.toString()
            var result = secondPageBinding.outputTextView
            var secondPageMainSpinnerSelectedItem =
                secondPageBinding.parantSpinner.selectedItem.toString()
            var secondPageFirstChildSpinnerSelectedItem =
                secondPageBinding.firstChildspinner.selectedItem.toString()
            var secondPageSecondChildSpinnerSelectedItem =
                secondPageBinding.SecondChildSpinner.selectedItem.toString()
            var secondPageThirdChildSpinnerSelectedItem =
                secondPageBinding.thirdChildSpinner.selectedItem.toString()
            if (firstInputValue.isEmpty() || secondInputValue.isEmpty()) {
                result.text = "0.0"
            } else {
                when (secondPageMainSpinnerSelectedItem) {
                    "Length" -> {
                        when (secondPageFirstChildSpinnerSelectedItem) {
                            "Centimeter" -> {
                                when (secondPageSecondChildSpinnerSelectedItem) {
                                    "Centimeter" -> {
                                        var output: Double =
                                            (firstInputValue.toDouble() + secondInputValue.toDouble())
                                        when (secondPageThirdChildSpinnerSelectedItem) {
                                            "Meter" -> {
                                                var secondPageLengthMeserment =
                                                    LengthMeserment(output)
                                                result.text =
                                                    " ${
                                                        secondPageLengthMeserment.centimeterTOmeter(
                                                            output
                                                        )
                                                    }"
                                            }
                                            "Kilometer" -> {
                                                var secondPageLengthMeserment =
                                                    LengthMeserment(output)
                                                result.text =
                                                    " ${
                                                        secondPageLengthMeserment.centimeterToKiloMeter(
                                                            output
                                                        )
                                                    }"
                                            }
                                        }
                                    }
                                    "Meter" -> {
                                        var secondPageLengthMeserment =
                                            LengthMeserment(secondInputValue.toDouble())
                                        var output =
                                            (firstInputValue.toDouble() + secondPageLengthMeserment.centimeterTOmeter(
                                                secondInputValue.toDouble()
                                            ))
                                        when (secondPageThirdChildSpinnerSelectedItem) {
                                            "Centimeter" -> {
                                                var secondPageLengthMeserment =
                                                    LengthMeserment(output)
                                                result.text = "${
                                                    secondPageLengthMeserment.meterTOCentimeter(
                                                        output
                                                    )
                                                }"
                                            }
                                            "Kilometer" -> {
                                                var secondPageLengthMeserment =
                                                    LengthMeserment(output)
                                                result.text = "${
                                                    secondPageLengthMeserment.meterToKilometer(
                                                        output
                                                    )
                                                }"
                                            }
                                            "Meter" -> {
                                                var secondPageLengthMeserment =
                                                    LengthMeserment(output)
                                                result.text = "${
                                                    secondPageLengthMeserment.centimeterTOmeter(
                                                        output
                                                    )
                                                }"
                                            }
                                        }
                                    }
                                    "Kilometer" -> {
                                        var secondPageLengthMeserment =
                                            LengthMeserment(secondInputValue.toDouble())
                                        var output =
                                            (firstInputValue.toDouble() + secondPageLengthMeserment.centimeterToKiloMeter(
                                                secondInputValue.toDouble()
                                            ))
                                        when (secondPageThirdChildSpinnerSelectedItem) {
                                            "Centimeter" -> {
                                                var secondPageLengthMeserment =
                                                    LengthMeserment(output)
                                                result.text = "${
                                                    secondPageLengthMeserment.kiloMeterToCentimeter(
                                                        output
                                                    )
                                                }"
                                            }
                                            "Meter" -> {
                                                var secondPageLengthMeserment =
                                                    LengthMeserment(output)
                                                result.text = "${
                                                    secondPageLengthMeserment.KiloMeterToMeter(
                                                        output
                                                    )
                                                }"
                                            }
                                            "Kilometer" -> {
                                                var secondPageLengthMeserment =
                                                    LengthMeserment(output)
                                                result.text = "${
                                                    secondPageLengthMeserment.centimeterToKiloMeter(
                                                        output
                                                    )
                                                }"
                                            }
                                        }
                                    }
                                }
                            }
                            "Meter" -> {
                                when (secondPageSecondChildSpinnerSelectedItem) {
                                    "Centimeter" -> {
                                        var secondPageLengthMeserment =
                                            LengthMeserment(secondInputValue.toDouble())
                                        var output =
                                            (firstInputValue.toDouble() + secondPageLengthMeserment.centimeterTOmeter(
                                                secondInputValue.toDouble()
                                            ))
                                        when (secondPageThirdChildSpinnerSelectedItem) {
                                            "Centimeter" -> {
                                                var secondPageLengthMeserment =
                                                    LengthMeserment(output)
                                                result.text = "${
                                                    secondPageLengthMeserment.meterTOCentimeter(
                                                        output
                                                    )
                                                }"
                                            }
                                            "Meter" -> {
                                                result.text = "${output}"
                                            }
                                            "Kilometer" -> {
                                                var secondPageLengthMeserment =
                                                    LengthMeserment(output)
                                                result.text = "${
                                                    secondPageLengthMeserment.meterToKilometer(
                                                        output
                                                    )
                                                }"
                                            }
                                        }
                                    }
                                    "Meter" -> {
                                        var output: Double =
                                            (firstInputValue.toDouble() + secondInputValue.toDouble())
                                        when (secondPageThirdChildSpinnerSelectedItem) {
                                            "Centimeter" -> {
                                                var secondPageLengthMeserment =
                                                    LengthMeserment(output)
                                                result.text = "${
                                                    secondPageLengthMeserment.meterTOCentimeter(
                                                        output
                                                    )
                                                }"
                                            }
                                            "Meter" -> {
                                                result.text = "${output}"
                                            }
                                            "Kilometer" -> {
                                                var secondPageLengthMeserment =
                                                    LengthMeserment(output)
                                                result.text = "${
                                                    secondPageLengthMeserment.meterToKilometer(
                                                        output
                                                    )
                                                }"
                                            }
                                        }
                                    }
                                    "Kilometer" -> {
                                        var secondPageLengthMeserment =
                                            LengthMeserment(secondInputValue.toDouble())
                                        var output =
                                            (firstInputValue.toDouble() + secondPageLengthMeserment.KiloMeterToMeter(
                                                secondInputValue.toDouble()
                                            ))
                                        when (secondPageThirdChildSpinnerSelectedItem) {
                                            "Centimeter" -> {
                                                var secondPageLengthMeserment =
                                                    LengthMeserment(output)
                                                result.text = "${
                                                    secondPageLengthMeserment.meterTOCentimeter(
                                                        output
                                                    )
                                                }"
                                            }
                                            "Meter" -> {
                                                result.text = "${output}"
                                            }
                                            "Kilometer" -> {
                                                var secondPageLengthMeserment =
                                                    LengthMeserment(output)
                                                result.text = "${
                                                    secondPageLengthMeserment.meterToKilometer(
                                                        output
                                                    )
                                                }"
                                            }

                                        }
                                    }
                                }
                            }
                            "Kilometer" -> {
                                when (secondPageSecondChildSpinnerSelectedItem) {
                                    "Centimeter" -> {
                                        var secondPageLengthMeserment =
                                            LengthMeserment(secondInputValue.toDouble())
                                        var output =
                                            (firstInputValue.toDouble() + secondPageLengthMeserment.centimeterToKiloMeter(
                                                secondInputValue.toDouble()
                                            ))
                                        when (secondPageThirdChildSpinnerSelectedItem) {
                                            "Centimeter" -> {
                                                var secondPageLengthMeserment =
                                                    LengthMeserment(output)
                                                result.text = "${
                                                    secondPageLengthMeserment.kiloMeterToCentimeter(
                                                        output
                                                    )
                                                }"
                                            }
                                            "Meter" -> {
                                                var secondPageLengthMeserment =
                                                    LengthMeserment(output)
                                                result.text = "${
                                                    secondPageLengthMeserment.KiloMeterToMeter(
                                                        output
                                                    )
                                                }"
                                            }
                                            "Kilometer" -> {
                                                result.text = "${output}"
                                            }
                                        }
                                    }
                                    "Meter" -> {
                                        var secondPageLengthMeserment =
                                            LengthMeserment(secondInputValue.toDouble())
                                        var output =
                                            (firstInputValue.toDouble() + secondPageLengthMeserment.meterToKilometer(
                                                secondInputValue.toDouble()
                                            ))
                                        when (secondPageThirdChildSpinnerSelectedItem) {
                                            "Centimeter" -> {
                                                var secondPageLengthMeserment =
                                                    LengthMeserment(output)
                                                result.text = "${
                                                    secondPageLengthMeserment.kiloMeterToCentimeter(
                                                        output
                                                    )
                                                }"
                                            }
                                            "Meter" -> {
                                                var secondPageLengthMeserment =
                                                    LengthMeserment(output)
                                                result.text = "${
                                                    secondPageLengthMeserment.KiloMeterToMeter(
                                                        output
                                                    )
                                                }"
                                            }
                                            "Kilometer" -> {
                                                result.text = "${output}"
                                            }
                                        }
                                    }
                                    "Kilometer"->{
                                        var output = (firstInputValue.toDouble() + secondInputValue.toDouble())
                                        when(secondPageThirdChildSpinnerSelectedItem){
                                            "Centimeter"->{
                                                var secondPageLengthMeserment =
                                                    LengthMeserment(output)
                                                result.text = "${
                                                    secondPageLengthMeserment.kiloMeterToCentimeter(
                                                        output
                                                    )
                                                }"
                                            }
                                            "Meter"->{
                                                var secondPageLengthMeserment =
                                                    LengthMeserment(output)
                                                result.text = "${
                                                    secondPageLengthMeserment.KiloMeterToMeter(
                                                        output
                                                    )
                                                }"
                                            }
                                            "Kilometer"->{
                                                result.text = "${output}"
                                            }                                        }
                                    }
                                }
                            }
                        }
                    }
                    "Weight"->{
                        when(secondPageFirstChildSpinnerSelectedItem){
                            "Gram"->{
                                when(secondPageSecondChildSpinnerSelectedItem){
                                    "Gram"-> {
                                        var output =
                                            (firstInputValue.toDouble() + secondInputValue.toDouble())
                                        when(secondPageThirdChildSpinnerSelectedItem){
                                            "Gram"->{
                                                result.text = "${output}"
                                            }
                                            "Kilogram"->{
                                                var secondPageWeightMeserment =
                                                    WeightMeserment(output)
                                                result.text =
                                                    " ${
                                                        secondPageWeightMeserment.gramToKiloGram(
                                                            output
                                                        )
                                                    }"
                                            }
                                            "Tonne"->{
                                                var secondPageWeightMeserment =
                                                    WeightMeserment(output)
                                                result.text =
                                                    " ${
                                                        secondPageWeightMeserment.gramToTonne(
                                                            output
                                                        )
                                                    }"
                                            }
                                        }
                                    }
                                    "Kilogram"->{
                                        var secondPageWeightMeserment = WeightMeserment(secondInputValue.toDouble())
                                        var output = (firstInputValue.toDouble() + secondPageWeightMeserment.kilogramTOGram(secondInputValue.toDouble()))
                                        when(secondPageThirdChildSpinnerSelectedItem){
                                            "Gram"->{
                                                var secondPageWeightMeserment = WeightMeserment(output)
                                                result.text = "${output}"
                                            }
                                            "Kilogram"->{
                                                var secondPageWeightMeserment = WeightMeserment(output)
                                                result.text = "${secondPageWeightMeserment.gramToKiloGram(output)}"
                                            }
                                            "Tonne"->{
                                                var secondPageWeightMeserment = WeightMeserment(output)
                                                result.text = "${secondPageWeightMeserment.gramToTonne(output)}"
                                            }
                                        }
                                    }
                                    "Tonne"->{
                                        var secondPageWeightMeserment = WeightMeserment(secondInputValue.toDouble())
                                        var output = (firstInputValue.toDouble() + secondPageWeightMeserment.tonneToGram(secondInputValue.toDouble()))
                                        when(secondPageThirdChildSpinnerSelectedItem){
                                            "Gram"->{
                                                var secondPageWeightMeserment = WeightMeserment(output)
                                                result.text = "${output}"
                                            }
                                            "Kilogram"->{
                                                var secondPageWeightMeserment = WeightMeserment(output)
                                                result.text = "${secondPageWeightMeserment.gramToKiloGram(output)}"
                                            }
                                            "Tonne"->{
                                                var secondPageWeightMeserment = WeightMeserment(output)
                                                result.text = "${secondPageWeightMeserment.gramToTonne(output)}"
                                            }
                                        }
                                    }
                                }
                            }
                            "Kilogram"->{
                                when(secondPageSecondChildSpinnerSelectedItem){
                                    "Gram"->{
                                        var secondPageWeightMeserment = WeightMeserment(secondInputValue.toDouble())
                                        var output = (firstInputValue.toDouble() + secondPageWeightMeserment.gramToKiloGram(secondInputValue.toDouble()))
                                        when(secondPageThirdChildSpinnerSelectedItem){
                                            "Gram"->{
                                                var secondPageWeightMeserment = WeightMeserment(output)
                                                result.text = "${secondPageWeightMeserment.gramToKiloGram(output)}"
                                            }
                                            "Kilogram"->{
                                                result.text = "${output}"
                                            }
                                            "Tonne"->{
                                                var secondPageWeightMeserment = WeightMeserment(output)
                                                result.text = "${secondPageWeightMeserment.kilogramToTonne(output)}"
                                            }
                                        }
                                    }
                                    "Kilogram"->{
                                        var output = (firstInputValue.toDouble() + secondInputValue.toDouble())
                                        when(secondPageThirdChildSpinnerSelectedItem){
                                            "Gram"->{
                                                var secondPageWeightMeserment = WeightMeserment(output)
                                                result.text = "${secondPageWeightMeserment.kilogramTOGram(output)}"
                                            }
                                            "Kilogram"->{
                                                result.text = "${output}"
                                            }
                                            "Tonne"->{
                                                var secondPageWeightMeserment = WeightMeserment(output)
                                                result.text = "${secondPageWeightMeserment.kilogramToTonne(output)}"
                                            }

                                        }
                                    }
                                    "Tonne"->{
                                        var secondPageWeightMeserment = WeightMeserment(secondInputValue.toDouble())
                                        var output = (firstInputValue.toDouble() + secondPageWeightMeserment.tonneToKilogram(secondInputValue.toDouble()))
                                         when(secondPageThirdChildSpinnerSelectedItem){
                                             "Gram"->{
                                                 var secondPageWeightMeserment = WeightMeserment(output)
                                                 result.text = "${secondPageWeightMeserment.kilogramTOGram(output)}"
                                             }
                                             "Kilogram"->{
                                                 result.text = "${output}"
                                             }
                                             "Tonne"->{
                                                 var secondPageWeightMeserment = WeightMeserment(output)
                                                 result.text = "${secondPageWeightMeserment.kilogramToTonne(output)}"
                                             }
                                         }
                                    }
                                }
                            }
                            "Tonne"->{
                                when(secondPageSecondChildSpinnerSelectedItem){
                                    "Gram"->{
                                        var secondPageWeightMeserment = WeightMeserment(secondInputValue.toDouble())
                                        var output = (firstInputValue.toDouble() + secondPageWeightMeserment.gramToTonne(secondInputValue.toDouble()))
                                        when(secondPageThirdChildSpinnerSelectedItem){
                                            "Gram"->{
                                                var secondPageWeightMeserment = WeightMeserment(output)
                                                result.text = "${secondPageWeightMeserment.tonneToGram(output)}"
                                            }
                                            "Kilogram"->{
                                                var secondPageWeightMeserment = WeightMeserment(output)
                                                result.text = "${secondPageWeightMeserment.tonneToKilogram(output)}"
                                            }
                                            "Tonne"->{
                                                result.text = "${output}"
                                            }
                                        }
                                    }
                                    "Kilogram"->{
                                        var secondPageWeightMeserment = WeightMeserment(secondInputValue.toDouble())
                                        var output = (firstInputValue.toDouble() + secondPageWeightMeserment.kilogramToTonne(secondInputValue.toDouble()))
                                        when(secondPageThirdChildSpinnerSelectedItem){
                                            "Gram"->{
                                                var secondPageWeightMeserment = WeightMeserment(output)
                                                result.text = "${secondPageWeightMeserment.tonneToGram(output)}"
                                            }
                                            "Kilogram"->{
                                                var secondPageWeightMeserment = WeightMeserment(output)
                                                result.text = "${secondPageWeightMeserment.tonneToKilogram(output)}"
                                            }

                                          "Tonne"->{
                                                result.text = "${output}"
                                           }

                                        }
                                    }
                                    "Tonne"->{
                                        var output = (firstInputValue.toDouble() + secondInputValue.toDouble())
                                        when(secondPageThirdChildSpinnerSelectedItem){
                                            "Gram"->{
                                                var secondPageWeightMeserment = WeightMeserment(output)
                                                result.text = "${secondPageWeightMeserment.tonneToGram(output)}"
                                            }
                                            "Kilogram"->{
                                                var secondPageWeightMeserment = WeightMeserment(output)
                                                result.text = "${secondPageWeightMeserment.tonneToKilogram(output)}"
                                            }

                                            "Tonne"->{
                                                result.text = "${output}"
                                            }

                                        }
                                    }
                                }
                            }
                        }
                    }
                    "Volume"->{
                        when(secondPageFirstChildSpinnerSelectedItem){
                            "MilliLitre"->{
                                when(secondPageSecondChildSpinnerSelectedItem){
                                    "MilliLitre"->{
                                        var output = (firstInputValue.toDouble() + secondInputValue.toDouble())
                                        when(secondPageThirdChildSpinnerSelectedItem){
                                            "MilliLitre"->{
                                                result.text = "${output}"
                                            }
                                            "Litre"->{
                                                var secondPageVolumeMeserment = VolumeMeserement(output)
                                                result.text = "${secondPageVolumeMeserment.millilitterToLitter(output)}"
                                            }
                                            "Gallon"->{
                                                var secondPageVolumeMeserment = VolumeMeserement(output)
                                                result.text = "${secondPageVolumeMeserment.millilitterToGallon(output)}"
                                            }
                                        }
                                    }
                                    "Litre"->{
                                        var secondPageVolumeMeserment = VolumeMeserement(secondInputValue.toDouble())
                                        var output = (firstInputValue.toDouble() +  secondPageVolumeMeserment.litterTOMilliLitter(secondInputValue.toDouble()))
                                        when(secondPageThirdChildSpinnerSelectedItem){
                                            "MilliLitre"->{
                                                result.text = "${output}"
                                            }
                                            "Litre"->{
                                                var secondPageVolumeMeserment = VolumeMeserement(output)
                                                result.text = "${secondPageVolumeMeserment.millilitterToLitter(output)}"
                                            }
                                            "Gallon"->{
                                                var secondPageVolumeMeserment = VolumeMeserement(output)
                                                result.text = "${secondPageVolumeMeserment.millilitterToGallon(output)}"
                                            }
                                        }
                                    }
                                    "Gallon"->{
                                        var secondPageVolumeMeserment = VolumeMeserement(secondInputValue.toDouble())
                                        var output = (firstInputValue.toDouble() +  secondPageVolumeMeserment.gallonTOMillitter(secondInputValue.toDouble()))
                                        when(secondPageThirdChildSpinnerSelectedItem){
                                            "MilliLitre"->{
                                                result.text = "${output}"
                                            }
                                            "Litre"->{
                                                var secondPageVolumeMeserment = VolumeMeserement(output)
                                                result.text = "${secondPageVolumeMeserment.millilitterToLitter(output)}"
                                            }
                                            "Gallon"->{
                                                var secondPageVolumeMeserment = VolumeMeserement(output)
                                                result.text = "${secondPageVolumeMeserment.millilitterToGallon(output)}"
                                            }
                                        }
                                    }
                                }
                            }
                            "Litre"->{
                                when(secondPageSecondChildSpinnerSelectedItem){
                                    "MilliLitre"->{
                                        var secondPageVolumeMeserment = VolumeMeserement(secondInputValue.toDouble())
                                        var output = (firstInputValue.toDouble() +  secondPageVolumeMeserment.millilitterToLitter(secondInputValue.toDouble()))
                                        when(secondPageThirdChildSpinnerSelectedItem){
                                            "MilliLitre"->{
                                                var secondPageVolumeMeserment = VolumeMeserement(output)
                                                result.text = "${secondPageVolumeMeserment.litterTOMilliLitter(output)}"
                                            }
                                            "Litre"->{
                                                result.text = "${output}"
                                            }
                                            "Gallon"->{
                                                var secondPageVolumeMeserment = VolumeMeserement(output)
                                                result.text = "${secondPageVolumeMeserment.millilitterToGallon(output)}"
                                            }
                                        }
                                    }
                                    "Litre"->{
                                        var output = (firstInputValue.toDouble() + secondInputValue.toDouble())
                                        when(secondPageThirdChildSpinnerSelectedItem){
                                            "MilliLitre"->{
                                                var secondPageVolumeMeserment = VolumeMeserement(output)
                                                result.text = "${secondPageVolumeMeserment.litterTOMilliLitter(output)}"
                                            }
                                            "Litre"->{
                                                result.text = "${output}"
                                            }
                                            "Gallon"->{
                                                var secondPageVolumeMeserment = VolumeMeserement(output)
                                                result.text = "${secondPageVolumeMeserment.litterToGallon(output)}"
                                            }
                                        }
                                    }
                                    "Gallon"->{
                                        var secondPageVolumeMeserment = VolumeMeserement(secondInputValue.toDouble())
                                        var output = (firstInputValue.toDouble() +  secondPageVolumeMeserment.gallonToLitter(secondInputValue.toDouble()))
                                        when(secondPageThirdChildSpinnerSelectedItem){
                                            "MilliLitre"->{
                                                var secondPageVolumeMeserment = VolumeMeserement(output)
                                                result.text = "${secondPageVolumeMeserment.litterTOMilliLitter(output)}"
                                            }
                                            "Litre"->{
                                                result.text = "${output}"
                                            }
                                            "Gallon"->{
                                                var secondPageVolumeMeserment = VolumeMeserement(output)
                                                result.text = "${secondPageVolumeMeserment.litterToGallon(output)}"
                                            }
                                        }
                                    }
                                }
                            }
                            "Gallon"->{
                                when(secondPageSecondChildSpinnerSelectedItem){
                                    "MilliLitre"->{
                                        var secondPageVolumeMeserment = VolumeMeserement(secondInputValue.toDouble())
                                        var output = (firstInputValue.toDouble() + secondPageVolumeMeserment.millilitterToGallon(secondInputValue.toDouble()))
                                        when(secondPageThirdChildSpinnerSelectedItem){
                                            "MilliLitre"->{
                                                var secondPageVolumeMeserment = VolumeMeserement(output)
                                                result.text = "${secondPageVolumeMeserment.gallonTOMillitter(output)}"
                                            }
                                            "Litre"->{
                                                var secondPageVolumeMeserment = VolumeMeserement(output)
                                                result.text = "${secondPageVolumeMeserment.gallonToLitter(output)}"
                                            }
                                            "Gallon"->{
                                                result.text = "${output}"
                                            }
                                        }
                                    }
                                    "Litre"->{
                                        var secondPageVolumeMeserment = VolumeMeserement(secondInputValue.toDouble())
                                        var output = (firstInputValue.toDouble() + secondPageVolumeMeserment.litterToGallon(secondInputValue.toDouble()))
                                        when(secondPageThirdChildSpinnerSelectedItem){
                                            "MilliLitre"->{
                                                var secondPageVolumeMeserment = VolumeMeserement(output)
                                                result.text = "${secondPageVolumeMeserment.gallonTOMillitter(output)}"
                                            }
                                            "Litre"->{
                                                var secondPageVolumeMeserment = VolumeMeserement(output)
                                                result.text = "${secondPageVolumeMeserment.gallonToLitter(output)}"
                                            }
                                            "Gallon"->{
                                                result.text = "${output}"
                                            }
                                        }
                                    }
                                    "Gallon"->{
                                        var output = (firstInputValue.toDouble() + secondInputValue.toDouble())
                                        when(secondPageThirdChildSpinnerSelectedItem){
                                            "MilliLitre"->{
                                                var secondPageVolumeMeserment = VolumeMeserement(output)
                                                result.text = "${secondPageVolumeMeserment.gallonTOMillitter(output)}"
                                            }
                                            "Litre"->{
                                                var secondPageVolumeMeserment = VolumeMeserement(output)
                                                result.text = "${secondPageVolumeMeserment.gallonToLitter(output)}"
                                            }
                                            "Gallon"->{
                                                result.text = "${output}"
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
