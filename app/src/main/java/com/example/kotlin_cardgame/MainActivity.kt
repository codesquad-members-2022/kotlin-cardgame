package com.example.kotlin_cardgame

import android.app.ActionBar
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.view.ViewTreeObserver
import androidx.core.content.res.ResourcesCompat
import androidx.core.widget.addTextChangedListener
import com.example.kotlin_cardgame.databinding.ActivityMainBinding

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setImageButtonSize()
        disableImageButton()

        nicknameEditTextListening()

        emotionViewsClickListening()


    }

    private fun disableImageButton() {
        binding.smileImageButton.isEnabled = false
        binding.neutralImageButton.isEnabled = false
        binding.dissatisfiedImageButton.isEnabled = false
        binding.badImageButton.isEnabled = false
    }

    private fun emotionViewsClickListening() {

        binding.smileImageButton.setOnClickListener { binding.emotionImageView.setImageResource(R.drawable.baseline_mood_24) }
        binding.neutralImageButton.setOnClickListener { binding.emotionImageView.setImageResource(R.drawable.baseline_sentiment_neutral_24) }
        binding.dissatisfiedImageButton.setOnClickListener {
            binding.emotionImageView.setImageResource(
                R.drawable.baseline_sentiment_very_dissatisfied_24
            )
        }
        binding.badImageButton.setOnClickListener { binding.emotionImageView.setImageResource(R.drawable.baseline_mood_bad_24) }

    }

    private fun nicknameEditTextListening() {
        binding.nicknameEditText.addTextChangedListener {
            // 버튼 활성화 및 비활성화
            val isClickable: Boolean = isNicknameAble(binding.nicknameEditText.text.toString())
            setEmotionButtonEnable(isClickable)

            // 이모션 클릭상태에서도 잘못된 글자 입력시 이미지 없애기
            if (!isClickable) binding.emotionImageView.setImageBitmap(null)
        }
    }

    private fun isNicknameAble(text: String): Boolean {
        // 제외사항
        // 빈칸일경우
        // 5자가 넘을 경우
        // 공백이나 특수문자가 있을 경우
        // 숫자만 있을경우
        // 알파벳이 한글자라도 포함 되지 않는경우

        return if (text.isEmpty() || text.length > 5) false
        else if (text.any { !it.isLetterOrDigit() }) false
        else if (text.all { it.isDigit() }) false
        else !text.none { it in 'a'..'z' || it in 'A'..'Z' }
    }


    private fun setImageButtonSize() {

        val viewDrawingListener = object : ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                Log.d(TAG, binding.smileImageButton.width.toString())
                binding.smileImageButton.layoutParams.height = binding.smileImageButton.width
                binding.smileImageButton.requestLayout()
                binding.smileImageButton.viewTreeObserver.removeOnGlobalLayoutListener(this)
            }
        }
        binding.smileImageButton.viewTreeObserver.addOnGlobalLayoutListener(viewDrawingListener)
    }


    private fun setEmotionButtonEnable(isClickable: Boolean) {
        binding.smileImageButton.isEnabled = isClickable
        binding.neutralImageButton.isEnabled = isClickable
        binding.dissatisfiedImageButton.isEnabled = isClickable
        binding.badImageButton.isEnabled = isClickable
    }
}




