package com.training.ihero.ui

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.training.ihero.databinding.ItemListBinding
import com.training.ihero.dto.HeroDto
import com.training.ihero.response.HeroListElement

class MyHolder(val view : View) : RecyclerView.ViewHolder(view) {
    val binding = ItemListBinding.bind(view)
    fun bind( hero: HeroListElement){
        binding.tvAtributo.text = hero.attrPrimary
        binding.tvName.text = hero.nameGame
        Log.d("HERO", hero.image)
        //Picasso.get().load(hero.image).centerCrop().into(binding.ivCover)
    }
}