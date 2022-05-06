package com.francklinmarroq.colormyviews

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.francklinmarroq.colormyviews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setListeners()
    }

    private fun setListeners() {
        val clickableViews: List<View> =
            listOf(
                mainBinding.boxOneText,
                mainBinding.boxTwoText,
                mainBinding.boxThreeText,
                mainBinding.boxFourText,
                mainBinding.boxFiveText,
                mainBinding.greenButton,
                mainBinding.redButton,
                mainBinding.yellowButton
            )
        for (item in clickableViews) {
            item.setOnClickListener { makeColored(it) }
        }
    }

    fun makeColored(view: View) {
        when (view.id) {

            // Boxes using Color class colors for background
            R.id.box_one_text -> view.setBackgroundColor(Color.DKGRAY)
            R.id.box_two_text -> view.setBackgroundColor(Color.GRAY)

            // Boxes using Android color resources for background
            R.id.box_three_text -> view.setBackgroundResource(android.R.color.holo_green_light)
            R.id.box_four_text -> view.setBackgroundResource(android.R.color.holo_green_dark)
            R.id.box_five_text -> view.setBackgroundResource(android.R.color.holo_green_light)

            R.id.green_button -> mainBinding.boxFiveText.setBackgroundResource(R.color.my_green)
            R.id.yellow_button -> mainBinding.boxFourText.setBackgroundResource(R.color.my_yellow)
            R.id.red_button -> mainBinding.boxThreeText.setBackgroundResource(R.color.my_red)

            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }
}
