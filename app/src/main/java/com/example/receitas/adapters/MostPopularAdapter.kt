package com.example.receitas.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.receitas.databinding.PopularItemsBinding
import com.example.receitas.models.MealsByCategory

class MostPopularAdapter() : RecyclerView.Adapter<MostPopularAdapter.PopularMealViewHolder> (){
    lateinit var onItemCLick:((MealsByCategory)->Unit)
    private var mealsList = ArrayList<MealsByCategory>()

    fun setMeals(mealsList: ArrayList<MealsByCategory>){
        this.mealsList = mealsList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularMealViewHolder {
        return PopularMealViewHolder(PopularItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: PopularMealViewHolder, position: Int) {
        Glide.with(holder.itemView)
            .load(mealsList[position].strMealThumb)
            .into(holder.binding.imgPopular)

        holder.itemView.setOnClickListener {
            onItemCLick.invoke(mealsList[position])
        }
    }

    override fun getItemCount(): Int {
        return mealsList.size
    }

    class PopularMealViewHolder(var binding: PopularItemsBinding) : RecyclerView.ViewHolder(binding.root)
}