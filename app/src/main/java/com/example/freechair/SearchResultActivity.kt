package com.example.freechair

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.freechair.databinding.ActivitySearchResultBinding


class SearchResultActivity : AppCompatActivity() {

    val binding by lazy{ActivitySearchResultBinding.inflate(layoutInflater)}
    val helper=SqliteHelper(this,"restaurantDb",1)
    var restaurantInfo: MutableList<Restaurant> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        helper.dbInit()

        Log.d("result","초기 검색값 : ${intent.getStringExtra("search")}")

        //초기화면에서 넘어온 검색값 intent
        val searchValue=intent.getStringExtra("search")

        //searchActivity로 넘겨주는 intent
        val searchIntent= Intent(this,SearchActivity::class.java)

        //검색 시작
        restaurantInfo=helper.search(searchValue,searchValue)

        //recycler view 위한 adapter 생성
        val adapter=CustomAdapter()
        adapter.listShop=restaurantInfo
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