package com.example.freechair

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.freechair.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy{ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContentView(binding.root)
    }
}