package com.example.freechair

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.CompoundButton
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.freechair.databinding.ActivitySearchResultBinding


class SearchResultActivity : AppCompatActivity() {

    val binding by lazy{ActivitySearchResultBinding.inflate(layoutInflater)}
    val helper=SqliteHelper(this,"restaurantDb",1)
    val adapter=CustomAdapter(this)
    var restaurantInfo: MutableList<Restaurant> = mutableListOf()//query 리턴문 저장. 검색에 대한 결과. 체크박스 고려 전.

    var searchValue:String?=""

    //4가지 체크 버튼. 기본 상태 : "Y". "N"은 체크 해제 상태.
    var rampCheck="N"
    var elevatorCheck="N"
    var stairCheck="N"
    var restroomCheck="N"

    var resultClick:Restaurant?=null

    //체크박스 리스너 코딩
    val checkListener by lazy {
        CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                when (buttonView.id) {

                    R.id.rampCheck -> {rampCheck = "Y"
                        Log.d("hello","램프체크true")}
                    R.id.elevatorCheck -> elevatorCheck = "Y"
                    R.id.stairCheck -> stairCheck = "Y"
                    R.id.restroomCheck -> restroomCheck = "Y"

                }
            } else {
                when (buttonView.id) {

                    R.id.rampCheck -> {rampCheck = "N"
                        Log.d("hello","램프체크flase")}
                    R.id.elevatorCheck -> elevatorCheck = "N"
                    R.id.stairCheck -> stairCheck = "N"
                    R.id.restroomCheck -> restroomCheck = "N"
                }
            }
            //체크박스 조건으로 필터링 하여 새 리스트 생성.

            Log.d("result","이전값 : ${adapter.listShop}")

            //필터 리스트 생성
            var filteredInfo=restaurantInfo
            if (rampCheck.equals("Y")){
                filteredInfo=filteredInfo.filter{
                    it.ramp.equals(rampCheck)
                }.toMutableList()

            }
            if (elevatorCheck.equals("Y")){
                filteredInfo=filteredInfo.filter{
                    it.elevator.equals(elevatorCheck)
                }.toMutableList()

            }
            if (stairCheck.equals("Y")){
                filteredInfo=filteredInfo.filter{
                    it.heightDiffer.equals(stairCheck)
                }.toMutableList()

            }
            if (restroomCheck.equals("Y")){
                filteredInfo=filteredInfo.filter{
                    it.restroom.equals(restroomCheck)
                }.toMutableList()

            }

            //필터 리스트로 어댑터 갱신

            adapter.listShop=filteredInfo
            binding.recycleView.adapter=adapter
            binding.recycleView.layoutManager=LinearLayoutManager(this)

            Log.d("result","결과값 : ${filteredInfo}")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        helper.dbInit()
        //유지 보수시에 아래 한줄 사용. 좌표 자동 계산.
        //helper.initCoordinate(this)

        Log.d("result","초기 검색값 : ${intent.getStringExtra("search")}")

        //초기화면에서 넘어온 검색값 intent
        searchValue=intent?.getStringExtra("search")

        //searchActivity로 넘겨주는 intent
        val searchIntent= Intent(this,SearchActivity::class.java)

        //검색 시작
        restaurantInfo=helper.search(searchValue,searchValue)

        //recycler view 위한 adapter 생성

        adapter.listShop=restaurantInfo
        binding.recycleView.adapter=adapter
        binding.recycleView.layoutManager=LinearLayoutManager(this)

        //체크박스 리스너 달기
        binding.rampCheck.setOnCheckedChangeListener(checkListener)
        binding.elevatorCheck.setOnCheckedChangeListener(checkListener)
        binding.restroomCheck.setOnCheckedChangeListener(checkListener)
        binding.stairCheck.setOnCheckedChangeListener(checkListener)
        

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
            //검색 결과
            searchValue= data?.getStringExtra("searchValue")

            //새로운 검색 결과로 adapter list 업그레이드 해주고, 다시 화면에 그려줌.
            restaurantInfo=helper.search(searchValue,searchValue)
            adapter.listShop=restaurantInfo
            binding.recycleView.adapter=adapter
            binding.recycleView.layoutManager=LinearLayoutManager(this)

            Log.d("result","결과값 : ${restaurantInfo}")
        }
    }
}