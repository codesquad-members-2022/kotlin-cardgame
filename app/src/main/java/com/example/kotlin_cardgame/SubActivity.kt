package com.example.kotlin_cardgame

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.kotlin_cardgame.databinding.ActivitySubBinding
import com.example.kotlin_cardgame.fragment.GameFragment
import com.example.kotlin_cardgame.fragment.SettingFragment
import com.google.android.material.tabs.TabLayoutMediator

class SubActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySubBinding

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val pagerAdapter = PagerAdapter(this)
        binding.viewPager2.adapter = pagerAdapter

        val tabTitles = listOf("게임", "설정")
        val tabIcons = getDrawable(R.drawable.ic_baseline_notifications_24)

        // TabLayout 과 ViewPager 연결
        TabLayoutMediator(binding.navigationBar, binding.viewPager2) { tab, position ->
            tab.icon = tabIcons
            tab.text = tabTitles[position]
        }.attach()
    }

    private inner class PagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int = 2

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> GameFragment()
                else -> SettingFragment()
            }
        }
    }
}