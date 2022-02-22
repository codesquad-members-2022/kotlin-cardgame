package com.codesquad.kotilin_cardgame

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)
        val profileImage = intent.getByteArrayExtra("profileImage")!!.let {
            BitmapFactory.decodeByteArray(it, 0, it.size)
        }
        val nickname = intent.getStringExtra("nickname")!!
        val toolbar = findViewById<Toolbar>(R.id.toolbar_cardgame)
        val settingBtn = findViewById<Button>(R.id.btn_fragment_setting)
        val gameBtn = findViewById<Button>(R.id.btn_fragment_game)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24)
        switchToSetting(settingBtn, nickname, profileImage)
        switchToGame(gameBtn)
    }

    fun switchToSetting(settingBtn: Button, nickname: String, profileImage: Bitmap) {
        settingBtn.setOnClickListener {
            val settingFragment = SettingFragment()
            settingFragment.setNickName(nickname)
            settingFragment.setImage(profileImage)
            supportFragmentManager.beginTransaction().replace(R.id.frame_sub, settingFragment)
                .commit()
        }
    }
    fun switchToGame(gameBtn:Button){
        gameBtn.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.frame_sub, GameFragment())
                .commit()
        }
    }
}