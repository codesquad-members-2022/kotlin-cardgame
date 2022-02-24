package com.example.kotlin_cardgame

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kotlin_cardgame.data.UserInfo
import com.example.kotlin_cardgame.databinding.FragmentSettingBinding
import com.example.kotlin_cardgame.util.ImageUtil

class SettingFragment(private val intent: Intent) : Fragment() {

    private var _binding: FragmentSettingBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSettingBinding.inflate(inflater, container, false)

        val data: UserInfo = intent.getSerializableExtra("userInfo") as UserInfo
        val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://codesquad.kr/"))
        with(binding) {
            ivSettingCharacterImage.setImageBitmap(ImageUtil.convertByteArrayToDrawable(data.byteArrayOfImage))
            tvSettingNickname.text = data.nickname
            btnHelp.setOnClickListener {
                startActivity(webIntent)
            }
        }

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
