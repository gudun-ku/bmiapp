package com.example.bitamirshafiee.bmiskeletonproject

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    var BMI: Float = 0F;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calculate(view: View) {

        val view = this.currentFocus
        view?.let { v ->
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
            imm?.let { it.hideSoftInputFromWindow(v.windowToken, 0) }
        }

        if (weight_text_view.text.isNullOrBlank()) {
            weight_text_view.setError("Input the weight!")
            return
        }

        if (height_text_view.text.isNullOrBlank()) {
            weight_text_view.setError("Input the height!")
            return
        }

        val weight: Float = weight_text_view.text.toString().toFloat();
        val height: Float = height_text_view.text.toString().toFloat();

        BMI = weight * 2.20462F * 0.45F / (height* 0.393701F * 0.025F).pow(2)

        bmi_text_view.text = BMI.toString()

        when (BMI){
            in 0F..18.5F -> image_view.setImageDrawable(resources.getDrawable(R.drawable.underweight))
            in 18.5F..25F -> image_view.setImageDrawable(resources.getDrawable(R.drawable.healthy))
            in 25F..29.9F -> image_view.setImageDrawable(resources.getDrawable(R.drawable.overweight))
            else -> image_view.setImageDrawable(resources.getDrawable(R.drawable.obesity))
        }
    }
}
