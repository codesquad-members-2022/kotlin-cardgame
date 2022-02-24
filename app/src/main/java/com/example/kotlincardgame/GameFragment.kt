package com.example.kotlincardgame

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.navigation.findNavController
import com.example.kotlincardgame.databinding.FragmentGameBinding

class GameFragment : BaseFragment<FragmentGameBinding>(FragmentGameBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val share = Login()
        binding.btnBack.text = "이전"
        binding.btnBack.setOnClickListener {
//            val fragmentManager = activity?.supportFragmentManager
//            fragmentManager?.beginTransaction()?.remove(this)?.commit()
//            fragmentManager?.popBackStack()
//            val nextButton = activity?.findViewById<Button>(R.id.btn_next)
//            nextButton?.visibility = View.VISIBLE
            val login = Login()
            context?.let {
                login.removeAllAttribute(requireContext())
            }
            view.findNavController().navigate(R.id.make_character)
        }
        context?.let {
            val context = requireContext()
            checkUser(
                view,
                share.getAttribute(context, "userName"),
                binding.textNickname,
                binding.character,
                share.getAttribute(context, "resName"),
                context.packageName
            )
        }
    }
}