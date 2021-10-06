package com.example.freechair

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.freechair.databinding.ActivitySearchResultBinding


class SearchResultActivity : AppCompatActivity() {

    val binding by lazy{ActivitySearchResultBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        Log.d("result","초기 검색값 : ${intent.getStringExtra("search")}")

        val searchIntent= Intent(this,SearchActivity::class.java)
        //검색 결과 창에서 다시 검색 버튼 눌러 검색시 실행
        binding.searchButton.setOnClickListener{
            startActivityForResult(searchIntent,99)


        }

        //뒤로가기 버튼 클릭시
        binding.backButton.setOnClickListener{
            finish()
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        
        if (resultCode==RESULT_OK){
            val searchResult= data?.getStringExtra("searchValue")
            Log.d("result","결과값 : ${searchResult}")
        }
    }
}