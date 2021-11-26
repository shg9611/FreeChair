package com.example.freechair

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import com.example.freechair.databinding.ActivityShopInfoBinding

class ShopInfoActivity : AppCompatActivity() {


    private lateinit var binding: ActivityShopInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityShopInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.backButtonMap.setOnClickListener{
            finish()
        }
        binding.name.text=intent.getStringExtra("name")
        binding.gu.text="담당 구 : "+intent.getStringExtra("gu")
        binding.address.text="주소 : "+intent.getStringExtra("address")
        binding.phoneNo.text=" : "+intent.getStringExtra("phoneNo")
        val phoneNo=intent.getStringExtra("phoneNo")

        val elevator = intent.getStringExtra("elevator")
        val ramp=intent.getStringExtra("ramp")
        val stair=intent.getStringExtra("stair")
        val restroom=intent.getStringExtra("restRoom")
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.

        binding.phoneCall.setOnClickListener{

            var callNum=intent.getStringExtra("phoneNo")
            if (callNum!=null){

                callNum=callNum.replace("-","")
                Log.d("phonecheck","${callNum}")
                Log.d("phonecheck","1234")
                val call= Intent(Intent.ACTION_DIAL)
                call.data= Uri.parse("tel:${callNum}")

                startActivity(call)
            }
        }


        if (elevator.equals("Y")){
            binding.elevator2.setColorFilter(Color.parseColor("#006400"))
            binding.elevator2.alpha=1.0F
            binding.elevator.text = " 엘리베이터 이용이 가능합니다."
        }
        else{
            binding.elevator2.setColorFilter(Color.parseColor("#B22222"))
            binding.elevator.text = " 엘리베이터 이용이 불가능합니다."
        }
        if (stair.equals("Y")){
            binding.stair2.setColorFilter(Color.parseColor("#006400"))
            binding.stair2.alpha=1.0F
            binding.stair.text = " 식당 내 바닥 높이차이가 없습니다."
        }
        else{
            binding.stair2.setColorFilter(Color.parseColor("#B22222"))
            binding.stair.text = " 식당 내 바닥 높이차이가 존재합니다."

        }
        if (ramp.equals("Y")){
            binding.ramp2.setColorFilter(Color.parseColor("#006400"))
            binding.ramp2.alpha=1.0F
            binding.ramp.text = " 식당 접근을 위한 경사로가 존재합니다."
        }
        else{
            binding.ramp2.setColorFilter(Color.parseColor("#B22222"))
            binding.ramp.text = " 식당 접근을 위한 경사로가 없습니다."

        }
        if (restroom.equals("Y")){
            binding.restRoom2.setColorFilter(Color.parseColor("#006400"))
            binding.restRoom2.alpha=1.0F
            binding.restRoom.text = " 장애인용 화장실이 존재합니다."
        }
        else{
            binding.restRoom2.setColorFilter(Color.parseColor("#B22222"))
            binding.restRoom.text = " 장애인용 화장실이 존재하지 않습니다."

        }

    }




}