package com.estudo.myfood.fragments

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import co.tiagoaguiar.atway.ui.adapter.ATAdapter
import com.estudo.myfood.FilterItem
import com.estudo.myfood.R
import com.estudo.myfood.databinding.FragmentRestaurantBinding
import com.estudo.myfood.models.Banner
import com.estudo.myfood.models.Category
import com.estudo.myfood.models.MoreShop
import com.estudo.myfood.models.Shop
import com.estudo.myfood.toChip
import com.estudo.myfood.views.BannerView
import com.estudo.myfood.views.CategoryView
import com.estudo.myfood.views.MoreShopView
import com.estudo.myfood.views.ShopView

class RestaurantFragment : Fragment(R.layout.fragment_restaurant) {

    private var binding: FragmentRestaurantBinding? = null

    private var position: Int? = RecyclerView.NO_POSITION
    private var snapHelper = LinearSnapHelper()

    private val categoryAdapter = ATAdapter({ CategoryView(it) })
    private val bannerAdapter = ATAdapter({ BannerView(it) })
    private val shopAdapter = ATAdapter({ ShopView(it) })
    private val moreShopAdapter = ATAdapter({ MoreShopView(it)})

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

        bannerAdapter.items = arrayListOf(
            Banner(
                1,
                "https://static-images.ifood.com.br/image/upload/t_high/discoveries/SonoiFood2_RnZj.png"
            ),
            Banner(
                2,
                "https://static-images.ifood.com.br/image/upload/t_high/discoveries/itensBasicosNOV21mercadoPrincipal1_CyZb.png"
            ),
            Banner(
                3,
                "https://static-images.ifood.com.br/image/upload/t_high/discoveries/Bebidas40offMercadoPrincipal_uFsl.png"
            )
        )

        shopAdapter.items = arrayListOf(Shop(1, "https://static-images.ifood.com.br/image/upload/t_thumbnail/logosgde/201910292243_94aaf166-84cc-4ebf-a35d-d223be34d01f.png","Coco Bambu"),
        Shop(2, "https://static-images.ifood.com.br/image/upload/t_thumbnail/logosgde/d4a3984f-2b73-4f46-99df-1d6bc79ff293/202001031317_CXpO_i.png", "China In Box"),
        Shop(3, "https://static-images.ifood.com.br/image/upload/t_thumbnail/logosgde/201801231937__HABIB_VERDE.jpg", "Habib's"),
        Shop(4, "https://static-images.ifood.com.br/image/upload/t_thumbnail/logosgde/201906182008_2b157a73-7564-4733-94c1-8d0376e7bb39.png", "Outback"),
        Shop(5, "https://static-images.ifood.com.br/image/upload/t_thumbnail/logosgde/Logo%20McDonald_MCDON_DRIV15.jpg", "MCdonalds")
        )

        moreShopAdapter.items = arrayListOf(
            MoreShop(1, "https://static-images.ifood.com.br/image/upload/t_high/logosgde/46ebd05c-116e-41cd-b3de-7a05c5bc730a/201811071958_30656.jp", "Pizza Crek", 4.4, "Pizza", 11.2, "60-70", 26.00),

            MoreShop(2, "https://static-images.ifood.com.br/image/upload/t_high/logosgde/bb3ad636-7c36-4ae2-a1bd-14cd35695350/202001271029_rk15_i.png", "Fábrica de Esfiha", 4.3, "Esfiha", 12.2, "60-70", 9.00),

            MoreShop(3, "https://static-images.ifood.com.br/image/upload/t_high/logosgde/2fd863ac-4cc2-476c-8896-99aedfdaeb5f/201911150948_Z9QG_i.jpg", "Pecorino", 4.9, "Grill", 17.2, "60-70", 10.00),

            MoreShop(4, "https://static-images.ifood.com.br/image/upload/t_high/logosgde/86b58685-a7dc-4596-be26-2c4037b4d591/202006051304_JuRt_i.jpg", "Barbacoa Grill", 4.9, "Grill", 12.2, "70-90", 40.00),

            MoreShop(5, "https://static-images.ifood.com.br/image/upload/t_high/logosgde/e2f3424a-06fb-46dd-89c3-f7b039e2b1f0_BOLOD_PPIN02.jpeg", "Bolo de Madre", 4.7, "Bolo", 11.0, "80-90", 30.00),

            MoreShop(6, "https://static-images.ifood.com.br/image/upload/t_high/logosgde/201901021647_8066dc64-9383-46d1-aa2d-56b942e27ed.png", "Uau Esfiha", 4.4, "Esfiha", 11.2, "60-70", 8.00),

            MoreShop(7, "https://static-images.ifood.com.br/image/upload/t_high/logosgde/201705131248_0ca51a98-ee95-48ac-b193-48066c8f20cc.png", "Bar do Juarez", 4.9, "Bar", 17.2, "40-50", 13.00)

        )

        binding = FragmentRestaurantBinding.bind(view)
        binding?.let {

            it.rvCategory.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            it.rvCategory.adapter = categoryAdapter

            it.rvBanners.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

            it.rvShops.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            it.rvShops.adapter = shopAdapter

            it.rvMoreShops.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            it.rvMoreShops.adapter = moreShopAdapter

            it.rvBanners.adapter = bannerAdapter
            it.rvBanners.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                        notifyPositionChanged(recyclerView)
                    }
                }
            })

            addDots(it.dots, bannerAdapter.items.size, 0)

            filters.forEach { filter ->
                it.chipGroupFilter.addView(filter.toChip(requireContext()))
            }
        }
    }

    private fun notifyPositionChanged(recyclerView: RecyclerView) {
        val layoutManager = recyclerView.layoutManager
        val view = snapHelper.findSnapView(layoutManager)
        val position = if (view == null) RecyclerView.NO_POSITION else layoutManager?.getPosition(view)

        val positionChanged = this.position != position
        if (positionChanged) {
            addDots(binding!!.dots, bannerAdapter.items.size, position ?: 0)
        }
        this.position = position
    }

    private fun addDots(container: LinearLayout, size: Int, position: Int) {
        container.removeAllViews()

        Array(size) {
            val textView = TextView(context).apply {
                text = getString(R.string.dotted)
                textSize = 20f
                setTextColor(
                    if (position == it) ContextCompat.getColor(context, android.R.color.black)
                    else ContextCompat.getColor(context, android.R.color.darker_gray)
                )
            }
            container.addView(textView)
        }
    }
}