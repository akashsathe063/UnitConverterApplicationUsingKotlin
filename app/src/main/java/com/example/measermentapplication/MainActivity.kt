package com.example.measermentapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.measermentapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val arrayListParent = arrayListOf<String>("Length", "Weight", "Volume", "Temperature")
        val arrayAdapterParent = ArrayAdapter(applicationContext, R.layout.textview_blue, arrayListParent)

        binding.spinner.adapter = arrayAdapterParent

        val arrayListLengthMeaserment = arrayListOf<String>("Centimeter", "Meter", "Kilometer")
        val arrayListWeigthMeserment = arrayListOf<String>("Kilogram", "Gram", "Tonne")
        val arrayListVolumeMeserment = arrayListOf<String>("Gallon", "Litre", "MilliLitre")
        val arrayAdapter_child = ArrayAdapter(applicationContext, R.layout.textview_red, arrayListLengthMeaserment)

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
        binding.buttonclik.setOnClickListener {
            val edit: EditText = findViewById(R.id.editText1)
            var inputValue: String = edit.text.toString()
            var result: TextView = findViewById(R.id.editTextNumberSigned2)
            var mainSpinnerSelectedItem: String = binding.spinner.selectedItem.toString()
            var childSpinnerOneSelectedItem: String = binding.spinner1.selectedItem.toString()
            var childSpinnerSecondSelectedItem: String = binding.spinner2.selectedItem.toString()
          //  Toast.makeText(getApplicationContext(), "vlaue is "+inputValue, Toast.LENGTH_LONG).show()
            when(mainSpinnerSelectedItem){
                   "Length" -> {
                       when(childSpinnerOneSelectedItem){
                           "Centimeter" ->{
                                    when(childSpinnerSecondSelectedItem){
                                        "Meter" ->{
                                            var outputValue: Double = 
                                            var unitCoverter = UnitCoverter(inputValue.toDouble())
                                            outputValue = unitCoverter.centimeterTOmeter(inputValue.toDouble())
                                            Toast.makeText(getApplicationContext(), "vlaue is "+outputValue, Toast.LENGTH_LONG).show()
                                        }
                                    }

                           }
                       }

                   }
            }

        }

    }


}