package com.example.freechair

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import com.example.freechair.databinding.ActivitySearchBinding

class SearchActivity : AppCompatActivity() {

    val binding by lazy{ActivitySearchBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val searchReturnIntent= Intent()

        //바로 서치뷰 작동되게 하는 부분
        binding.search.setIconified(false)
        binding.search.requestFocus()

        //서치뷰 검색시. SearchView의 onQueryTextListener를 override 한 object를 생성한 후, 그 object를 search의 파라미터로 넘겨주는 코드.
        binding.search.setOnQueryTextListener(object : SearchView.OnQueryTextListener{

            //서치뷰 엔터시 일어나는 일 override
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchReturnIntent.putExtra("searchValue",query)
                setResult(RESULT_OK,searchReturnIntent)
                finish()
                return true
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                return true
            }
        })

        binding.backButtonSearch.setOnClickListener{
            finish()
        }
    }
}