package com.example.measermentapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.measermentapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val arrayListParent = arrayListOf<String>("Length", "Weight", "Volume")
        val arrayAdapterParent =
            ArrayAdapter(applicationContext, R.layout.textview_blue, arrayListParent)

        binding.spinner.adapter = arrayAdapterParent

        val arrayListLengthMeaserment = arrayListOf<String>("Centimeter", "Meter", "Kilometer")
        val arrayListWeigthMeserment = arrayListOf<String>("Kilogram", "Gram", "Tonne")
        val arrayListVolumeMeserment = arrayListOf<String>("Gallon", "Litre", "MilliLitre")
        val arrayAdapter_child =
            ArrayAdapter(applicationContext, R.layout.textview_red, arrayListLengthMeaserment)

        binding.spinner1.adapter = arrayAdapter_child
        binding.spinner2.adapter = arrayAdapter_child
        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                when (position) {
                    0 -> {
                        val arrayAdapter_child = ArrayAdapter(
                            applicationContext,
                            R.layout.textview_red,
                            arrayListLengthMeaserment
                        )
                        binding.spinner1.adapter = arrayAdapter_child
                        binding.spinner2.adapter = arrayAdapter_child
                    }
                    1 -> {
                        val arrayAdapter_child = ArrayAdapter(
                            applicationContext,
                            R.layout.textview_red,
                            arrayListWeigthMeserment
                        )
                        binding.spinner1.adapter = arrayAdapter_child
                        binding.spinner2.adapter = arrayAdapter_child
                    }
                    2 -> {
                        val arrayAdapter_child = ArrayAdapter(
                            applicationContext,
                            R.layout.textview_red,
                            arrayListVolumeMeserment
                        )
                        binding.spinner1.adapter = arrayAdapter_child
                        binding.spinner2.adapter = arrayAdapter_child
                    }
//                3 -> { val arrayAdapter_child = ArrayAdapter(applicationContext,R.layout.textview_red,arraylist_temperature)
//                    binding.spinner1.adapter = arrayAdapter_child
//                    binding.spinner2.adapter = arrayAdapter_child}
                }

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        binding.btnSecongPage.setOnClickListener {
            val intent = Intent(this,UnitCovertAppSecondPage::class.java)
            startActivity(intent)
        }

        binding.buttonclik.setOnClickListener {
            val edit: EditText = findViewById(R.id.editText1)
            var inputValue: String = edit.text.toString()
            var result: TextView = findViewById(R.id.editTextNumberSigned2)
            var mainSpinnerSelectedItem: String = binding.spinner.selectedItem.toString()
            var childSpinnerOneSelectedItem: String = binding.spinner1.selectedItem.toString()
            var childSpinnerSecondSelectedItem: String = binding.spinner2.selectedItem.toString()
            //  Toast.makeText(getApplicationContext(), "vlaue is "+inputValue, Toast.LENGTH_LONG).show()
            if(inputValue.isEmpty()){
                result.text = "0.0"
            }
            else {
                when (mainSpinnerSelectedItem) {
                    "Length" -> {
                        when (childSpinnerOneSelectedItem) {
                            "Centimeter" -> {
                                when (childSpinnerSecondSelectedItem) {

                                    "Meter" -> {

                                        var lengthMeserment = LengthMeserment(inputValue.toDouble())
                                        result.text =
                                            " ${lengthMeserment.centimeterTOmeter(inputValue.toDouble())}"
                                    }
                                    "Kilometer" -> {
                                        var lengthMeserment = LengthMeserment(inputValue.toDouble())
                                        result.text =
                                            " ${lengthMeserment.centimeterToKiloMeter(inputValue.toDouble())}"
                                    }

                                }
                            }
                            "Meter" -> {
                                when (childSpinnerSecondSelectedItem) {
                                    "Centimeter" -> {
                                        var lengthMeserment = LengthMeserment(inputValue.toDouble())
                                        result.text =
                                            " ${lengthMeserment.meterTOCentimeter(inputValue.toDouble())}"
                                    }

                                    "Kilometer" -> {
                                        var lengthMeserment = LengthMeserment(inputValue.toDouble())
                                        result.text =
                                            " ${lengthMeserment.meterToKilometer(inputValue.toDouble())}"
                                    }
                                }
                            }
                            "Kilometer" -> {
                                when (childSpinnerSecondSelectedItem) {
                                    "Centimeter" -> {
                                        var lengthMeserment = LengthMeserment(inputValue.toDouble())
                                        result.text =
                                            " ${lengthMeserment.kiloMeterToCentimeter(inputValue.toDouble())}"
                                    }
                                    "Meter" -> {
                                        var lengthMeserment = LengthMeserment(inputValue.toDouble())
                                        result.text =
                                            " ${lengthMeserment.KiloMeterToMeter(inputValue.toDouble())}"
                                    }
                                }
                            }
                        }
                    }
                    "Weight" -> {
                        when (childSpinnerOneSelectedItem) {
                            "Gram" -> {
                                when (childSpinnerSecondSelectedItem) {
                                    "Kilogram" -> {
                                        var weightMeserment = WeightMeserment(inputValue.toDouble())
                                        result.text =
                                            "${weightMeserment.gramToKiloGram(inputValue.toDouble())}"
                                    }
                                    "Tonne" -> {
                                        var weightMeserment = WeightMeserment(inputValue.toDouble())
                                        result.text =
                                            "${weightMeserment.gramToTonne(inputValue.toDouble())}"
                                    }
                                }
                            }
                            "Kilogram" -> {
                                when (childSpinnerSecondSelectedItem) {
                                    "Gram" -> {
                                        var weightMeserment = WeightMeserment(inputValue.toDouble())
                                        result.text =
                                            "${weightMeserment.kilogramTOGram(inputValue.toDouble())}"

                                    }
                                    "Tonne" -> {
                                        var weightMeserment = WeightMeserment(inputValue.toDouble())
                                        result.text =
                                            "${weightMeserment.kilogramToTonne(inputValue.toDouble())}"
                                    }
                                }
                            }
                            "Tonne" -> {
                                when (childSpinnerSecondSelectedItem) {
                                    "Gram" -> {
                                        var weightMeserment = WeightMeserment(inputValue.toDouble())
                                        result.text =
                                            "${weightMeserment.tonneToGram(inputValue.toDouble())}"
                                    }
                                    "Kilogram" -> {
                                        var weightMeserment = WeightMeserment(inputValue.toDouble())
                                        result.text =
                                            "${weightMeserment.tonneToKilogram(inputValue.toDouble())}"
                                    }
                                }
                            }
                        }
                    }
                    "Volume" -> {
                        when (childSpinnerOneSelectedItem) {

                            "MilliLitre" -> {
                                when (childSpinnerSecondSelectedItem) {
                                    "Litre" -> {
                                        var volumeMeserement =
                                            VolumeMeserement(inputValue.toDouble())
                                        result.text =
                                            "${volumeMeserement.millilitterToLitter(inputValue.toDouble())}"
                                    }
                                    "Gallon" -> {
                                        var volumeMeserement =
                                            VolumeMeserement(inputValue.toDouble())
                                        result.text =
                                            "${volumeMeserement.millilitterToGallon(inputValue.toDouble())}"
                                    }
                                }
                            }

                            "Litre" -> {
                                when (childSpinnerSecondSelectedItem) {
                                    "MilliLitre" -> {
                                        var volumeMeserement =
                                            VolumeMeserement(inputValue.toDouble())
                                        result.text =
                                            "${volumeMeserement.litterTOMilliLitter(inputValue.toDouble())}"
                                    }
                                    "Gallon" -> {
                                        var volumeMeserement =
                                            VolumeMeserement(inputValue.toDouble())
                                        result.text =
                                            "${volumeMeserement.litterToGallon(inputValue.toDouble())}"
                                    }
                                }
                            }
                            "Gallon" -> {
                                when (childSpinnerSecondSelectedItem) {
                                    "MilliLitre" -> {
                                        var volumeMeserement =
                                            VolumeMeserement(inputValue.toDouble())
                                        result.text =
                                            "${volumeMeserement.gallonTOMillitter(inputValue.toDouble())}"

                                    }
                                    "Litre" -> {
                                        var volumeMeserement =
                                            VolumeMeserement(inputValue.toDouble())
                                        result.text =
                                            "${volumeMeserement.gallonToLitter(inputValue.toDouble())}"
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
