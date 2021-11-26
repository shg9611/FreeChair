package com.example.freechair

import android.content.Intent
import android.location.Address
import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.KeyEvent.KEYCODE_ENTER
import com.example.freechair.databinding.ActivityMainBinding
import java.io.IOException


class MainActivity : AppCompatActivity() {

    val binding by lazy{ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        val intentMap= Intent(this,MapsActivity::class.java)
        val intentSearch=Intent(this,SearchResultActivity::class.java)

        //지도 기반 검색
        binding.findingMapButton.setOnClickListener { startActivity(intentMap) }

        //검색창 검색. 엔터 누르면 인텐트로 검색 string 보냄.
        binding.editSearch.setOnKeyListener{ v, keyCode, event->

            if ((event.action == KeyEvent.ACTION_DOWN) && (keyCode==KEYCODE_ENTER)){
                intentSearch.putExtra("search",binding.editSearch.text.toString())
                startActivity(intentSearch)

                return@setOnKeyListener true
            }
            else {
                return@setOnKeyListener false
            }

        }


    }
}