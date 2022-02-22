package com.example.kotlin_cardgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.kotlin_cardgame.databinding.ActivitySubBinding

class SubActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySubBinding
    private lateinit var gameFragment: Fragment
    private lateinit var settingFragment: Fragment
    private val fragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubBinding.inflate(layoutInflater)
        setContentView(binding.root)

        gameFragment = GameFragment()
        settingFragment = SettingFragment(intent)

        binding.btnGame.setOnClickListener(click)
        binding.btnSetting.setOnClickListener(click)
    }

    private val click = View.OnClickListener {
        val fragmentTransaction = fragmentManager.beginTransaction()
        var tmpFragment: Fragment? = null
        when (it?.id) {
            R.id.btn_game -> tmpFragment = gameFragment
            R.id.btn_setting -> tmpFragment = settingFragment
        }

        tmpFragment?.let {
            fragmentTransaction.replace(
                R.id.fragment_container_view_tag,
                tmpFragment
            ).commit()
        }
    }
}