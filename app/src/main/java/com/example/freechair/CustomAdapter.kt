package com.example.freechair

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.freechair.databinding.ItemRecyclerBinding

class CustomAdapter(var context: Context):RecyclerView.Adapter<CustomAdapter.Holder>() {

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

    inner class Holder(val binding:ItemRecyclerBinding): RecyclerView.ViewHolder(binding.root){

        var currentRestaurant:Restaurant? =null

        init {
            binding.listBackground.setOnClickListener{

                val intentShopInfo=Intent(context,ShopInfoActivity::class.java)

                intentShopInfo.putExtra("name","${currentRestaurant?.name}")
                intentShopInfo.putExtra("phoneNo","${currentRestaurant?.phoneNo}")
                intentShopInfo.putExtra("address","${currentRestaurant?.address}")
                intentShopInfo.putExtra("gu","${currentRestaurant?.gu}")
                intentShopInfo.putExtra("elevator","${currentRestaurant?.elevator}")
                intentShopInfo.putExtra("stair","${currentRestaurant?.heightDiffer}")
                intentShopInfo.putExtra("ramp","${currentRestaurant?.ramp}")
                intentShopInfo.putExtra("restRoom","${currentRestaurant?.restroom}")

                context.startActivity(intentShopInfo)
            }
        }


        fun setShop(restaurant: Restaurant){//가게 정보 draw. 리사이클러뷰.
            binding.shopName.text="${restaurant.name}"
            binding.shopPhonenum.text="${restaurant.phoneNo}"
            binding.address.text="${restaurant.address}"
            binding.guName.text="${restaurant.gu}"

            this.currentRestaurant=restaurant

            // 가게 아이콘 표시부
            if (restaurant.elevator.equals("Y")){
                binding.elevator.setColorFilter(Color.parseColor("#006400"))
                binding.elevator.alpha=1.0F
            }
            else{
                binding.elevator.setColorFilter(Color.parseColor("#B22222"))
                binding.elevator.alpha=0.2F
            }
            if (restaurant.heightDiffer.equals("Y")){
                binding.stair.setColorFilter(Color.parseColor("#006400"))
                binding.stair.alpha=1.0F
            }
            else{
                binding.stair.setColorFilter(Color.parseColor("#B22222"))
                binding.stair.alpha=0.2F
            }
            if (restaurant.ramp.equals("Y")){
                binding.ramp.setColorFilter(Color.parseColor("#006400"))
                binding.ramp.alpha=1.0F
            }
            else{
                binding.ramp.setColorFilter(Color.parseColor("#B22222"))
                binding.ramp.alpha=0.2F
            }
            if (restaurant.restroom.equals("Y")){
                binding.restRoom.setColorFilter(Color.parseColor("#006400"))
                binding.restRoom.alpha=1.0F
            }
            else{
                binding.restRoom.setColorFilter(Color.parseColor("#B22222"))
                binding.restRoom.alpha=0.2F
            }

        }
    }
}

