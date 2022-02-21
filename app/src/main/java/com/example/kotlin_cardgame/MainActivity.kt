package com.example.kotlin_cardgame

import android.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.view.ViewTreeObserver
import com.example.kotlin_cardgame.databinding.ActivityMainBinding

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setImageButtonSize()


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

        binding.smileImageButton.viewTreeObserver.addOnGlobalLayoutListener (viewDrawingListener )

    }


}