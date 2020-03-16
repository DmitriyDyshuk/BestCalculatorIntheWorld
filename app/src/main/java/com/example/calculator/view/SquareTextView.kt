package com.example.calculator.view

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class SquareTextView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0) : AppCompatTextView(context, attrs, defStyle) {

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val measureSpecSize = MeasureSpec.getSize(widthMeasureSpec)
        this.setMeasuredDimension(measureSpecSize, measureSpecSize)
        super.onMeasure(widthMeasureSpec, widthMeasureSpec)
    }

}