package com.codesquard.kotlincardgame

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class CharacterFragment : Fragment() {
    lateinit var charImageView: ImageView
    lateinit var charText: TextView
    lateinit var charBtn: Button
    lateinit var nickname: String
    lateinit var image: ByteArray

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_character, container, false)
        charImageView = view.findViewById(R.id.imageView_character)
        charText = view.findViewById(R.id.text_character)
        charBtn = view.findViewById(R.id.button_character)
        clickBtnToWeb()
        charText.text = nickname
        charImageView.setImageBitmap(byteToBitmap())
        return view
    }

    private fun byteToBitmap(): Bitmap {
        return image.let { BitmapFactory.decodeByteArray(image, 0, it.size) }
    }

    private fun clickBtnToWeb() {
        charBtn.setOnClickListener {
            val webpage: Uri = Uri.parse("https://codesquad.kr/")
            val intent = Intent(Intent.ACTION_VIEW, webpage)
            startActivity(intent)
        }
    }

    fun getTextAndImage(nickname: String, image: ByteArray) {
        this.nickname = nickname
        this.image = image
    }

    /*
    문제가 발생하는 코드
    private fun setTextAndImage() {
        val nickname: String? = arguments?.getString("name")
        val image: ByteArray? = arguments?.getByteArray("char")
    }*/

}