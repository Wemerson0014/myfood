package com.estudo.myfood.views

import android.view.ViewGroup
import co.tiagoaguiar.atway.ui.adapter.ATViewHolder
import com.estudo.myfood.databinding.ShopItemBinding
import com.estudo.myfood.models.Shop
import com.squareup.picasso.Picasso

class ShopView(viewGroup: ViewGroup) : ATViewHolder<Shop, ShopItemBinding>(
    ShopItemBinding::inflate,
    viewGroup
) {

    override fun bind(item: Shop) {
        Picasso.get()
            .load(item.bannerUrl)
            .into(binding.imgShop)

        binding.textShop.text = item.text
    }
}