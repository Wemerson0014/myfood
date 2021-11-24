package com.estudo.myfood.views

import android.view.ViewGroup
import co.tiagoaguiar.atway.ui.adapter.ATViewHolder
import com.estudo.myfood.R
import com.estudo.myfood.databinding.MoreShopItemBinding
import com.estudo.myfood.databinding.ShopItemBinding
import com.estudo.myfood.models.MoreShop
import com.estudo.myfood.models.Shop
import com.squareup.picasso.Picasso

class MoreShopView(viewGroup: ViewGroup) : ATViewHolder<MoreShop, MoreShopItemBinding>(
    MoreShopItemBinding::inflate,
    viewGroup
) {

    override fun bind(item: MoreShop) {
        Picasso.get()
            .load(item.bannerUrl)
            .into(binding.imgShop)

        binding.textShop.text = item.text
        binding.textStar.text = item.rate.toString()
        binding.textSubtitle.text = itemView.context.getString(R.string.shop_category, item.category, item.distance)
        binding.textPrice.text = itemView.context.getString(R.string.shop_price, item.time, item.price)
    }
}