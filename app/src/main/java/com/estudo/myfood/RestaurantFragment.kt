package com.estudo.myfood

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.estudo.myfood.databinding.FragmentRestaurantBinding

class RestaurantFragment : Fragment(R.layout.fragment_restaurant) {

    private var binding: FragmentRestaurantBinding? = null

    private var filters = arrayOf(
        FilterItem(0, "Ordernar", closeIcon = R.drawable.ic_baseline_keyboard_arrow_down_24),
        FilterItem(1, "Pra retirar", icon = R.drawable.ic_baseline_directions_walk_24),
        FilterItem(2, "Entrega Grátis"),
        FilterItem(3, "Vale-refeição", R.drawable.ic_baseline_keyboard_arrow_down_24),
        FilterItem(4, "Distância", R.drawable.ic_baseline_keyboard_arrow_down_24),
        FilterItem(5, "Entrega Parceira"),
        FilterItem(6, "Super Restaurante"),
        FilterItem(7, "Filtros", R.drawable.ic_baseline_filter_list_24),
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentRestaurantBinding.bind(view)
        binding?.let {
            filters.forEach { filter ->
                it.chipGrouoFilter.addView(filter.toChip(requireContext()))
            }
        }
    }
}