package com.codesquad_Han.kotlin_cardgame

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.codesquad_Han.kotlin_cardgame.databinding.FragmentGameOptionBinding
import com.codesquad_Han.kotlin_cardgame.databinding.FragmentGamePlayBinding

class GamePlayFragment : Fragment() {

    private var _binding: FragmentGamePlayBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGamePlayBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}