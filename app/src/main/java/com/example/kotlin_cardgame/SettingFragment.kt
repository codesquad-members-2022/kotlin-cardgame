package com.example.kotlin_cardgame

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.kotlin_cardgame.data.UserInfo
import com.example.kotlin_cardgame.util.ImageUtil

class SettingFragment(private val intent: Intent) : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_setting, container, false)

        val ivCharacter: ImageView = v.findViewById(R.id.iv_setting_character_image)
        val tvNickname: TextView = v.findViewById(R.id.tv_setting_nickname)
        val btnHelp: Button = v.findViewById(R.id.btn_help)

        val data: UserInfo = intent.getSerializableExtra("userInfo") as UserInfo
        ivCharacter.setImageBitmap(ImageUtil.convertByteArrayToDrawable(data.byteArrayOfImage))
        tvNickname.text = data.nickname

        val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://codesquad.kr/"))
        btnHelp.setOnClickListener {
            startActivity(webIntent)
        }

        return v
    }
}