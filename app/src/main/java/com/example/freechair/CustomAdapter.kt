package com.example.freechair

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.freechair.databinding.ItemRecyclerBinding

class CustomAdapter:RecyclerView.Adapter<Holder>() {

    var listShop=mutableListOf<shopInfo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding=ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Holder(binding)

    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val shop=listShop.get(position)
        holder.setShop(shop)

    }

    override fun getItemCount(): Int {
        return listShop.size
    }
}

class Holder(val binding:ItemRecyclerBinding): RecyclerView.ViewHolder(binding.root){
    fun setShop(shop:shopInfo){//가게 정보 draw. 리사이클러뷰.
        binding.shopName.text="${shop.name}"
        binding.shopPhonenum.text="${shop.phoneNum}"
        binding.address.text="${shop.address}"
        binding.guName.text="${shop.guName}"
        /* 가게 아이콘 표시부 구현 대기중
        if (shop.elevator=='Y'){
            binding.elevator.setBackgroundColor()
        }
        else{
        
        }
           */
    }
}