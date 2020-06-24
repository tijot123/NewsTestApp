package com.app.newstestapp.helper

import android.text.TextUtils
import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("setMarquee")
fun setTextViewMarquee(mTextView: TextView, isNeeded: Boolean) {
    mTextView.isSelected = isNeeded
    mTextView.setSingleLine()
    mTextView.ellipsize = TextUtils.TruncateAt.MARQUEE
}