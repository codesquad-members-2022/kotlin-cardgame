package com.example.kotlin_cardgame

import android.annotation.SuppressLint
import android.graphics.BlendMode
import android.graphics.BlendModeColorFilter
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.kotlin_cardgame.databinding.ActivitySubBinding
import com.example.kotlin_cardgame.fragment.GameFragment
import com.example.kotlin_cardgame.fragment.SettingFragment
import com.google.android.material.tabs.TabLayout
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

        val white = getColor(R.color.white)
        val black = getColor(R.color.black)
        val tabIcons = getDrawable(R.drawable.ic_baseline_notifications_24)

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            @RequiresApi(Build.VERSION_CODES.Q) // minSdkVersion 이 지정한 버전보다 낮을 경우 바로 호출시에는 컴파일 에러 발생 (setColorFilter 메소드가 deprecated 되면서 필요)
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.icon?.colorFilter = BlendModeColorFilter(white, BlendMode.SRC_IN)
            }

            @RequiresApi(Build.VERSION_CODES.Q)
            override fun onTabUnselected(tab: TabLayout.Tab?) {
                tab?.icon?.colorFilter = BlendModeColorFilter(black, BlendMode.SRC_IN)
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })

        // TabLayout 과 ViewPager 연결
        TabLayoutMediator(binding.tabLayout, binding.viewPager2) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "게임"
                    tab.icon = tabIcons
                }
                1 -> {
                    tab.text = "설정"
                    tab.icon = tabIcons
                }
            }
        }.attach()
    }

    private inner class PagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int = 2

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> {
                    val bundle = Bundle()
                    bundle.putString("test", "textView")
                    Log.d("test1", bundle.toString())
                    val gameFragment = GameFragment()
                    gameFragment.arguments = bundle
                    gameFragment
                }
                else -> {
                    val settingFragment = SettingFragment()
                    when {
                        intent.hasExtra("firstIntent") -> {
                            val bundle = intent.getBundleExtra("firstIntent")
                            settingFragment.arguments = bundle
                        }
                        intent.hasExtra("secondIntent") -> {
                            val bundle = intent.getBundleExtra("secondIntent")
                            settingFragment.arguments = bundle
                        }
                        intent.hasExtra("thirdIntent") -> {
                            val bundle = intent.getBundleExtra("thirdIntent")
                            settingFragment.arguments = bundle
                        }
                        intent.hasExtra("fourthIntent") -> {
                            val bundle = intent.getBundleExtra("fourthIntent")
                            settingFragment.arguments = bundle
                        }
                    }
                    settingFragment
                }
            }
        }
    }
}