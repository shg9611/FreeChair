package com.example.freechair

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
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
        // 가게 아이콘 표시부
        if (restaurant.elevator.equals("Y")){
            binding.elevator.setColorFilter(Color.parseColor("#006400"))
        }
        else{
            binding.elevator.setColorFilter(Color.parseColor("#B22222"))
        }
        if (restaurant.heightDiffer.equals("Y")){
            binding.stair.setColorFilter(Color.parseColor("#006400"))
        }
        else{
            binding.stair.setColorFilter(Color.parseColor("#B22222"))
        }
        if (restaurant.ramp.equals("Y")){
            binding.ramp.setColorFilter(Color.parseColor("#006400"))
        }
        else{
            binding.ramp.setColorFilter(Color.parseColor("#B22222"))
        }
        if (restaurant.restroom.equals("Y")){
            binding.restRoom.setColorFilter(Color.parseColor("#006400"))
        }
        else{
            binding.restRoom.setColorFilter(Color.parseColor("#B22222"))
        }

    }
}