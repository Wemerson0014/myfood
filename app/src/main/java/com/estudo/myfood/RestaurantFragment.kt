package com.estudo.myfood

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import co.tiagoaguiar.atway.ui.adapter.ATAdapter
import com.estudo.myfood.databinding.FragmentRestaurantBinding

class RestaurantFragment : Fragment(R.layout.fragment_restaurant) {

    private var binding: FragmentRestaurantBinding? = null

    private val categoryAdapter = ATAdapter({ CategoryView(it) })

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

        categoryAdapter.items = arrayListOf(
            Category(
                1,
                "https://www.ifood.com.br/static/images/categories/market.png",
                "Mercado",
                0xFFB6D048
            ),
            Category(
                2,
                "https://www.ifood.com.br/static/images/categories/restaurant.png",
                "Restaurante",
                0xFFE91D2D
            ),
            Category(
                3,
                "https://www.ifood.com.br/static/images/categories/drinks.png",
                "Bebidas",
                0xFFF6D553
            ),
            Category(
                4,
                "https://static-images.ifood.com.br/image/upload/f_auto/webapp/landingV2/express.png",
                "Express",
                0xFFFF0000
            ),
            Category(
                5,
                "https://parceiros.ifood.com.br/static/media/salad.9db040c0.png",
                "Saudável",
                0xFFE91D2D
            ),
            Category(
                6,
                "https://static-images.ifood.com.br/image/upload/t_high/discoveries/Salgados-out_20_o4cW.jpg",
                "Salgados",
                0xFF8C60C5
            )
        )

        binding = FragmentRestaurantBinding.bind(view)
        binding?.let {

            it.rvCategory.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            it.rvCategory.adapter = categoryAdapter

            filters.forEach { filter ->
                it.chipGrouoFilter.addView(filter.toChip(requireContext()))
            }
        }
    }
}