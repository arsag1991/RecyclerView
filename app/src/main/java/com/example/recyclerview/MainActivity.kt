package com.example.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recyclerview.databinding.ActivityMain2Binding
import com.example.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val adapter = MyAdapter()
    private var editLauncher: ActivityResultLauncher<Intent>? = null

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        editLauncher = registerForActivityResult(StartActivityForResult()){
            if (it.resultCode == RESULT_OK){
                adapter.addCar(it.data?.getSerializableExtra("car") as MainClass)
            }
        }
        init()
    }
    private fun init(){
        binding.rcView.layoutManager = GridLayoutManager(this, 3)
        binding.rcView.adapter = adapter
        binding.bAdd.setOnClickListener {
            editLauncher?.launch(Intent(this, MainActivity2::class.java))
        }

    }
}