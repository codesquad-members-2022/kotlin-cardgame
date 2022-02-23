package com.codesquard.kotlincardgame

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
        setTextAndImage()
        return view
    }

    private fun clickBtnToWeb() {
        charBtn.setOnClickListener {
            val webpage: Uri = Uri.parse("https://codesquad.kr/")
            val intent = Intent(Intent.ACTION_VIEW,webpage)
            startActivity(intent)
        }
    }

    fun getTextAndImage(nickname: String, image: ByteArray) {
        this.nickname = nickname
        this.image = image
    }

    private fun setTextAndImage() {
        val nickname: String? = arguments?.getString("name")
        val image:ByteArray? = arguments?.getByteArray("char")
    }

}