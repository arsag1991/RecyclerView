package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val adapter = MyAdapter()
    private val carListId = listOf(
        R.drawable.image1,
        R.drawable.image2,
        R.drawable.image3,
        R.drawable.image4,
        R.drawable.image5,
        R.drawable.image6,
        )
    private var i = 0

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
    }
    private fun init(){
        binding.rcView.layoutManager = GridLayoutManager(this, 3)
        binding.rcView.adapter = adapter
        binding.bAdd.setOnClickListener {
            if (i > 5) i = 0
            val car = MainClass(carListId[i], "car ${i+1}")
            adapter.addCar(car)
            i++
        }

    }
}