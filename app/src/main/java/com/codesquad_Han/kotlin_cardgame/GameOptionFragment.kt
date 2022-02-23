package com.codesquad_Han.kotlin_cardgame

import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.codesquad_Han.kotlin_cardgame.databinding.FragmentGameOptionBinding
import com.codesquad_Han.kotlin_cardgame.model.CharacterData

class GameOptionFragment : Fragment() {

    private val gameViewModel : GameViewModel by activityViewModels()
    private var _binding : FragmentGameOptionBinding? = null
    private val binding get() = _binding!!
    private lateinit var characterData : CharacterData

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGameOptionBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("AppTest", "$this / ${gameViewModel.characterNickname}, ${gameViewModel.characterImageByteArray}")

        setCharacterData()
        setBtn()
    }

    fun setCharacterData(){
        binding.tvNickName.text = gameViewModel.characterNickname
        val byteArray = gameViewModel.characterImageByteArray
        val bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)
        binding.ivCharacter.setImageBitmap(bitmap)
    }

    fun setBtn(){

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}