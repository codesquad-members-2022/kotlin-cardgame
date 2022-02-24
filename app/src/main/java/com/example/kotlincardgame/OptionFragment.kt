package com.example.kotlincardgame

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.kotlincardgame.databinding.FragmentOptionBinding


class OptionFragment : BaseFragment<FragmentOptionBinding>(FragmentOptionBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val share = Login()
        context?.let {
            val context = requireContext()
            checkUser(
                view,
                share.getAttribute(context, "userName"),
                binding.userName,
                binding.userCharacter,
                share.getAttribute(context, "resName"),
                context.packageName
            )
        }
        binding.help.setOnClickListener {
            val urlIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://codesquad.kr/"))
            startActivity(urlIntent)
        }
    }
}