package com.example.freechair

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.freechair.databinding.ActivitySearchResultBinding


class SearchResultActivity : AppCompatActivity() {

    val binding by lazy{ActivitySearchResultBinding.inflate(layoutInflater)}
    val shopInfo: MutableList<shopInfo> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        Log.d("result","초기 검색값 : ${intent.getStringExtra("search")}")

        val searchIntent= Intent(this,SearchActivity::class.java)
        val adapter=CustomAdapter()
        adapter.listShop=shopInfo
        binding.recycleView.adapter=adapter
        binding.recycleView.layoutManager=LinearLayoutManager(this)

        //검색 결과 창에서 다시 검색 버튼 눌러 검색시 실행
        binding.searchButton.setOnClickListener{
            startActivityForResult(searchIntent,99)


        }

        //뒤로가기 버튼 클릭시
        binding.backButton.setOnClickListener{
            finish()
        }


        //가상 가게 정보 데이터 생성부
        var shopOne=shopInfo(
            "롯데리아1",
            "은평구",
            "02-308-6681",
            "서울시 은평구 응암로 229",
            'N',
            'N',
            'Y',
            'N'
        )

        var shopTwo=shopInfo(
            "롯데리아2",
            "구로구",
            "02-308-6681",
            "서울시 은평구 응암로 229",
            'y',
            'N',
            'y',
            'y'
        )

        var shopThree=shopInfo(
            "롯데리아3",
            "광진구",
            "02-308-6681",
            "서울시 은평구 응암로 229",
            'N',
            'N',
            'N',
            'N'
        )

        var shopFour=shopInfo(
            "고깃집",
            "송파구",
            "02-208-6681",
            "서울시 은평구 응암로 229",
            'N',
            'N',
            'N',
            'N'
        )

        shopInfo.add(shopOne)
        shopInfo.add(shopTwo)
        shopInfo.add(shopThree)
        shopInfo.add(shopFour)


    }
    //호출했던 activity 종료시 result 받는 메서드
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        
        if (resultCode==RESULT_OK){
            val searchResult= data?.getStringExtra("searchValue")
            Log.d("result","결과값 : ${searchResult}")
        }
    }
}