package com.example.kotlin_cardgame.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.kotlin_cardgame.R

class SettingFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_setting, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val settingFragmentImageView = view.findViewById<ImageView>(R.id.setting_fragment_imageView)
        val keySet = this.arguments?.keySet()

        if (keySet != null) {
            when {
                "firstBundle" in keySet -> {
                    val drawable = this.arguments?.getInt("firstBundle")
                    if (drawable != null) {
                        settingFragmentImageView.setImageResource(drawable)
                    }
                }
                "secondBundle" in keySet -> {
                    val drawable = this.arguments?.getInt("secondBundle")
                    if (drawable != null) {
                        settingFragmentImageView.setImageResource(drawable)
                    }
                }
                "thirdBundle" in keySet -> {
                    val drawable = this.arguments?.getInt("thirdBundle")
                    if (drawable != null) {
                        settingFragmentImageView.setImageResource(drawable)
                    }
                }
                "fourthBundle" in keySet -> {
                    val drawable = this.arguments?.getInt("fourthBundle")
                    if (drawable != null) {
                        settingFragmentImageView.setImageResource(drawable)
                    }
                }
            }
        }
    }
}