package com.example.kotlin_cardgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ViewTreeObserver
import androidx.core.widget.addTextChangedListener
import com.example.kotlin_cardgame.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var selectedEmotion: Emotion? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setImageButtonSize()
        disableImageButton()

        nicknameEditTextListening()
        emotionViewsClickListening()
        nextButtonListening()
    }

    private fun nextButtonListening() {
        binding.nextButton.setOnClickListener {
            if (selectedEmotion == null) {
                Snackbar.make(binding.rootLayout, "표정을 먼저 선택해주세요", Snackbar.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("emotion", selectedEmotion)
                startActivity(intent)
            }
        }
    }

    private fun disableImageButton() {
        binding.smileImageButton.isEnabled = false
        binding.neutralImageButton.isEnabled = false
        binding.dissatisfiedImageButton.isEnabled = false
        binding.badImageButton.isEnabled = false
    }

    private fun changeEmotionImage(emotion: Emotion?) {
        selectedEmotion = emotion

        if (emotion == null) binding.emotionImageView.setImageBitmap(null)
        else if (emotion == Emotion.SMILE) binding.emotionImageView.setImageResource(R.drawable.baseline_mood_24)
        else if (emotion == Emotion.NEUTRAL) binding.emotionImageView.setImageResource(R.drawable.baseline_sentiment_neutral_24)
        else if (emotion == Emotion.DISSATISFIED) binding.emotionImageView.setImageResource(R.drawable.baseline_sentiment_very_dissatisfied_24)
        else if (emotion == Emotion.BAD) binding.emotionImageView.setImageResource(R.drawable.baseline_mood_bad_24)
    }

    private fun emotionViewsClickListening() {
        binding.smileImageButton.setOnClickListener { changeEmotionImage(Emotion.SMILE) }
        binding.neutralImageButton.setOnClickListener { changeEmotionImage(Emotion.NEUTRAL) }
        binding.dissatisfiedImageButton.setOnClickListener { changeEmotionImage(Emotion.DISSATISFIED) }
        binding.badImageButton.setOnClickListener { changeEmotionImage(Emotion.BAD) }
    }


    private fun nicknameEditTextListening() {
        binding.nicknameEditText.addTextChangedListener {
            // 버튼 활성화 및 비활성화
            val isClickable: Boolean = isNicknameAble(binding.nicknameEditText.text.toString())
            setEmotionButtonEnable(isClickable)

            // 이모션 클릭상태에서도 잘못된 글자 입력시 이미지 없애기
            if (!isClickable) changeEmotionImage(null)
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




