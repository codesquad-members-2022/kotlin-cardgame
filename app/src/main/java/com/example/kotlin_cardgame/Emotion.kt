package com.example.kotlin_cardgame

import android.content.Context
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.core.graphics.drawable.toBitmap

enum class EmotionEnum {
    SMILE, NEUTRAL, DISSATISFIED, BAD
}

object Emotion {
    fun getImage(context: Context, emotionEnum: EmotionEnum?): Bitmap? {
        var image: Bitmap? = when (emotionEnum) {
            null -> null
            EmotionEnum.SMILE -> context.resources.getDrawable(R.drawable.baseline_mood_24)
                .toBitmap()
            EmotionEnum.NEUTRAL -> context.resources.getDrawable(R.drawable.baseline_sentiment_neutral_24)
                .toBitmap()
            EmotionEnum.DISSATISFIED -> context.resources.getDrawable(R.drawable.baseline_sentiment_very_dissatisfied_24)
                .toBitmap()
            EmotionEnum.BAD -> context.resources.getDrawable(R.drawable.baseline_mood_bad_24)
                .toBitmap()
        }
        return image
    }

}
