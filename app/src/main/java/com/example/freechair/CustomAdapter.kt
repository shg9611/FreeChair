package com.example.freechair

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.freechair.databinding.ItemRecyclerBinding

class CustomAdapter:RecyclerView.Adapter<Holder>() {

    var listShop=mutableListOf<Restaurant>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding=ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Holder(binding)

    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val restaurant=listShop.get(position)
        holder.setShop(restaurant)

    }

    override fun getItemCount(): Int {
        return listShop.size
    }
}

class Holder(val binding:ItemRecyclerBinding): RecyclerView.ViewHolder(binding.root){
    fun setShop(restaurant: Restaurant){//가게 정보 draw. 리사이클러뷰.
        binding.shopName.text="${restaurant.name}"
        binding.shopPhonenum.text="${restaurant.phoneNo}"
        binding.address.text="${restaurant.address}"
        binding.guName.text="${restaurant.gu}"
        /* 가게 아이콘 표시부 구현 대기중
        if (shop.elevator=='Y'){
            binding.elevator.setBackgroundColor()
        }
        else{
        
        }
           */
    }
}