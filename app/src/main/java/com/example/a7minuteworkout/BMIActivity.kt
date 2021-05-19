package com.example.a7minuteworkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a7minuteworkout.databinding.ActivityBMIBinding

class BMIActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBMIBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBMIBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarBmiActivity)
        val actionbar = supportActionBar
        if (actionbar != null) {
            actionbar.setDisplayHomeAsUpEnabled(true)
            actionbar.title = "CALCULATE BMI"
        }

        binding.toolbarBmiActivity.setNavigationOnClickListener {
            onBackPressed()
        }

        binding.btnCalculateUnits.setOnClickListener {
            if (validateMetricUnits()) {
                val weightValue : Float = binding.etMetricUnitWeight.text.toString().toFloat()
                val heightValue : Float = binding.etMetricUnitHeight.text.toString().toFloat() / 1_000

                val bmi = weightValue / (heightValue * heightValue)
            }
        }
    }

    private fun validateMetricUnits() : Boolean {
        var isValid = true

        if (binding.etMetricUnitWeight.text.toString().isEmpty())
            isValid = false
        if (binding.etMetricUnitHeight.text.toString().isEmpty())
            isValid = false

        return isValid
    }
}