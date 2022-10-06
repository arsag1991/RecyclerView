package com.example.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recyclerview.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    var index = 0
    var carId = R.drawable.image1
    private val carListId = listOf(
        R.drawable.image1,
        R.drawable.image2,
        R.drawable.image3,
        R.drawable.image4,
        R.drawable.image5,
        R.drawable.image6,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        initButtons()
    }
    private fun initButtons() = with (binding){
        bNext.setOnClickListener {
            index++
            carId = carListId[index]
            imageView.setImageResource(carId)
        }
        bDone.setOnClickListener {
            val car = MainClass(carId, edTitle.text.toString(), edDesc.text.toString())
            val editIntent = Intent().apply {
                putExtra("car", car)
            }
            setResult (RESULT_OK, editIntent)
            finish()
        }

    }

}