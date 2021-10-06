package com.example.freechair

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.freechair.databinding.ActivityMapBinding

class MapActivity : AppCompatActivity() {

    val binding by lazy{ActivityMapBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //뒤로가기 버튼 클릭시
        binding.backButton.setOnClickListener{
            finish()
        }
    }
}