package com.example.kotlin_cardgame

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_cardgame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val resources = this.resources

        // editText 를 이용한 닉네임 정규식
        binding.textInputLayout.editText?.addTextChangedListener(listener)

        binding.imageButton1.setOnClickListener {
            // imageButton 을 누르면 pressed color 로 바뀌면서 해당 벡터 이미지가 imageview 로 이동
            if (!binding.imageButton1.isSelected) {
                binding.imageButton1.isSelected = true
                binding.imageButton2.isSelected = false
                binding.imageButton3.isSelected = false
                binding.imageButton4.isSelected = false
                binding.imageView.setImageResource(R.drawable.ic_baseline_sentiment_satisfied_alt_24)
            } else {
                // imageButton 을 다시 누르면 unpressed color 로 바뀌면서 해당 벡터 이미지가 없어짐
                binding.imageButton1.isSelected = false
                binding.imageView.setImageResource(0)
            }
        }
        binding.imageButton2.setOnClickListener {
            if (!binding.imageButton2.isSelected) {
                binding.imageButton2.isSelected = true
                binding.imageButton1.isSelected = false
                binding.imageButton3.isSelected = false
                binding.imageButton4.isSelected = false
                binding.imageView.setImageResource(R.drawable.ic_baseline_sentiment_satisfied_24)
                val secondImageBitmap = BitmapFactory.decodeResource(resources, R.drawable.ic_baseline_sentiment_satisfied_24)
            } else {
                binding.imageButton2.isSelected = false
                binding.imageView.setImageResource(0)
            }
        }
        binding.imageButton3.setOnClickListener {
            if (!binding.imageButton3.isSelected) {
                binding.imageButton3.isSelected = true
                binding.imageButton1.isSelected = false
                binding.imageButton2.isSelected = false
                binding.imageButton4.isSelected = false
                binding.imageView.setImageResource(R.drawable.ic_baseline_sentiment_very_dissatisfied_24)
                val thirdImageBitmap = BitmapFactory.decodeResource(resources, R.drawable.ic_baseline_sentiment_very_dissatisfied_24)
            } else {
                binding.imageButton3.isSelected = false
                binding.imageView.setImageResource(0)
            }
        }
        binding.imageButton4.setOnClickListener {
            if (!binding.imageButton4.isSelected) {
                binding.imageButton4.isSelected = true
                binding.imageButton1.isSelected = false
                binding.imageButton2.isSelected = false
                binding.imageButton3.isSelected = false
                binding.imageView.setImageResource(R.drawable.ic_baseline_sentiment_very_satisfied_24)
                val fourthImageBitmap = BitmapFactory.decodeResource(resources, R.drawable.ic_baseline_sentiment_very_satisfied_24)
            } else {
                binding.imageButton4.isSelected = false
                binding.imageView.setImageResource(0)
            }
        }

        binding.button.setOnClickListener {
            val intent = Intent(this, SubActivity::class.java)
            if (binding.imageButton1.isSelected) {
                val bundle = Bundle()
                val firstImageBitmap = BitmapFactory.decodeResource(resources, R.drawable.ic_baseline_sentiment_satisfied_alt_24)

                bundle.putParcelable("first", firstImageBitmap)
                intent.putExtra("first", bundle)
            }
            startActivity(intent)
        }
    }

    val listener = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun afterTextChanged(s: Editable?) {
            if (s != null) {
                if (s.isEmpty()) {
                    binding.textInputLayout.error = "닉네임을 입력하세요."
                    binding.button.isEnabled = false
                }
                else if (s.length > 5) {
                    binding.textInputLayout.error = "닉네임은 5글자 아래로 작성하세요."
                    binding.button.isEnabled = false
                }
                else if (hasSpecialCharacter(s.toString())) {
                    binding.textInputLayout.error = "특수문자를 포함할 수 없습니다."
                    binding.button.isEnabled = false
                }
                else if (!hasAlphabet(s.toString()) && s.isNotEmpty()) {
                    binding.textInputLayout.error = "영문자를 최소 한 개 포함해야 합니다. "
                    binding.button.isEnabled = false
                }
                else {
                    binding.textInputLayout.error = null
                    binding.button.isEnabled = true
                }
            }
        }
    }

    // 특수문자 존재 여부를 확인하는 메서드
    fun hasSpecialCharacter(string: String): Boolean {
        for (i in string.indices) {
            if (!Character.isLetterOrDigit(string[i])) {
                return true
            }
        }
        return false
    }

    // 영문자 존재 여부를 확인하는 메서드
    fun hasAlphabet(string: String): Boolean {
        for (i in string.indices) {
            if (Character.isAlphabetic(string[i].code)) {
                return true
            }
        }
        return false
    }
}


