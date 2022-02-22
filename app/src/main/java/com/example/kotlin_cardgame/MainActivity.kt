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

        setRadioButtonSize()
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
        binding.smileRadioButton.isEnabled = false
        binding.neutralRadioButton.isEnabled = false
        binding.dissatisfiedRadioButton.isEnabled = false
        binding.badRadioButton.isEnabled = false
    }

    private fun changeEmotionImage(emotion: Emotion?) {
        selectedEmotion = emotion

        when (emotion) {
            null -> binding.emotionImageView.setImageBitmap(null)
            Emotion.SMILE -> binding.emotionImageView.setImageResource(R.drawable.baseline_mood_24)
            Emotion.NEUTRAL -> binding.emotionImageView.setImageResource(R.drawable.baseline_sentiment_neutral_24)
            Emotion.DISSATISFIED -> binding.emotionImageView.setImageResource(R.drawable.baseline_sentiment_very_dissatisfied_24)
            Emotion.BAD -> binding.emotionImageView.setImageResource(R.drawable.baseline_mood_bad_24)
        }
    }

    private fun emotionViewsClickListening() {
        binding.smileRadioButton.setOnClickListener { changeEmotionImage(Emotion.SMILE) }
        binding.neutralRadioButton.setOnClickListener { changeEmotionImage(Emotion.NEUTRAL) }
        binding.dissatisfiedRadioButton.setOnClickListener { changeEmotionImage(Emotion.DISSATISFIED) }
        binding.badRadioButton.setOnClickListener { changeEmotionImage(Emotion.BAD) }
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


    private fun setRadioButtonSize() {
        // 한개의 버튼만 수정해주어도 모두 바뀐다.
        val viewDrawingListener = object : ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                Log.d(TAG, binding.smileRadioButton.width.toString())
                binding.smileRadioButton.layoutParams.height = binding.smileRadioButton.width
                binding.smileRadioButton.requestLayout()
                binding.smileRadioButton.viewTreeObserver.removeOnGlobalLayoutListener(this)
            }
        }
        binding.smileRadioButton.viewTreeObserver.addOnGlobalLayoutListener(viewDrawingListener)
    }


    private fun setEmotionButtonEnable(isClickable: Boolean) {
        binding.smileRadioButton.isEnabled = isClickable
        binding.neutralRadioButton.isEnabled = isClickable
        binding.dissatisfiedRadioButton.isEnabled = isClickable
        binding.badRadioButton.isEnabled = isClickable
    }
}




