package com.example.kotlin_cardgame.fragment

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kotlin_cardgame.databinding.FragmentSettingBinding

class SettingFragment : Fragment() {
    private var _binding: FragmentSettingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSettingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bitmap: Bitmap? = this.arguments?.getParcelable("first")
//        val bitmap = bundle?.getParcelable<Bitmap>("first")
//        Log.d("test", bundle.toString())
        Log.d("test", bitmap.toString())
        val resource = this.resources
        val drawable = BitmapDrawable(resource, bitmap)
        binding.settingFragmentImageView.background = drawable
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null // 바인딩 클래스는 뷰에 대한 참조를 가지고 있는데 뷰가 제거될 때 즉 onDestroyView() 메서드가 작동할 때 이 바인딩 클래스의 인스턴스도 같이 정리
    }
}