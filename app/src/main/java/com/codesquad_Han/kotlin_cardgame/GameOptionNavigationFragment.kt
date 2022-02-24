package com.codesquad_Han.kotlin_cardgame

import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.codesquad_Han.kotlin_cardgame.databinding.FragmentGameOptionBinding
import com.codesquad_Han.kotlin_cardgame.databinding.FragmentGameOptionNavigationBinding
import com.codesquad_Han.kotlin_cardgame.model.CharacterData

class GameOptionNavigationFragment : Fragment() {

    private val gameViewModel: GameNavigationViewModel by activityViewModels()
    private var _binding: FragmentGameOptionNavigationBinding? = null
    private val binding get() = _binding!!
    private lateinit var characterData: CharacterData

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGameOptionNavigationBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(
            "AppTest",
            "$this / ${gameViewModel.characterNickname}, ${gameViewModel.characterImageByteArray}"
        )

        setCharacterData()
        setBtn()
    }

    fun setCharacterData() {
        binding.tvNickName.text = gameViewModel.characterNickname
        val byteArray = gameViewModel.characterImageByteArray
        val bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)
        binding.ivCharacter.setImageBitmap(bitmap)
    }

    fun setBtn() {
        binding.btnHelp.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://codesquad.kr/"))
            startActivity(intent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}