package com.estudo.myfood

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class TabViewPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {

    val tabs = arrayOf(R.string.restaurants, R.string.marketplaces, R.string.drinks)
    val fragments = arrayOf(RestaurantFragment(), MarketPlaceFragment(), MarketPlaceFragment())

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}